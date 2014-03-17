package linecounter.util;

import java.io.File;
import java.io.FileFilter;

public class DefaultFileFilter implements FileFilter
{
	@Override
	public boolean accept(File file)
	{
		return (file.isFile() || file.isDirectory());
	}
}
