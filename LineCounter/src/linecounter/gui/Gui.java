package linecounter.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import linecounter.logic.CommonStats;
import linecounter.logic.SourceTree;

public class Gui extends VBox implements TreeDisplay
{
	@FXML
	private OptionsPaneController _optionsPaneController;

	@FXML
	private TabPane _tabPane;

	public Gui()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gui.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try
		{
			fxmlLoader.load();
		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
		
		_optionsPaneController.setTreeDisplay(this);
	}

	@Override
	public void display(SourceTree<? extends CommonStats> tree)
	{
		Tab newTab = new Tab(tree.toString());
		newTab.contentProperty().set(new TreePane(tree));
		_tabPane.getTabs().add(newTab);
		_tabPane.getSelectionModel().select(newTab);
	}
}
