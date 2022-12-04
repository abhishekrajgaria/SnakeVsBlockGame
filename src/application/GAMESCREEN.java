package application;

import java.io.File;
//import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler; 
import javafx.scene.input.*;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
//import javafx.scene.layout.BorderPane;
abstract class Tokens{
	
	public abstract void power();
	public abstract String identity();
	public abstract void setxcord(double x);
	public abstract void setycord(double y);
	public abstract void stoprotate();
	public abstract void resumerotate();
	public abstract double getxcord();
	public abstract double getycord();
	public abstract void update();
	public abstract Circle gettoken();
	public abstract void setvisibilty(boolean b);
	public abstract boolean getvisibilty();
}

public class GAMESCREEN extends Application implements Serializable{
 
int flag = 0;
int flag2 = 0;
int counter1 = 0;
int counter2 = 0;
Date date=new Date();
Snake snake ;
Block block1 = new Block(0,-75);
Block block2 = new Block(0,-475);
Wall wall1 = new Wall(225,-400,75);
Label Coins=new Label();
Label Score=new Label();
Wall wall2 = new Wall(225,-800,75);
Rectangle dropmenu1=new Rectangle(250,400);
Button resumebtn1=new Button();
Button restartbtn1=new Button();
Button exitbtn1=new Button();
//Wall wall1 = new Wall(225,-400,75);
//
//Wall wall2 = new Wall(225,-800,75);
MainPage mp=new MainPage();
MainPage mp1=new MainPage();
ArrayList<TranslateTransition> trans = new ArrayList<TranslateTransition>();

 Timeline time1 = new Timeline();
 Timeline time2 = new Timeline();
 Timeline time3 = new Timeline();
 Timeline time4 = new Timeline();
 Timeline time5 = new Timeline();
 Timeline time6 = new Timeline();
 Timeline time7 = new Timeline();
 Timeline time8 = new Timeline();
 Timeline time10 = new Timeline();
 
 /**
  * This method will stop all the timelines
  * @param t1 this is t1 for rotate tranistion
  * @param t2 this is t2 for rotate tranistion
  */
 public void rukzau(Token t1,Token t2) {
	 time1.stop();
		time2.stop();
		time3.stop();
		t1.stoprotate();
		time5.stop();
		time6.stop();
		t2.stoprotate();
		time10.stop();
 }
 /**
  * This method will resume all the timelines
  * @param t1 this is t1 for rotate tranistion
  * @param t2 this is t2 for rotate tranistion

  */
 public void resume(Token t1, Token t2) {
	 time1.play();
		time2.play();
		time3.play();
		t1.resumerotate();
		time5.play();
		time6.play();
		t2.resumerotate();
		time10.play();
		
 }
 
