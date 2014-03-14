package linecounter.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class SourceContainer
{
	private final File _originalFile;
	
	
	
	public SourceContainer(File file)
	{
		_originalFile = file;
	}
	
	
	
	/** Factory method. */
	public static SourceContainer getTree(File file)
	{
		if (file.isFile())
			return new SourceFile(file);
		else if (file.isDirectory())
			return new SourceDirectory(file);
		else
			throw new IllegalArgumentException(file + " is not a file or directory.");
	}
	
	public abstract int getLineCount();
	
	/**
	 * This method should be overridden.
	 * This default implementation returns an empty list.
	 */
	public List<SourceContainer> getChildren()
	{
		return new ArrayList<SourceContainer>();
	}
	
	@Override
	public String toString()
	{
		return _originalFile.getName() + ":\t" + getLineCount();
	}
}
