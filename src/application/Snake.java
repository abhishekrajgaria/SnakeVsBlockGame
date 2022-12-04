package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class Snake {
	
	private static ArrayList<Circle> snake;
	private double xcord;
	private double ycord;
	private int length;
	private Text text;
	private Circle head;
	private static Image avatar;
	private int power;
	private int power2;
	private Circle mgbub;
	private Circle shbub;
	//Image mgb1 = new Image(new FileInputStream("E:\\t1bubble.png"));
	//Image shb1 = new Image(new FileInputStream("E:\\mbubble.png"));
	
	/**
	 * This is the constructor for a snake object with x and y coordinates of its head
	 * @param x this x cordiante
	 * @param y this is ycordinate
	 */
	public Snake(double x,double y) {  //Image ke liye bhi add krna hai
		ArrayList<Circle> tempc = new ArrayList<Circle>(); 
		for(int i=0;i<1000;i++) {
			
			tempc.add(new Circle(x,y+14*i,7.5,Color.YELLOW));
			if(i<5) {
				tempc.get(i).setVisible(true);
			}
			else {
				tempc.get(i).setVisible(false);
			}
			
		}
		//text.setFill(Color.WHITE);
		this.setText(new Text(x-5,y-10,Integer.toString(5)));
		//this.setText(new Text());
		this.snake = tempc;
		this.setHead(snake.get(0));
		this.setLength(5);
		mgbub = new Circle(x,y,20);
		mgbub.setVisible(false);
		shbub = new Circle(x,y,20);
		shbub.setVisible(false);
		
	}
	
	/**
	 * This is also a constructor function for snake object with x and y as coordinates and specified length i
	 * @param x cordiante
	 * @param y cordinate
	 * @param i lenght of snake
	 */
	public Snake(double x,double y,int i) {
		ArrayList<Circle> tempc = new ArrayList<Circle>();
		for(int j=0;j<1000;j++) {
			tempc.add(new Circle(x,y+14*j,7.5,Color.YELLOW));
			if(j<i) {
				tempc.get(j).setVisible(true);
			}
			else {
				tempc.get(j).setVisible(false);
			}
		}
		this.setText(new Text(x-5,y-10,Integer.toString(i)));
		this.snake = tempc;
		this.setHead(snake.get(0));
		this.setLength(i);
		mgbub = new Circle(x,y,20);
		mgbub.setVisible(false);
		shbub = new Circle(x,y,20);
		shbub.setVisible(false);
	}
	
	public void setTclr() {
		this.text.setFill(Color.WHITE);
	}
	public void setTxcord(double xt) {
		this.text.setX(xt);
	}
	public void setXcord(double xcord) {
		for(int i=0;i<snake.size();i++) {
			snake.get(i).setCenterX(xcord);
		}
	}
	/**
	 * This function will add a ball to the existing snake
	 */
	public void add(){
		this.setLength(length+1);
		//this.setText(new Text(Integer.toString(getLength())));
		snake.get(getLength()-1).setVisible(true);
		this.text.setText(Integer.toString(getLength()));
	}
	
	/**
	 * This function will delete a ball from the snake
	 */
	public void delete() {
		this.setLength(length-1);
		//this.setText(new Text(Integer.toString(getLength())));
		snake.get(getLength()).setVisible(false);
		this.text.setText(Integer.toString(getLength()));
	}
	public void changexcordlistitem(int i,double x) {
		snake.get(i).setCenterX(x);
	}
	
	public double getxcordlistitem(int i) {
		return snake.get(i).getCenterX();
	}
	

	public ArrayList<Circle> getSnake() {
		return snake;
	}

	public void setSnake(ArrayList<Circle> snake) {
		this.snake = snake;
	}

	public double getXcord() {
		return xcord;
	}

	

	public double getYcord() {
		return ycord;
	}

	public void setYcord(double ycord) {
		this.ycord = ycord;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	public Circle getHead() {
		return head;
	}
	public void setHead(Circle head) {
		this.head = head;
	}
	public Image getAvatar()
	{
		return avatar;
	}
	public static void setAvatar(Image avatar)
	{
		if(avatar==null)
		{
			for(int i=0;i<snake.size();i++)
			{
				snake.get(i).setFill(Color.YELLOW);
			}
		}
		else
		{
			for(int i=0;i<snake.size();i++)
			{
				snake.get(i).setFill(new ImagePattern(avatar));
			}
		}
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getPower2() {
		return power2;
	}
	public void setPower2(int power2) {
		this.power2 = power2;
	}






	public Circle getMgbub() {
		return mgbub;
	}






	public void setMgbub(Circle mgbub) {
		this.mgbub = mgbub;
	}






	public Circle getShbub() {
		return shbub;
	}






	public void setShbub(Circle shbub) {
		this.shbub = shbub;
	}

}