 /**
  * This method is the collision method between wall and blocks
  * @param blck this is block
  * @param c1 this is snake head
  * @param Score this score label
  * @param t1 this is rotate tranistion
  * @param t2 this is rotate transition
  * @param date this date label
  * @param month this month label
  * @param year this year label
  * @param dropmenu1 this is a rectangle
  * @param restartbtn1 this is button
  * @param exitbtn1 this a button
  * @throws Exception this is an exception
  */
 public void collide12(Block blck,Circle c1,Label Score,Token t1,Token t2,Label date,Label month,Label year,Rectangle dropmenu1,Button restartbtn1,Button exitbtn1) throws Exception {
		int value=0,value1=0;
		for(int i=0;i<blck.getBlocks().size();i++) {
		if(blck.getblockitem(i).isVisible() && !blck.getdestitem(i)){
		   if(blck.getYcordblock(i)+73 <= snake.getHead().getCenterY()+7.5 && snake.getHead().getCenterY()+7.5<=blck.getYcordblock(i)+77 && blck.getXcordblock(i)<=snake.getHead().getCenterX() && blck.getXcordblock(i)+75>=snake.getHead().getCenterX() ) {
//			   System.out.println(blck.getdestitem(i)+"HARAMKHOR SMJJHA");
			
			int itemnum = i;
			Image burst=new Image(new FileInputStream("C:\\\\Users\\\\shiva\\\\eclipse-workspace\\\\SnakeVersusBlock\\\\src\\\\application\\\\stars.png"));
			if(snake.getPower()==0) {
				Timeline time11 = new Timeline();
				rukzau(t1, t2);
				int del = Integer.parseInt(blck.getTexi().get(i).getText());
				int keeper = snake.getLength();
				
//				System.out.println(Math.min(del, snake.getLength())+"CHECK KRLNE KE LIYE");
				int realdel = Math.min(del, snake.getLength());
				time11.setCycleCount(Math.min(del, snake.getLength()));
				KeyFrame key11 = new KeyFrame(Duration.millis(50),e->{
//					System.out.println("time1111111111111111111111111111111111111111111");
					if(snake.getLength()>=1) {
			    		if(snake.getPower()==0 && realdel>0) {
			    			snake.delete();
			    			 blck.settexiitem(itemnum, Integer.parseInt(blck.getTexi().get(itemnum).getText())-1);
			    			 Score.setText(Integer.toString(Integer.parseInt(Score.getText().toString())+1));
			    			   
			    			
			    		}
					}
			    	//value=Integer.parseInt(Score.getText().toString());
				    //value1=value+1;
					 if(snake.getLength()==0) {
//						 System.out.println("KHHHHHHHHTTTTTAAAAAMMMM");
//						 System.out.println("Right "+Score.getText());
						 Label l=new Label();
						 l.setText(Score.getText());
						 LeaderPage.update1(l, date, month, year);
						 try
						 {
							SaveData datas=new SaveData();
							for(int k=0;k<LeaderPage.scores.size();k++)
							{
								datas.scores.add(LeaderPage.scores.get(k).getText());
								datas.date.add(LeaderPage.date.get(k).getText());
								datas.month.add(LeaderPage.month.get(k).getText());
								datas.year.add(LeaderPage.year.get(k).getText());
							}
							ResourceManager.save(datas, "LEADERDATA.dat");
							
						 }catch(Exception e2)
						 {
//							 e2.printStackTrace();
						 }
						 dropmenu1.setVisible(true);
						 restartbtn1.setVisible(true);
						 exitbtn1.setVisible(true);
							rukzau(t1, t2);
						}
//					 System.out.println(snake.getLength()+"ok");
//					 System.out.println(keeper);
//					 System.out.println(Integer.parseInt(blck.getTexi().get(itemnum).getText())<=0 && snake.getLength()>0); 
					 
						if(Integer.parseInt(blck.getTexi().get(itemnum).getText())<=0) {
						    FadeTransition ft=new FadeTransition(Duration.seconds(0.5));
							ft.setFromValue(0.0);
							ft.setToValue(50.0);
							ft.setAutoReverse(true);
							ft.setCycleCount(1);
							ft.setNode(blck.getblockitem(itemnum));
							
							blck.setFillblockimage(itemnum, burst);
							blck.setdestitem(itemnum, true);
						    ft.play();
						    
						    resume(t1, t2);
						}
				   
				});
				time11.getKeyFrames().addAll(key11);
				
					time11.play();
				
			}
			
			else {
				 FadeTransition ft=new FadeTransition(Duration.seconds(0.5));
					ft.setFromValue(0.0);
					ft.setToValue(50.0);
					ft.setAutoReverse(true);
					ft.setCycleCount(1);
					ft.setNode(blck.getblockitem(itemnum));
					
					blck.setFillblockimage(itemnum, burst);
					blck.setdestitem(itemnum, true);
					Score.setText(Integer.toString(Integer.parseInt(Score.getText().toString())+Integer.parseInt(blck.getTexi().get(itemnum).getText())));
				    ft.play();
				   // resume(t1, t2);
			}
			
//			for(int j=0;j<del;j++) {
//				//rukzau(t1, t2);
//		    	
//		    	
//		    } 
			
		    //System.out.println("value of rect is: "+Integer.parseInt(blck.getTexi().get(i).getText()));
			
		    
		    
		    break;
		   }
		 }
	  }
	 }
 /**
  * This method is called when snake collides with ball
  * @param ball this is the ball object
  * @param snake this is the snake object
  */
	 public void collideball(Ball ball, Snake snake) {
		 if(ball.getvisibility()) {
		  if(ball.getBall().getBoundsInParent().intersects(snake.getHead().getBoundsInParent())) {
		   ball.setvisiblity(false);
		   int ad = Integer.parseInt(ball.getText().getText());
		   for(int j=0;j<ad;j++) {
			   snake.add();
		   }
		   
		   //System.out.println("BOOOOOOOOOOOOOOOOOOOOOOOOOOOOMMMMMMMMMMMMMMMMMMMMMMMM");
		   
		  }
		 }
	 }
	 /**
	  * This method is called when snake collide with tokens
	  * @param token this is the token object 
	  * @param snake this is the snake object
	  * @param image1 this is the image
	  * @param image2 this is also an image
	  * @param image3 this is also an image
	  * @param image5 this is alos an image
	  * @param Score this is the score label
	  * @throws Exception this is an exception
	  */
	 public void collidetoken(Token token,Snake snake,Image image1,Image image2,Image image3,Image image5,Label Score ) throws Exception {
		 //token.power(snake, ball1, ball2, ball3, ball4, ball5, ball6, counter1, counter2, block1, block2);
		 if(token.getvisibilty()) {
		  if(token.gettoken().getBoundsInParent().intersects(snake.getHead().getBoundsInParent())) {
		   token.setvisibilty(false);
		   if(token.getidentity()==1) { //sheild
//			   System.out.println("hello brooooooooooooooo");
			   snake.setPower(1);
			   counter1 = 0;
			   snake.getShbub().setVisible(true);
			   //token.power(snake, ball1, ball2, ball3, ball4, ball5, ball6, counter1, counter2, block1, block2);
		   }
		   
		   else if(token.getidentity()==2) { //coin
			   int val=Integer.parseInt(Coins.getText());
			   val++;
			   Coins.setText(Integer.toString(val));
		   }
		   else if(token.getidentity()==3) {//magnet
//			   System.out.println("yahooooooooooooo");
			   snake.setPower2(1);
			   counter2 =0;
			   snake.getMgbub().setVisible(true);
			   //token.power(snake, ball1, ball2, ball3, ball4, ball5, ball6, counter1, counter2, block1, block2);
		   }
		   else if(token.getidentity()==4) { //mystry
			   int[] takitaki = {1,2,3,4};
			   int rumba = takitaki[new Random().nextInt(takitaki.length)];
			   if(rumba==1) {
				   token.setimage(image1);
				   token.setidentity(1);
//				   System.out.println("shield");
				   snake.setPower(1);
				   counter1 = 0;
				   snake.getShbub().setVisible(true);
			   }
			   else if(rumba==2) {
				   token.setimage(image2);
				   token.setidentity(2);
//				   System.out.println("coin");
				   int val=Integer.parseInt(Coins.getText());
				   val++;
				   Coins.setText(Integer.toString(val));
			   }
			   else if(rumba==3) {
				   token.setimage(image3);
				   token.setidentity(3);
//				   System.out.println("magnet");
				   snake.setPower2(1);
				   counter2=0;
				   snake.getMgbub().setVisible(true);
			   }
			   else if(rumba==4) {
				   token.setimage(image5);
				   token.setidentity(5);
//				   System.out.println("destroy");
				   Image burst=new Image(new FileInputStream("C:\\\\Users\\\\shiva\\\\eclipse-workspace\\\\SnakeVersusBlock\\\\src\\\\application\\\\\\stars.png"));
				   if(block1.getYcordblock(0)>=0) {
					   for(int i=0;i<6;i++) {
						   if(block1.getblockitem(i).isVisible()) {
							   block1.setFillblockimage(i, burst);
							   block1.setdestitem(i, true);
							   Score.setText(Integer.toString(Integer.parseInt(Score.getText().toString())+Integer.parseInt(block1.getTexi().get(i).getText())));
						   }
					   }
				   }
				   if(block2.getYcordblock(0)>=0) {
					   for(int i=0;i<6;i++) {
						   if(block2.getblockitem(i).isVisible()) {
							   block2.setFillblockimage(i, burst);
							   block2.setdestitem(i, true);
							   Score.setText(Integer.toString(Integer.parseInt(Score.getText().toString())+Integer.parseInt(block2.getTexi().get(i).getText())));
						   }
					   }
				   }
				   if(wall1.getwallycord()>=-75) {
					   wall1.getWall().setFill(new ImagePattern(burst));
				   }
				   if(wall2.getwallycord()>=-75) {
					   wall2.getWall().setFill(new ImagePattern(burst));
				   }
			   }
			   
			   
			   
		   }
		   else if(token.getidentity()==5) {//destroyer
			   Image burst=new Image(new FileInputStream("C:\\\\Users\\\\shiva\\\\eclipse-workspace\\\\SnakeVersusBlock\\\\src\\\\application\\\\\\stars.png"));
			   if(block1.getYcordblock(0)>=0) {
				   for(int i=0;i<6;i++) {
					   if(block1.getblockitem(i).isVisible()) {
						   block1.setFillblockimage(i, burst);
						   block1.setdestitem(i, true);
						   Score.setText(Integer.toString(Integer.parseInt(Score.getText().toString())+Integer.parseInt(block1.getTexi().get(i).getText())));
					   }
				   }
			   }
			   if(block2.getYcordblock(0)>=0) {
				   for(int i=0;i<6;i++) {
					   if(block2.getblockitem(i).isVisible()) {
						   block2.setFillblockimage(i, burst);
						   block2.setdestitem(i, true);
						   Score.setText(Integer.toString(Integer.parseInt(Score.getText().toString())+Integer.parseInt(block2.getTexi().get(i).getText())));
					   }
				   }
			   }
			   if(wall1.getwallycord()>=-75) {
				   wall1.getWall().setFill(new ImagePattern(burst));
			   }
			   if(wall2.getwallycord()>=-75) {
				   wall2.getWall().setFill(new ImagePattern(burst));
			   }
		   }
		   //System.out.println("BOOOOOOOOOOOOOOOOOOOOOOOOOOOOMMMMMMMMMMMMMMMMMMMMMMMM");
		   
		  }
		 }
		}
/**
 * This method is called when snake collides with wall
 * @param wall this  is the wall object
 * @param c1 this is the circle
 */
	 public void collide56(Wall wall,Circle c1) {
			//System.out.println(wall.checker(c1));
			if(wall.checker(c1)==1) {
				//System.out.println("ONLY GO TO RIGHT");
				flag =1;
			}
			else if(wall.checker(c1)==-1) {
				//System.out.println("ONLY GO TO LEFT");
				flag = 2;
			}
			else flag = 0; //System.out.println("YOU ARE FREE");
		 }
		 public void othercollide56(Wall wall,Circle c1) {
				//System.out.println(wall.checker(c1));
				if(wall.checker(c1)==1) {
					//System.out.println("ONLY GO TO RIGHT");
					flag2 =1;
				}
				else if(wall.checker(c1)==-1) {
					//System.out.println("ONLY GO TO LEFT");
					flag2 = 2;
				}
				else flag2 = 0; //System.out.println("YOU ARE FREE");
			 }
		 
	 
	 
 
 @Override
 /**
  * Launcher function for the gamescreen
  */
 public void start(Stage stage) throws IOException{
	 Media media = new Media(new File("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\music.mp3").toURI().toString()); 
     MediaPlayer player = new MediaPlayer(media); 
     player.play();
	 Image background=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\red.png"));
	 
	 dropmenu1.setFill(new ImagePattern(background));
	 dropmenu1.setArcHeight(20);
	 dropmenu1.setArcWidth(20);
	 dropmenu1.setLayoutX(100);
	 dropmenu1.setLayoutY(100);
	 dropmenu1.setVisible(false);
	 restartbtn1.setPrefSize(200, 50);
	 restartbtn1.setLayoutX(125);
	 restartbtn1.setLayoutY(250);
	 restartbtn1.setText("R E S T A R T");
	 exitbtn1.setPrefSize(200, 50);
	 exitbtn1.setLayoutX(125);
	 exitbtn1.setLayoutY(350);
	 exitbtn1.setText("M A I N M E N U");
	 resumebtn1.setVisible(false);
	 restartbtn1.setVisible(false);
	 exitbtn1.setVisible(false);


	 for(int i=0;i<10;i++)
	   {
		   Label l=new Label();
		   LeaderPage.scores.add(l);
	   }
	   for(int i=0;i<10;i++)
	   {
		   Label l=new Label();
		   LeaderPage.date.add(l);
	   }
	   for(int i=0;i<10;i++)
	   {
		   Label l=new Label();
		   LeaderPage.month.add(l);
	   }
	   for(int i=0;i<10;i++)
	   {
		   Label l=new Label();
		   LeaderPage.year.add(l);
	   }
	 try
	 {
		 File f=new File("LEADERDATA.dat");
		SaveData data=(SaveData) ResourceManager.load(f.getName());
		for(int i=0;i<10;i++)
		{
			LeaderPage.scores.get(i).setText(data.scores.get(i));
			LeaderPage.date.get(i).setText(data.date.get(i));
			LeaderPage.month.get(i).setText(data.month.get(i));
			LeaderPage.year.get(i).setText(data.year.get(i));
		}
//		System.out.println("Abhi "+data.scores.get(0));
	 }
   catch(Exception e)
   {
//	   e.printStackTrace();
   }
	 
	 boolean flag3=false;
//	System.out.println(date.toString()+" jaadoo");

	 String str=date.toString();
	 String[] arr=str.split(" ");
	 String currdate=arr[2];
	 String currmonth=arr[1];
	 String curryear=arr[arr.length-1];
	 
	 Label date1=new Label();
	 date1.setText(currdate);
	 Label month1=new Label();
	 month1.setText(currmonth);
	 Label year1=new Label();
	 year1.setText(curryear);
	// System.out.println(calendar.get);
	 Group root1 = new Group();
		Image img1=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\football1.png"));
		Image img2=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\dots.jpg"));
		Image img3=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\basketball.png"));
		Image img4=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\purple.png"));
		Image img5=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\billiard.png"));
		Image img6=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\watermelon.png"));
		Image img7=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\mudcrack.jpg"));
		Image img8=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\metalball.png"));
		Image img9=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\cracks.jpg"));
		Image img10=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\emoji1.png"));
		Image img11=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\yinyang.png"));
		Image img12=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\emoji2.png"));
		Image img13=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\orange.png"));
		Image img14=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\mosaic.png"));
		Image img15=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\pizza.png"));
		Image mgb1 = new Image(new FileInputStream("C:\\\\Users\\\\shiva\\\\eclipse-workspace\\\\SnakeVersusBlock\\\\src\\\\application\\\\\\t1bubble.png"));
		Image shb1 = new Image(new FileInputStream("C:\\\\Users\\\\shiva\\\\eclipse-workspace\\\\SnakeVersusBlock\\\\src\\\\application\\\\\\mbubble.png"));
		
		
		
		Circle ca1=new Circle();
		Circle ca2=new Circle();
		Circle ca3=new Circle();
		Circle ca4=new Circle();
		Circle ca5=new Circle();
		Circle ca6=new Circle();
		Circle ca7=new Circle();
		Circle ca8=new Circle();
		Circle ca9=new Circle();
		Circle ca10=new Circle();
		Circle ca11=new Circle();
		Circle ca12=new Circle();
		Circle ca13=new Circle();
		Circle ca14=new Circle();
		Circle ca15=new Circle();
		
		ca1.setFill(new ImagePattern(img1));
		ca2.setFill(new ImagePattern(img2));
		ca3.setFill(new ImagePattern(img3));
		ca4.setFill(new ImagePattern(img4));
		ca5.setFill(new ImagePattern(img5));
		ca6.setFill(new ImagePattern(img6));
		ca7.setFill(new ImagePattern(img7));
		ca8.setFill(new ImagePattern(img8));
		ca9.setFill(new ImagePattern(img9));
		ca10.setFill(new ImagePattern(img10));
		ca11.setFill(new ImagePattern(img11));
		ca12.setFill(new ImagePattern(img12));
		ca13.setFill(new ImagePattern(img13));
		ca14.setFill(new ImagePattern(img14));
		ca15.setFill(new ImagePattern(img15));
		
	 if(MainPage.whatclicked==1)
	 {
//		 System.out.println("I am here hello plz take me away");
		 snake = new Snake(153,400,5);
		 Score.setText("0");
		 Coins.setText("0");
	 }
	 else
	 {
		 try
		 {
			 File f=new File("GAMEDATA.dat");
				SaveData data=(SaveData) ResourceManager.load(f.getName());
//				System.out.println("I like being here hello plz take me away "+data.snakeavatarnum);
//				System.out.println("hellloooo"+data.currscore);
				Score.setText(data.currscore);
				Coins.setText(data.currcoins);
				int lambai = data.snakelenght;
				if(lambai==0)
				{
					flag3=true;
					snake=new Snake(153,400,5);
				}
				if(flag3==false)
				{
				ArrayList<Circle> temp = new ArrayList<Circle>();
				for(int i=0;i<data.getSnakeballxs().size();i++)
				{
					Circle c=new Circle();
					c.setCenterX(data.getSnakeballxs().get(i));
					c.setCenterY(data.getSnakeballys().get(i));
					c.setRadius(data.getSnakeballradius().get(i));
					c.setVisible(data.getSnakeballvisibility().get(i));
					temp.add(i, c);
				}
				snake=new Snake(temp.get(0).getCenterX(),temp.get(0).getCenterY(),lambai);
				if(data.snakeavatarnum==1)
				{
//					System.out.println("Football I am");
					snake.getSnake().get(0).setFill(new ImagePattern(img1));
					AvatarPage.img=img1;
				}
				else if(data.snakeavatarnum==2)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img2));
					AvatarPage.img=img2;
				}
				else if(data.snakeavatarnum==3)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img3));
					AvatarPage.img=img3;
				}
				else if(data.snakeavatarnum==4)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img4));
					AvatarPage.img=img4;
				}
				else if(data.snakeavatarnum==5)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img5));
					AvatarPage.img=img5;
				}
				else if(data.snakeavatarnum==6)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img6));
					AvatarPage.img=img6;
				}
				else if(data.snakeavatarnum==7)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img7));
					AvatarPage.img=img7;
				}
				else if(data.snakeavatarnum==8)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img8));
					AvatarPage.img=img8;
				}
				else if(data.snakeavatarnum==9)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img9));
					AvatarPage.img=img9;
				}
				else if(data.snakeavatarnum==10)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img10));
					AvatarPage.img=img10;
				}
				else if(data.snakeavatarnum==11)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img11));
					AvatarPage.img=img11;
				}
				else if(data.snakeavatarnum==12)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img12));
					AvatarPage.img=img12;
				}
				else if(data.snakeavatarnum==13)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img13));
					AvatarPage.img=img13;
				}
				else if(data.snakeavatarnum==14)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img14));
					AvatarPage.img=img14;
				}
				else if(data.snakeavatarnum==15)
				{
					snake.getSnake().get(0).setFill(new ImagePattern(img15));
					AvatarPage.img=img15;
				}
				else
				{
					snake.getSnake().get(0).setFill(Color.YELLOW);
				}
				for(int i=0;i<snake.getSnake().size();i++)
				{
					snake.getSnake().get(i).setFill(snake.getHead().getFill());
				}
				}
		 }catch(Exception e)
		 {
//			 e.printStackTrace();
		 }
	 }
	 
	 snake.setTclr();
