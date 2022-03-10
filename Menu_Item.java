package application;

import javafx.scene.control.Button;

public class Menu_Item {
	//Data fields
	private String name, size, topping;
	private double price;
	private Button button;
	
	//Constructor
	public Menu_Item(String name, String size, String topping) {
		this.name = name;
		this.size = size;
		this.topping = topping;
	}
	
	public Menu_Item(String name) {
		this.name = name;
	}
	
	//Getters
	public String getName() { return name; }
	public String getSize() { return size; }
	public String getToppings() { return topping; }
	public double getPrice() { return price; }
	public Button getButton() { return button; }
	
	//Setters
	public void setName(String name) { this.name = name; }
	public void setSize(String size) { this.size = size; }
	public void setTopping(String topping) { this.topping = topping; }
	public void setPrice(double price) { this.price = price; }
	public void setButton(Button button) { this.button = button; }
	
	//Methods
	public double total(double price) {
		double total =+ price;
		return total;
	}
	
	public static void addButton(Button button, String buttonName) {
		button = new Button(buttonName);
	}
	
	
	//Override Methods
	public String toString() { return (name + " | " + size + " | " + topping); }
	
}
