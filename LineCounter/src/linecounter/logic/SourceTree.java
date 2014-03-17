package linecounter.logic;

import java.io.File;

import linecounter.logic.stats.CommonStats;

public class SourceTree<S extends CommonStats>
{
	private final SourceNode<S> _root;
	private final String _name;
	
	
	
	public SourceTree(File file, TreeConfig<S> config)
	{
		if (!file.isDirectory())
			throw new IllegalArgumentException();
		
//		if ((file.isFile() && !config.getFileFilter().accept(file)) || 
//				!(file.isDirectory() || file.isFile()))
//			file = new File("null");
		
		_root = new SourceNode<>(file, config);
		_name = file.getName();
	}
	
	
	
	public SourceNode<S> getRoot()
	{
		return _root;
	}
	
	@Override
	public String toString()
	{
		return _name;
	}
}
