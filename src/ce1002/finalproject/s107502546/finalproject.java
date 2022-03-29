package ce1002.finalproject.s107502546;

import java.io.IOException;

import ce1002.finalproject.s107502546.finalproject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class finalproject extends Application{
	public static Stage mainStage;
	public static Scene mainScene;

	public static void main(String[] args){
	    launch(args);
	}
	@Override
	public void start(Stage mainStage) throws IOException {
		finalproject.mainStage = mainStage;
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("views/Main.fxml"));
		    Parent main = loadder.load();       
		    mainScene = new Scene(main);
		    mainStage.setTitle("Cheese Push Push");
		    mainStage.setScene(mainScene);
		    mainStage.show();
		    mainStage.setResizable(false);
	}
}