//	 System.out.println("Avatar is"+AvatarPage.img);
	 snake.setAvatar(AvatarPage.img);
	   Image image1 = new Image(new FileInputStream("C:\\\\Users\\\\shiva\\\\eclipse-workspace\\\\SnakeVersusBlock\\\\src\\\\application\\\\shield.png"));
	   Image image2 = new Image(new FileInputStream("C:\\\\Users\\\\shiva\\\\eclipse-workspace\\\\SnakeVersusBlock\\\\src\\\\application\\\\Coin.png"));
	   Image image3 = new Image(new FileInputStream("C:\\\\Users\\\\shiva\\\\eclipse-workspace\\\\SnakeVersusBlock\\\\src\\\\application\\\\magnet.png"));
	   Image image4 = new Image(new FileInputStream("C:\\\\Users\\\\shiva\\\\eclipse-workspace\\\\SnakeVersusBlock\\\\src\\\\application\\\\mystrettoken.png"));
	   Image image5 = new Image(new FileInputStream("C:\\\\Users\\\\shiva\\\\eclipse-workspace\\\\SnakeVersusBlock\\\\src\\\\application\\\\destroyall.png"));
	   Image image6 = new Image(new FileInputStream("C:\\\\Users\\\\shiva\\\\eclipse-workspace\\\\SnakeVersusBlock\\\\src\\\\application\\\\pause.png"));
	   
	   snake.getMgbub().setFill(new ImagePattern(mgb1));
		snake.getShbub().setFill(new ImagePattern(shb1));
		
		Image[] imagi = {image1,image2,image3,image4,image5};
		Ball ball4 = new Ball(400,-710,snake.getHead());
		Ball ball5 = new Ball(400,-630,snake.getHead());
		Ball ball6 = new Ball(400,-550,snake.getHead());
		Ball ball1 = new Ball(100,-310,snake.getHead());
		Ball ball2 = new Ball(100,-230,snake.getHead());
		Ball ball3 = new Ball(100,-150,snake.getHead());
		int[] imagenumbers= {1,2,3,4,5};
		Token token1 = new Token(-310,image2);
		token1.setidentity(2);
		Token token4 = new Token(-710,image2);
		token4.setidentity(2);
	 ArrayList<Circle> as=new ArrayList<Circle>();
		try
		{
			if(MainPage.whatclicked==2)
			{
				if(flag3==false)
				{
//				System.out.println("Snake text is"+snake.getText().getText());
				File f=new File("GAMEDATA.dat");
			SaveData data=(SaveData) ResourceManager.load(f.getName());
//			if(snake.getText().getText().equals("0"))
//			{
//				MainPage.whatclicked=1;
//				GAMESCREEN gs1=new GAMESCREEN();
//				gs1.start(stage);
//			}
			for(int i=0;i<data.getBlockxs().size();i++)
			{
				Rectangle r=new Rectangle();
				r.setX(data.getBlockxs().get(i));
				r.setY(data.getBlockys().get(i));
				r.setWidth(data.getBlockwidth().get(i));
				r.setHeight(data.getBlockheight().get(i));
				r.setArcWidth(data.getBlockarcwidth().get(i));
				r.setArcHeight(data.getBlockarcheight().get(i));
				r.setVisible(data.getBlockvisibilities().get(i));
				if(data.getBlockcolors().get(i)==1)
					r.setFill(Color.CORAL);
				else if(data.getBlockcolors().get(i)==2)
					r.setFill(Color.LAVENDER);
				else if(data.getBlockcolors().get(i)==3)
					r.setFill(Color.CORNFLOWERBLUE);
				else if(data.getBlockcolors().get(i)==4)
					r.setFill(Color.CRIMSON);
				else if(data.getBlockcolors().get(i)==5)
					r.setFill(Color.DARKSLATEBLUE);
				else if(data.getBlockcolors().get(i)==6)
					r.setFill(Color.FIREBRICK);
				else if(data.getBlockcolors().get(i)==7)
					r.setFill(Color.KHAKI);
				else if(data.getBlockcolors().get(i)==8)
					r.setFill(Color.LIGHTSEAGREEN);
				block1.getBlocks().add(i,r);
			}
			for(int i=0;i<data.getBlocknumbers().size();i++)
			{
				Text t=new Text(data.getBlocknumbers().get(i));
				t.setVisible(data.getBlocknumbervisibility().get(i));
				t.setFont(Font.font(null,FontWeight.BOLD,28));
				t.setX(data.blocknumberx.get(i));
				t.setY(data.blocknumbery.get(i));
				block1.getTexi().add(i, t);
			}
			for(int i=0;i<data.getBlockxs2().size();i++)
			{
				Rectangle r=new Rectangle();
				r.setX(data.getBlockxs2().get(i));
				r.setY(data.getBlockys2().get(i));
				r.setWidth(data.getBlockwidth2().get(i));
				r.setHeight(data.getBlockheight2().get(i));
				r.setArcWidth(data.getBlockarcwidth2().get(i));
				r.setArcHeight(data.getBlockarcheight2().get(i));
				r.setVisible(data.getBlockvisibilities2().get(i));
				if(data.getBlockcolors2().get(i)==1)
					r.setFill(Color.CORAL);
				else if(data.getBlockcolors2().get(i)==2)
					r.setFill(Color.LAVENDER);
				else if(data.getBlockcolors2().get(i)==3)
					r.setFill(Color.CORNFLOWERBLUE);
				else if(data.getBlockcolors2().get(i)==4)
					r.setFill(Color.CRIMSON);
				else if(data.getBlockcolors2().get(i)==5)
					r.setFill(Color.DARKSLATEBLUE);
				else if(data.getBlockcolors2().get(i)==6)
					r.setFill(Color.FIREBRICK);
				else if(data.getBlockcolors2().get(i)==7)
					r.setFill(Color.KHAKI);
				else if(data.getBlockcolors2().get(i)==8)
					r.setFill(Color.LIGHTSEAGREEN);
				block2.getBlocks().add(i,r);
			}
			for(int i=0;i<data.getBlocknumbers2().size();i++)
			{
				Text t=new Text(data.getBlocknumbers2().get(i));
				t.setVisible(data.getBlocknumbervisibility2().get(i));
				t.setFont(Font.font(null,FontWeight.BOLD,28));
				t.setX(data.blocknumberx2.get(i));
				t.setY(data.blocknumbery2.get(i));
				block2.getTexi().add(i, t);
			}
			Rectangle r1 = new Rectangle();
			r1.setHeight(data.wallheight1);
			r1.setX(data.wallxcord1);
			r1.setY(data.wallycord1);
			r1.setFill(Color.WHITE);
			r1.setWidth(5);
			wall1.setWall(r1);
			
			
			wall1.setMarker(data.wallmarker1);
			
			Rectangle r2=new Rectangle();
			r2.setHeight(data.wallheight2);
			r2.setX(data.wallxcord2);
			r2.setY(data.wallycord2);
			r2.setFill(Color.WHITE);
			r2.setWidth(5);
			wall2.setWall(r2);
			wall2.setMarker(data.wallmarker2);
			
			
			Circle b1=new Circle(7.5);
			Circle b2=new Circle(7.5);
			Circle b3=new Circle(7.5);
			Circle b4=new Circle(7.5);
			Circle b5=new Circle(7.5);
			Circle b6=new Circle(7.5);
			Text t1=new Text();
			Text t2=new Text();
			Text t3=new Text();
			Text t4=new Text();
			Text t5=new Text();
			Text t6=new Text();
			
//			System.out.println("avatar is "+data.snakeavatarnum);
			if(data.snakeavatarnum==1)
			{
				b1.setFill(new ImagePattern(img1));
				b2.setFill(new ImagePattern(img1));
				b3.setFill(new ImagePattern(img1));
				b4.setFill(new ImagePattern(img1));
				b5.setFill(new ImagePattern(img1));
				b6.setFill(new ImagePattern(img1));
			}
			else if(data.snakeavatarnum==2)
			{
				b1.setFill(new ImagePattern(img2));
				b2.setFill(new ImagePattern(img2));
				b3.setFill(new ImagePattern(img2));
				b4.setFill(new ImagePattern(img2));
				b5.setFill(new ImagePattern(img2));
				b6.setFill(new ImagePattern(img2));
			}
			else if(data.snakeavatarnum==3)
			{
				b1.setFill(new ImagePattern(img3));
				b2.setFill(new ImagePattern(img3));
				b3.setFill(new ImagePattern(img3));
				b4.setFill(new ImagePattern(img3));
				b5.setFill(new ImagePattern(img3));
				b6.setFill(new ImagePattern(img3));
			}
			else if(data.snakeavatarnum==4)
			{
				b1.setFill(new ImagePattern(img4));
				b2.setFill(new ImagePattern(img4));
				b3.setFill(new ImagePattern(img4));
				b4.setFill(new ImagePattern(img4));
				b5.setFill(new ImagePattern(img4));
				b6.setFill(new ImagePattern(img4));
			}
			else if(data.snakeavatarnum==5)
			{
				b1.setFill(new ImagePattern(img5));
				b2.setFill(new ImagePattern(img5));
				b3.setFill(new ImagePattern(img5));
				b4.setFill(new ImagePattern(img5));
				b5.setFill(new ImagePattern(img5));
				b6.setFill(new ImagePattern(img5));
			}
			else if(data.snakeavatarnum==6)
			{
				b1.setFill(new ImagePattern(img6));
				b2.setFill(new ImagePattern(img6));
				b3.setFill(new ImagePattern(img6));
				b4.setFill(new ImagePattern(img6));
				b5.setFill(new ImagePattern(img6));
				b6.setFill(new ImagePattern(img6));
			}
			else if(data.snakeavatarnum==7)
			{
				b1.setFill(new ImagePattern(img7));
				b2.setFill(new ImagePattern(img7));
				b3.setFill(new ImagePattern(img7));
				b4.setFill(new ImagePattern(img7));
				b5.setFill(new ImagePattern(img7));
				b6.setFill(new ImagePattern(img7));
			}
			else if(data.snakeavatarnum==8)
			{
				b1.setFill(new ImagePattern(img8));
				b2.setFill(new ImagePattern(img8));
				b3.setFill(new ImagePattern(img8));
				b4.setFill(new ImagePattern(img8));
				b5.setFill(new ImagePattern(img8));
				b6.setFill(new ImagePattern(img8));
			}
			else if(data.snakeavatarnum==9)
			{
				b1.setFill(new ImagePattern(img9));
				b2.setFill(new ImagePattern(img9));
				b3.setFill(new ImagePattern(img9));
				b4.setFill(new ImagePattern(img9));
				b5.setFill(new ImagePattern(img9));
				b6.setFill(new ImagePattern(img9));
			}
			else if(data.snakeavatarnum==10)
			{
				b1.setFill(new ImagePattern(img10));
				b2.setFill(new ImagePattern(img10));
				b3.setFill(new ImagePattern(img10));
				b4.setFill(new ImagePattern(img10));
				b5.setFill(new ImagePattern(img10));
				b6.setFill(new ImagePattern(img10));
			}
			else if(data.snakeavatarnum==11)
			{
				b1.setFill(new ImagePattern(img11));
				b2.setFill(new ImagePattern(img11));
				b3.setFill(new ImagePattern(img11));
				b4.setFill(new ImagePattern(img11));
				b5.setFill(new ImagePattern(img11));
				b6.setFill(new ImagePattern(img11));
			}
			else if(data.snakeavatarnum==12)
			{
				b1.setFill(new ImagePattern(img12));
				b2.setFill(new ImagePattern(img12));
				b3.setFill(new ImagePattern(img12));
				b4.setFill(new ImagePattern(img12));
				b5.setFill(new ImagePattern(img12));
				b6.setFill(new ImagePattern(img12));
			}
			else if(data.snakeavatarnum==13)
			{
				b1.setFill(new ImagePattern(img13));
				b2.setFill(new ImagePattern(img13));
				b3.setFill(new ImagePattern(img13));
				b4.setFill(new ImagePattern(img13));
				b5.setFill(new ImagePattern(img13));
				b6.setFill(new ImagePattern(img13));
			}
			else if(data.snakeavatarnum==14)
			{
				b1.setFill(new ImagePattern(img14));
				b2.setFill(new ImagePattern(img14));
				b3.setFill(new ImagePattern(img14));
				b4.setFill(new ImagePattern(img14));
				b5.setFill(new ImagePattern(img14));
				b6.setFill(new ImagePattern(img14));
			}
			else if(data.snakeavatarnum==15)
			{
				b1.setFill(new ImagePattern(img15));
				b2.setFill(new ImagePattern(img15));
				b3.setFill(new ImagePattern(img15));
				b4.setFill(new ImagePattern(img15));
				b5.setFill(new ImagePattern(img15));
				b6.setFill(new ImagePattern(img15));
			}
			else
			{
				b1.setFill(Color.YELLOW);
				b2.setFill(Color.YELLOW);
				b3.setFill(Color.YELLOW);
				b4.setFill(Color.YELLOW);
				b5.setFill(Color.YELLOW);
				b6.setFill(Color.YELLOW);
			}
			b1.setCenterX(data.ball1xs);
			b1.setCenterY(data.ball1ys);
			b1.setVisible(data.ball1visibility);
			t1.setX(data.ball1textx);
			t1.setY(data.ball1texty);
			t1.setText(data.ball1text);
			t1.setVisible(data.ball1textvisibility);
			t1.setFill(Color.WHITE);
			
			b2.setCenterX(data.ball2xs);
			b2.setCenterY(data.ball2ys);
			b2.setVisible(data.ball2visibility);
			t2.setX(data.ball2textx);
			t2.setY(data.ball2texty);
			t2.setText(data.ball2text);
			t2.setVisible(data.ball2textvisibility);
			t2.setFill(Color.WHITE);
			
			b3.setCenterX(data.ball3xs);
			b3.setCenterY(data.ball3ys);
			b3.setVisible(data.ball3visibility);
			t3.setX(data.ball3textx);
			t3.setY(data.ball3texty);
			t3.setText(data.ball3text);
			t3.setVisible(data.ball3textvisibility);
			t3.setFill(Color.WHITE);
			
			b4.setCenterX(data.ball4xs);
			b4.setCenterY(data.ball4ys);
			b4.setVisible(data.ball4visibility);
			t4.setX(data.ball4textx);
			t4.setY(data.ball4texty);
			t4.setText(data.ball4text);
			t4.setVisible(data.ball4textvisibility);
			t4.setFill(Color.WHITE);
			
			b5.setCenterX(data.ball5xs);
			b5.setCenterY(data.ball5ys);
			b5.setVisible(data.ball5visibility);
			t5.setX(data.ball5textx);
			t5.setY(data.ball5texty);
			t5.setText(data.ball5text);
			t5.setVisible(data.ball5textvisibility);
			t5.setFill(Color.WHITE);
			
			b6.setCenterX(data.ball6xs);
			b6.setCenterY(data.ball6ys);
			b6.setVisible(data.ball6visibility);
			t6.setX(data.ball6textx);
			t6.setY(data.ball6texty);
			t6.setText(data.ball6text);
			t6.setVisible(data.ball6textvisibility);
			t6.setFill(Color.WHITE);
			
			ball1.setBall(b1);
			ball1.setText(t1);
			
			ball2.setBall(b2);
			ball2.setText(t2);
			
			ball3.setBall(b3);
			ball3.setText(t3);
			
			ball4.setBall(b4);
			ball4.setText(t4);
			
			ball5.setBall(b5);
			ball5.setText(t5);
			
			ball6.setBall(b6);
			ball6.setText(t6);
			
			Circle tokenc1=new Circle();
			Circle tokenc2=new Circle();
			
			tokenc1.setCenterX(data.token1x);
			tokenc1.setCenterY(data.token1y);
			if(data.token1imagenum==1)
				tokenc1.setFill(new ImagePattern(imagi[0]));
			else if(data.token1imagenum==2)
				tokenc1.setFill(new ImagePattern(imagi[1]));
			else if(data.token1imagenum==3)
				tokenc1.setFill(new ImagePattern(imagi[2]));
			else if(data.token1imagenum==4)
				tokenc1.setFill(new ImagePattern(imagi[3]));
			else if(data.token1imagenum==5)
				tokenc1.setFill(new ImagePattern(imagi[4]));
			tokenc1.setVisible(data.token1visibility);
			tokenc1.setRadius(data.token1rad);
			
			tokenc2.setCenterX(data.token2x);
			tokenc2.setCenterY(data.token2y);
			if(data.token2imagenum==1)
				tokenc2.setFill(new ImagePattern(imagi[0]));
			else if(data.token2imagenum==2)
				tokenc2.setFill(new ImagePattern(imagi[1]));
			else if(data.token2imagenum==3)
				tokenc2.setFill(new ImagePattern(imagi[2]));
			else if(data.token2imagenum==4)
				tokenc2.setFill(new ImagePattern(imagi[3]));
			else if(data.token2imagenum==5)
				tokenc2.setFill(new ImagePattern(imagi[4]));
			tokenc2.setVisible(data.token2visibility);
			tokenc2.setRadius(data.token2rad);
			
			token1.setToken(tokenc1);
			token4.setToken(tokenc2);
			}
			}
			//MainPage.whatclicked=1;
		}
		catch(Exception E)
		{
			//E.printStackTrace();
		}
		Circle pause=new Circle(20);
	   	pause.setFill(new ImagePattern(image6));
	   	pause.setCenterX(420);
	   	pause.setCenterY(30);
			
			Text scores=new Text();
			scores.setFont(Font.font("Times New Roman", 35));
			scores.setText("Score: ");
			scores.setLayoutX(15);
			scores.setLayoutY(40);
			scores.setFill(Color.WHITE);
			Score.setFont(Font.font("Times New Roman", 35));
			Score.setLayoutX(110);
			Score.setLayoutY(10);
			
			Coins.setFont(Font.font("Times New Roman", 35));
			Coins.setLayoutX(40);
			Coins.setLayoutY(610);
			
			Score.setTextFill(Color.WHITE);
			Coins.setTextFill(Color.WHITE);
			Circle con=new Circle(12);
			con.setFill(new ImagePattern(image2));
			con.setCenterX(20);
			con.setCenterY(630);
  
  
  Color[] arrcolor = {Color.CORAL,Color.LAVENDER,Color.CORNFLOWERBLUE,Color.CRIMSON,Color.DARKSLATEBLUE,Color.FIREBRICK,Color.KHAKI,Color.LIGHTSEAGREEN}; 
  int[] colornumber= {1,2,3,4,5,6,7,8};
  int[] X = {0,76,151,226,301,376};
  int[] bul = {1,2,3,4,5,6};
  
  //Create a Rectangle
  
  //First Layer
  
  time1.setCycleCount(Animation.INDEFINITE);
 
  KeyFrame k1 = new KeyFrame(Duration.millis(20),e->{

   block1.setYcordblock(block1.getYcordblock(0)+4);
   block1.setYcordtexi(block1.getYcordtexi(0)+4);
   try
   {
	   collide12(block1,snake.getHead(),Score,token1,token4,date1,month1,year1,dropmenu1,restartbtn1,exitbtn1);
   }catch(Exception e1)
   {
//	   e1.printStackTrace();
   }
   if(block1.getYcordblock(0)>=725) {
	   block1.update(snake.getLength());
   }
   
  
     }
  );
  
  
  //Second Layer
  
  time2.setCycleCount(Animation.INDEFINITE);
  KeyFrame k2 = new KeyFrame(Duration.millis(20),e->{
   
	  block2.setYcordblock(block2.getYcordblock(0)+4);
	  block2.setYcordtexi(block2.getYcordtexi(0)+4);
   
   try
   {
	   collide12(block2,snake.getHead(),Score,token1,token4,date1,month1,year1,dropmenu1,restartbtn1,exitbtn1);
   }
   catch(Exception e2)
   {
//	   e2.printStackTrace();
   }
   
   if(block2.getYcordblock(0)>=725) {
	   block2.update(snake.getLength());
   }
   
   
  
  }  
  );
 //Walls
  
  
 
  time5.setCycleCount(Animation.INDEFINITE);
  KeyFrame k5 = new KeyFrame(Duration.millis(20),e ->{
   wall1.setwallycord(wall1.getwallycord()+4);
   if(wall1.getwallycord()>=725) {
    wall1.update();
   }
   collide56(wall2,snake.getHead());collide56(wall1,snake.getHead());
  }//,new KeyValue(wall.yProperty(),725)
  );
  
  
  
  time6.setCycleCount(Animation.INDEFINITE);
  KeyFrame k6 = new KeyFrame(Duration.millis(20),e ->{
	  wall2.setwallycord(wall2.getwallycord()+4);
   if(wall2.getwallycord()>=725) {
	   wall2.update();
   }
   othercollide56(wall2,snake.getHead());
  }//,new KeyValue(wall2.yProperty(),725)
  );
  
  
 
  
  //Tokens
  time3.setCycleCount(Animation.INDEFINITE);
  int ct=0;
  KeyFrame k3 = new KeyFrame(Duration.millis(20),e ->{
   ball1.setycordtext(ball1.getycordtext()+4);
   ball1.setycordball(ball1.getycordball()+4);
   ball2.setycordtext(ball2.getycordtext()+4);
   ball2.setycordball(ball2.getycordball()+4);
   ball3.setycordtext(ball3.getycordtext()+4);
   ball3.setycordball(ball3.getycordball()+4);
   ball4.setycordtext(ball4.getycordtext()+4);
   ball4.setycordball(ball4.getycordball()+4);
   ball5.setycordtext(ball5.getycordtext()+4);
   ball5.setycordball(ball5.getycordball()+4);
   ball6.setycordtext(ball6.getycordtext()+4);
   ball6.setycordball(ball6.getycordball()+4);
   token1.setycord(token1.getycord()+4);
   token4.setycord(token4.getycord()+4);
   collideball(ball1, snake);
   collideball(ball2, snake);
   collideball(ball3, snake);
   collideball(ball4, snake);
   collideball(ball5, snake);
   collideball(ball6, snake);
   try
   {
	   collidetoken(token1, snake,image1,image2,image3,image5,Score);
	   collidetoken(token4,snake,image1,image2,image3,image5,Score);
   }catch(Exception e1)
   {
//	   e1.printStackTrace();
   }
  
   if(snake.getPower2()==1) {
	  ball1.maggie(snake);
	  ball2.maggie(snake);
	  ball3.maggie(snake);
	  ball4.maggie(snake);
	  ball5.maggie(snake);
	  ball6.maggie(snake);
   }

   if(ball2.getycordball()>=725 ) {
	   ball2.update();
	   if(snake.getPower()==1) {
//		   System.out.println("Power zingalala");
		   counter1+=1;
		   if(counter1==4) {
			   counter1=0;
			   snake.setPower(0);
			   snake.getShbub().setVisible(false);
		   }
	   }
	   if(snake.getPower2()==1) { //magenet
//		   System.out.println("Power is Ironman");
		   counter2+=1;
		   if(counter2==4) {
			   counter2=0;
			   snake.setPower2(0);
			   snake.getMgbub().setVisible(false);
		   }
	   }

	  
   }
   if(ball3.getycordball()>=725) {
	   ball3.update();

   }
   if(ball4.getycordball()>=725 && token4.getycord()>=725) {
	   int[] per = {0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,2,3,4,5};
	   int pt = per[new Random().nextInt(per.length)];
	   ball4.update();
	   token4.update();
	   if(pt==0) {
			 token4.setvisibilty(false);
	   }
	   else if(pt==1) {
			 token4.setimage(image2);
			 token4.setidentity(2);
			 ball4.setvisiblity(false);
	   }
	   else if(pt==2) {
		   token4.setimage(image1);
		   token4.setidentity(1);
		   ball4.setvisiblity(false);
			 
	   }
	   else if(pt==3) {
		   token4.setimage(image3);
		   token4.setidentity(3);
		   ball4.setvisiblity(false); 
	   }
	   else if(pt==4) {
		   token4.setimage(image4);
		   token4.setidentity(4);
		   ball4.setvisiblity(false);
	   }
	   else if(pt==5) {
		   token4.setimage(image5);
		   token4.setidentity(5);
		   ball4.setvisiblity(false);
	   }
	  
   }
   if(ball5.getycordball()>=725 ) {
	   ball5.update();

   }
   if(ball6.getycordball()>=725 ) {
	   ball6.update();  
   }
   
   if(ball1.getycordball()>=725 && token1.getycord()>=725) {
	   int[] per = {0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,2,3,4,5};
	   int pt = per[new Random().nextInt(per.length)];
	   ball1.update();
	   token1.update();
	   if(pt==0) {
			 token1.setvisibilty(false);
	   }
	   else if(pt==1) {
			 token1.setimage(image2);
			 token1.setidentity(2);
			 ball1.setvisiblity(false);
	   }
	   else if(pt==2) {
		   token1.setimage(image1);
		   token1.setidentity(1);
		   ball1.setvisiblity(false);
			 
	   }
	   else if(pt==3) {
		   token1.setimage(image3);
		   token1.setidentity(3);
		   ball1.setvisiblity(false); 
	   }
	   else if(pt==4) {
		   token1.setimage(image4);
		   token1.setidentity(4);
		   ball1.setvisiblity(false);
	   }
	   else if(pt==5) {
		   token1.setimage(image5);
		   token1.setidentity(5);
		   ball1.setvisiblity(false);
	   }
	  
   }
  }
 );
  
  
  // faltu
    
  time10.setCycleCount(Animation.INDEFINITE);
  //int cnt = 1;
  KeyFrame kgf = new KeyFrame(Duration.millis(30),e->{
	
	  ArrayList<Double> prev = new ArrayList<Double>();
	 // System.out.println(snake.getLength());
	  for(int j=0;j<snake.getSnake().size();j++) {
		//  System.out.println(snake.getxcordlistitem(j));
		  prev.add(snake.getxcordlistitem(j));
	  }
	  for(int j=1;j<snake.getSnake().size();j++) {
		  snake.changexcordlistitem(j, prev.get(j-1));
	  }
	  //System.out.println("hello how are you");
   
  });

  time10.getKeyFrames().add(kgf);
  time10.play();
  
  time5.getKeyFrames().addAll(k5);
  time5.play();
  
  time6.getKeyFrames().addAll(k6);
  time6.play();
  
  time3.getKeyFrames().addAll(k3);
  time3.playFrom(Duration.millis(1000));

  time1.getKeyFrames().addAll(k1);
  time1.play();
  
  time2.getKeyFrames().addAll(k2);
  time2.play();
  Rectangle dropmenu=new Rectangle(250,400);
  dropmenu.setFill(new ImagePattern(background));
  dropmenu.setArcHeight(20);
  dropmenu.setArcWidth(20);
  dropmenu.setLayoutX(100);
  dropmenu.setLayoutY(100);
  dropmenu.setVisible(false);
  Button resumebtn=new Button();
  resumebtn.setPrefSize(200, 50);
  resumebtn.setLayoutX(125);
  resumebtn.setLayoutY(150);
  resumebtn.setText("R E S U M E");
  Button restartbtn=new Button();
  restartbtn.setPrefSize(200, 50);
  restartbtn.setLayoutX(125);
  restartbtn.setLayoutY(250);
  restartbtn.setText("R E S T A R T");
  Button exitbtn=new Button();
  exitbtn.setPrefSize(200, 50);
  exitbtn.setLayoutX(125);
  exitbtn.setLayoutY(350);
  exitbtn.setText("M A I N M E N U");
  resumebtn.setVisible(false);
  restartbtn.setVisible(false);
  exitbtn.setVisible(false);
  Text highestscore=new Text();
