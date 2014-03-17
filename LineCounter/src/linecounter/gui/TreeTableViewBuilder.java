package linecounter.gui;

import javafx.scene.control.TreeTableView;
import linecounter.logic.fileinfo.BuilderConfiguration;
import linecounter.logic.fileinfo.FileInfo;

public class TreeTableViewBuilder
{
	public TreeTableView<FileInfo> newTreeTableView(BuilderConfiguration config)
	{
		TreeTableView<FileInfo> ttView = new TreeTableView<>();
		
		
		return ttView;
	}
	
	private void addColumns(TreeTableView<FileInfo> ttView, BuilderConfiguration config)
	{
		if (config.showName.get())
		{
	}
}
