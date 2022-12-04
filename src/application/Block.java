package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.*;

import javafx.scene.shape.Rectangle;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Block {
	private ArrayList<Rectangle> blocks = new ArrayList<Rectangle>();
	private ArrayList<Boolean> destoryed = new ArrayList<Boolean>();
	private ArrayList<Text> texi = new ArrayList<Text>();
	private double xcord;
	private double ycord;
	private Color[] arrcolor = {Color.CORAL,Color.LAVENDER,Color.CORNFLOWERBLUE,Color.CRIMSON,Color.DARKSLATEBLUE,Color.FIREBRICK,Color.KHAKI,Color.LIGHTSEAGREEN}; 
	private int[] X = {0,76,151,226,301,376};
	private int[] bul = {1,2,3,4,5,6};
	
	/**
	 * This is the constructor function of a block with x and y as coordinates
	 * @param x this is xcordinate
	 * @param y this is y cordinate
	 */
	public Block(int x,int y){
		
		for(int i=0;i<6;i++) {
			blocks.add(new Rectangle(x+75*i,y,75,75));
			blocks.get(i).setFill(arrcolor[new Random().nextInt(arrcolor.length)]);
			blocks.get(i).setArcHeight(30);
			blocks.get(i).setArcWidth(30);
			texi.add(new Text(x+75*i+22,y+47,"00"));
			texi.get(i).setFont(Font.font(null,FontWeight.BOLD,28));
			destoryed.add(false);
			//texi.get(i).setFill(Color.WHITE);
			
		}
		ArrayList<Color> coxy = new ArrayList<Color>();
		 ArrayList<Integer> xy = new ArrayList<Integer>();
		 for(int q1=0;q1<arrcolor.length;q1++) {
		  //System.out.println(arrcolor[q1]);
			 coxy.add(arrcolor[q1]);
		 }
		 for(int q1=0;q1<X.length;q1++) {
			 xy.add(X[q1]);
		 }
		 
		 Text[] testtexi = new Text[6];
		 Rectangle[] testblocks = new Rectangle[6];
		 for(int q1=0;q1<6;q1++) {
			 testtexi[q1] = texi.get(q1);
			 testblocks[q1] = blocks.get(q1);
		 }
		 
		 for(int q1=0;q1<6;q1++) {
		    // testtexi[q1].setY(-28);
		    // testblocks[q1].setY(-75);
		     int ind =new Random().nextInt(xy.size());
		     testblocks[q1].setX(xy.get(ind));
		     testtexi[q1].setX(xy.get(ind)+20);
		     int cnd = new Random().nextInt(coxy.size());
		     testblocks[q1].setFill(coxy.get(cnd));
		     coxy.remove(cnd);
		     xy.remove(ind);
		   }
		 
		 int[] gk = {0,1,2,3,4,5};   
		 int gok = gk[new Random().nextInt(gk.length)];
		 //System.out.println(gok);
		 for(int q1=0;q1<gok;q1++) {
			 blocks.get(q1).setVisible(false);
			 destoryed.remove(q1);
			 destoryed.add(q1,true);
			 
		 	}
		 for(int q1=gok;q1<6;q1++) {
			 
			 
			 destoryed.remove(q1);
			 destoryed.add(q1,false);
			 
			 if(gok==0) {
				 if(q1<2) {
					// System.out.println("six hai");
					 testtexi[q1].setText(Integer.toString(new Random().nextInt(5-1)+1));
				 }
				 else {
					 testtexi[q1].setText(Integer.toString(new Random().nextInt(5)+5));
				 }
			 }
			 else if(gok==1) {
				 if(q1<2) {
//					 System.out.println("five hai");
					 testtexi[q1].setText(Integer.toString(new Random().nextInt(5-1)+1));
				 }
				 else {
					 testtexi[q1].setText(Integer.toString(new Random().nextInt(5)+5));
				 }
			 }
			 else {
				 testtexi[q1].setText(Integer.toString(new Random().nextInt(5)+5));
			 }
			 
			 blocks.get(q1).setVisible(true);
		 }
		
		
	}
	public double getYcordblock(int i) { //cordinate y get blck
		return blocks.get(i).getY();
	}
	
	public double getYcordtexi(int i) { //cordinate y get tex
		return texi.get(i).getY();
	}
	
	public double getXcordblock(int i) { //cordinate x get blck
		return blocks.get(i).getX();
	}
	public double getXcordtexi(int i) { // cordinate x get tex
		return texi.get(i).getX();
	}
	
	
	
	public void setYcordblock(double y) { // set all y cordinate block
		for(int i=0;i<6;i++) {
			blocks.get(i).setY(y);
			//texi.get(i).setY(y);
		}
	}
	public void setYcordtexi(double y) {  // set all y cordinate texi
		for(int i=0;i<6;i++) {
			//blocks.get(i).setY(y);
			texi.get(i).setY(y);
		}
	}
	//public void 
	/**
	 * This function will set the block position and values as per the snake length in a random fashion
	 * @param snakelength this is snakelenght
	 */
	public void update(int snakelength) {
		try {
			
		 ArrayList<Color> coxy = new ArrayList<Color>();
		 ArrayList<Integer> xy = new ArrayList<Integer>();
		 for(int q1=0;q1<arrcolor.length;q1++) {
		  //System.out.println(arrcolor[q1]);
			 coxy.add(arrcolor[q1]);
		 }
		 for(int q1=0;q1<X.length;q1++) {
			 xy.add(X[q1]);
		 }
		 
		 Text[] testtexi = new Text[6];
		 Rectangle[] testblocks = new Rectangle[6];
		 for(int q1=0;q1<6;q1++) {
			 testtexi[q1] = texi.get(q1);
			 testblocks[q1] = blocks.get(q1);
		 }
		 
		 for(int q1=0;q1<6;q1++) {
		     testtexi[q1].setY(-28);
		     testblocks[q1].setY(-75);
		     int ind =new Random().nextInt(xy.size());
		     testblocks[q1].setX(xy.get(ind));
		     testtexi[q1].setX(xy.get(ind)+20);
		     int cnd = new Random().nextInt(coxy.size());
		     testblocks[q1].setFill(coxy.get(cnd));
		     coxy.remove(cnd);
		     xy.remove(ind);
		   }
		 
		 int[] gk = {0,1,2,3,4,5};   
		 int gok = gk[new Random().nextInt(gk.length)];
		 //System.out.println(gok);
		 for(int q1=0;q1<gok;q1++) {
			 blocks.get(q1).setVisible(false);
			 destoryed.remove(q1);
			 destoryed.add(q1,true);
			 
		 	}
		 for(int q1=gok;q1<6;q1++) {
			 
			 
			 destoryed.remove(q1);
			 destoryed.add(q1,false);
			 
			 if(gok==0) {
				 if(q1<2) {
					// System.out.println("six hai");
					 testtexi[q1].setText(Integer.toString(new Random().nextInt(snakelength-1)+1));
				 }
				 else {
					 testtexi[q1].setText(Integer.toString(new Random().nextInt(snakelength)+snakelength));
				 }
			 }
			 else if(gok==1) {
				 if(q1<2) {
					 System.out.println("five hai");
					 testtexi[q1].setText(Integer.toString(new Random().nextInt(snakelength-1)+1));
				 }
				 else {
					 testtexi[q1].setText(Integer.toString(new Random().nextInt(snakelength)+snakelength));
				 }
			 }
			 else {
				 testtexi[q1].setText(Integer.toString(new Random().nextInt(snakelength)+snakelength));
			 }
			 
			 blocks.get(q1).setVisible(true);
		 }
		}catch(Exception e)
		{
			
		}
	}
	public boolean getdestitem(int i) {
		return destoryed.get(i);
	}
	public void setdestitem(int i,boolean b) {
		destoryed.remove(i);
		destoryed.add(i, b);
	}
	
	public Text gettexiitem(int i) { //get tex
		return texi.get(i);
	}
	public void settexiitem(int i,int t) {
		texi.get(i).setText(Integer.toString(t));
	}
	
	public Rectangle getblockitem(int i) { // get rec
		return blocks.get(i);
	}
	
	public void setFillblockimage(int i,Image img) {
		blocks.get(i).setFill(new ImagePattern(img));
	}
	
	
	
	public void changexcordtexiitem(int i,double x) { //set x cordinate texi
		texi.get(i).setX(x);
	}
	

	
	public void changexcordblockitem(int i,double x) { // set x cordinate block
		blocks.get(i).setX(x);
	
	}
	
	public ArrayList<Rectangle> getBlocks() {
		return blocks;
	}
	public void setBlocks(ArrayList<Rectangle> blocks) {
		this.blocks = blocks;
	}
	public ArrayList<Text> getTexi() {
		return texi;
	}
	public void setTexi(ArrayList<Text> texi) {
		this.texi = texi;
	}

	

	
	  
	
	

}
