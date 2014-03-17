package linecounter.logic;

import java.io.File;

public class Tree
{
	private final TreeNode _root;
	private final TreeConfig _config;
	
	
	
	public Tree(File file, TreeConfig config)
	{
		if (!file.isDirectory())
			throw new IllegalArgumentException();
		
		_config = config;
		_root = new TreeFolder(file, config);
	}
	
	
	
	public TreeNode getRoot()
	{
		return _root;
	}
	
	public TreeConfig getConfig()
	{
		return _config;
	}
}
