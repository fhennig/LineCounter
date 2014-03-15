package linecounter.logic;

import java.io.File;
import java.io.FileFilter;

public class DefaultFileFilter implements FileFilter
{
	@Override
	public boolean accept(File pathname)
	{
		return true;
	}
}
