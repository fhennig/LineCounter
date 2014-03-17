package linecounter.gui;

import java.io.File;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import linecounter.logic.JavaTreeConfig;
import linecounter.logic.SourceTree;
import linecounter.logic.stats.JavaStats;

public class OptionsPaneController
{
	@FXML
	private TextField _filePathTextBox;

	@FXML
	private Button _showBtn;
	
	private TreeDisplay _display;

	
	
	@FXML
	void initialize()
	{
		assert _filePathTextBox != null : "fx:id=\"_filePathTextBox\" was not injected: check your FXML file 'OptionsPane.fxml'.";
		assert _showBtn != null : "fx:id=\"_showBtn\" was not injected: check your FXML file 'OptionsPane.fxml'.";

		_showBtn.setDisable(true);
		
		_filePathTextBox.textProperty().addListener(new ChangeListener<String>()
		{

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String oldValue, String newValue)
			{
				boolean valid = new File(newValue).exists();
				_showBtn.setDisable(!valid);
			}
		});
	}
	
	
		
	@FXML
	void handlePathChooseBtnAction(ActionEvent event)
	{
		DirectoryChooser chooser = new DirectoryChooser();
		File directory = chooser.showDialog(null);
		_filePathTextBox.setText(directory.getPath());
	}

	@FXML
	void handleShowBtnAction(ActionEvent event)
	{
		SourceTree<JavaStats> tree = new SourceTree<>(new File(_filePathTextBox.getText()), new JavaTreeConfig());
		_display.display(tree);
	}
	
	public void setTreeDisplay(TreeDisplay display)
	{
		_display = display;
	}
}
