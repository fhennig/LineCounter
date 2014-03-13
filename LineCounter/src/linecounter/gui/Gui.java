package linecounter.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gui extends Application
{
	@Override
	public void start(Stage stage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("Gui.fxml"));
				
		stage.setTitle("LineCounter");
		stage.setScene(new Scene(root));
		stage.show();
	}
}
