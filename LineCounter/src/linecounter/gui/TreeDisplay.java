package linecounter.gui;

import linecounter.logic.SourceTree;
import linecounter.logic.stats.CommonStats;

public interface TreeDisplay
{
	public void display(SourceTree<? extends CommonStats> tree);
}
