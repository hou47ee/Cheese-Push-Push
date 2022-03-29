package ce1002.finalproject.s107502546.controller;

import java.io.IOException;

import ce1002.finalproject.s107502546.finalproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main {
	boolean h = false;
	@FXML
	Pane help;
	public void Start(ActionEvent e) throws IOException {
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/level.fxml"));
	    Parent level = loadder.load();
	    Scene levelScene = new Scene(level);
	    finalproject.mainStage.setScene(levelScene);	    
	}
	public void Exit(ActionEvent e) {
		finalproject.mainStage.close();
	}
	public void Help(ActionEvent e) {
			help.setVisible(h);
			if(h == false)
				h = true;
			else
				h = false;
			help.setVisible(h);
		
	}

}
