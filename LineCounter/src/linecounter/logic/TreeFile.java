package linecounter.logic;

import java.io.File;

import linecounter.logic.fileinfo.DefaultFileInfo;
import linecounter.logic.fileinfo.FileInfo;

public class TreeFile extends TreeNode
{
	private File _file;
	
	

	public TreeFile(File file, TreeConfig config)
	{
		super(file, config);
	}

	

	@Override
	protected void init(File file)
	{
		if (!file.isFile())
			throw new IllegalArgumentException();
			
		_file = file;
	}

	@Override
	protected FileInfo initFileInfo()
	{
		return new DefaultFileInfo(_file, _config.getFileInfoPrototype());
	}
}