//  	highestscore.setFont(Font.font("Times New Roman", 80));
//  	LeaderPage p=new LeaderPage();
//  	p.start(stage);
//  	highestscore.setText(p.scores.get(0).getText());
//  	highestscore.setLayoutX(170);
//  	highestscore.setLayoutY(480);
//  	highestscore.setFill(Color.WHITE);
//  	highestscore.setVisible(false);
  restartbtn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent e)
		{
			MainPage.whatclicked=1;
			dropmenu1.setVisible(false);
			//resumebtn1.setVisible(false);
			restartbtn1.setVisible(false);
			exitbtn1.setVisible(false);
			//highestscore.setVisible(false);
			try {
				GAMESCREEN gs=new GAMESCREEN();
				gs.start(stage);
			}
			catch(Exception l)
			{
//				l.printStackTrace();
			}
		}
	});
  exitbtn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent e)
		{
			try {
				SaveData data=new SaveData();
				for(int i=0;i<block1.getBlocks().size();i++)
				{
					data.blockxs.add(i, block1.getXcordblock(i));
					data.blockys.add(i, block1.getYcordblock(i));
					data.blockarcheight.add(i,30.0);
					data.blockarcwidth.add(i,30.0);
					data.blockheight.add(i, 75);
					data.blockwidth.add(i, 75);
					if(block1.getblockitem(i).getFill().toString().equals(Color.CORAL.toString()))
						data.blockcolors.add(i,1);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.LAVENDER.toString()))
						data.blockcolors.add(i,2);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.CORNFLOWERBLUE.toString()))
						data.blockcolors.add(i,3);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.CRIMSON.toString()))
						data.blockcolors.add(i,4);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.DARKSLATEBLUE.toString()))
						data.blockcolors.add(i,5);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.FIREBRICK.toString()))
						data.blockcolors.add(i,6);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.KHAKI.toString()))
						data.blockcolors.add(i,7);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.LIGHTSEAGREEN.toString()))
						data.blockcolors.add(i,8);
					data.blockvisibilities.add(i, block1.getblockitem(i).isVisible());
				}
				for(int i=0;i<block1.getTexi().size();i++)
				{
					data.blocknumbers.add(i, block1.gettexiitem(i).getText());
					data.blocknumberx.add(i, block1.getXcordtexi(i));
					data.blocknumbery.add(i, block1.getYcordtexi(i));
					data.blocknumbervisibility.add(i, block1.gettexiitem(i).isVisible());
					data.blocknumbersize.add(i, 28);
				}
				for(int i=0;i<block2.getBlocks().size();i++)
				{
					data.blockxs2.add(i, block2.getXcordblock(i));
					data.blockys2.add(i, block2.getYcordblock(i));
					data.blockarcheight2.add(i,30.0);
					data.blockarcwidth2.add(i,30.0);
					data.blockheight2.add(i, 75);
					data.blockwidth2.add(i, 75);
					if(block2.getblockitem(i).getFill().toString().equals(Color.CORAL.toString()))
						data.blockcolors2.add(i,1);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.LAVENDER.toString()))
						data.blockcolors2.add(i,2);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.CORNFLOWERBLUE.toString()))
						data.blockcolors2.add(i,3);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.CRIMSON.toString()))
						data.blockcolors2.add(i,4);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.DARKSLATEBLUE.toString()))
						data.blockcolors2.add(i,5);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.FIREBRICK.toString()))
						data.blockcolors2.add(i,6);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.KHAKI.toString()))
						data.blockcolors2.add(i,7);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.LIGHTSEAGREEN.toString()))
						data.blockcolors2.add(i,8);
					data.blockvisibilities2.add(i, block2.getblockitem(i).isVisible());
				}
				for(int i=0;i<block2.getTexi().size();i++)
				{
					data.blocknumbers2.add(i, block2.gettexiitem(i).getText());
					data.blocknumberx2.add(i, block2.getXcordtexi(i));
					data.blocknumbery2.add(i, block2.getYcordtexi(i));
					data.blocknumbervisibility2.add(i, block2.gettexiitem(i).isVisible());
					data.blocknumbersize2.add(i, 28);
				}
				for(int i=0;i<snake.getSnake().size();i++)
				{
					data.snakeballxs.add(i,snake.getSnake().get(i).getCenterX());
					data.snakeballys.add(i,snake.getSnake().get(i).getCenterY());
					data.snakeballradius.add(i,snake.getSnake().get(i).getRadius());
					//data.snakeballcolors.add(i, snake.getSnake().get(i).getFill().toString());
					data.snakeballvisibility.add(i,snake.getSnake().get(i).isVisible());
					data.snakelenght = snake.getLength();
				}
				
				System.out.println(snake.getHead().getFill().toString()+" "+ca8.getFill().toString());
				if(AvatarPage.imagenumber==1)
					data.snakeavatarnum=1;
				else if(AvatarPage.imagenumber==2)
					data.snakeavatarnum=2;
				else if(AvatarPage.imagenumber==3)
					data.snakeavatarnum=3;
				else if(AvatarPage.imagenumber==4)
					data.snakeavatarnum=4;
				else if(AvatarPage.imagenumber==5)
					data.snakeavatarnum=5;
				else if(AvatarPage.imagenumber==6)
					data.snakeavatarnum=6;
				else if(AvatarPage.imagenumber==7)
					data.snakeavatarnum=7;
				else if(AvatarPage.imagenumber==8)
					data.snakeavatarnum=8;
				else if(AvatarPage.imagenumber==9)
					data.snakeavatarnum=9;
				else if(AvatarPage.imagenumber==10)
					data.snakeavatarnum=10;
				else if(AvatarPage.imagenumber==11)
					data.snakeavatarnum=11;
				else if(AvatarPage.imagenumber==12)
					data.snakeavatarnum=12;
				else if(AvatarPage.imagenumber==13)
					data.snakeavatarnum=13;
				else if(AvatarPage.imagenumber==14)
					data.snakeavatarnum=14;
				else if(AvatarPage.imagenumber==15)
					data.snakeavatarnum=15;
				else
					data.snakeavatarnum=0;
				data.wallheight1=wall1.getWall().getHeight();
				data.wallxcord1=wall1.getwallxcord();
				data.wallycord1=wall1.getwallycord();
				data.wallmarker1=wall1.getMarker();
				
				data.wallheight2=wall2.getWall().getHeight();
				data.wallxcord2=wall2.getwallxcord();
				data.wallycord2=wall2.getwallycord();
				data.wallmarker2=wall2.getMarker();
				
				data.ball1xs=ball1.getxcordball();
				data.ball1ys=ball1.getycordball();
				data.ball1text=ball1.getText().getText();
				data.ball1textx=ball1.getText().getX();
				data.ball1texty=ball1.getText().getY();
				data.ball1visibility=ball1.getvisibility();
				data.ball1textvisibility=ball1.getText().isVisible();
				
				data.ball2xs=ball2.getxcordball();
				data.ball2ys=ball2.getycordball();
				data.ball2text=ball2.getText().getText();
				data.ball2textx=ball2.getText().getX();
				data.ball2texty=ball2.getText().getY();
				data.ball2visibility=ball2.getvisibility();
				data.ball2textvisibility=ball2.getText().isVisible();
				
				data.ball3xs=ball3.getxcordball();
				data.ball3ys=ball3.getycordball();
				data.ball3text=ball3.getText().getText();
				data.ball3textx=ball3.getText().getX();
				data.ball3texty=ball3.getText().getY();
				data.ball3visibility=ball3.getvisibility();
				data.ball3textvisibility=ball3.getText().isVisible();
				
				data.ball4xs=ball4.getxcordball();
				data.ball4ys=ball4.getycordball();
				data.ball4text=ball4.getText().getText();
				data.ball4textx=ball4.getText().getX();
				data.ball4texty=ball4.getText().getY();
				data.ball4visibility=ball4.getvisibility();
				data.ball4textvisibility=ball4.getText().isVisible();
				
				data.ball5xs=ball5.getxcordball();
				data.ball5ys=ball5.getycordball();
				data.ball5text=ball5.getText().getText();
				data.ball5textx=ball5.getText().getX();
				data.ball5texty=ball5.getText().getY();
				data.ball5visibility=ball5.getvisibility();
				data.ball5textvisibility=ball5.getText().isVisible();
				
				data.ball6xs=ball6.getxcordball();
				data.ball6ys=ball6.getycordball();
				data.ball6text=ball6.getText().getText();
				data.ball6textx=ball6.getText().getX();
				data.ball6texty=ball6.getText().getY();
				data.ball6visibility=ball6.getvisibility();
				data.ball6textvisibility=ball6.getText().isVisible();
				
				data.token1x=token1.getxcord();
				data.token1y=token1.getycord();
				data.token1rad=token1.gettoken().getRadius();
				data.token1visibility=token1.getvisibilty();
				
				if(token1.getidentity()==1)
					data.token1imagenum=1;
				else if(token1.getidentity()==2)
					data.token1imagenum=2;
				else if(token1.getidentity()==3)
					data.token1imagenum=3;
				else if(token1.getidentity()==4)
					data.token1imagenum=4;
				else if(token1.getidentity()==5)
					data.token1imagenum=5;
				
				data.token2x=token4.getxcord();
				data.token2y=token4.getycord();
				data.token2rad=token4.gettoken().getRadius();
				data.token2visibility=token4.getvisibilty();
				
				if(token4.getidentity()==1)
					data.token2imagenum=1;
				else if(token4.getidentity()==2)
					data.token2imagenum=2;
				else if(token4.getidentity()==3)
					data.token2imagenum=3;
				else if(token4.getidentity()==4)
					data.token2imagenum=4;
				else if(token4.getidentity()==5)
					data.token2imagenum=5;
				data.currscore="0";
				data.currcoins="0";
				
				//System.out.println("Valueeee "+data.currscore+" "+data.currcoins);
				
				ResourceManager.save(data, "GAMEDATA.dat");
				mp.start(stage);
				stage.show();
			}
			catch(Exception E)
			{
//				E.printStackTrace();
			}
		}
	});
  root1.getChildren().addAll(block1.getBlocks());
  root1.getChildren().addAll(block1.getTexi());
  root1.getChildren().addAll(block2.getBlocks());
  root1.getChildren().addAll(block2.getTexi());
  root1.getChildren().addAll(snake.getMgbub(),snake.getShbub());
  root1.getChildren().addAll(snake.getSnake());
  root1.getChildren().addAll(ball1.getBall(),ball1.getText(),ball2.getBall(),ball2.getText(),ball3.getBall(),ball3.getText(),ball4.getBall(),ball4.getText(),ball5.getBall(),ball5.getText(),ball6.getBall(),ball6.getText());
  root1.getChildren().addAll(token1.gettoken(),token4.gettoken());
  root1.getChildren().addAll(wall1.getWall(),wall2.getWall(),snake.getText(),Score,Coins,scores,con,pause,dropmenu,resumebtn,restartbtn,exitbtn,highestscore,dropmenu1,restartbtn1,exitbtn1);
  Scene scene = new Scene(root1,450,650);
  scene.setFill(Color.BLACK);
  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
  stage.setScene(scene);
  
  pause.setOnMouseClicked(new EventHandler<MouseEvent>() {
	  @Override
	  public void handle(MouseEvent e)
	  {
			dropmenu.setVisible(true);
			resumebtn.setVisible(true);
			restartbtn.setVisible(true);
			exitbtn.setVisible(true);
			highestscore.setVisible(true);

			rukzau(token1,token4);
			resumebtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					dropmenu.setVisible(false);
					resumebtn.setVisible(false);
					restartbtn.setVisible(false);
					exitbtn.setVisible(false);
					highestscore.setVisible(false);
					resume(token1,token4);
				}
			});
			restartbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					MainPage.whatclicked=1;
					dropmenu.setVisible(false);
					resumebtn.setVisible(false);
					restartbtn.setVisible(false);
					exitbtn.setVisible(false);
					highestscore.setVisible(false);
					try {
						GAMESCREEN gs=new GAMESCREEN();
						gs.start(stage);
					}
					catch(Exception l)
					{
//						l.printStackTrace();
					}
				}
			});
			exitbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					try
					{
						//System.out.println("HElloz "+imagi[2].toString());
						//System.out.println("Helloz2 "+token1.getImage().toString());
						SaveData data=new SaveData();
						for(int i=0;i<block1.getBlocks().size();i++)
						{
							data.blockxs.add(i, block1.getXcordblock(i));
							data.blockys.add(i, block1.getYcordblock(i));
							data.blockarcheight.add(i,30.0);
							data.blockarcwidth.add(i,30.0);
							data.blockheight.add(i, 75);
							data.blockwidth.add(i, 75);
							if(block1.getblockitem(i).getFill().toString().equals(Color.CORAL.toString()))
								data.blockcolors.add(i,1);
							else if(block1.getblockitem(i).getFill().toString().equals(Color.LAVENDER.toString()))
								data.blockcolors.add(i,2);
							else if(block1.getblockitem(i).getFill().toString().equals(Color.CORNFLOWERBLUE.toString()))
								data.blockcolors.add(i,3);
							else if(block1.getblockitem(i).getFill().toString().equals(Color.CRIMSON.toString()))
								data.blockcolors.add(i,4);
							else if(block1.getblockitem(i).getFill().toString().equals(Color.DARKSLATEBLUE.toString()))
								data.blockcolors.add(i,5);
							else if(block1.getblockitem(i).getFill().toString().equals(Color.FIREBRICK.toString()))
								data.blockcolors.add(i,6);
							else if(block1.getblockitem(i).getFill().toString().equals(Color.KHAKI.toString()))
								data.blockcolors.add(i,7);
							else if(block1.getblockitem(i).getFill().toString().equals(Color.LIGHTSEAGREEN.toString()))
								data.blockcolors.add(i,8);
							data.blockvisibilities.add(i, block1.getblockitem(i).isVisible());
						}
						for(int i=0;i<block1.getTexi().size();i++)
						{
							data.blocknumbers.add(i, block1.gettexiitem(i).getText());
							data.blocknumberx.add(i, block1.getXcordtexi(i));
							data.blocknumbery.add(i, block1.getYcordtexi(i));
							data.blocknumbervisibility.add(i, block1.gettexiitem(i).isVisible());
							data.blocknumbersize.add(i, 28);
						}
						for(int i=0;i<block2.getBlocks().size();i++)
						{
							data.blockxs2.add(i, block2.getXcordblock(i));
							data.blockys2.add(i, block2.getYcordblock(i));
							data.blockarcheight2.add(i,30.0);
							data.blockarcwidth2.add(i,30.0);
							data.blockheight2.add(i, 75);
							data.blockwidth2.add(i, 75);
							if(block2.getblockitem(i).getFill().toString().equals(Color.CORAL.toString()))
								data.blockcolors2.add(i,1);
							else if(block2.getblockitem(i).getFill().toString().equals(Color.LAVENDER.toString()))
								data.blockcolors2.add(i,2);
							else if(block2.getblockitem(i).getFill().toString().equals(Color.CORNFLOWERBLUE.toString()))
								data.blockcolors2.add(i,3);
							else if(block2.getblockitem(i).getFill().toString().equals(Color.CRIMSON.toString()))
								data.blockcolors2.add(i,4);
							else if(block2.getblockitem(i).getFill().toString().equals(Color.DARKSLATEBLUE.toString()))
								data.blockcolors2.add(i,5);
							else if(block2.getblockitem(i).getFill().toString().equals(Color.FIREBRICK.toString()))
								data.blockcolors2.add(i,6);
							else if(block2.getblockitem(i).getFill().toString().equals(Color.KHAKI.toString()))
								data.blockcolors2.add(i,7);
							else if(block2.getblockitem(i).getFill().toString().equals(Color.LIGHTSEAGREEN.toString()))
								data.blockcolors2.add(i,8);
							data.blockvisibilities2.add(i, block2.getblockitem(i).isVisible());
						}
						for(int i=0;i<block2.getTexi().size();i++)
						{
							data.blocknumbers2.add(i, block2.gettexiitem(i).getText());
							data.blocknumberx2.add(i, block2.getXcordtexi(i));
							data.blocknumbery2.add(i, block2.getYcordtexi(i));
							data.blocknumbervisibility2.add(i, block2.gettexiitem(i).isVisible());
							data.blocknumbersize2.add(i, 28);
						}
						for(int i=0;i<snake.getSnake().size();i++)
						{
							data.snakeballxs.add(i,snake.getSnake().get(i).getCenterX());
							data.snakeballys.add(i,snake.getSnake().get(i).getCenterY());
							data.snakeballradius.add(i,snake.getSnake().get(i).getRadius());
							//data.snakeballcolors.add(i, snake.getSnake().get(i).getFill().toString());
							data.snakeballvisibility.add(i,snake.getSnake().get(i).isVisible());
							data.snakelenght = snake.getLength();
						}
						
						//System.out.println(snake.getHead().getFill().toString()+" "+ca8.getFill().toString());
						if(AvatarPage.imagenumber==1)
							data.snakeavatarnum=1;
						else if(AvatarPage.imagenumber==2)
							data.snakeavatarnum=2;
						else if(AvatarPage.imagenumber==3)
							data.snakeavatarnum=3;
						else if(AvatarPage.imagenumber==4)
							data.snakeavatarnum=4;
						else if(AvatarPage.imagenumber==5)
							data.snakeavatarnum=5;
						else if(AvatarPage.imagenumber==6)
							data.snakeavatarnum=6;
						else if(AvatarPage.imagenumber==7)
							data.snakeavatarnum=7;
						else if(AvatarPage.imagenumber==8)
							data.snakeavatarnum=8;
						else if(AvatarPage.imagenumber==9)
							data.snakeavatarnum=9;
						else if(AvatarPage.imagenumber==10)
							data.snakeavatarnum=10;
						else if(AvatarPage.imagenumber==11)
							data.snakeavatarnum=11;
						else if(AvatarPage.imagenumber==12)
							data.snakeavatarnum=12;
						else if(AvatarPage.imagenumber==13)
							data.snakeavatarnum=13;
						else if(AvatarPage.imagenumber==14)
							data.snakeavatarnum=14;
						else if(AvatarPage.imagenumber==15)
							data.snakeavatarnum=15;
						else
							data.snakeavatarnum=0;
						data.wallheight1=wall1.getWall().getHeight();
						data.wallxcord1=wall1.getwallxcord();
						data.wallycord1=wall1.getwallycord();
						data.wallmarker1=wall1.getMarker();
						
						data.wallheight2=wall2.getWall().getHeight();
						data.wallxcord2=wall2.getwallxcord();
						data.wallycord2=wall2.getwallycord();
						data.wallmarker2=wall2.getMarker();
						
						data.ball1xs=ball1.getxcordball();
						data.ball1ys=ball1.getycordball();
						data.ball1text=ball1.getText().getText();
						data.ball1textx=ball1.getText().getX();
						data.ball1texty=ball1.getText().getY();
						data.ball1visibility=ball1.getvisibility();
						data.ball1textvisibility=ball1.getText().isVisible();
						
						data.ball2xs=ball2.getxcordball();
						data.ball2ys=ball2.getycordball();
						data.ball2text=ball2.getText().getText();
						data.ball2textx=ball2.getText().getX();
						data.ball2texty=ball2.getText().getY();
						data.ball2visibility=ball2.getvisibility();
						data.ball2textvisibility=ball2.getText().isVisible();
						
						data.ball3xs=ball3.getxcordball();
						data.ball3ys=ball3.getycordball();
						data.ball3text=ball3.getText().getText();
						data.ball3textx=ball3.getText().getX();
						data.ball3texty=ball3.getText().getY();
						data.ball3visibility=ball3.getvisibility();
						data.ball3textvisibility=ball3.getText().isVisible();
						
						data.ball4xs=ball4.getxcordball();
						data.ball4ys=ball4.getycordball();
						data.ball4text=ball4.getText().getText();
						data.ball4textx=ball4.getText().getX();
						data.ball4texty=ball4.getText().getY();
						data.ball4visibility=ball4.getvisibility();
						data.ball4textvisibility=ball4.getText().isVisible();
						
						data.ball5xs=ball5.getxcordball();
						data.ball5ys=ball5.getycordball();
						data.ball5text=ball5.getText().getText();
						data.ball5textx=ball5.getText().getX();
						data.ball5texty=ball5.getText().getY();
						data.ball5visibility=ball5.getvisibility();
						data.ball5textvisibility=ball5.getText().isVisible();
						
						data.ball6xs=ball6.getxcordball();
						data.ball6ys=ball6.getycordball();
						data.ball6text=ball6.getText().getText();
						data.ball6textx=ball6.getText().getX();
						data.ball6texty=ball6.getText().getY();
						data.ball6visibility=ball6.getvisibility();
						data.ball6textvisibility=ball6.getText().isVisible();
						
						data.token1x=token1.getxcord();
						data.token1y=token1.getycord();
						data.token1rad=token1.gettoken().getRadius();
						data.token1visibility=token1.getvisibilty();
						
						if(token1.getidentity()==1)
							data.token1imagenum=1;
						else if(token1.getidentity()==2)
							data.token1imagenum=2;
						else if(token1.getidentity()==3)
							data.token1imagenum=3;
						else if(token1.getidentity()==4)
							data.token1imagenum=4;
						else if(token1.getidentity()==5)
							data.token1imagenum=5;
						
						data.token2x=token4.getxcord();
						data.token2y=token4.getycord();
						data.token2rad=token4.gettoken().getRadius();
						data.token2visibility=token4.getvisibilty();
						
						if(token4.getidentity()==1)
							data.token2imagenum=1;
						else if(token4.getidentity()==2)
							data.token2imagenum=2;
						else if(token4.getidentity()==3)
							data.token2imagenum=3;
						else if(token4.getidentity()==4)
							data.token2imagenum=4;
						else if(token4.getidentity()==5)
							data.token2imagenum=5;
						data.currscore=Score.getText();
						data.currcoins=Coins.getText();
						
//						System.out.println("Valueeee "+data.currscore+" "+data.currcoins);
						
						ResourceManager.save(data, "GAMEDATA.dat");
						mp.start(stage);
						stage.show();
					}
					catch(Exception E)
					{
//						E.printStackTrace();
					}
				}
			});
	  }
  });
  
  stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	  @Override
	  public void handle(WindowEvent e)
	  {
		  try
			{
				SaveData data=new SaveData();
				for(int i=0;i<block1.getBlocks().size();i++)
				{
					data.blockxs.add(i, block1.getXcordblock(i));
					data.blockys.add(i, block1.getYcordblock(i));
					data.blockarcheight.add(i,30.0);
					data.blockarcwidth.add(i,30.0);
					data.blockheight.add(i, 75);
					data.blockwidth.add(i, 75);
					if(block1.getblockitem(i).getFill().toString().equals(Color.CORAL.toString()))
						data.blockcolors.add(i,1);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.LAVENDER.toString()))
						data.blockcolors.add(i,2);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.CORNFLOWERBLUE.toString()))
						data.blockcolors.add(i,3);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.CRIMSON.toString()))
						data.blockcolors.add(i,4);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.DARKSLATEBLUE.toString()))
						data.blockcolors.add(i,5);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.FIREBRICK.toString()))
						data.blockcolors.add(i,6);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.KHAKI.toString()))
						data.blockcolors.add(i,7);
					else if(block1.getblockitem(i).getFill().toString().equals(Color.LIGHTSEAGREEN.toString()))
						data.blockcolors.add(i,8);
					data.blockvisibilities.add(i, block1.getblockitem(i).isVisible());
				}
				for(int i=0;i<block1.getTexi().size();i++)
				{
					data.blocknumbers.add(i, block1.gettexiitem(i).getText());
					data.blocknumberx.add(i, block1.getXcordtexi(i));
					data.blocknumbery.add(i, block1.getYcordtexi(i));
					data.blocknumbervisibility.add(i, block1.gettexiitem(i).isVisible());
					data.blocknumbersize.add(i, 28);
				}
				for(int i=0;i<block2.getBlocks().size();i++)
				{
					data.blockxs2.add(i, block2.getXcordblock(i));
					data.blockys2.add(i, block2.getYcordblock(i));
					data.blockarcheight2.add(i,30.0);
					data.blockarcwidth2.add(i,30.0);
					data.blockheight2.add(i, 75);
					data.blockwidth2.add(i, 75);
					if(block2.getblockitem(i).getFill().toString().equals(Color.CORAL.toString()))
						data.blockcolors2.add(i,1);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.LAVENDER.toString()))
						data.blockcolors2.add(i,2);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.CORNFLOWERBLUE.toString()))
						data.blockcolors2.add(i,3);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.CRIMSON.toString()))
						data.blockcolors2.add(i,4);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.DARKSLATEBLUE.toString()))
						data.blockcolors2.add(i,5);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.FIREBRICK.toString()))
						data.blockcolors2.add(i,6);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.KHAKI.toString()))
						data.blockcolors2.add(i,7);
					else if(block2.getblockitem(i).getFill().toString().equals(Color.LIGHTSEAGREEN.toString()))
						data.blockcolors2.add(i,8);
					data.blockvisibilities2.add(i, block2.getblockitem(i).isVisible());
				}
				for(int i=0;i<block2.getTexi().size();i++)
				{
					data.blocknumbers2.add(i, block2.gettexiitem(i).getText());
					data.blocknumberx2.add(i, block2.getXcordtexi(i));
					data.blocknumbery2.add(i, block2.getYcordtexi(i));
					data.blocknumbervisibility2.add(i, block2.gettexiitem(i).isVisible());
					data.blocknumbersize2.add(i, 28);
				}
				for(int i=0;i<snake.getSnake().size();i++)
				{
					data.snakeballxs.add(i,snake.getSnake().get(i).getCenterX());
					data.snakeballys.add(i,snake.getSnake().get(i).getCenterY());
					data.snakeballradius.add(i,snake.getSnake().get(i).getRadius());
					data.snakeballvisibility.add(i,snake.getSnake().get(i).isVisible());
					data.snakelenght = snake.getLength();
				}
				
				if(AvatarPage.imagenumber==1)
					data.snakeavatarnum=1;
				else if(AvatarPage.imagenumber==2)
					data.snakeavatarnum=2;
				else if(AvatarPage.imagenumber==3)
					data.snakeavatarnum=3;
				else if(AvatarPage.imagenumber==4)
					data.snakeavatarnum=4;
				else if(AvatarPage.imagenumber==5)
					data.snakeavatarnum=5;
				else if(AvatarPage.imagenumber==6)
					data.snakeavatarnum=6;
				else if(AvatarPage.imagenumber==7)
					data.snakeavatarnum=7;
				else if(AvatarPage.imagenumber==8)
					data.snakeavatarnum=8;
				else if(AvatarPage.imagenumber==9)
					data.snakeavatarnum=9;
				else if(AvatarPage.imagenumber==10)
					data.snakeavatarnum=10;
				else if(AvatarPage.imagenumber==11)
					data.snakeavatarnum=11;
				else if(AvatarPage.imagenumber==12)
					data.snakeavatarnum=12;
				else if(AvatarPage.imagenumber==13)
					data.snakeavatarnum=13;
				else if(AvatarPage.imagenumber==14)
					data.snakeavatarnum=14;
				else if(AvatarPage.imagenumber==15)
					data.snakeavatarnum=15;
				else
					data.snakeavatarnum=0;

