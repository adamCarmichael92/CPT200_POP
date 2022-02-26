package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	Stage window;
	Scene scene1, scene2, scene3, scene4, scene5, scene6;
	
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button goBack, goBack2, goBack3;
	Button pay;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) throws Exception {
		
		Label label1 = new Label("Welcome to first scene");
		Label label2 = new Label("Thank you for your purchase!");
		//Create Button
		//You can also use button.setText("")
		button1 = new Button("PIZZA");
		button2 = new Button("SIDES");
		button3 = new Button("DRINKS");
		button4 = new Button("CHECKOUT");
		goBack = new Button("Go Back");
		goBack2 = new Button("Go Back");
		goBack3 = new Button("Go Back");
		pay = new Button("Pay");
		//Set action for when user clicks button
		button1.setOnAction(e -> window.setScene(scene2));
		button2.setOnAction(e -> window.setScene(scene3));
		button3.setOnAction(e -> window.setScene(scene4));
		button4.setOnAction(e -> window.setScene(scene5));
		

		
		//Layout 1 - children are laid out in vertical column
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1, button2, button3, button4);		
		scene1 = new Scene(layout1, 500, 300);
		
		//Layout 2
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(goBack);
		goBack.setOnAction(e -> window.setScene(scene1));
		scene2 = new Scene(layout2, 600, 300);
		
		//Layout 3
		StackPane layout3 = new StackPane();
		layout3.getChildren().add(goBack2);
		goBack2.setOnAction(e -> window.setScene(scene1));
		scene3 = new Scene(layout3, 600, 300);
		
		//Layout 4
		StackPane layout4 = new StackPane();
		layout4.getChildren().add(goBack3);
		goBack3.setOnAction(e -> window.setScene(scene1));
		scene4 = new Scene(layout4, 600, 300);
		
		//Layout 5
		StackPane layout5 = new StackPane();
		layout5.getChildren().add(pay);
		pay.setOnAction(e -> window.setScene(scene6));
		scene5 = new Scene(layout5, 600, 300);
		
		//Layout 6
		StackPane layout6 = new StackPane();
		layout6.getChildren().add(label2);
		scene6 = new Scene(layout6, 300, 300);
		
		window.setScene(scene1);
		window.setTitle("PIZZA PLACE");
		window.show();
		
	}
	

	
}
