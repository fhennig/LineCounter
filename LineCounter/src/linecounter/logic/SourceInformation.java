package linecounter.logic;

import java.util.ArrayList;
import java.util.List;

public abstract class SourceInformation
{
	protected int _allLines;
	protected int _sourceLines;
	protected int _docLines;
	protected int _emptyLines;
	
	
	
	public int getLines()
	{
		return _allLines;
	}
	
	public int getSourceLines()
	{
		return _sourceLines;
	}
	
	public int getDocLines()
	{
		return _docLines;
	}
	
	public int getEmptyLines()
	{
		return _emptyLines;
	}
	
	public List<SourceInformation> getChildren()
	{
		return new ArrayList<>();
	}
}
