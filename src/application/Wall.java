package application;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Wall {

	private Rectangle wall;
	private int height;
	private double xcord;
	private double ycord;
	private int marker;
	
	
	public Wall(double x,double y,int height) {
		wall = new Rectangle(x,y,5,height);
		wall.setFill(Color.WHITE);
		setMarker(0);
		int[] he = {120,130,140,160};
	    int[] wx = {75,100,125,150,175,225,200,250,275,300,325,350,375};
	    wall.setHeight(he[new Random().nextInt(he.length)]);
	    //wall.setHeight(500);
	    wall.setX(wx[new Random().nextInt(wx.length)]);
	   
	    wall.setFill(Color.WHITE);
	}
	
	public void update() {
		int[] he = {120,130,140,160};
	    int[] wx = {75,100,125,150,175,225,200,250,275,300,325,350,375};
	    wall.setHeight(he[new Random().nextInt(he.length)]);
	    //wall.setHeight(500);
	    wall.setX(wx[new Random().nextInt(wx.length)]);
	    wall.setY(-75);
	    wall.setFill(Color.WHITE);
	}
	
	public int checker(Circle c) {
		
		if(getMarker()==0) {
			//System.out.println("hello");
			if(wall.getY()+wall.getHeight()+15 >= c.getCenterY() && wall.getY()-15 <= c.getCenterY()) {
				
				if(wall.getX()+5+16.5>=c.getCenterX() && wall.getX()+5<=c.getCenterX()) {
					return 1;
				}
				else if(wall.getX()-12<=c.getCenterX() && wall.getX()>=c.getCenterX()) {
					return -1;
				}
				else return  0;
			}
			else {
				if(wall.getY()-15 > c.getCenterY()) {
					//System.out.println("PASS HO GYA ");
					//setMarker(1);
				}
				return 0;
			}
		}
		else return 0;
		
		
	}
	
	public double getwallxcord() {
		return wall.getX();
	}
	public void setwallxcord(double x) {
		wall.setX(x);
	}
	
	public double getwallycord() {
		return wall.getY();
	}
	public void setwallycord(double y) {
		wall.setY(y);
	}
	
	public Rectangle getWall() {
		return wall;
	}


	public void setWall(Rectangle wall) {
		this.wall = wall;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public double getXcord() {
		return xcord;
	}


	public void setXcord(int xcord) {
		this.xcord = xcord;
	}


	public double getYcord() {
		return ycord;
	}


	public void setYcord(int ycord) {
		this.ycord = ycord;
	}

	public int getMarker() {
		return marker;
	}

	public void setMarker(int marker) {
		this.marker = marker;
	}
	
}
