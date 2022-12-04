package application;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class SaveData implements Serializable{
private static final long serialVersionUID=1L;

ArrayList<Double> blockxs=new ArrayList<Double>();
ArrayList<Double> blockys=new ArrayList<Double>();
ArrayList<Integer> blockwidth=new ArrayList<Integer>();
ArrayList<Integer> blockheight=new ArrayList<Integer>();
ArrayList<Integer> blockcolors=new ArrayList<Integer>();
ArrayList<Boolean> blockvisibilities=new ArrayList<Boolean>();
ArrayList<String> blocknumbers=new ArrayList<String>();
ArrayList<Double> blockarcheight=new ArrayList<Double>();
ArrayList<Double> blockarcwidth=new ArrayList<Double>();
ArrayList<Boolean> blocknumbervisibility=new ArrayList<Boolean>();
ArrayList<Double> blocknumberx=new ArrayList<Double>();
ArrayList<Double> blocknumbery=new ArrayList<Double>();
ArrayList<Integer> blocknumbersize=new ArrayList<Integer>();


ArrayList<Double> blockxs2=new ArrayList<Double>();
ArrayList<Double> blockys2=new ArrayList<Double>();
ArrayList<Integer> blockwidth2=new ArrayList<Integer>();
ArrayList<Integer> blockheight2=new ArrayList<Integer>();
ArrayList<Integer> blockcolors2=new ArrayList<Integer>();
ArrayList<Boolean> blockvisibilities2=new ArrayList<Boolean>();
ArrayList<String> blocknumbers2=new ArrayList<String>();
ArrayList<Double> blockarcheight2=new ArrayList<Double>();
ArrayList<Double> blockarcwidth2=new ArrayList<Double>();
ArrayList<Boolean> blocknumbervisibility2=new ArrayList<Boolean>();
ArrayList<Double> blocknumberx2=new ArrayList<Double>();
ArrayList<Double> blocknumbery2=new ArrayList<Double>();
ArrayList<Integer> blocknumbersize2=new ArrayList<Integer>();

public ArrayList<Boolean> getBlocknumbervisibility() {
	Rectangle r=new Rectangle();
	return blocknumbervisibility;
}
public void setBlocknumbervisibility(ArrayList<Boolean> blocknumbervisibility) {
	this.blocknumbervisibility = blocknumbervisibility;
}
public ArrayList<Boolean> getBlocknumbervisibility2() {
	return blocknumbervisibility2;
}
public void setBlocknumbervisibility2(ArrayList<Boolean> blocknumbervisibility2) {
	this.blocknumbervisibility2 = blocknumbervisibility2;
}
public ArrayList<Double> getBlockxs2() {
	return blockxs2;
}
public void setBlockxs2(ArrayList<Double> blockxs2) {
	this.blockxs2 = blockxs2;
}
public ArrayList<Double> getBlockys2() {
	return blockys2;
}
public void setBlockys2(ArrayList<Double> blockys2) {
	this.blockys2 = blockys2;
}
public ArrayList<Integer> getBlockwidth2() {
	return blockwidth2;
}
public void setBlockwidth2(ArrayList<Integer> blockwidth2) {
	this.blockwidth2 = blockwidth2;
}
public ArrayList<Integer> getBlockheight2() {
	return blockheight2;
}
public void setBlockheight2(ArrayList<Integer> blockheight2) {
	this.blockheight2 = blockheight2;
}
public ArrayList<Integer> getBlockcolors2() {
	return blockcolors2;
}
public void setBlockcolors2(ArrayList<Integer> blockcolors2) {
	this.blockcolors2 = blockcolors2;
}
public ArrayList<Boolean> getBlockvisibilities2() {
	return blockvisibilities2;
}
public void setBlockvisibilities2(ArrayList<Boolean> blockvisibilities2) {
	this.blockvisibilities2 = blockvisibilities2;
}
public ArrayList<String> getBlocknumbers2() {
	return blocknumbers2;
}
public void setBlocknumbers2(ArrayList<String> blocknumbers2) {
	this.blocknumbers2 = blocknumbers2;
}
public ArrayList<Double> getBlockarcheight2() {
	return blockarcheight2;
}
public void setBlockarcheight2(ArrayList<Double> blockarcheight2) {
	this.blockarcheight2 = blockarcheight2;
}
public ArrayList<Double> getBlockarcwidth2() {
	return blockarcwidth2;
}
public void setBlockarcwidth2(ArrayList<Double> blockarcwidth2) {
	this.blockarcwidth2 = blockarcwidth2;
}
double ball1xs;
double ball1ys;
float ball1radius;
String ball1color;
String ball1text;
double ball1textx;
double ball1texty;
boolean ball1textvisibility;
boolean ball1visibility;

double ball2xs;
double ball2ys;
float ball2radius;
String ball2color;
String ball2text;
double ball2textx;
double ball2texty;
boolean ball2textvisibility;
boolean ball2visibility;

double ball3xs;
double ball3ys;
float ball3radius;
String ball3color;
String ball3text;
double ball3textx;
double ball3texty;
boolean ball3textvisibility;
boolean ball3visibility;

double ball4xs;
double ball4ys;
float ball4radius;
String ball4color;
String ball4text;
double ball4textx;
double ball4texty;
boolean ball4textvisibility;
boolean ball4visibility;

double ball5xs;
double ball5ys;
float ball5radius;
String ball5color;
String ball5text;
double ball5textx;
double ball5texty;
boolean ball5textvisibility;
boolean ball5visibility;

double ball6xs;
double ball6ys;
float ball6radius;
String ball6color;
String ball6text;
double ball6textx;
double ball6texty;
boolean ball6textvisibility;
boolean ball6visibility;
//Wall w1=new Wall(225,-400,75);
//Wall w2=new Wall(225,-800,75);

String colorwall1;
String colorwall2;
double wallheight1;
double wallheight2;
double wallxcord1;
double wallycord1;
double wallxcord2;
double wallycord2;
boolean wallvisibility1;
boolean wallvisibility2;
int wallmarker1;
int wallmarker2;


double token1x;
double token1y;
double token1rad;
int token1imagenum;
boolean token1visibility;

double token2x;
double token2y;
double token2rad;
int token2imagenum;
boolean token2visibility;

ArrayList<String> scores=new ArrayList<String>();
ArrayList<String> date=new ArrayList<String>();
ArrayList<String> month=new ArrayList<String>();
ArrayList<String> year=new ArrayList<String>();

ArrayList<Double> snakeballxs=new ArrayList<Double>();
ArrayList<Double> snakeballys=new ArrayList<Double>();
ArrayList<Double> snakeballradius=new ArrayList<Double>();
ArrayList<String> snakeballcolors=new ArrayList<String>();
ArrayList<Boolean> snakeballvisibility=new ArrayList<Boolean>();
int snakeavatarnum;
int snakelenght = 0;
String currscore;
String currcoins;


public ArrayList<Double> getBlockxs() {
	return blockxs;
}
public void setBlockxs(ArrayList<Double> blockxs) {
	this.blockxs = blockxs;
}
public ArrayList<Double> getBlockys() {
	return blockys;
}
public void setBlockys(ArrayList<Double> blockys) {
	this.blockys = blockys;
}
public ArrayList<Integer> getBlockwidth() {
	return blockwidth;
}
public void setBlockwidth(ArrayList<Integer> blockwidth) {
	this.blockwidth = blockwidth;
}
public ArrayList<Integer> getBlockheight() {
	return blockheight;
}
public void setBlockheight(ArrayList<Integer> blockheight) {
	this.blockheight = blockheight;
}
public ArrayList<Integer> getBlockcolors() {
	return blockcolors;
}
public void setBlockcolors(ArrayList<Integer> blockcolors) {
	this.blockcolors = blockcolors;
}
public ArrayList<Boolean> getBlockvisibilities() {
	return blockvisibilities;
}
public void setBlockvisibilities(ArrayList<Boolean> blockvisibilities) {
	this.blockvisibilities = blockvisibilities;
}
public ArrayList<String> getBlocknumbers() {
	return blocknumbers;
}
public void setBlocknumbers(ArrayList<String> blocknumbers) {
	this.blocknumbers = blocknumbers;
}
public ArrayList<Double> getBlockarcheight() {
	return blockarcheight;
}
public void setBlockarcheight(ArrayList<Double> blockarcheight) {
	this.blockarcheight = blockarcheight;
}
public ArrayList<Double> getBlockarcwidth() {
	return blockarcwidth;
}
public void setBlockarcwidth(ArrayList<Double> blockarcwidth) {
	this.blockarcwidth = blockarcwidth;
}
public ArrayList<Double> getSnakeballxs() {
	return snakeballxs;
}
public void setSnakeballxs(ArrayList<Double> snakeballxs) {
	this.snakeballxs = snakeballxs;
}
public ArrayList<Double> getSnakeballys() {
	return snakeballys;
}
public void setSnakeballys(ArrayList<Double> snakeballys) {
	this.snakeballys = snakeballys;
}
public ArrayList<Double> getSnakeballradius() {
	return snakeballradius;
}
public void setSnakeballradius(ArrayList<Double> snakeballradius) {
	this.snakeballradius = snakeballradius;
}
public ArrayList<String> getSnakeballcolors() {
	return snakeballcolors;
}
public void setSnakeballcolors(ArrayList<String> snakeballcolors) {
	this.snakeballcolors = snakeballcolors;
}
public ArrayList<Boolean> getSnakeballvisibility() {
	return snakeballvisibility;
}
public void setSnakeballvisibility(ArrayList<Boolean> snakeballvisibility) {
	this.snakeballvisibility = snakeballvisibility;
}


}
