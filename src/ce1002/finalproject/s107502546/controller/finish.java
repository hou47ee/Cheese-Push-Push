package ce1002.finalproject.s107502546.controller;

import java.io.IOException;

import ce1002.finalproject.s107502546.finalproject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class finish extends Application{
	public static Stage mainStage;
	public static Scene mainScene;
	public void start(Stage mainStage) throws IOException {
		finish.mainStage = mainStage;
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/finish.fxml"));
	    Parent fin = loadder.load();
	    Scene MainScene = new Scene(fin);
	    finish.mainStage.setScene(MainScene);
	}
}
