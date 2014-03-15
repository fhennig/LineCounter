package linecounter.logic;


public class DefaultSourceInformation extends SourceInformation
{
	public DefaultSourceInformation(int allLines, int emptyLines, int docLines, int sourceLines)
	{
		_allLines = allLines;
		_emptyLines = emptyLines;
		_docLines = docLines;
		_sourceLines = sourceLines;
	}
	
	
//	public DefaultSourceInformation(File file, LineFilter filter) throws IOException
//	{
//		if (!file.isFile())
//			throw new IllegalArgumentException(file + " is not a file.");
//		
//		init(file, filter);
//	}
//
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
