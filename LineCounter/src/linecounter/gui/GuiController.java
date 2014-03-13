package linecounter.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class GuiController
{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane _optionsPane;

	@FXML
	private AnchorPane _treePane;
	
	@FXML
	private TreePaneController _treePaneController;
	
	@FXML
	private OptionsPaneController _optionsPaneController;

	@FXML
	void initialize()
	{
		assert _optionsPane != null : "fx:id=\"_optionsPane\" was not injected: check your FXML file 'Gui.fxml'.";
		assert _treePane != null : "fx:id=\"_treePane\" was not injected: check your FXML file 'Gui.fxml'.";
		_optionsPaneController.addLineCountListener(_treePaneController);
	}

}
