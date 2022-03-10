package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	Stage window;
	Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8;
	
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button goBack, goBack2, goBack3, goBack4;
	Button pay;
	Button closeProg;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) throws Exception {
		
		Label label1 = new Label("Welcome to (Insert Pizzeria Name Here)");
		Label label2 = new Label("Thank you for your purchase!");
		//Create Button
		//You can also use button.setText("")
		button1 = new Button("PIZZA");
		button2 = new Button("SIDES");
		button3 = new Button("DRINKS");
		button4 = new Button("CHECKOUT");
		
		closeProg = new Button("Close Program");
		goBack = new Button("Go Back");
		goBack2 = new Button("Go Back");
		goBack3 = new Button("Go Back");
		goBack4 = new Button("Go Back");
		pay = new Button("Pay");
		
		//Set action for when user clicks button
		button1.setOnAction(e -> window.setScene(scene2));
		button2.setOnAction(e -> window.setScene(scene3));
		button3.setOnAction(e -> window.setScene(scene4));
		button4.setOnAction(e -> window.setScene(scene5));
		closeProg.setOnAction(e -> {
			boolean result = ConfirmBox.display("POP", "Are you sure you want to exit?\nOrder will not be saved.");
			if (result == true) { 
				window.close();
			}
			else {
				window.setScene(scene1);
			}
		});
		
		//Layout 1 - children are laid out in vertical column
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1, button2, button3, button4, closeProg);		
		scene1 = new Scene(layout1, 500, 300);
		
		//Pizza Topping GridPane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		Label size = new Label("Select Size:");
		Label topping = new Label("Select Topping(s):");
		
		Button sizeSmall = new Button("Small\n10inch");
		Button sizeMed = new Button("Medium\n12inch");
		Button sizeLarge = new Button("Large\n14inch");
		Button topping1 = new Button("Pepperoni");
		Button topping2 = new Button("Green Pep");
		Button topping3 = new Button("Sausage");
		Button topping4 = new Button("Bacon");
		
		GridPane.setConstraints(size, 0, 0);
		GridPane.setConstraints(sizeSmall, 1, 0);
		GridPane.setConstraints(sizeMed, 2, 0);
		GridPane.setConstraints(sizeLarge, 3, 0);
		GridPane.setConstraints(topping, 0, 2);
		GridPane.setConstraints(topping1, 0, 3);
		GridPane.setConstraints(topping2, 1, 3);
		GridPane.setConstraints(topping3, 0, 4);
		GridPane.setConstraints(topping4, 1, 4);
		
		GridPane.setConstraints(goBack, 0, 5);
		
		grid.getChildren().addAll(topping1, topping2, topping3, topping4, goBack, size, topping, sizeSmall, sizeMed, sizeLarge);
		goBack.setOnAction(e -> window.setScene(scene1));
		
		scene2 = new Scene(grid, 600, 300);
		
		//Sides GridPane
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(10, 10, 10, 10));
		grid2.setVgap(8);
		grid2.setHgap(10);
				
		Button side1 = new Button("Garlic Knots");
		Button side2 = new Button("Hot Wings");
		Button side3 = new Button("Cheese Bread");
		Button side4 = new Button("Salad");
		GridPane.setConstraints(side1, 0, 0);
		GridPane.setConstraints(side2, 0, 1);
		GridPane.setConstraints(side3, 1, 0);
		GridPane.setConstraints(side4, 1, 1);
		GridPane.setConstraints(goBack2, 0, 2);
				
		grid2.getChildren().addAll(side1, side2, side3, side4, goBack2);
		goBack2.setOnAction(e -> window.setScene(scene1));
				
		scene3 = new Scene(grid2, 600, 300);
		
		//Drinks GridPane
		GridPane grid3 = new GridPane();
		grid3.setPadding(new Insets(10, 10, 10, 10));
		grid3.setVgap(8);
		grid3.setHgap(10);
						
		Button drink1 = new Button("Coke-Cola");
		Button drink2 = new Button("Sprite");
		Button drink3 = new Button("Mountain Dew");
		Button drink4 = new Button("Diet Coke");
		GridPane.setConstraints(drink1, 0, 0);
		GridPane.setConstraints(drink2, 0, 1);
		GridPane.setConstraints(drink3, 1, 0);
		GridPane.setConstraints(drink4, 1, 1);
		GridPane.setConstraints(goBack3, 0, 2);
						
		grid3.getChildren().addAll(drink1, drink2, drink3, drink4, goBack3);
		goBack3.setOnAction(e -> window.setScene(scene1));
				
		scene4 = new Scene(grid3, 600, 300);

		//Checkout Layout
		VBox layout5 = new VBox();
		layout5.getChildren().addAll(pay, goBack4);
		pay.setOnAction(e -> window.setScene(scene6));
		goBack4.setOnAction(e -> window.setScene(scene1));
		scene5 = new Scene(layout5, 200, 200);
		
		//Pick-up or Delivery
		GridPane layout6 = new GridPane();
		layout6.setPadding(new Insets(10, 10, 10, 10));
		layout6.setVgap(8);
		layout6.setHgap(10);
		
		Label select = new Label("Select One:");
		
		Button carryOut = new Button("Carry Out");
		Button delivery = new Button("Delivery");
		
		GridPane.setConstraints(select, 0, 0);
		GridPane.setConstraints(carryOut, 0, 1);
		GridPane.setConstraints(delivery, 0, 2);
		
		layout6.getChildren().addAll(select, carryOut, delivery);
		carryOut.setOnAction(e -> window.setScene(scene7));
		delivery.setOnAction(e -> window.setScene(scene8));
		scene6 = new Scene(layout6, 200, 200);
		
		//Scene 7: Payment Window (Enter in payment info)
		
		//Scene 8: Delivery Scene (User Enter in Address, then goes to the payment window)
		
		//Set First Window
		window.setScene(scene1);
		window.setTitle("PIZZA PLACE");
		window.show();
		
	}
	
	

	
}
