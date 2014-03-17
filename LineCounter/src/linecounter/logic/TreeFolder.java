package linecounter.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import linecounter.logic.fileinfo.FileInfo;
import linecounter.logic.fileinfo.FolderFileInfo;

public class TreeFolder extends TreeNode
{
	private File _file;
	private final List<TreeNode> _children = new ArrayList<TreeNode>();

	

	public TreeFolder(File file, TreeConfig config)
	{
		super(file, config);
	}

	
	
	@Override
	protected void init(File file)
	{
		if (!file.isDirectory())
			throw new IllegalArgumentException();
		
		_file = file;
		initChildren();
	}
	
	private void initChildren()
	{
		for (File file : _file.listFiles(_config.getFileFilter()))
		{
			if (file.isDirectory())
				_children.add(new TreeFolder(file, _config));
			else if (file.isFile())
				_children.add(new TreeFile(file, _config));
		}
	}

	@Override
	protected FileInfo initFileInfo()
	{
		return new FolderFileInfo(_file, _config.getFileInfoPrototype(), getChildInfo());
	}
	
	private List<FileInfo> getChildInfo()
	{
		List<FileInfo> childInfo = new ArrayList<>();
		
		for (TreeNode child : _children)
			childInfo.add(child.getFileInfo());
		
		return childInfo;
	}
	
	@Override
	public List<TreeNode> getChildren()
	{
		return Collections.unmodifiableList(_children);
	}
}
