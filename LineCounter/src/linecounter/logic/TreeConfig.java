package linecounter.logic;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

import linecounter.logic.stats.CommonStats;

public interface TreeConfig<S extends CommonStats>
{
	public S getStats(File file);
	public S summarizeStats(List<S> stats);
	public FileFilter getFileFilter();
}
