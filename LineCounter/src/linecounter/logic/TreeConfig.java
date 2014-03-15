package linecounter.logic;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

public interface TreeConfig<S extends FileStats>
{
	public S getStats(File file);
	public S summarizeStats(List<S> stats);
	public FileFilter getFileFilter();
}
