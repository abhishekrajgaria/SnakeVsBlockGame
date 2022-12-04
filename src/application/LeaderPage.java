package application;
import javafx.event.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
class Leaderboard
{
	private int scores[];
	private boolean exit;
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	public boolean isExit() {
		return exit;
	}
	public void setExit(boolean exit) {
		this.exit = exit;
	}
}
public class LeaderPage extends Application{
	MainPage mp=new MainPage();
	static ArrayList<Label> scores=new ArrayList<Label>();
	static ArrayList<Label> date=new ArrayList<Label>();
	static ArrayList<Label> month=new ArrayList<Label>();
	static ArrayList<Label> year=new ArrayList<Label>();
	/**
	 * 
	 * @param score this is score
	 * @param d this is date
	 * @param m this is month
	 * @param y this is year
	 * This will update the different arraylists in the leaderboard pages 
	 */
	public static void update1(Label score,Label d,Label m,Label y)
	{
//		System.out.println(scores.size());
		for(int i=0;i<scores.size();i++) {
			try
			{
			int s=Integer.parseInt(scores.get(i).getText());
			int temps=Integer.parseInt(score.getText());
//			System.out.println(temps+" fgrg "+s);
			if(temps>s)
			{
//				System.out.println(temps+"jfalskjjhgkjsahgjas");
				score.setPrefSize(300,100);
				   score.setLayoutX(170);
				   score.setLayoutY(scores.get(i).getLayoutY());
				   score.setFont(Font.font("Cambria", 30));
				   score.setTextFill(Color.WHITE);
				   score.setTextAlignment(TextAlignment.CENTER);
				
					d.setPrefSize(300,100);
					   d.setLayoutX(250);
					   d.setLayoutY(date.get(i).getLayoutY());
					   d.setFont(Font.font("Cambria", 30));
					   d.setTextFill(Color.WHITE);
					   d.setTextAlignment(TextAlignment.CENTER);
					   
						m.setPrefSize(300,100);
						   m.setLayoutX(310);
						   m.setLayoutY(month.get(i).getLayoutY());
						   m.setFont(Font.font("Cambria", 30));
						   m.setTextFill(Color.WHITE);
						   m.setTextAlignment(TextAlignment.CENTER);
						   
							y.setPrefSize(300,100);
							   y.setLayoutX(370);
							   y.setLayoutY(year.get(i).getLayoutY());
							   y.setFont(Font.font("Cambria", 30));
							   y.setTextFill(Color.WHITE);
							   y.setTextAlignment(TextAlignment.CENTER);	
							   int d1=60;
							   for(int j=i+1;j<10;j++)
							   {
								   scores.get(j).setLayoutY(score.getLayoutY()+d1);
								   d1=d1+60;
							   }
				   
				scores.add(i, score);
				date.add(i,d);
				month.add(i, m);
				year.add(i, y);
				
				break;
			}
			}catch(Exception e)
			{
				
			}
		}
		scores.remove(scores.size()-1);
		date.remove(date.size()-1);
		month.remove(month.size()-1);
		year.remove(year.size()-1);
		
	}
	/**
	 * 
	 * @param primaryStage
	 * @throws IOException
	 * This is the launcher function for leaderboard page screen
	 */
	public void start(Stage primaryStage) throws IOException {
		   Group root=new Group();
			Button back=new Button();
			back.setPrefSize(90, 20);
			back.setLayoutX(360);
			back.setLayoutY(620);
			back.setId("backbutton");
			back.setText("B A C K");
		   for(int i=0;i<10;i++)
		   {
			   Label l=new Label();
			   scores.add(l);
		   }
		   for(int i=0;i<10;i++)
		   {
			   Label l=new Label();
			   date.add(l);
		   }
		   for(int i=0;i<10;i++)
		   {
			   Label l=new Label();
			   month.add(l);
		   }
		   for(int i=0;i<10;i++)
		   {
			   Label l=new Label();
			   year.add(l);
		   }
		   
		   	Image img1=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\gold.png"));
			Image img2=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\silver.png"));
			Image img3=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\bronze.png"));
			Image background=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\wood1.jpg"));
			Line l1=new Line();
			l1.setLayoutX(10);
			l1.setEndX(440);
			l1.setFill(Color.WHITE);
			Text t4=new Text();
			Text t5=new Text();
			Text t6=new Text();
			Text t7=new Text();
			Text t8=new Text();
			Text t9=new Text();
			Text t10=new Text();
			t4.setFont(Font.font("Times New Roman", 35));
			t5.setFont(Font.font("Times New Roman", 35));
			t6.setFont(Font.font("Times New Roman", 35));
			t7.setFont(Font.font("Times New Roman", 35));
			t8.setFont(Font.font("Times New Roman", 35));
			t9.setFont(Font.font("Times New Roman", 35));
			t10.setFont(Font.font("Times New Roman", 35));
			t4.setText("IV");
			t5.setText("V");
			t6.setText("VI");
			t7.setText("VII");
			t8.setText("VIII");
			t9.setText("IX");
			t10.setText("X");
			t4.setFill(Color.AZURE);
			t5.setFill(Color.AZURE);
			t6.setFill(Color.AZURE);
			t7.setFill(Color.AZURE);
			t8.setFill(Color.AZURE);
			t9.setFill(Color.AZURE);
			t10.setFill(Color.AZURE);
		   scores.get(0).setPrefSize(300, 100);
		   scores.get(1).setPrefSize(300, 100);
		   scores.get(2).setPrefSize(300, 100);
		   scores.get(3).setPrefSize(300, 100);
		   scores.get(4).setPrefSize(300, 100);
		   scores.get(5).setPrefSize(300, 100);
		   scores.get(6).setPrefSize(300, 100);
		   scores.get(7).setPrefSize(300, 100);
		   scores.get(8).setPrefSize(300, 100);
		   scores.get(9).setPrefSize(300, 100);
		   
		   date.get(0).setPrefSize(300, 100);
		   date.get(1).setPrefSize(300, 100);
		   date.get(2).setPrefSize(300, 100);
		   date.get(3).setPrefSize(300, 100);
		   date.get(4).setPrefSize(300, 100);
		   date.get(5).setPrefSize(300, 100);
		   date.get(6).setPrefSize(300, 100);
		   date.get(7).setPrefSize(300, 100);
		   date.get(8).setPrefSize(300, 100);
		   date.get(9).setPrefSize(300, 100);
		  
		   year.get(0).setPrefSize(300, 100);
		   year.get(1).setPrefSize(300, 100);
		   year.get(2).setPrefSize(300, 100);
		   year.get(3).setPrefSize(300, 100);
		   year.get(4).setPrefSize(300, 100);
		   year.get(5).setPrefSize(300, 100);
		   year.get(6).setPrefSize(300, 100);
		   year.get(7).setPrefSize(300, 100);
		   year.get(8).setPrefSize(300, 100);
		   year.get(9).setPrefSize(300, 100);
		   
		   month.get(0).setPrefSize(300, 100);
		   month.get(1).setPrefSize(300, 100);
		   month.get(2).setPrefSize(300, 100);
		   month.get(3).setPrefSize(300, 100);
		   month.get(4).setPrefSize(300, 100);
		   month.get(5).setPrefSize(300, 100);
		   month.get(6).setPrefSize(300, 100);
		   month.get(7).setPrefSize(300, 100);
		   month.get(8).setPrefSize(300, 100);
		   month.get(9).setPrefSize(300, 100);
		   
		   
		   Rectangle rect1=new Rectangle(40,40);
		   Rectangle rect2=new Rectangle(40,40);
		   Rectangle rect3=new Rectangle(40,40);
		   rect1.setLayoutX(30);
		   rect1.setLayoutY(30);
		   rect1.setFill(new ImagePattern(img1));
		   rect2.setLayoutX(30);
		   rect2.setLayoutY(90);
		   rect2.setFill(new ImagePattern(img2));
		   rect3.setLayoutX(30);
		   rect3.setLayoutY(150);
		   rect3.setFill(new ImagePattern(img3));
		   int x=0;
		   int j=0;
		   int k=0;
		   t4.setLayoutX(40);
		   t5.setLayoutX(40);
		   t6.setLayoutX(40);
		   t7.setLayoutX(40);
		   t8.setLayoutX(40);
		   t9.setLayoutX(40);
		   t10.setLayoutX(40);
		   t4.setLayoutY(240);
		   t5.setLayoutY(300);
		   t6.setLayoutY(360);
		   t7.setLayoutY(420);
		   t8.setLayoutY(480);
		   t9.setLayoutY(540);
		   t10.setLayoutY(600);
		   Text t=new Text();
		   for(int i=0;i<10;i++)
		   {
			   scores.get(i).setLayoutX(170);
			   scores.get(i).setLayoutY(x);
			   scores.get(i).setText("0");
			   scores.get(i).setFont(Font.font("Cambria", 30));
			   scores.get(i).setTextFill(Color.WHITE);
			   scores.get(i).setTextAlignment(TextAlignment.CENTER);
			   
			   date.get(i).setLayoutX(250);
			   date.get(i).setLayoutY(x);
			   date.get(i).setText("0");
			   date.get(i).setFont(Font.font("Cambria", 30));
			   date.get(i).setTextFill(Color.WHITE);
			   date.get(i).setTextAlignment(TextAlignment.CENTER);
			   
			   month.get(i).setLayoutX(310);
			   month.get(i).setLayoutY(x);
			   month.get(i).setText("0");
			   month.get(i).setFont(Font.font("Cambria", 30));
			   month.get(i).setTextFill(Color.WHITE);
			   month.get(i).setTextAlignment(TextAlignment.CENTER);
			   
			   year.get(i).setLayoutX(370);
			   year.get(i).setLayoutY(x);
			   year.get(i).setText("0");
			   year.get(i).setFont(Font.font("Cambria", 30));
			   year.get(i).setTextFill(Color.WHITE);
			   year.get(i).setTextAlignment(TextAlignment.CENTER);
			   
			   x=x+60;
			   
		   }
		   try
			 {
				 File f=new File("LEADERDATA.dat");
				SaveData data=(SaveData) ResourceManager.load(f.getName());
				for(int i=0;i<10;i++)
				{
					scores.get(i).setText(data.scores.get(i));
					date.get(i).setText(data.date.get(i));
					month.get(i).setText(data.month.get(i));
					year.get(i).setText(data.year.get(i));
				}
//				System.out.println("Abhi "+data.scores.get(0));
			 }
		   catch(Exception e)
		   {
			   //e.printStackTrace();
		   }
//		   Label l2=new Label();
//		   l2.setText("2");
//		   l2.setPrefSize(300, 100);
//		   l2.setLayoutX(170);
//		   l2.setLayoutY(scores.get(5).getLayoutY());
//		   l2.setFont(Font.font("Cambria", 30));
//		   l2.setTextFill(Color.WHITE);
//		   l2.setTextAlignment(TextAlignment.CENTER);
//		   scores.add(5, l2);
//		   scores.remove(6);
			FadeTransition tr1=new FadeTransition(Duration.seconds(0.2),scores.get(0));
			FadeTransition tr2=new FadeTransition(Duration.seconds(0.2),scores.get(1));
			FadeTransition tr3=new FadeTransition(Duration.seconds(0.2),scores.get(2));
			FadeTransition tr4=new FadeTransition(Duration.seconds(0.2),scores.get(3));
			FadeTransition tr5=new FadeTransition(Duration.seconds(0.2),scores.get(4));
			FadeTransition tr6=new FadeTransition(Duration.seconds(0.2),scores.get(5));
			FadeTransition tr7=new FadeTransition(Duration.seconds(0.2),scores.get(6));
			FadeTransition tr8=new FadeTransition(Duration.seconds(0.2),scores.get(7));
			FadeTransition tr9=new FadeTransition(Duration.seconds(0.2),scores.get(8));
			FadeTransition tr10=new FadeTransition(Duration.seconds(0.2),scores.get(9));
			ScaleTransition sc1=new ScaleTransition(Duration.seconds(1),rect1);
			ScaleTransition sc2=new ScaleTransition(Duration.seconds(1),rect2);
			ScaleTransition sc3=new ScaleTransition(Duration.seconds(1),rect3);
			tr1.setFromValue(0.0);
			tr1.setToValue(40.0);
			tr2.setFromValue(0.0);
			tr2.setToValue(40.0);
			tr3.setFromValue(0.0);
			tr3.setToValue(40.0);
			tr4.setFromValue(0.0);
			tr4.setToValue(40.0);
			tr5.setFromValue(0.0);
			tr5.setToValue(40.0);
			tr6.setFromValue(0.0);
			tr6.setToValue(40.0);
			tr7.setFromValue(0.0);
			tr7.setToValue(40.0);
			tr8.setFromValue(0.0);
			tr8.setToValue(40.0);
			tr9.setFromValue(0.0);
			tr9.setToValue(40.0);
			tr10.setFromValue(0.0);
			tr10.setToValue(40.0);
			sc1.setByX(1);
			sc1.setByY(1);
			sc2.setByX(1);
			sc2.setByY(1);
			sc3.setByX(1);
			sc3.setByY(1);
			sc1.setAutoReverse(true);
			sc2.setAutoReverse(true);
			sc3.setAutoReverse(true);
			sc1.setCycleCount(Animation.INDEFINITE);
			sc2.setCycleCount(Animation.INDEFINITE);
			sc3.setCycleCount(Animation.INDEFINITE);
			ParallelTransition pt=new ParallelTransition(sc1,sc2,sc3);
			SequentialTransition st=new SequentialTransition(tr1,tr2,tr3,tr4,tr5,tr6,tr7,tr8,tr9,tr10,pt);
			//ParallelTransition pt=new ParallelTransition(sc1,sc2,sc3);
			root.getChildren().add(back);
		   root.getChildren().addAll(rect1,rect2,rect3,t4,t5,t6,t7,t8,t9,t10);
		   st.play();
		   root.getChildren().addAll(scores);
		   root.getChildren().addAll(date);
		   root.getChildren().addAll(month);
		   root.getChildren().addAll(year);
		   
		   Scene scene = new Scene(root,450,650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Main Page");
			scene.setFill(new ImagePattern(background));
			primaryStage.setScene(scene);
			primaryStage.show();
			back.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					try
					{
						mp.start(primaryStage);
						primaryStage.show();
					}
					catch(Exception E)
					{
						E.printStackTrace();
					}
				}
			});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
