package linecounter.logic;

import java.io.File;

public abstract class SourceContainer
{
	private final File _originalFile;
	
	
	
	public SourceContainer(File file)
	{
		_originalFile = file;
	}
	
	
	
	protected File getOriginalFile()
	{
		return _originalFile;
	}	
	
	public abstract int getLineCount();
	
	@Override
	public String toString()
	{
		return _originalFile.getName() + ":\t" + getLineCount();
	}
}
