package linecounter.gui;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import linecounter.logic.SourceContainer;
import linecounter.logic.SourceDirectory;

public class OptionsPaneController
{
	private List<LineCountListener> _listeners = new ArrayList<>();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private CheckBox _commentsCheckBox;

	@FXML
	private CheckBox _emptyLinesCheckBox;

	@FXML
	private TextField _filePathTextBox;

	@FXML
	private CheckBox _importsCheckBox;

	@FXML
	void handlePathChooseBtnAction(ActionEvent event)
	{
		DirectoryChooser chooser = new DirectoryChooser();
		
		File file = chooser.showDialog(null);
		if (file != null)
			_filePathTextBox.setText(file.toString());
	}

	@FXML
	void handleStartBtnAction(ActionEvent event)
	{
		try
		{
			File root = new File(_filePathTextBox.getText());
			SourceContainer sc = new SourceDirectory(root);
			for (LineCountListener l : _listeners)
				l.lineCountGenerated(sc);
		} catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Fehler:\n\n" + ex.toString());
		}
	}
	
	public void addLineCountListener(LineCountListener listener)
	{
		_listeners.add(listener);
	}
	
	public void removeLineCountListener(LineCountListener listener)
	{
		_listeners.remove(listener);
	}

	@FXML
	void initialize()
	{
		assert _commentsCheckBox != null : "fx:id=\"_commentsCheckBox\" was not injected: check your FXML file 'OptionsPane.fxml'.";
		assert _emptyLinesCheckBox != null : "fx:id=\"_emptyLinesCheckBox\" was not injected: check your FXML file 'OptionsPane.fxml'.";
		assert _filePathTextBox != null : "fx:id=\"_filePathTextBox\" was not injected: check your FXML file 'OptionsPane.fxml'.";
		assert _importsCheckBox != null : "fx:id=\"_importsCheckBox\" was not injected: check your FXML file 'OptionsPane.fxml'.";
		

	}

}
