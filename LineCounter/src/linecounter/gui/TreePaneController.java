package linecounter.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import linecounter.logic.SourceContainer;

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
		_treeView.setShowRoot(false);
		_treeView.setRoot(new TreeItem<SourceContainer>());
	}

	@Override
	public void lineCountGenerated(SourceContainer sc)
	{
		unravelDirectory(sc, _treeView.getRoot());
	}
	
	private void unravelDirectory(SourceContainer sourceContainer, TreeItem<SourceContainer> root)
	{
		TreeItem<SourceContainer> newRoot =new TreeItem<SourceContainer>(sourceContainer); 
		root.getChildren().add(newRoot);
		for (SourceContainer dir : sourceContainer.getChildren())
		{
			unravelDirectory(dir, newRoot);
		}
	}
}
