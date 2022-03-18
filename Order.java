package application;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.CheckBox;

public class Order {

	public static String printToTotal(CheckBox sizeSmall, CheckBox sizeMed, CheckBox sizeLarge, CheckBox topping1, CheckBox topping2, CheckBox topping3, CheckBox topping4,
			CheckBox side1, CheckBox side2, CheckBox side3, CheckBox side4,CheckBox drink1, CheckBox drink2, CheckBox drink3, CheckBox drink4) {
			
		
			double totalPrice = 0.0;
			
			if (sizeSmall.isSelected()) {
				totalPrice += 6.99;
			}
			if (sizeMed.isSelected()) {
				totalPrice += 8.99;
			}
			if (sizeLarge.isSelected()) {
				totalPrice += 10.99;
			}
			if (topping1.isSelected()) {
				totalPrice += 1.50;
			}
			if (topping2.isSelected()) {
				totalPrice += 1.50;
			}
			if (topping3.isSelected()) {
				totalPrice += 1.50;
			}
			if (topping4.isSelected()) {
				totalPrice += 1.50;
			}
			
			if (side2.isSelected()) {
				totalPrice += 8.00;
			}
			if (side3.isSelected()) {
				totalPrice += 5.50;
			}
			if (side1.isSelected()) {
				totalPrice += 5.50;
			}
			if (side4.isSelected()) {
				totalPrice += 6.50;
			}		
			if (drink2.isSelected()) {
				totalPrice += 2.00;
			}
			if (drink1.isSelected()) {
				totalPrice += 2.00;
			}
			if (drink3.isSelected()) {
				totalPrice += 2.00;
			}
			if (drink4.isSelected()) {
				totalPrice += 2.00;
			}
			
			String printedPrice = String.format("$%.2f", totalPrice);
			
			return printedPrice.formatted(printedPrice);
			
		}
	
}
