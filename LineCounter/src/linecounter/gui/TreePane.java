package linecounter.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import linecounter.logic.CommonStats;
import linecounter.logic.SourceNode;
import linecounter.logic.SourceTree;

public class TreePane extends AnchorPane
{
	@FXML
	private TreeView<String> _treeView;

	public TreePane(SourceTree<? extends CommonStats> tree)
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TreePane.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try
		{
			fxmlLoader.load();
		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}

		_treeView.setRoot(new SourceTreeItem<>(tree.getRoot()));
	}

	private class SourceTreeItem<S extends CommonStats> extends
			TreeItem<String>
	{
		private String _name;

		public SourceTreeItem(SourceNode<S> node)
		{
			_name = node.toString();
			_name = _name + "\t\t\t\t" + node.getStats().toString();

			for (SourceNode<S> child : node.getChildren())
			{
				this.getChildren().add(new SourceTreeItem<>(child));
			}
			this.valueProperty().set(_name);
		}
	}
}
