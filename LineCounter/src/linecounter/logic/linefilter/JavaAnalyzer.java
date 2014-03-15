package linecounter.logic.linefilter;

import java.io.File;

import linecounter.logic.SourceInformation;

public class JavaAnalyzer implements FileAnalyzer
{
	public boolean isEmpty(String line)
	{
		return line.isEmpty();
	}

	public boolean isDoc(String line)
	{
		line = line.trim();
		boolean result = (line.startsWith("//") ||
						  line.startsWith("/*") ||
						  line.startsWith("*") ||
						  line.startsWith("*/"));
		return result;
	}

	public boolean isSource(String line)
	{
		if (!isEmpty(line) && !isDoc(line))
			return true;
		return false;
	}

	@Override
	public SourceInformation analyze(File file)
	{
		if (!file.isFile())
			throw new IllegalArgumentException();
		
		return null; //TODO
	}
	
//	private void init(File file, LineFilter filter) throws IOException
//	{
//		FileReader fileReader = new FileReader(file);
//		try(BufferedReader reader = new BufferedReader(fileReader))
//		{			
//			String currentLine = reader.readLine();
//			
//			while (currentLine != null)
//			{
//				_allLines++;
//				if (filter.isEmpty(currentLine))
//					_emptyLines++;
//				if (filter.isDoc(currentLine))
//					_docLines++;
//				if (filter.isSource(currentLine))
//					_sourceLines++;
//				
//				currentLine = reader.readLine();
//			}
//		}
//		
//	}
}
