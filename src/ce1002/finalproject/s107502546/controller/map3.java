package ce1002.finalproject.s107502546.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import ce1002.finalproject.s107502546.finalproject;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class map3 extends chooselevel implements Initializable{
	@FXML
	ImageView star;
	Image b1 = new Image(getClass().getResourceAsStream("../images/bear1.png"));
    Image b2 = new Image(getClass().getResourceAsStream("../images/bear2.png"));		    
    Image b3 = new Image(getClass().getResourceAsStream("../images/bear3.png"));		    
    Image b4 = new Image(getClass().getResourceAsStream("../images/bear4.png"));
    Image b[]= {b1,b2,b3,b4};
    
    Image wall = new Image(getClass().getResourceAsStream("../images/wall.jpg"));
    Image cheese = new Image(getClass().getResourceAsStream("../images/cheese.png"));
    Image heart = new Image(getClass().getResourceAsStream("../images/heart.png"));
    Image fin = new Image(getClass().getResourceAsStream("../images/background.jpg"));

    Image s1 = new Image(getClass().getResourceAsStream("../images/s1.png"));
    Image s2 = new Image(getClass().getResourceAsStream("../images/s2.png"));
    Image s3 = new Image(getClass().getResourceAsStream("../images/s3.png"));
    
	Image[] imap = {wall, cheese, heart, b1};
	ImageView[][] ivmap = new ImageView[7][11];
	DropShadow wdow = new DropShadow();
	DropShadow cdow = new DropShadow();

    @FXML
    GridPane grid;
    @FXML
    Pane finish,pause,Lose;
    @FXML
    Label Step;
    @FXML
    Label time;
    
	LinkedList<Image> _walk = new LinkedList<Image>();
	
	int[][] map2 = new int[7][11];
	int m = 0;
	int n = 2;
	int x = 0;
	int y = 0;
	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	int x3 = 0;
	int y3 = 0;
	int x4 = 0;
	int y4 = 0;
	int x5 = 0;
	int y5 = 0;
	int step = 0;
	int min = 4, sec = 60;
	boolean move = true;
	boolean lose = false;
	boolean T = true;
	public void setmap() {
		
		for(int i = 0; i < 7; i++) {
	      for(int j = 0; j < 11; j++) {
	       if(omap[i][j] == 1) {
		       ivmap[i][j]= new ImageView();
		       ivmap[i][j].setImage(imap[0]);
		       ivmap[i][j].setFitHeight(57);
		       ivmap[i][j].setFitWidth(57);
		       ivmap[i][j].setEffect(wdow);
		       GridPane.setHalignment(ivmap[i][j], HPos.CENTER);
		       grid.add(ivmap[i][j], j, i);
	       }
	       else if(omap[i][j] == 21 || omap[i][j] == 22 || omap[i][j] == 23 || omap[i][j] == 24 || omap[i][j] == 25) {
	    	   if(omap[i][j] == 21) {
	    		   y1 = i;
	    		   x1 = j;
	    	   }
	    	   else if(omap[i][j] == 22) {
	    		   y2 = i;
	    		   x2 = j;
	    	   }
	    	   else if(omap[i][j] == 23) {
	    		   y3 = i;
	    		   x3 = j;	    		 
	    	   }
	    	   else if(omap[i][j] == 24) {
	    		   y4 = i;
	    		   x4 = j;
	    	   }
	    	   else if(omap[i][j] == 25) {
	    		   y5 = i;
	    		   x5 = j;
	    	   }
	    	   ivmap[i][j]= new ImageView();
		       ivmap[i][j].setImage(imap[1]);
		       ivmap[i][j].setFitHeight(77);
		       ivmap[i][j].setFitWidth(77);
		       GridPane.setValignment(ivmap[i][j], VPos.CENTER);
		       GridPane.setMargin(ivmap[i][j], new Insets(0, 0, 0, -7));
		       ivmap[i][j].setEffect(cdow);
		       grid.add(ivmap[i][j], j, i);
	       }
	       else if(omap[i][j] == 3) {
	    	   ivmap[i][j]= new ImageView();
		       ivmap[i][j].setImage(imap[2]);
		       ivmap[i][j].setFitHeight(60);
		       ivmap[i][j].setFitWidth(60);	       
		       grid.add(ivmap[i][j], j, i);
		       ivmap[i][j].toBack();
	       }
	       else if(omap[i][j] == 4) {
	    	   ivmap[i][j]= new ImageView();
		       ivmap[i][j].setImage(imap[3]);
		       ivmap[i][j].setFitHeight(100);
		       ivmap[i][j].setFitWidth(100);
		       GridPane.setHalignment(ivmap[i][j], HPos.CENTER);
		       GridPane.setMargin(ivmap[i][j], new Insets(0, 0, 10, 0));
		       grid.add(ivmap[i][j], j, i);
		       ivmap[i][j].toFront();
		       y = i;
		       x = j;
	       } 
	     }
		}
	}
	public EventHandler<KeyEvent> onKeyPressed = (e)->{
		int b_x = GridPane.getColumnIndex(ivmap[y][x]);
		int b_y = GridPane.getRowIndex(ivmap[y][x]);
		int c1_x = GridPane.getColumnIndex(ivmap[y1][x1]);
		int c1_y = GridPane.getRowIndex(ivmap[y1][x1]);
		int c2_x = GridPane.getColumnIndex(ivmap[y2][x2]);
		int c2_y = GridPane.getRowIndex(ivmap[y2][x2]);
		int c3_x = GridPane.getColumnIndex(ivmap[y3][x3]);
		int c3_y = GridPane.getRowIndex(ivmap[y3][x3]);
		int c4_x = GridPane.getColumnIndex(ivmap[y4][x4]);
		int c4_y = GridPane.getRowIndex(ivmap[y4][x4]);
		int c5_x = GridPane.getColumnIndex(ivmap[y5][x5]);
		int c5_y = GridPane.getRowIndex(ivmap[y5][x5]);
		if(e.getCode() == KeyCode.UP && move == true && lose != true){
			if(map2[b_y - 1][b_x] != 1) {
				if(map2[b_y - 1][b_x] != 21 && map2[b_y - 1][b_x] != 22 && map2[b_y - 1][b_x] != 23 && map2[b_y - 1][b_x] != 24 && map2[b_y - 1][b_x] != 25){
					map2[b_y][b_x] = 0;
					b_y -= 1;
					step++;
					Step.setText("Step: " + Integer.toString(step));
					map2[b_y][b_x] = 4;
				}
				else if((map2[b_y - 2][b_x] == 0 || map2[b_y - 2][b_x] == 3)){
		        	switch(map2[b_y - 1][b_x]) {
		        		case 21:
		        			if(map2[c1_y - 1][c1_x] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c1_y][c1_x] = 4;
		        				c1_y -= 1;
		        				map2[c1_y][c1_x] = 21;
		        			}
		        			break;
		        		case 22:
		        			if(map2[c2_y - 1][c2_x] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c2_y][c2_x] = 4;
		        				c2_y -= 1;
			        			map2[c2_y][c2_x] = 22;
		        			}
			        		break;
		        		case 23:
		        			if(map2[c3_y - 1][c3_x] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c3_y][c3_x] = 4;
		        				c3_y -= 1;
			        			map2[c3_y][c3_x] = 23;
		        			}
			        		break;
		        		case 24:
		        			if(map2[c4_y - 1][c4_x] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c4_y][c4_x] = 4;
		        				c4_y -= 1;
		        				map2[c4_y][c4_x] = 24;
		        			}
		        			break;
		        		case 25:
		        			if(map2[c5_y - 1][c5_x] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c5_y][c5_x] = 4;
		        				c5_y -= 1;
		        				map2[c5_y][c5_x] = 25;
		        			}
		            }
		        	b_y -= 1;
		        	step++;
		        	Step.setText("Step: " + Integer.toString(step));
			    }  		
			}
		}
		if(e.getCode() == KeyCode.DOWN && move == true && lose != true){
			if(map2[b_y + 1][b_x] != 1) {
				if(map2[b_y + 1][b_x] != 21 && map2[b_y + 1][b_x] != 22 && map2[b_y + 1][b_x] != 23 && map2[b_y + 1][b_x] != 24 && map2[b_y + 1][b_x] != 25){
					map2[b_y][b_x] = 0;
					b_y += 1;
					step++;
					Step.setText("Step: " + Integer.toString(step));
					map2[b_y][b_x] = 4;
				}
				else if((map2[b_y + 2][b_x] == 0 || map2[b_y + 2][b_x] == 3)){
		        	switch(map2[b_y + 1][b_x]) {
		        		case 21:
		        			if(map2[c1_y + 1][c1_x] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c1_y][c1_x] = 4;
		        				c1_y += 1;
		        				map2[c1_y][c1_x] = 21;
		        			}
		        			break;
		        		case 22:
		        			if(map2[c2_y + 1][c2_x] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c2_y][c2_x] = 4;
		        				c2_y += 1;
			        			map2[c2_y][c2_x] = 22;
		        			}
			        		break;
		        		case 23:
		        			if(map2[c3_y + 1][c3_x] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c3_y][c3_x] = 4;
		        				c3_y += 1;
			        			map2[c3_y][c3_x] = 23;
		        			}
			        		break;
		        		case 24:
		        			if(map2[c4_y + 1][c4_x] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c4_y][c4_x] = 4;
		        				c4_y += 1;
		        				map2[c4_y][c4_x] = 24;
		        			}
		        			break;
		        		case 25:
		        			if(map2[c5_y + 1][c5_x] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c5_y][c5_x] = 4;
		        				c5_y += 1;
		        				map2[c5_y][c5_x] = 25;
		        			}
		            }
		        	b_y += 1;
		        	step++;
		        	Step.setText("Step: " + Integer.toString(step));
			    }
			}	
		}
		if(e.getCode() == KeyCode.LEFT && move == true && lose != true){
			ivmap[y][x].setImage(b3);
			if(map2[b_y][b_x - 1] != 1) {
				if(map2[b_y][b_x - 1] != 21 && map2[b_y][b_x - 1] != 22 && map2[b_y][b_x - 1] != 23 && map2[b_y][b_x - 1] != 24 && map2[b_y][b_x - 1] != 25){
					map2[b_y][b_x] = 0;
					b_x -= 1;
					step++;
					Step.setText("Step: " + Integer.toString(step));
					map2[b_y][b_x] = 4;
				}
				else if((map2[b_y][b_x - 2] == 0 || map2[b_y][b_x - 2] == 3)){
		        	switch(map2[b_y][b_x - 1]) {
		        		case 21:
		        			if(map2[c1_y][c1_x - 1] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c1_y][c1_x] = 4;
		        				c1_x -= 1;
		        				map2[c1_y][c1_x] = 21;
		        			}
		        			break;
		        		case 22:
		        			if(map2[c2_y][c2_x - 1] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c2_y][c2_x] = 4;
		        				c2_x -= 1;
			        			map2[c2_y][c2_x] = 22;
		        			}
			        		break;
		        		case 23:
		        			if(map2[c3_y][c3_x - 1] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c3_y][c3_x] = 4;
		        				c3_x -= 1;
			        			map2[c3_y][c3_x] = 23;
		        			}
			        		break;
		        		case 24:
		        			if(map2[c4_y][c4_x - 1] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c4_y][c4_x] = 4;
		        				c4_x -= 1;
		        				map2[c4_y][c4_x] = 24;
		        			}
		        			break;
		        		case 25:
		        			if(map2[c5_y][c5_x - 1] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c5_y][c5_x] = 4;
		        				c5_x -= 1;
		        				map2[c5_y][c5_x] = 25;
		        			}
		        			break;
		            }
		        	b_x -= 1;
		        	step++;
		        	Step.setText("Step: " + Integer.toString(step));
			    }  
			}
		}
		if(e.getCode() == KeyCode.RIGHT && move == true && lose != true) {
			ivmap[y][x].setImage(b1);
			if(map2[b_y][b_x + 1] != 1) {
				if(map2[b_y][b_x + 1] != 21 && map2[b_y][b_x + 1] != 22 && map2[b_y][b_x + 1] != 23 && map2[b_y][b_x + 1] != 24 && map2[b_y][b_x + 1] != 25){
					map2[b_y][b_x] = 0;
					b_x += 1;
					step++;
					Step.setText("Step: " + Integer.toString(step));
					map2[b_y][b_x] = 4;
				}
				else if((map2[b_y][b_x + 2] == 0 || map2[b_y][b_x + 2] == 3)){
		        	switch(map2[b_y][b_x + 1]) {
		        		case 21:
		        			if(map2[c1_y][c1_x + 1] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c1_y][c1_x] = 4;
		        				c1_x += 1;
		        				map2[c1_y][c1_x] = 21;      				
		        			}
		        			break;	
		        		case 22:
		        			if(map2[c2_y][c2_x + 1] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c2_y][c2_x] = 4;
		        				c2_x += 1;
			        			map2[c2_y][c2_x] = 22;
		        			}
		        			break;
		        		case 23:
		        			if(map2[c3_y][c3_x + 1] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c3_y][c3_x] = 4;
		        				c3_x += 1;
			        			map2[c3_y][c3_x] = 23;
		        			}
			        		break;
		        		case 24:
		        			if(map2[c4_y][c4_x + 1] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c4_y][c4_x] = 4;
		        				c4_x += 1;
		        				map2[c4_y][c4_x] = 24;
		        			}
		        			break;
		        		case 25:
		        			if(map2[c5_y][c5_x + 1] != 1) {
		        				map2[b_y][b_x] = 0;
		        				map2[c5_y][c5_x] = 4;
		        				c5_x += 1;
		        				map2[c5_y][c5_x] = 25;
		        			}
		        			break;
		            }
		        	b_x += 1;
		        	step++;
		        	Step.setText("Step: " + Integer.toString(step));
				}				
			}
		}
		GridPane.setRowIndex(ivmap[y][x], b_y);
		GridPane.setColumnIndex(ivmap[y][x], b_x);
		GridPane.setRowIndex(ivmap[y1][x1], c1_y);
		GridPane.setColumnIndex(ivmap[y1][x1], c1_x);
		GridPane.setRowIndex(ivmap[y2][x2], c2_y);
		GridPane.setColumnIndex(ivmap[y2][x2], c2_x);
		GridPane.setRowIndex(ivmap[y3][x3], c3_y);
		GridPane.setColumnIndex(ivmap[y3][x3], c3_x);
		GridPane.setRowIndex(ivmap[y4][x4], c4_y);
		GridPane.setColumnIndex(ivmap[y4][x4], c4_x);
		GridPane.setRowIndex(ivmap[y5][x5], c5_y);
		GridPane.setColumnIndex(ivmap[y5][x5], c5_x);
		if(omap[c1_y][c1_x] == 3 && omap[c2_y][c2_x] == 3 && (omap[c3_y][c3_x] == 3 || omap[c3_y][c3_x] == 1) && (omap[c4_y][c4_x] == 3 || omap[c4_y][c4_x] == 1) && (omap[c5_y][c5_x] == 3 || omap[c5_y][c5_x] == 1)) {
			finish.setVisible(true);
			T = false;
		}
		if(step <= 120 && min == 4)
			star.setImage(s3);
		else if(step > 120 && step <= 140)
			star.setImage(s2);
		else if(step > 140 && step <= 150)
			star.setImage(s1);
		else {
			lose = true;
			Lose.setVisible(lose);
		}
	};
	public void initialize(URL arg0, ResourceBundle arg1) {
		Timeline walk= new Timeline(new KeyFrame(Duration.millis(250),(e)->{
			if(move) {
				if(ivmap[y][x].getImage() == b3 || ivmap[y][x].getImage() == b4) {
					ivmap[y][x].setImage(b[n]);
					if(n == 2)
						n = 3;
					else
						n = 2;
				}
				else{
					ivmap[y][x].setImage(b[m]);
					if(m == 0)
						m = 1;
					else
						m = 0;				
				}
				
			}
		}));
		walk.setCycleCount(Timeline.INDEFINITE);
		walk.play();
		Timeline set= new Timeline(new KeyFrame(Duration.millis(1),(e)->{
			setmap();
			wdow.setHeight(21);
			wdow.setWidth(21);
			wdow.setSpread(0.5);
			wdow.setRadius(10);
			cdow.setHeight(15);
			cdow.setWidth(15);
			cdow.setSpread(0.2);
			cdow.setRadius(7);
			Step.setText("Step: " + Integer.toString(step));
			for(int f = 0; f < 7; f++) {
				for(int g = 0; g < 11; g++)
					map2[f][g] = omap[f][g]; 
			}
		}));
		set.play();
	Timeline t = new Timeline(new KeyFrame(Duration.millis(1000),(e)->{
			if(T) {
				String Time = "";//save the running time
				sec--;
				if(sec == 0) {
					if(min == 0 && sec == 0) {
						lose = true;
						Lose.setVisible(lose);
						T = false;
						move = false;
					}
					else {
						sec = sec + 59;
						min--;
					}
				}
				Time = Time + String.format("%02d", min) + ":" + String.format("%02d", sec);
				time.setText(Time);
			}
		}));
	    t.setCycleCount(Timeline.INDEFINITE);
		t.play();
	}
	public void Back(ActionEvent e) throws IOException {
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/level.fxml"));
	    Parent level = loadder.load();
	    Scene levelScene = new Scene(level);
	    finalproject.mainStage.setScene(levelScene);
	}
	public void Next(ActionEvent e) throws IOException {
		if(barrier != 9) {
			barrier++;
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
		    Parent e1 = loadder.load();
		    Scene MainScene = new Scene(e1);
		    map3 mazeCtrl = loadder.getController();
		    MainScene.setOnKeyPressed(mazeCtrl.onKeyPressed);
		    finalproject.mainStage.setScene(MainScene);
		}
		else if(barrier == 9) {
			FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/level.fxml"));
		    Parent level = loadder.load();
		    Scene levelScene = new Scene(level);
		    finalproject.mainStage.setScene(levelScene);
		}
	}
	public void Reset(ActionEvent e) throws IOException {
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/map3.fxml"));
	    Parent reset = loadder.load();
	    Scene MainScene = new Scene(reset);
	    map3 mazeCtrl = loadder.getController();
	    MainScene.setOnKeyPressed(mazeCtrl.onKeyPressed);
	    finalproject.mainStage.setScene(MainScene);
	}
	public void Pause(ActionEvent e) throws IOException {
		pause.setVisible(true);
		move = false;
		T = false;
	}
	public void Conti(ActionEvent e) throws IOException {
		pause.setVisible(false);
		move = true;
		T = true;
	}
	public void menu(ActionEvent e) throws IOException {
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/level.fxml"));
	    Parent level = loadder.load();
	    Scene levelScene = new Scene(level);
	    finalproject.mainStage.setScene(levelScene);
	}
}
