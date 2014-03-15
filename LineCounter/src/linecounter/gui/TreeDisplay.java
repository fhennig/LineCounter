package linecounter.gui;

import linecounter.logic.CommonStats;
import linecounter.logic.SourceTree;

public interface TreeDisplay
{
	public void display(SourceTree<? extends CommonStats> tree);
}
