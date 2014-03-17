package linecounter.logic;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

import linecounter.logic.stats.JavaStats;
import linecounter.util.DefaultFileFilter;

public class JavaTreeConfig implements TreeConfig<JavaStats>
{
	private FileFilter _fileFilter = new DefaultFileFilter();
	
	

	@Override
	public JavaStats getStats(File file)
	{
		return new JavaStats(file);
	}

	@Override
	public JavaStats summarizeStats(List<JavaStats> stats)
	{
		return new JavaStats(stats);
	}

	@Override
	public FileFilter getFileFilter()
	{
		return _fileFilter;
	}
}
