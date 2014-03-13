package linecounter.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import linecounter.logic.SourceContainer;
import linecounter.logic.SourceDirectory;
import linecounter.logic.SourceFile;

public class TreePaneController implements LineCountListener
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TreeView<SourceContainer> _treeView;

	@FXML
	void initialize()
	{
		assert _treeView != null : "fx:id=\"_treeView\" was not injected: check your FXML file 'TreePane.fxml'.";
		
	}

	@Override
	public void lineCountGenerated(SourceContainer sc)
	{
		_treeView.setRoot(new TreeItem<SourceContainer>(sc));
		if (sc instanceof SourceDirectory)
		{
			unravelDirectory((SourceDirectory) sc, _treeView.getRoot());
		}
	}
	
	private void unravelDirectory(SourceDirectory directory, TreeItem<SourceContainer> root)
	{
		TreeItem<SourceContainer> newRoot =new TreeItem<SourceContainer>(directory); 
		root.getChildren().add(newRoot);
		for (SourceDirectory dir : directory.getChildDirectories())
		{
			unravelDirectory(dir, newRoot);
		}
		for (SourceFile file : directory.getFiles())
		{
			newRoot.getChildren().add(new TreeItem<SourceContainer>(file));
		}
	}
}
