package linecounter.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import linecounter.logic.stats.CommonStats;

public class SourceNode<S extends CommonStats>
{
	private final String _name;
	private final S _stats;
	private final List<SourceNode<S>> _children = new ArrayList<>();
	private final TreeConfig<S> _config;
	
	
	
	public SourceNode(File file, TreeConfig<S> config)
	{
		_name = file.getName();
		_config = config;
		
		if (file.isFile())
			_stats = _config.getStats(file);
		else if (file.isDirectory())
		{
			initChildren(file);
			_stats = _config.summarizeStats(getChildStats());
		}
		else
			throw new IllegalArgumentException();
	}
	
	
	
	private void initChildren(File directory)
	{
		for (File file : directory.listFiles(_config.getFileFilter()))
		{
			SourceNode<S> child = new SourceNode<>(file, _config);
			_children.add(child);
		}
	}
	
	private List<S> getChildStats()
	{
		List<S> childStats = new ArrayList<>();
		
		for (SourceNode<S> child : _children)
			childStats.add(child.getStats());
		
		return childStats;
	}
	
	public S getStats()
	{
		return _stats;
	}
	
	public List<SourceNode<S>> getChildren()
	{
		return Collections.unmodifiableList(_children);
	}
	
	@Override
	public String toString()
	{
		String name = _name;
		if (_children.size() > 0)
			name = name + " (" + _children.size() + ")";
		return name;
	}
}
