package linecounter.logic.fileinfo.stats;

import java.util.HashMap;
import java.util.Map;

public class AnalyzedStats
{
	private final Map<String, AnalyzedStat> _stats = new HashMap<>();
	
	
	
	public AnalyzedStats()
	{
		
	}
	
	
	
	public void add(String key, AnalyzedStat stat)
	{
		if (_stats.containsKey(key))
			throw new IllegalArgumentException();
		
		_stats.put(key, stat);
	}
	
	public void remove(String key)
	{
		_stats.remove(key);
	}
	
	public AnalyzedStat get(String key)
	{
		return _stats.get(key);
	}
	
	public void analyze(String line)
	{
		for (AnalyzedStat stat : _stats.values())
		{
			stat.analyzeLine(line);
		}
	}
	
	public AnalyzedStats cloneSetup()
	{
		AnalyzedStats clone = new AnalyzedStats();
		
		for (String key : _stats.keySet())
		{
			clone.add(key, _stats.get(key).cloneSetup());
		}
		
		return clone;
	}
}
