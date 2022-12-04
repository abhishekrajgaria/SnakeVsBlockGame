package application;



import java.util.Random;

import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
//import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Token{

	private Circle token;
	private Image image;
	private RotateTransition rotate = new RotateTransition();
	private int identity;
	
	/**
	 * This is the constructor function of token with its y coordinate and image
	 * @param y cordiante
	 * @param img image
	 */
	public Token(double y,Image img) {
		token = new Circle();
		token.setCenterY(y);
		token.setRadius(20);
		token.setFill(new ImagePattern(img));
		this.image = img;
		rotate.setAxis(Rotate.Y_AXIS);
		rotate.setByAngle(360);
		rotate.setCycleCount(500);
		rotate.setDuration(Duration.millis(1000));
		rotate.setAutoReverse(true);
		rotate.setNode(this.token);
		token.setVisible(false);
		
	}
	
	
	public double getxcord() {
		return token.getCenterX();
	}
	 
	public void setxcord(double x) {
		token.setCenterX(x);
	}
	 
	public double getycord() {
		return token.getCenterY();
	}
	 
	public void setycord(double y) {
		token.setCenterY(y);
	}
	 
	public void setimage(Image img) {
		token.setFill(new ImagePattern(img));
	}
	public void setidentity(int i) {
		identity = i;
	}
	public int getidentity() {
		return identity;
	}
	
	 /**
	  * This method will update the position of tokens and its type randomly
	  */
	public void update() {
		
		token.setVisible(true);
	    
	    int[] X = {35,87,113,138,163,188,213,238,263,288,313,328,363,388,413};
	    int ind = X[new Random().nextInt(X.length)];
	    token.setCenterX(ind);
	    token.setCenterY(-75);
	    
	    token.setFill(new ImagePattern(image));
	    token.setRadius(20);
	    rotate.play();
	}
	 /**
	  * This will stop the rotate transition of tokens
	  */
	public void stoprotate() {
		rotate.pause();
	}
	/**
	  * This will resume the rotate transition of tokens
	  */
	public void resumerotate(){
		rotate.play();
	}
	
	
	 /**
	  * This will set the power of the snake object or give it tokens
	  * @param snake snake
	  * @param ball1 ball
	  * @param ball2 ball
	  * @param ball3 ball
	  * @param ball4 ball
	  * @param ball5 ball
	  * @param ball6 ball
	  * @param chk1 counter
	  * @param chk2 counter
	  * @param bk1 block
	  * @param bk2 block
	  */
	public void power(Snake snake,Ball ball1,Ball ball2,Ball ball3,Ball ball4,Ball ball5,Ball ball6,int chk1,int chk2,Block bk1,Block bk2) {
		//System.out.println("BHAAAGH MILKHA BHAAG");
		if(snake.getPower()==1) {
			if(chk2==4) {
				snake.setPower2(0);
				chk2 = 0;
			}
		}
		if(snake.getPower2()==1) {
//			System.out.println("AA GYA HUN");
			if(chk1>=0 && chk1<4) {
//				System.out.println("I AM ALIVE");
				ball1.setTrans(snake);
				ball2.setTrans(snake);
				ball3.setTrans(snake);
				ball4.setTrans(snake);
				ball5.setTrans(snake);
				ball6.setTrans(snake);
			}
			if(chk1==4) {
				snake.setPower(0);
				chk1 = 0;
			}
		}
		if(identity==5) {
			
		}
		if(identity==4) {
			
		}
		// TODO Auto-generated method stub
		
	}

	 
	public Circle gettoken() {
		// TODO Auto-generated method stub
		return token;
	}

	public void setToken(Circle c)
	{
		this.token=c;
	}
	 
	public void setvisibilty(boolean b) {
		token.setVisible(b);
		// TODO Auto-generated method stub
		
	}

	 
	public boolean getvisibilty() {
		// TODO Auto-generated method stub
		return token.isVisible();
	}
	
}
