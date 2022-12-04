package application;
	
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	/**
	 * Launcher fucntion for the main starting screen
	 */
	public void start(Stage primaryStage) throws IOException{
		try {
			MainPage mp=new MainPage();
			Group root = new Group();
			Image img1=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\snake2.png"));
			Rectangle figure=new Rectangle(80,80);
			figure.setFill(new ImagePattern(img1));
			figure.setLayoutX(200);
			figure.setLayoutY(450);
			ScaleTransition st1=new ScaleTransition(Duration.seconds(6),figure);
			FadeTransition ft1=new FadeTransition(Duration.seconds(6),figure);
			st1.setByX(2);
			st1.setByY(2);
			ft1.setFromValue(0.0);
			ft1.setToValue(40.0);
			ArrayList<Circle> circles1=new ArrayList<Circle>();
			for(int i=0;i<10;i++)
			{
					Circle p=new Circle();
					circles1.add(p);
					circles1.get(i).setFill(Color.YELLOW);
			}
			for(int i=0;i<10;i++)
			{
				circles1.get(i).setRadius(10);
			}
			int y=10;
			for(int i=0;i<circles1.size();i++)
			{
				circles1.get(i).setCenterX(50);
				circles1.get(i).setCenterY(50+y);
				y=y+20;
			}
			ArrayList<Circle> circles2=new ArrayList<Circle>();
			for(int i=0;i<15;i++)
			{
					Circle p=new Circle();
					circles2.add(p);
					circles2.get(i).setFill(Color.ORANGE);
			}
			for(int i=0;i<15;i++)
			{
				circles2.get(i).setRadius(10);
			}
			y=10;
			for(int i=0;i<circles2.size();i++)
			{
				circles2.get(i).setCenterX(400);
				circles2.get(i).setCenterY(50+y);
				y=y+20;
			}
			ArrayList<Circle> circles3=new ArrayList<Circle>();
			for(int i=0;i<10;i++)
			{
					Circle p=new Circle();
					circles3.add(p);
					circles3.get(i).setFill(Color.YELLOW);
			}
			for(int i=0;i<10;i++)
			{
				circles3.get(i).setRadius(10);
			}
			int x=10;
			for(int i=0;i<circles3.size();i++)
			{
				circles3.get(i).setCenterX(50+x);
				circles3.get(i).setCenterY(400);
				x=x+20;
			}
			Circle c=new Circle(200);
			c.setLayoutX(200);
			c.setLayoutY(200);
//			PathTransition p=new PathTransition();
//			p.setNode(circles.get(0));
//			p.setNode(circles.get(1));
//			p.setPath(c);
//			p.setDuration(Duration.seconds(2));
//			p.play();
			Text Gametitle1=new Text();
			Text Gametitle2=new Text();
			Text Gametitle3=new Text();
			Text taphere=new Text();
			taphere.setFill(Color.WHITE);
			taphere.setFont(Font.font("Times New Roman", 20));
			Image img=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\snakes.png"));
			taphere.setText("T A P  T O  C O N T I N U E...");
			taphere.setX(100);
			taphere.setY(500);
			DropShadow ds = new DropShadow();
			Reflection r = new Reflection();
			r.setFraction(0.6f);
			TranslateTransition tr1=new TranslateTransition();
			TranslateTransition tr2=new TranslateTransition();
			TranslateTransition tr3=new TranslateTransition();
			ArrayList<TranslateTransition> snake1=new ArrayList<TranslateTransition>();
			ArrayList<TranslateTransition> snake2=new ArrayList<TranslateTransition>();
			for(int i=0;i<circles1.size();i++)
			{
				TranslateTransition p=new TranslateTransition();
				snake1.add(p);
			}
			for(int i=0;i<circles2.size();i++)
			{
				TranslateTransition p=new TranslateTransition();
				snake2.add(p);
			}
			FadeTransition FadeIn=new FadeTransition(Duration.seconds(1),taphere);
			tr1.setDuration(Duration.seconds(2));
			tr2.setDuration(Duration.seconds(2));
			tr3.setDuration(Duration.seconds(2));
//			snake1.setDuration(Duration.seconds(2));
//			snake2.setDuration(Duration.seconds(2));
			for(int i=0;i<circles1.size();i++)
			{
				snake1.get(i).setNode(circles1.get(i));
			}
			for(int j=0;j<circles2.size();j++)
			{
				snake2.get(j).setNode(circles2.get(j));
			}
			int z=0;
			for(int i=0;i<snake1.size();i++)
			{
				snake1.get(i).setDuration(Duration.seconds(2));
				snake1.get(i).setDelay(Duration.seconds(1));
				snake1.get(i).setAutoReverse(true);
				snake1.get(i).setCycleCount(Animation.INDEFINITE);
				snake1.get(snake1.size()-1-i).setToY(390-z);
				//z=z+10;
			}
			z=0;
			for(int j=0;j<snake2.size();j++)
			{
				snake2.get(j).setDuration(Duration.seconds(2));
				snake2.get(j).setAutoReverse(true);
				snake2.get(j).setCycleCount(Animation.INDEFINITE);
				snake2.get(snake2.size()-1-j).setToY(290-z);
				//z=z+10;
			}
			ParallelTransition p1=new ParallelTransition(snake1.get(0),snake1.get(1),snake1.get(2),snake1.get(3),snake1.get(4),snake1.get(5),snake1.get(6),snake1.get(7),snake1.get(8),snake1.get(9));
			ParallelTransition p2=new ParallelTransition(snake2.get(0),snake2.get(1),snake2.get(2),snake2.get(3),snake2.get(4),snake2.get(5),snake2.get(6),snake2.get(7),snake2.get(8),snake2.get(9),snake2.get(10),snake2.get(11),snake2.get(12),snake2.get(13),snake2.get(14));
			ds.setOffsetY(3.0f);
			ds.setColor(Color.WHITE);
			Gametitle1.setText("Snake");
			Gametitle1.setFont(Font.font("Kalam",20));
			Gametitle1.setX(-300);
			Gametitle1.setY(100);
			Gametitle1.setId("fancytext1");
			Gametitle1.setEffect(ds);
			Gametitle2.setText("Vs");
			Gametitle2.setFont(Font.font("Kalam",20));
			Gametitle2.setX(650);
			Gametitle2.setY(200);
			Gametitle2.setId("fancytext2");
			Gametitle2.setEffect(ds);
			Gametitle3.setText("Block");
			Gametitle3.setFont(Font.font("Kalam",20));
			Gametitle3.setX(100);
			Gametitle3.setY(750);
			Gametitle3.setId("fancytext3");
			Gametitle3.setEffect(ds);
			tr1.setToX(380);
			tr2.setToX(-470);
			tr3.setToY(-450);
			tr1.setNode(Gametitle1);
			tr2.setNode(Gametitle2);
			tr3.setNode(Gametitle3);
			FadeIn.setFromValue(0.0);
			FadeIn.setToValue(20.0);
			FadeIn.setAutoReverse(true);
			FadeIn.setCycleCount(Animation.INDEFINITE);
			ParallelTransition pr=new ParallelTransition(st1,ft1);
			SequentialTransition st=new SequentialTransition(tr1,tr2,tr3,FadeIn);
			st.play();
			p1.play();
			p2.play();
			pr.play();
//			SequentialTransition stp=new SequentialTransition(p1,p2);
//			stp.play();
//			root.getChildren().addAll(circles3);
			root.getChildren().addAll(Gametitle1,Gametitle2,Gametitle3,taphere);
			//root.getChildren().addAll(circles1);
			//root.getChildren().addAll(circles2);
			root.getChildren().add(figure);
			Scene scene = new Scene(root,450,650);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Snake Vs Block");
			scene.setFill(Color.BLACK);
			primaryStage.setScene(scene);
			primaryStage.show();
			scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
