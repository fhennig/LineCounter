package linecounter.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SourceFile extends SourceContainer
{
	private int _lineCount;
	
	public SourceFile(File file)
	{
		super(file);
		if (!file.isFile())
			throw new IllegalArgumentException(file + " is not a File!");
		
		countLines(file);
	}
	
	private void countLines(File file)
	{
		FileReader fileReader;
		try
		{
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e1)
		{
			_lineCount = 0;
			return;
		}
		BufferedReader br = new BufferedReader(fileReader);
		
		String line;
		try
		{
			while ((line = br.readLine()) != null)
			{
				if (LineFilter.getInstance().isLineRelevant(line))
					_lineCount++;
			}
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	@Override
	public int getLineCount()
	{
		return _lineCount;
	}
}
