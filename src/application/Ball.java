package application;

import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Ball{
	private Circle ball;
	private Text text;
	private Circle snakehead;
	private TranslateTransition trans = new TranslateTransition();
	
	/**
	 * This is the constructor function with a circle c1
	 * @param c1 this is circle
	 */
	public Ball(Circle c1) {
		ball.setFill(c1.getFill());
		text.setFill(Color.WHITE);
		snakehead = c1;
	}
	/**
	 * This is a constructor function with x,y as its coordinates and circle c1
	 * @param x cordiante
	 * @param y cordinate
	 * @param c1 circle
	 */
	public Ball(double x,double y,Circle c1) {
		ball = new Circle(x, y, c1.getRadius(), c1.getFill());
		text = new Text();
		text.setY(y-10);
		text.setFill(Color.WHITE);
		snakehead = c1;
		int[] bul = {1,1,2,2,3,3,3,3,4,4,4,5,5,5,6,6};
	    int[] X = {35,87,113,138,163,188,213,238,263,288,313,328,363,388,413};
	    int ind = X[new Random().nextInt(X.length)];
	    ball.setCenterX(ind);
	   
	    text.setFill(Color.WHITE);
	    text.setText(Integer.toString(bul[new Random().nextInt(bul.length)]));
	    text.setX(ind-3);
	  
	    ball.setFill(snakehead.getFill());
	    ball.setRadius(snakehead.getRadius());

		
	}
	/**
	 * This function will work when the snake has magnetic power
	 * @param snake snake object
	 */
	public void maggie(Snake snake) {
		if(ball.getCenterY()>=240) {
			   double diff = ball.getCenterX()-snake.getHead().getCenterX();
			   if(diff<0) {
			   ball.setCenterX(ball.getCenterX()+4);
			   text.setX(ball.getCenterX()+4);
			   }
			   else if(diff>0) {
				   ball.setCenterX(ball.getCenterX()-4);
				   text.setX(ball.getCenterX()-4);
			   }
			   if(ball.getCenterY()>=410) {
				  
				   int tnum = Integer.parseInt(text.getText());
					if(ball.isVisible()) {
					for(int i=0;i<tnum;i++) {
						snake.add();
					}
					}
					ball.setVisible(false);
					text.setVisible(false);
			   }
			}
	}
	/**
	 * This method is used to identify a ball token
	 * @return return
	 */
	public String identity() {
		return "ball";
	}
	public void setTrans(Snake snake) {
//		System.out.println("hello");
		if(ball.getCenterY()>=240 && snake.getPower2()==1 && ball.isVisible()) {
			
			trans.setNode(ball);
			trans.setNode(text);
			trans.setDuration(Duration.millis(800));
			trans.setFromX(ball.getCenterX());
			trans.setToX(snake.getHead().getCenterX());
			trans.play();
			int tnum = Integer.parseInt(text.getText());
			if(ball.isVisible()) {
			for(int i=0;i<tnum;i++) {
				snake.add();
			}
			}
			//ball.setVisible(false);
			//text.setVisible(false);
		}
	}
	
	/**
	 * This function will update the position and value of the ball in random fashion
	 */
	public void update() {
		ball.setVisible(true);
	    text.setVisible(true);
	    int[] bul = {1,1,2,2,3,3,3,3,4,4,4,5,5,5,6,6};
	    int[] X = {35,87,113,138,163,188,213,238,263,288,313,328,363,388,413};
	    int ind = X[new Random().nextInt(X.length)];
	    ball.setCenterX(ind);
	    ball.setCenterY(-75);
	    text.setFill(Color.WHITE);
	    text.setText(Integer.toString(bul[new Random().nextInt(bul.length)]));
	    text.setX(ind-3);
	    text.setY(-85);
	    ball.setFill(snakehead.getFill());
	    ball.setRadius(snakehead.getRadius());
	    //trans = null;
	}
	
	public double getxcordball() {
		return ball.getCenterX();
	}
	public void setxcordball(double x) {
		ball.setCenterX(x);
	}
	public double getycordball() {
		return ball.getCenterY();
	}
	public void setycordball(double y) {
		ball.setCenterY(y);
	}
	public int getTextnum() {
		return Integer.parseInt(text.getText());
	}
	public double getxcordtext() {
		return text.getX();
	}
	public void setxcordtext(double x) {
		text.setX(x);
	}
	public double getycordtext() {
		return text.getY();
	}
	public void setycordtext(double y) {
		text.setY(y);
	}
	public boolean getvisibility() {
		return ball.isVisible();
	}
	public void setvisiblity(boolean b) {
		ball.setVisible(b);
		text.setVisible(b);
	}
	
	
	
	
	public void power() {
		
	}




	public Circle getBall() {
		return ball;
	}




	public void setBall(Circle ball) {
		this.ball = ball;
	}




	public Text getText() {
		return text;
	}




	public void setText(Text text) {
		this.text = text;
	}

	public Circle getSnakehead() {
		return snakehead;
	}

	public void setSnakehead(Circle snakehead) {
		this.snakehead = snakehead;
	}
}
