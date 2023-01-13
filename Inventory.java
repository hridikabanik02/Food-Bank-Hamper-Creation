/*
 * @authour: muteeba jamal <a href="mailto:muteeba.jamal@ucalgary.ca">
 * muteeba.jamal@ucalgary.ca</a>
 * @authour: shahzill naveed <a href="mailto:shahzill.naveed@ucalgary.ca">
 * shahzill.naveed@ucalgary.ca</a>
 * @authour: ahsan zia <a href="mailto:ahsan.zia@ucalgary.ca">
 * ahsan.zia@ucalgary.ca</a>
 * @authour: hridika banik <a href="mailto:hridika.banik@ucalgary.ca">
 * hridika.banik@ucalgary.ca</a>
 * @version 1.2
 * @since 1.0
 */
 
package edu.ucalgary.ensf409;


import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

public class Inventory{

    private static LinkedList<Food> foodList;

    /*
	 * Inventory Constructor
	 * 
	 * This copies the data of a Linked List to the foodList  
	 * 
	 * @param listOfFoods is the Linked list of foods. 
	 * 
	 * 
	 */ 
    public Inventory(LinkedList<Food> listOfFoods){
        this.foodList = listOfFoods;
    }

     /*
	 * removeFood
	 * removes the food from inventory and send an id to
     * the deleteFood() method which deletes the food from 
     * the SQL inventory  
	 * 
	 * @param id is the id of the food that is to be removed 
	 */ 
    public static void removeFood(int id){
        
        for (int i = 0; i < foodList.size(); i++){
            Food food = foodList.get(i);

            if (food.getFoodID() == id ){
                foodList.remove(i);
                Project.deleteFood(Integer.toString(id));
                
            }
        }
    }

    /*
	 * getFoodList()
	 * returns the foodList object 
	 * 
	 */ 
    public static LinkedList<Food> getFoodList(){
        return foodList;
    }

}