//				System.out.println("Avtar iamge num "+AvatarPage.imagenumber);
				data.wallheight1=wall1.getWall().getHeight();
				data.wallxcord1=wall1.getwallxcord();
				data.wallycord1=wall1.getwallycord();
				data.wallmarker1=wall1.getMarker();
				
				data.wallheight2=wall2.getWall().getHeight();
				data.wallxcord2=wall2.getwallxcord();
				data.wallycord2=wall2.getwallycord();
				data.wallmarker2=wall2.getMarker();
				
				data.ball1xs=ball1.getxcordball();
				data.ball1ys=ball1.getycordball();
				data.ball1text=ball1.getText().getText();
				data.ball1textx=ball1.getText().getX();
				data.ball1texty=ball1.getText().getY();
				data.ball1visibility=ball1.getvisibility();
				data.ball1textvisibility=ball1.getText().isVisible();
				
				data.ball2xs=ball2.getxcordball();
				data.ball2ys=ball2.getycordball();
				data.ball2text=ball2.getText().getText();
				data.ball2textx=ball2.getText().getX();
				data.ball2texty=ball2.getText().getY();
				data.ball2visibility=ball2.getvisibility();
				data.ball2textvisibility=ball2.getText().isVisible();
				
				data.ball3xs=ball3.getxcordball();
				data.ball3ys=ball3.getycordball();
				data.ball3text=ball3.getText().getText();
				data.ball3textx=ball3.getText().getX();
				data.ball3texty=ball3.getText().getY();
				data.ball3visibility=ball3.getvisibility();
				data.ball3textvisibility=ball3.getText().isVisible();
				
				data.ball4xs=ball4.getxcordball();
				data.ball4ys=ball4.getycordball();
				data.ball4text=ball4.getText().getText();
				data.ball4textx=ball4.getText().getX();
				data.ball4texty=ball4.getText().getY();
				data.ball4visibility=ball4.getvisibility();
				data.ball4textvisibility=ball4.getText().isVisible();
				
				data.ball5xs=ball5.getxcordball();
				data.ball5ys=ball5.getycordball();
				data.ball5text=ball5.getText().getText();
				data.ball5textx=ball5.getText().getX();
				data.ball5texty=ball5.getText().getY();
				data.ball5visibility=ball5.getvisibility();
				data.ball5textvisibility=ball5.getText().isVisible();
				
				data.ball6xs=ball6.getxcordball();
				data.ball6ys=ball6.getycordball();
				data.ball6text=ball6.getText().getText();
				data.ball6textx=ball6.getText().getX();
				data.ball6texty=ball6.getText().getY();
				data.ball6visibility=ball6.getvisibility();
				data.ball6textvisibility=ball6.getText().isVisible();
				
				data.token1x=token1.getxcord();
				data.token1y=token1.getycord();
				data.token1rad=token1.gettoken().getRadius();
				data.token1visibility=token1.getvisibilty();
				
				if(token1.getidentity()==1)
					data.token1imagenum=1;
				else if(token1.getidentity()==2)
					data.token1imagenum=2;
				else if(token1.getidentity()==3)
					data.token1imagenum=3;
				else if(token1.getidentity()==4)
					data.token1imagenum=4;
				else if(token1.getidentity()==5)
					data.token1imagenum=5;
				
				data.token2x=token4.getxcord();
				data.token2y=token4.getycord();
				data.token2rad=token4.gettoken().getRadius();
				data.token2visibility=token4.getvisibilty();
				
				if(token4.getidentity()==1)
					data.token2imagenum=1;
				else if(token4.getidentity()==2)
					data.token2imagenum=2;
				else if(token4.getidentity()==3)
					data.token2imagenum=3;
				else if(token4.getidentity()==4)
					data.token2imagenum=4;
				else if(token4.getidentity()==5)
					data.token2imagenum=5;
				MainPage.whatclicked=2;
				data.currscore=Score.getText();
				data.currcoins=Coins.getText();
				
				ResourceManager.save(data, "GAMEDATA.dat");
				mp.start(stage);
				stage.show();
			}
			catch(Exception E)
			{
			}
	  }
  });
  scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	   @Override
	   public void handle(KeyEvent event) {
	    double x =snake.getxcordlistitem(0);
	    switch (event.getCode()) {
	     case RIGHT:{
	      //System.out.println("This is right");
	      //double x =snake.get(0).getCenterX();
	      
	      double y = 10;
	      if(x==441) {
	       x = x;
	      }
	      else if(flag!=2 && flag2!=2) {
	       x = x+9;
	      }
	      snake.getShbub().setCenterX(x);
	      snake.getMgbub().setCenterX(x);
	      snake.setTxcord(x-5);
	      snake.changexcordlistitem(0, x);
	      //time10.play();
	      break;
	     }
	     case LEFT:{
	      //System.out.println("This is left");
	      
	      double y = 10;
	      //x = snake.get(i).getCenterX()-5;
	      if(x==9) {
	       x=x;
	      }
	      else if(flag!=1 && flag2!=1) {
	       x = x-9;
	      }
	      snake.getShbub().setCenterX(x);
	      snake.getMgbub().setCenterX(x);
	      snake.setTxcord(x-5);
	      snake.changexcordlistitem(0, x);
	      break;
	     }
	    }
	   }
	   
	  });
	  
  

  stage.setTitle("A rectangle");
  
  stage.setScene(scene);
  
  stage.show();
 }
 
 
 public static void main(String[] args) {
  launch(args);
 }
}