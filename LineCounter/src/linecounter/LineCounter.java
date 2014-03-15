package linecounter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import linecounter.gui.Gui;

public class LineCounter extends Application
{
	public static void main(String[] args)
	{
		Application.launch(LineCounter.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		//Parent root = FXMLLoader.load(getClass().getResource("Gui.fxml"));
		
		stage.setTitle("LineCounter");
		stage.setScene(new Scene(new Gui()));
		stage.show();
	}
}
