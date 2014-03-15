package linecounter.logic;

import java.io.File;
import java.util.List;

public class JavaStats extends FileStats
{
	private int _emptyLines;
	private int _docLines;
	private int _sourceLines;
	
	

	public JavaStats(File file)
	{
		super(file);
	}
	
	public JavaStats(List<JavaStats> stats)
	{
		super(stats);
		for (JavaStats js : stats)
		{
			_emptyLines += js.getEmptyLines();
			_docLines += js.getDocLines();
			_sourceLines += js.getSourceLines();
		}
	}



	@Override
	protected void analyzeLine(String line)
	{
		super.analyzeLine(line);
		line = line.trim();
		if (line.isEmpty())
			_emptyLines++;
		else if  (isDocumentation(line))
			_docLines++;
		else
			_sourceLines++;
	}
	
	private boolean isDocumentation(String line)
	{
		line = line.trim();
		boolean result = (line.startsWith("//") ||
						  line.startsWith("/*") ||
						  line.startsWith("*") ||
						  line.startsWith("*/"));
		return result;
	}
	
	public int getEmptyLines()
	{
		return _emptyLines;
	}

	public int getDocLines()
	{
		return _docLines;
	}

	public int getSourceLines()
	{
		return _sourceLines;
	}
}
