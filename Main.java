package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Main extends Application {
	
	Stage window;
	
	Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, kitchenScene, trackScene;
	
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
		
		//Kitchen Scene
		GridPane kitchenLayout = new GridPane();
		//Tracker Scene
		VBox tracker = new VBox(10);
		
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
		button4.setOnAction(e -> window.setScene(scene6));
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
		
		Button addToOrder = new Button("Add To Cart");
		
		Label size = new Label("Select Size:");
		Label topping = new Label("Select Topping(s):");
		
		CheckBox sizeSmall = new CheckBox("Small\n10inch");
		CheckBox sizeMed = new CheckBox("Medium\n12inch");
		CheckBox sizeLarge = new CheckBox("Large\n14inch");
		CheckBox topping1 = new CheckBox("Pepperoni");
		CheckBox topping2 = new CheckBox("Green Pep");
		CheckBox topping3 = new CheckBox("Sausage");
		CheckBox topping4 = new CheckBox("Bacon");
		
		GridPane.setConstraints(size, 0, 0);
		GridPane.setConstraints(sizeSmall, 1, 0);
		GridPane.setConstraints(sizeMed, 2, 0);
		GridPane.setConstraints(sizeLarge, 3, 0);
		GridPane.setConstraints(topping, 0, 2);
		GridPane.setConstraints(topping1, 0, 3);
		GridPane.setConstraints(topping2, 1, 3);
		GridPane.setConstraints(topping3, 0, 4);
		GridPane.setConstraints(topping4, 1, 4);
		GridPane.setConstraints(addToOrder, 1, 5);
		GridPane.setConstraints(goBack, 0, 5);
		
		grid.getChildren().addAll(topping1, topping2, topping3, topping4, goBack, size, topping, sizeSmall, sizeMed, sizeLarge, addToOrder);
		goBack.setOnAction(e -> window.setScene(scene1));
		addToOrder.setOnAction(e -> { 
				String message = handlePizzaOptions(sizeSmall, sizeMed, sizeLarge, topping1, topping2, topping3, topping4);
				printPizzaToKit(kitchenLayout, message);
				AlertBox.display("Item Added", "Your item has been added to your cart");
				window.setScene(scene1);
			});
		
		scene2 = new Scene(grid, 600, 300);
		
		//Sides GridPane
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(10, 10, 10, 10));
		grid2.setVgap(8);
		grid2.setHgap(10);
		
		Button addToOrder1 = new Button("Add To Cart");
				
		CheckBox side1 = new CheckBox("Garlic Knots");
		CheckBox side2 = new CheckBox("Hot Wings");
		CheckBox side3 = new CheckBox("Cheese Bread");
		CheckBox side4 = new CheckBox("Salad");
		GridPane.setConstraints(side1, 0, 0);
		GridPane.setConstraints(side2, 0, 1);
		GridPane.setConstraints(side3, 1, 0);
		GridPane.setConstraints(side4, 1, 1);
		GridPane.setConstraints(addToOrder1, 1, 2);
		GridPane.setConstraints(goBack2, 0, 2);
				
		grid2.getChildren().addAll(side1, side2, side3, side4, goBack2, addToOrder1);
		goBack2.setOnAction(e -> window.setScene(scene1));
		addToOrder1.setOnAction(e -> { 
			String message = handleSidesOptions(side1, side2, side3, side4);
			printSidesToKit(kitchenLayout, message);
			AlertBox.display("Item Added", "Your item has been added to your cart");
			window.setScene(scene1);
		});		
				
		scene3 = new Scene(grid2, 600, 300);
		
		//Drinks GridPane
		GridPane grid3 = new GridPane();
		grid3.setPadding(new Insets(10, 10, 10, 10));
		grid3.setVgap(8);
		grid3.setHgap(10);
		
		Button addToOrder2 = new Button("Add To Cart");
						
		CheckBox drink1 = new CheckBox("Coke-Cola");
		CheckBox drink2 = new CheckBox("Sprite");
		CheckBox drink3 = new CheckBox("Mountain Dew");
		CheckBox drink4 = new CheckBox("Diet Coke");
		GridPane.setConstraints(drink1, 0, 0);
		GridPane.setConstraints(drink2, 0, 1);
		GridPane.setConstraints(drink3, 1, 0);
		GridPane.setConstraints(drink4, 1, 1);
		GridPane.setConstraints(addToOrder2, 1, 2);
		GridPane.setConstraints(goBack3, 0, 2);
						
		grid3.getChildren().addAll(drink1, drink2, drink3, drink4, goBack3, addToOrder2);
		goBack3.setOnAction(e -> window.setScene(scene1));
		addToOrder2.setOnAction(e -> { 
			String message = handleDrinkOptions(drink1, drink2, drink3, drink4);
			printDrinkToKit(kitchenLayout, message);
			AlertBox.display("Item Added", "Your item has been added to your cart");
			window.setScene(scene1);
		});
				
		scene4 = new Scene(grid3, 600, 300);
		
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
		GridPane payment = new GridPane();
		payment.setPadding(new Insets(10, 10, 10, 10));
		payment.setVgap(8);
		payment.setHgap(10);
		
		Button submit1 = new Button("Submit Order");
		
		Label enterInfo = new Label("Please enter you payment information.");
		Label cardNum = new Label("Card Number:");
		Label expDate = new Label("Exp. Date:");
		Label month = new Label("Month:");
		Label year = new Label("Year:");
		Label cardCode = new Label("CCV (Number on back of card):");
		Label name = new Label("Name on card:");
		
		TextField cardNumber = new TextField();
		ChoiceBox<Integer> monthNum = new ChoiceBox<>();
		monthNum.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		ChoiceBox<Integer> yearNum = new ChoiceBox<>();
		yearNum.getItems().addAll(2022, 2023, 2024, 2025, 2026, 2027, 2028);
		TextField ccvNum = new TextField();
		TextField cardName = new TextField();
		
		GridPane.setConstraints(enterInfo, 0, 0);
		GridPane.setConstraints(cardNum, 0, 1);
		GridPane.setConstraints(cardNumber, 1, 1);
		GridPane.setConstraints(expDate, 0, 2);
		GridPane.setConstraints(month, 0, 3);
		GridPane.setConstraints(monthNum, 1, 3);
		GridPane.setConstraints(year, 2, 3);
		GridPane.setConstraints(yearNum, 3, 3);
		GridPane.setConstraints(cardCode, 0, 4);
		GridPane.setConstraints(ccvNum, 1, 4);
		GridPane.setConstraints(name, 0, 5);
		GridPane.setConstraints(cardName, 1, 5);
		GridPane.setConstraints(submit1, 0, 6);
		
		payment.getChildren().addAll(submit1, enterInfo, cardNum, expDate, month, year, cardCode, name, cardNumber, monthNum, yearNum, ccvNum, cardName);

		submit1.setOnAction(e -> window.setScene(kitchenScene));
		
		scene7 = new Scene(payment, 500, 500);
		
		//Scene 8: Delivery Scene (User Enter in Address, then goes to the payment window)
		VBox address = new VBox();
		address.setPadding(new Insets(20, 20, 20, 20));
		
		Button submit = new Button("Submit Order");
		
		Label street = new Label("Street");
		Label cityLabel = new Label("City");
		Label stateLabel = new Label("State");
		Label zipLabel = new Label("Zip");
		
		TextField streetAddress = new TextField();
		TextField city = new TextField();
		ChoiceBox<String> state = new ChoiceBox<>();
		state.getItems().addAll("MO", "IL");
		TextField zipCode = new TextField();
		
		submit.setOnAction(e -> window.setScene(scene7));
		
		address.getChildren().addAll(street, streetAddress, cityLabel, city, stateLabel, state, zipLabel, zipCode, submit);
		scene8 = new Scene(address, 500, 500);
		
		//Kitchen Scene
		kitchenLayout.setPadding(new Insets(20, 20, 20, 20));
		kitchenLayout.setVgap(8);
		kitchenLayout.setHgap(10);
		 
		
		Button prep = new Button("Prep");
		Button cooking = new Button("In The Oven");
		Button box = new Button("Boxed Up");
		Button outTheDoor = new Button("Out For Delivery");
		Button track = new Button("Track my food!");
		
		Label order = new Label("Orders:\n");
		
		GridPane.setConstraints(order, 0, 1);
		GridPane.setConstraints(prep, 0, 0);
		GridPane.setConstraints(cooking, 1, 0);
		GridPane.setConstraints(box, 2, 0);
		GridPane.setConstraints(outTheDoor, 3, 0);
		GridPane.setConstraints(track, 5, 5);
		
		prep.setOnAction(e -> printToTracker(tracker, "We are preparing your food now."));
		cooking.setOnAction(e -> printToTracker(tracker, "We have your pizza in the oven."));
		box.setOnAction(e -> printToTracker(tracker, "Your food is boxed up!"));
		outTheDoor.setOnAction(e -> printToTracker(tracker, "Your food is on the way!"));
		track.setOnAction(e -> window.setScene(trackScene));
		
		kitchenLayout.getChildren().addAll(order, prep, cooking, box, outTheDoor, track);
		kitchenScene = new Scene(kitchenLayout, 800, 800);
		
		//Tracker Scene
		tracker.setPadding(new Insets(10, 10, 10, 10));
		Button goBack4 = new Button("Go Back");
		
		goBack4.setOnAction(e -> window.setScene(kitchenScene));
		tracker.getChildren().add(goBack4);
		trackScene = new Scene(tracker, 200, 200);
		
		
		//Set First Window
		window.setScene(scene1);
		window.setTitle("PIZZA PLACE");
		window.show();
	}
	
	private String handlePizzaOptions(CheckBox sizeSmall, CheckBox sizeMed, CheckBox sizeLarge, CheckBox topping1, CheckBox topping2, CheckBox topping3, CheckBox topping4) {
		String message = "";
		
		if(sizeSmall.isSelected()) { message += "10\" "; }
		if(sizeMed.isSelected()) { message += "12\" "; }
		if(sizeLarge.isSelected()) { message += "14\" "; }
		if(topping1.isSelected()) { message += "\nPepperoni"; }
		if(topping2.isSelected()) { message += "\nGreen Peps"; }
		if(topping3.isSelected()) { message += "\nSausage"; }
		if(topping4.isSelected()) { message += "\nBacon"; }
		
		return message;
		
	}
	
	private String handleSidesOptions(CheckBox side1, CheckBox side2, CheckBox side3, CheckBox side4) {
		String message = "";
		
		if(side1.isSelected()) { message += "\nGarlic Knots"; }
		if(side2.isSelected()) { message += "\nHot Wings"; }
		if(side3.isSelected()) { message += "\nCheese Bread"; }
		if(side4.isSelected()) { message += "\nSalad"; }
		
		return message;
	}
	
	private String handleDrinkOptions(CheckBox drink1, CheckBox drink2, CheckBox drink3, CheckBox drink4) {
		String message = "";
		
		if(drink1.isSelected()) { message += "\nCoke-Cola"; }
		if(drink2.isSelected()) { message += "\nSprite"; }
		if(drink3.isSelected()) { message += "\nMountain Dew"; }
		if(drink4.isSelected()) { message += "\nDiet-Coke"; }
		
		return message;
	}
	
	public static Label printPizzaToKit(GridPane layout, String message) {
		Label orderText = new Label(message);
		GridPane.setConstraints(orderText, 0, 2);
		layout.getChildren().add(orderText);
		return orderText;
	}
	
	public static Label printSidesToKit(GridPane layout, String message) {
		Label orderText = new Label(message);
		GridPane.setConstraints(orderText, 0, 3);
		layout.getChildren().add(orderText);
		return orderText;
	}
	
	public static Label printDrinkToKit(GridPane layout, String message) {
		Label orderText = new Label(message);
		GridPane.setConstraints(orderText, 0, 4);
		layout.getChildren().add(orderText);
		return orderText;
	}
	
	public static Label printToTracker(VBox layout, String message) {
		Label label = new Label(message);
		layout.getChildren().add(label);
		layout.setAlignment(Pos.CENTER);
		return label;
	}
	
}
