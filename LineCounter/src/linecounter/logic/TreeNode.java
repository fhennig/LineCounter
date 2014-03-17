package linecounter.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import linecounter.logic.fileinfo.FileInfo;

public abstract class TreeNode
{
	private final FileInfo _info;
	protected final TreeConfig _config;
	
	
	
	public TreeNode(File file, TreeConfig config)
	{
		_config = config;
		init(file);
		_info = initFileInfo();
	}
	
	
	
	protected abstract void init(File file);
	
	protected abstract FileInfo initFileInfo();
	
	public FileInfo getFileInfo()
	{
		return _info;
	}
	
	public List<TreeNode> getChildren()
	{
		return new ArrayList<TreeNode>();
	}
}
