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

import java.util.LinkedList;

public class Food {
	
	int itemID;
	String name;
	int grainC;
	int fruitVegC;
	int proteinC;
	int otherC;
	int calorie;
	
	/* 
	 * Food Constructor
	 * 
	 * Constructs a Food object with the data of a particular food.
	 * 
	 * @param String itemID
	 * @param String name
	 * @param String grainC
	 * @param String fruitVegC
	 * @param String proteinC
	 * @param String otherC
	 * @param String calorie
	 * 
	 * IllegalArgumentException is thrown if invalid data is provided. 
	 */ 
	public Food(String itemID, String name, String grainC, String fruitVegC, String proteinC, String otherC, String calorie){
		if(Integer.parseInt(itemID) >= 0 && Integer.parseInt(grainC) >= 0 && Integer.parseInt(fruitVegC) >= 0 &&
			Integer.parseInt(proteinC) >= 0 && Integer.parseInt(otherC) >= 0 && Integer.parseInt(calorie) >= 0){
			this.itemID = Integer.parseInt(itemID);
			this.name = name;
			this.grainC = Integer.parseInt(grainC);
			this.fruitVegC = Integer.parseInt(fruitVegC);
			this.proteinC = Integer.parseInt(proteinC);
			this.otherC = Integer.parseInt(otherC);
			this.calorie = Integer.parseInt(calorie);
		}
		else{
			throw new IllegalArgumentException();
		}
		
	}
	
	
	/*
	 * Setter methods.
	 * 
	 * These methods are used to set/change content details of a food.  
	 * 
	 * The argument is the new value we would like to set. 
	 * 
	 * IllegalArgumentException is thrown if invalid data is provided. 
	 */
	 
	// @param int g
	public void setGrainC(int g){
		if(g >= 0){
			grainC = g;
		}
		else{
			throw new IllegalArgumentException();
		}
		
	}
	
	// @param int fV
	public void setFruitVegC(int fV){
		if(fV >= 0){
			fruitVegC = fV;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	// @param int p
	public void setProtenC(int p){
		if(p >= 0){
			proteinC = p;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	// @param int o
	public void setOtherC(int o){
		if(o >= 0){
			otherC = o;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	// @param int c
	public void setCalorie(int c){
		if(c >= 0){
			calorie = c;
		}
		else{
			throw new IllegalArgumentException();
		}
	}


	/*
	 * Getter methods.
	 * 
	 * These methods are used to get data for a food object.  
	 */
	public String getName(){
		return name;
	}

	public int getFoodID(){
		return itemID;
	}
	
	public int getGrainC(){
		return grainC;
	}
	
	public int getFruitVegC(){
		return fruitVegC;
	}
	
	public int getProteinC(){
		return proteinC;
	}
	
	public int getOtherC(){
		return otherC;
	}
	
	public int getCalorie(){
		return calorie;
	}

	// getTotalCalorie() calculated the total calorie contant of a food.
	public int getTotalCalorie(){
		int total = grainC+fruitVegC+proteinC+otherC+calorie;
		return total;
	}
}

