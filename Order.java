/*
 * @authour: muteeba jamal <a href="mailto:muteeba.jamal@ucalgary.ca">
 * muteeba.jamal@ucalgary.ca</a>
 * @authour: shahzill naveed <a href="mailto:shahzill.naveed@ucalgary.ca">
 * shahzill.naveed@ucalgary.ca</a>
 * @authour: ahsan zia <a href="mailto:ahsan.zia@ucalgary.ca">
 * ahsan.zia@ucalgary.ca</a>
 * @authour: hridika banik <a href="mailto:hridika.banik@ucalgary.ca">
 * hridika.banik@ucalgary.ca</a>
 * @version 1.4
 * @since 1.0
 */
package edu.ucalgary.ensf409;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class Order {
	private static String orderDetails;
	private static String orders;
	private static int numberOfHampers = 0;

	/* 
	 * Order Constructor
	 * 
	 * Constructs an Order object
	 * 
	 * @param String request is the order request (the user input in the GUI
	 * @param String orders is a string containing all the food in a particular 
	 * hamper or an error if hamper cannot be created 
	 * @param int num is the hamper number
	 * 
	 * IllegalArgumentException is thrown if invalid data is provided. 
	 */ 
	public Order(String request, String orders, int num) throws IOException{
		if(num >= 1){
			 orderDetails= request;
			 this.orders = orders;
			 numberOfHampers = num;
			 createOrderFile();
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	
	/* 
	 * createOrderFile() Method
	 * 
	 * Opens a file called "Order.txt" and appends it with the hamper data provided 
	 * in the contructor
	 *
	 * IOException is thrown if there is an error accessing hte file. 
	 */ 
	public void createOrderFile() throws IOException{
		if(Hamper.getHamperSize() != 0){
			try {
				FileWriter myWriter = new FileWriter("Order.txt", true);
	
				myWriter.write("\n");
				myWriter.write("Hamper " + numberOfHampers + ": " + orderDetails);
				myWriter.write("\n");
				myWriter.write(orders);
				numberOfHampers++;
	
				myWriter.close();
				
			} catch (FileNotFoundException e) {e.printStackTrace();}
		}
		else{
			try {
				
				FileWriter myWriter = new FileWriter("Order.txt", true);

				myWriter.write("\n");
				myWriter.write("Hamper " + numberOfHampers + ": " + orderDetails);
				myWriter.write("\n");
				myWriter.write("Invalid order: The hamper can not be generated according to the provided specifications.\n" );
				myWriter.write(orders);
				myWriter.write("\n");
				numberOfHampers++;
			
				myWriter.close();
				
			} catch (FileNotFoundException e) {e.printStackTrace();}
		}
		
		
		
	}

	/* 
	 * returnFinalOrder() Method
	 * 
	 * Returns a string of the food in the hamper. 
	 */ 
	public static String returnFinalOrder(){
		StringBuilder order= new StringBuilder();
		
		if(Hamper.getHamperSize() != 0){
			numberOfHampers--;
			order.append("\n");
			order.append("Hamper " + numberOfHampers  + ": " + orderDetails);
			order.append("\n");
			order.append(orders);
			numberOfHampers++;

			return order.toString();
		}

		else{
			return ("No hamper can be generated using the values provided, \n" + orders );
		}
	}
}

