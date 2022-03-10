package application;

public class Reciept {
	//Data fields
	private String name, size, topping;
	
	//Constructor
	public Reciept(String name, String size, String topping) {
		this.name = name;
		this.size = size;
		this.topping = topping;
	}
	
	public Reciept(String name) {
		this.name = name;
	}
	
	//Getters
	public String getName() { return name; }
	public String getSize() { return size; }
	public String getToppings() { return topping;}
	
	//Setters
	public void setName(String name) {this.name = name; }
	public void setSize(String size) {this.size = size; }
	public void setTopping(String topping) {this.topping = topping; }
	
	//Override Methods
	public String toString() { return (name + " | " + size + " | " + topping); }
}
