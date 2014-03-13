package linecounter.logic;

public class LineFilter
{
	private static LineFilter _instance = null;
	private boolean _skipEmptyLines = false;
	
	
	
	private LineFilter() { }
	
	public static LineFilter getInstance()
	{
		if (_instance == null)
			_instance = new LineFilter();
		
		return _instance;
	}
	
	
	
	public void setSkipEmptyLines(boolean b)
	{
		_skipEmptyLines = b;
	}
	
	public boolean isLineRelevant(String line)
	{
		line = line.trim();
		if (_skipEmptyLines && line.isEmpty())
			return false;
		
		return true;
	}
}
