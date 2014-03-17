package linecounter.logic.fileinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import linecounter.logic.fileinfo.stats.AnalyzingStatFactory;
import linecounter.logic.fileinfo.stats.AnalyzingStat;

public class DefaultFileInfo extends FileInfo
{
	private final Map<String, AnalyzingStat> _stats = new HashMap<String, AnalyzingStat>();
	
	
	
	public DefaultFileInfo(File file, Set<String> statsToUse)
	{
		if (!file.isFile())
			throw new IllegalArgumentException();
		
		String fileName = file.getName();
		_fileName = fileName.substring(0, fileName.lastIndexOf("."));
		_fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
		_amountChildren = "";
		
		loadStats(statsToUse);
		try
		{
			initStats(file);
		} catch (IOException e)
		{
			throw new IllegalArgumentException();
		}
	}
	
	
	
	private void loadStats(Set<String> statsToUse)
	{
		for (String stat : statsToUse)
		{
			_stats.put(stat, AnalyzingStatFactory.getInstance().newAnalyzingStat(stat));
		}
	}
	
	private void initStats(File file) throws IOException
	{
		FileReader fileReader = new FileReader(file);
		try(BufferedReader reader = new BufferedReader(fileReader))
		{			
			String currentLine = reader.readLine();
			
			while (currentLine != null)
			{
				analyzeLine(currentLine);
				currentLine = reader.readLine();
			}
		}
	}

	private void analyzeLine(String Line)
	{
		for (AnalyzingStat stat : _stats.values())
		{
			stat.analyzeLine(Line);
		}
	}

	@Override
	public int getStat(String statName)
	{
		return _stats.get(statName).getValue();
	}
}
