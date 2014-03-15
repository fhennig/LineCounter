package linecounter.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DefaultSourceInformation extends SourceInformation
{
	public DefaultSourceInformation(File file, LineFilter filter)
	{
		if (!file.isFile())
			throw new IllegalArgumentException(file + " is not a file.");
		
		try
		{
			init(file, filter);
		} catch (IOException e)
		{
			throw new IllegalArgumentException(e);
		}
	}

	private void init(File file, LineFilter filter) throws IOException
	{
		FileReader fileReader = new FileReader(file);
		try(BufferedReader reader = new BufferedReader(fileReader))
		{			
			String currentLine = reader.readLine();
			
			while (currentLine != null)
			{
				_allLines++;
				if (filter.isEmpty(currentLine))
					_emptyLines++;
				if (filter.isDoc(currentLine))
					_docLines++;
				if (filter.isSource(currentLine))
					_sourceLines++;
				
				currentLine = reader.readLine();
			}
		}
		
	}
}
