package linecounter.logic.fileinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import linecounter.logic.fileinfo.stats.AnalyzedStat;

public class DefaultFileInfo implements FileInfo
{
	private final String _fileName;
	private final String _fileExtension;
	private final String _amountChildren;
	private final Map<String, AnalyzedStat> _stats;
	
	
	
	public DefaultFileInfo(File file, FileInfoPrototype prototype)
	{
		if (!file.isFile())
			throw new IllegalArgumentException();
		
		String fileName = file.getName();
		_fileName = fileName.substring(0, fileName.lastIndexOf("."));
		_fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
		_amountChildren = "";
		
		_stats = prototype.cloneStatsMap();
		try
		{
			initStats(file);
		} catch (IOException e)
		{
			throw new IllegalArgumentException();
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
		for (AnalyzedStat stat : _stats.values())
		{
			stat.analyzeLine(Line);
		}
	}

	@Override
	public String getName()
	{
		return _fileName;
	}

	@Override
	public String getExtension()
	{
		return _fileExtension;
	}

	@Override
	public String getAmountChildren()
	{
		return _amountChildren;
	}

	@Override
	public int getStat(String statName)
	{
		return _stats.get(statName).getValue();
	}
}
