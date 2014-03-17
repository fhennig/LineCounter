package linecounter.logic;

import java.io.FileFilter;

import linecounter.logic.fileinfo.FileInfoPrototype;

public class TreeConfig
{
	private final FileFilter _filter;
	private final FileInfoPrototype _prototype;
	
	
	
	public TreeConfig(FileFilter filter, FileInfoPrototype prototype)
	{
		_filter = filter;
		_prototype = prototype;
	}
	
	
	
	public FileFilter getFileFilter()
	{
		return _filter;
	}
	
	public FileInfoPrototype getFileInfoPrototype()
	{
		return _prototype;
	}
}
