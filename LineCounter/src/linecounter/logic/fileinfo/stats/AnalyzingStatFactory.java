package linecounter.logic.fileinfo.stats;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnalyzingStatFactory
{
	private static AnalyzingStatFactory _instance = null;
	private final Map<String, AnalyzingStat> _stats = new HashMap<>();
	
	
	
	private AnalyzingStatFactory()
	{
		//TODO add all the possible stats
	}
	
	public static AnalyzingStatFactory getInstance()
	{
		if (_instance == null)
			_instance = new AnalyzingStatFactory();
		
		return _instance;
	}
	
	
	
	public AnalyzingStat newAnalyzingStat(String key)
	{
		return _stats.get(key).cloneSetup();
	}
	
	public Set<String> possibleStats()
	{
		return _stats.keySet();
	}
}
