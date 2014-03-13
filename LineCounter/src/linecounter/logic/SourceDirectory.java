package linecounter.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SourceDirectory extends SourceContainer
{
	private List<SourceDirectory> _childDirectories = new ArrayList<>();
	private List<SourceFile> _files = new ArrayList<>();
	
	
	
	public SourceDirectory(File directory)
	{
		super(directory);
		if (!directory.isDirectory())
			throw new IllegalArgumentException(directory + " is not a Directory!");
				
		for (File f : directory.listFiles())
		{
			if (f.isFile())
				_files.add(new SourceFile(f));
			else if (f.isDirectory())
				_childDirectories.add(new SourceDirectory(f));
		}
	}
	
	

	public List<SourceContainer> getChildEntries()
	{
		return new ArrayList<>(); //TODO
	}
	
	public List<SourceDirectory> getChildDirectories()
	{
		return Collections.unmodifiableList(_childDirectories);
	}
	
	public List<SourceFile> getFiles()
	{
		return Collections.unmodifiableList(_files);
	}
	
	@Override
	public int getLineCount()
	{
		int lineCount = 0;
		for (SourceContainer sc : _childDirectories)
			lineCount += sc.getLineCount();
		for (SourceContainer sc : _files)
			lineCount += sc.getLineCount();
		return lineCount;
	}
}
