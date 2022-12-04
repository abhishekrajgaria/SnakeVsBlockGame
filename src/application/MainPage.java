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
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainPage extends Application{
	static int whatclicked;
	/**
	 * This function is the launcher function for the main menu screen
	 */
	public void start(Stage primaryStage) throws IOException{
		AvatarPage avp=new AvatarPage();
		LeaderPage lp=new LeaderPage();
		GAMESCREEN gs=new GAMESCREEN();
		Stage window = primaryStage;
		Group root=new Group();
		Image img=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\border2.png"));
		Reflection ref = new Reflection();
		ref.setFraction(0.6f);
		Button startbtn=new Button();
		startbtn.setEffect(ref);
		Rectangle r=new Rectangle(450,650);
		//r.setX(0));
		r.setFill(new ImagePattern(img));
		startbtn.setPrefSize(300, 50);
		startbtn.setLayoutX(80);
		startbtn.setLayoutY(100);
		startbtn.setText("S T A R T");
		Button instrbtn=new Button();
		instrbtn.setEffect(ref);
		instrbtn.setPrefSize(300, 50);
		instrbtn.setLayoutX(80);
		instrbtn.setLayoutY(200);
		instrbtn.setText("R E S U M E");
		Button avatarbtn=new Button();
		avatarbtn.setEffect(ref);
		avatarbtn.setPrefSize(300, 50);
		avatarbtn.setLayoutX(80);
		avatarbtn.setLayoutY(300);
		avatarbtn.setText("A V A T A R");
		Button leaderbtn=new Button();
		leaderbtn.setEffect(ref);
		leaderbtn.setPrefSize(300, 50);
		leaderbtn.setLayoutX(80);
		leaderbtn.setLayoutY(400);
		leaderbtn.setText("L E A D E R B O A R D");
		Button exitbtn=new Button();
		exitbtn.setEffect(ref);
		exitbtn.setPrefSize(300, 50);
		exitbtn.setLayoutX(80);
		exitbtn.setLayoutY(500);
		exitbtn.setText("E X I T");
		root.getChildren().add(r);
		root.getChildren().addAll(startbtn,leaderbtn,avatarbtn,instrbtn,exitbtn);
		Scene scene = new Scene(root,450,650);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Main Page");
		scene.setFill(Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
		avatarbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e)
			{
				try
				{
					avp.start(primaryStage);
					primaryStage.show();
				}
				catch(Exception E)
				{
					E.printStackTrace();
				}
			}
		});
		leaderbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e)
			{
				try
				{
					lp.start(primaryStage);
					primaryStage.show();
				}
				catch(Exception E)
				{
					E.printStackTrace();
				}
			}
		});
		startbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e)
			{
				try
				{
					whatclicked=1;
					gs.start(primaryStage);
					primaryStage.show();
				}
				catch(Exception E)
				{
					E.printStackTrace();
				}
			}
		});
		instrbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e)
			{
				try
				{
					whatclicked=2;
					gs.start(primaryStage);
					primaryStage.show();
				}
				catch(Exception E)
				{
					E.printStackTrace();
				}
			}
		});
		exitbtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e)
			{
				try
				{
					primaryStage.close();
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
