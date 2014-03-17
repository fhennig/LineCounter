package linecounter.logic;

import java.io.FileFilter;
import java.util.Set;

public class TreeConfig
{
	private final FileFilter _filter;
	private final Set<String> _statsToUse;
	
	
	
	public TreeConfig(FileFilter filter, Set<String> statsToUse)
	{
		_filter = filter;
		_statsToUse = statsToUse;
	}
	
	
	
	public FileFilter getFileFilter()
	{
		return _filter;
	}
	
	public Set<String> getStatsToUse()
	{
		return _statsToUse;
	}
}
