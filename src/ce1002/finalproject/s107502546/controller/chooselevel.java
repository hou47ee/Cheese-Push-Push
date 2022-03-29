package ce1002.finalproject.s107502546.controller;

import java.io.FileInputStream;
import java.io.IOException;
import ce1002.finalproject.s107502546.finalproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class chooselevel {
	
	public Button button= new Button();//use to store the level number
	@FXML
	Pane choose1, choose2, choose3;
	static int barrier = 0;
	String content = "";
	boolean p = false;
	boolean p1 = false;
	boolean p2 = false;
	public static  int[][] omap = new int[7][11];
	public void Menu(ActionEvent e) throws IOException {
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/Main.fxml"));
	    Parent Main = loadder.load();
	    Scene MainScene = new Scene(Main);
	    finalproject.mainStage.setScene(MainScene);
	}
	public void ch1(ActionEvent e) throws IOException{
		if(p1 != true && p2 != true) {
			choose1.setVisible(p);
			if(p == false)
				p = true;
			else
				p = false;
			choose1.setVisible(p);
		}
	}
	public void ch2(ActionEvent e) throws IOException{
		if(p != true && p2 != true) {
			choose2.setVisible(p1);
			if(p1 == false)
				p1 = true;
			else
				p1 = false;
			choose2.setVisible(p1);
		}
	}
	public void ch3(ActionEvent e) throws IOException{
		if(p1 != true && p != true) {
			choose3.setVisible(p2);
			if(p2 == false)
				p2 = true;
			else
				p2 = false;
			choose3.setVisible(p2);
		}
	}
	public void Level(ActionEvent e) throws IOException {
		button = (Button) e.getSource();
		barrier = Integer.valueOf(button.getText());
		for(int v = 0; v < 9; v++) {
			if(barrier == v + 1) {
				FileInputStream in = new FileInputStream("src/ce1002/finalproject/s107502546/easy/" + barrier + ".txt");
				byte[] bytes = in.readAllBytes();
				content = new String(bytes);
				String[] contentArr = content.split(" ");
				int c = 0;
				for(int z = 0; z < 7; z++) {
					for(int w = 0; w < 11; w++) {
						omap[z][w] = Integer.valueOf(contentArr[c]);
						c++;
					}
				}
				break;
			}
		}
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/map.fxml"));
	    Parent e1 = loadder.load();
	    Scene MainScene = new Scene(e1);
	    map mazeCtrl = loadder.getController();
	    MainScene.setOnKeyPressed(mazeCtrl.onKeyPressed);
	    finalproject.mainStage.setScene(MainScene);
	}
	public void Level2(ActionEvent e) throws IOException {
		button = (Button) e.getSource();
		barrier = Integer.valueOf(button.getText());
		for(int v = 0; v < 9; v++) {
			if(barrier == v + 1) {
				FileInputStream in = new FileInputStream("src/ce1002/finalproject/s107502546/general/" + barrier + ".txt");
				byte[] bytes = in.readAllBytes();
				content = new String(bytes);
				String[] contentArr = content.split(" ");
				int c = 0;
				for(int z = 0; z < 7; z++) {
					for(int w = 0; w < 11; w++) {
						omap[z][w] = Integer.valueOf(contentArr[c]);
						c++;
					}
				}
				break;
			}
		}
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/map2.fxml"));
	    Parent e2 = loadder.load();
	    Scene MainScene = new Scene(e2);
	    map2 mazeCtrl = loadder.getController();
	    MainScene.setOnKeyPressed(mazeCtrl.onKeyPressed);
	    finalproject.mainStage.setScene(MainScene);
	}
	public void Level3(ActionEvent e) throws IOException {
		button = (Button) e.getSource();
		barrier = Integer.valueOf(button.getText());
		for(int v = 0; v < 9; v++) {
			if(barrier == v + 1) {
				FileInputStream in = new FileInputStream("src/ce1002/finalproject/s107502546/hard/" + barrier + ".txt");
				byte[] bytes = in.readAllBytes();
				content = new String(bytes);
				String[] contentArr = content.split(" ");
				int c = 0;
				for(int z = 0; z < 7; z++) {
					for(int w = 0; w < 11; w++) {
						omap[z][w] = Integer.valueOf(contentArr[c]);
						c++;
					}
				}
				break;
			}
		}
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/map3.fxml"));
	    Parent e2 = loadder.load();
	    Scene MainScene = new Scene(e2);
	    map3 mazeCtrl = loadder.getController();
	    MainScene.setOnKeyPressed(mazeCtrl.onKeyPressed);
	    finalproject.mainStage.setScene(MainScene);
	}
}