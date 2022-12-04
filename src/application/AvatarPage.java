package application;
import javafx.event.*;
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

class Avatar
{
	private Circle avatarhead;
	private boolean exit;
	public Circle getAvatarhead() {
		return avatarhead;
	}
	public void setAvatarhead(Circle avatarhead) {
		this.avatarhead = avatarhead;
	}
	public boolean isExit() {
		return exit;
	}
	public void setExit(boolean exit) {
		this.exit = exit;
	}
}
public class AvatarPage extends Application{
	MainPage mp=new MainPage();
	static Snake currsnake=new Snake(153,400);
	static Image img;
	static int imagenumber;
	/**
	 * This is the launcher function for avatar screen
	 */
	public void start(Stage primaryStage) throws IOException {
	   Group root=new Group();
	    Reflection r = new Reflection();
		r.setFraction(0.2f);
		Button back=new Button();
		back.setPrefSize(90, 20);
		back.setLayoutX(10);
		back.setLayoutY(10);
		back.setId("backbutton");
		back.setText("B A C K");
		ArrayList<Rectangle> rectangles=new ArrayList<Rectangle>();
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
		Image img16=new Image(new FileInputStream("C:\\Users\\shiva\\eclipse-workspace\\SnakeVersusBlock\\src\\application\\snakes.png"));
		for(int i=0;i<15;i++)
		{
				Rectangle p=new Rectangle();
				rectangles.add(p);
		}
		for(int i=0;i<rectangles.size();i++)
		{
			if(i<3)
			{
			rectangles.get(i).setFill(Color.GREEN);
			}
			else if(i<6 && i>=3)
			{
				rectangles.get(i).setFill(Color.FORESTGREEN);
			}
			else if(i<9 && i>=6)
			{
				rectangles.get(i).setFill(Color.LAWNGREEN);
			}
			else if(i<12 && i>=9)
			{
				rectangles.get(i).setFill(Color.ORANGE);
			}
			else
			{
				rectangles.get(i).setFill(Color.YELLOW);
			}
			rectangles.get(i).setHeight(80);
			rectangles.get(i).setWidth(80);
			rectangles.get(i).setArcHeight(25);
			rectangles.get(i).setArcWidth(25);
			rectangles.get(i).setEffect(r);
			rectangles.get(i).setStroke(Color.BLACK);
		}
		int x=10;
		for(int i=0;i<rectangles.size()/5;i++)
		{
			rectangles.get(i).setX(30+x);
			rectangles.get(i).setY(50);
			x=x+150;
		}
		x=10;
		int y=0;
		for(int i=0;i<rectangles.size()/5;i++)
		{
			rectangles.get(i+3).setX(30+x);
			rectangles.get(i+3).setY(170);
			x=x+150;
		}
		x=10;
		for(int i=0;i<rectangles.size()/5;i++)
		{
			rectangles.get(i+6).setX(30+x);
			rectangles.get(i+6).setY(290);
			x=x+150;
		}
		x=10;
		for(int i=0;i<rectangles.size()/5;i++)
		{
			rectangles.get(i+9).setX(30+x);
			rectangles.get(i+9).setY(410);
			x=x+150;
		}
		x=10;
		for(int i=0;i<rectangles.size()/5;i++)
		{
			rectangles.get(i+12).setX(30+x);
			rectangles.get(i+12).setY(530);
			x=x+150;
		}
			rectangles.get(0).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(0).setFill(new ImagePattern(img1));
				}
			});
			rectangles.get(0).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(0).setFill(Color.GREEN);
				}
			});
			
			rectangles.get(1).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(1).setFill(new ImagePattern(img2));
				}
			});
			rectangles.get(1).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(1).setFill(Color.GREEN);
				}
			});
			
			rectangles.get(2).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(2).setFill(new ImagePattern(img3));
				}
			});
			rectangles.get(2).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(2).setFill(Color.GREEN);
				}
			});
			
			rectangles.get(3).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(3).setFill(new ImagePattern(img4));
				}
			});
			rectangles.get(3).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(3).setFill(Color.FORESTGREEN);
				}
			});
			
			rectangles.get(4).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(4).setFill(new ImagePattern(img5));
				}
			});
			rectangles.get(4).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(4).setFill(Color.FORESTGREEN);
				}
			});
			
			
			
			rectangles.get(5).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(5).setFill(new ImagePattern(img6));
				}
			});
			rectangles.get(5).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(5).setFill(Color.FORESTGREEN);
				}
			});
			
			rectangles.get(6).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(6).setFill(new ImagePattern(img7));
				}
			});
			rectangles.get(6).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(6).setFill(Color.LAWNGREEN);
				}
			});
			
			rectangles.get(7).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(7).setFill(new ImagePattern(img8));
				}
			});
			rectangles.get(7).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(7).setFill(Color.LAWNGREEN);
				}
			});
			
			rectangles.get(8).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(8).setFill(new ImagePattern(img9));
				}
			});
			rectangles.get(8).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(8).setFill(Color.LAWNGREEN);
				}
			});
			
			rectangles.get(9).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(9).setFill(new ImagePattern(img10));
				}
			});
			rectangles.get(9).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(9).setFill(Color.ORANGE);
				}
			});
			
			
			rectangles.get(10).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(10).setFill(new ImagePattern(img11));
				}
			});
			rectangles.get(10).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(10).setFill(Color.ORANGE);
				}
			});
			
			rectangles.get(11).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(11).setFill(new ImagePattern(img12));
				}
			});
			rectangles.get(11).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(11).setFill(Color.ORANGE);
				}
			});
			
			rectangles.get(12).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(12).setFill(new ImagePattern(img13));
				}
			});
			rectangles.get(12).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(12).setFill(Color.YELLOW);
				}
			});
			
			rectangles.get(13).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(13).setFill(new ImagePattern(img14));
				}
			});
			rectangles.get(13).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(13).setFill(Color.YELLOW);
				}
			});
			
			rectangles.get(14).setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(14).setFill(new ImagePattern(img15));
				}
			});
			rectangles.get(14).setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					rectangles.get(14).setFill(Color.YELLOW);
				}
			});
			
			rectangles.get(0).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(0).setStroke(Color.AQUA);
					rectangles.get(0).setStrokeWidth(5);
					currsnake.setAvatar(img1);
					img=img1;
					imagenumber=1;
				}
			});
			rectangles.get(1).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(1).setStroke(Color.AQUA);
					rectangles.get(1).setStrokeWidth(5);
					currsnake.setAvatar(img2);
					img=img2;
					imagenumber=2;
				}
			});
			rectangles.get(2).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(2).setStroke(Color.AQUA);
					rectangles.get(2).setStrokeWidth(5);
					currsnake.setAvatar(img3);
					img=img3;
					imagenumber=3;
				}
			});
			rectangles.get(3).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(3).setStroke(Color.AQUA);
					rectangles.get(3).setStrokeWidth(5);
					currsnake.setAvatar(img4);
					img=img4;
					imagenumber=4;
				}
			});
			rectangles.get(4).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(4).setStroke(Color.AQUA);
					rectangles.get(4).setStrokeWidth(5);
					currsnake.setAvatar(img5);
					img=img5;
					imagenumber=5;
				}
			});
			rectangles.get(5).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(5).setStroke(Color.AQUA);
					rectangles.get(5).setStrokeWidth(5);
					currsnake.setAvatar(img6);
					img=img6;
					imagenumber=6;
				}
			});
			rectangles.get(6).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(6).setStroke(Color.AQUA);
					rectangles.get(6).setStrokeWidth(5);
					currsnake.setAvatar(img7);
					img=img7;
					imagenumber=7;
				}
			});
			rectangles.get(7).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(7).setStroke(Color.AQUA);
					rectangles.get(7).setStrokeWidth(5);
					currsnake.setAvatar(img8);
					img=img8;
					imagenumber=8;
				}
			});
			rectangles.get(8).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(8).setStroke(Color.AQUA);
					rectangles.get(8).setStrokeWidth(5);
					currsnake.setAvatar(img9);
					img=img9;
					imagenumber=9;
				}
			});
			rectangles.get(9).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(9).setStroke(Color.AQUA);
					rectangles.get(9).setStrokeWidth(5);
					currsnake.setAvatar(img10);
					img=img10;
					imagenumber=10;
				}
			});
			rectangles.get(10).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(10).setStroke(Color.AQUA);
					rectangles.get(10).setStrokeWidth(5);
					currsnake.setAvatar(img11);
					img=img11;
					imagenumber=11;
				}
			});
			rectangles.get(11).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(11).setStroke(Color.AQUA);
					rectangles.get(11).setStrokeWidth(5);
					currsnake.setAvatar(img12);
					img=img12;
					imagenumber=12;
				}
			});
			rectangles.get(12).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(12).setStroke(Color.AQUA);
					rectangles.get(12).setStrokeWidth(5);
					currsnake.setAvatar(img13);
					img=img13;
					imagenumber=13;
				}
			});
			rectangles.get(13).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(13).setStroke(Color.AQUA);
					rectangles.get(13).setStrokeWidth(5);
					currsnake.setAvatar(img14);
					img=img14;
					imagenumber=14;
				}
			});
			rectangles.get(14).setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e)
				{
					for(int i=0;i<rectangles.size();i++)
					{
						if(!rectangles.get(i).getStroke().equals(Color.BLACK))
						{
							rectangles.get(i).setStroke(Color.BLACK);
							rectangles.get(i).setStrokeWidth(0);
						}
					}
					rectangles.get(14).setStroke(Color.AQUA);
					rectangles.get(14).setStrokeWidth(5);
					currsnake.setAvatar(img15);
					img=img15;
					imagenumber=15;
				}
			});
	    root.getChildren().add(back);
		root.getChildren().addAll(rectangles);
		Scene scene = new Scene(root,450,650);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Main Page");
		scene.setFill(Color.BLACK);
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
