package linecounter.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileStats
{
	private int _allLines;
	
	
	
	public FileStats(File file)
	{
		if (!file.isFile())
			throw new IllegalArgumentException();
		
		try
		{
			analyze(file);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public FileStats(List<? extends FileStats> stats)
	{
		for (FileStats fs : stats)
			_allLines += fs.getAllLines();
	}
	
	
	
	private void analyze(File file) throws IOException
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
	
	protected void analyzeLine(String line)
	{
		_allLines++;
	}
	
	public int getAllLines()
	{
		return _allLines;
	}
}
