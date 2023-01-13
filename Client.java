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

public class Client {
	private int[] clientID = new int[5];
	private String[] client = new String[5];
	
	private static int[] wheat = new int[5];
	private static int[] fruitVeggies = new int[5];
	private static int[] protein = new int[5];
	private static int[] other = new int[5];
	private static int[] calories = new int[5];


	/* 
	 * Client Constructor
	 * 
	 * Constructs a Client object.
	 * 
	 * This object stores the data for all 4 clients in the database in a 2d array.
	 * 
	 * @param String[][] var contains the data for all clients in the database. 
	 * 
	 * IllegalArgumentException is thrown if invalid data is provided. 
	 */ 
	public Client(String[][] var){
		int id = 1;
		
		for(int i = 0; i< var.length; i++){
			int j = 0;
			
			if(Integer.parseInt(var[i][j]) >= 0 && Integer.parseInt(var[i][j+2]) >= 0 && Integer.parseInt(var[i][j+3]) >= 0 &&
			Integer.parseInt(var[i][j+4]) >= 0 && Integer.parseInt(var[i][j+5]) >= 0 && Integer.parseInt(var[i][j+6]) >= 0){
				clientID[id] = Integer.parseInt(var[i][j]);j++;
				client[id] = var[i][j];j++;
				wheat[id] = Integer.parseInt(var[i][j]);j++;
				fruitVeggies[id] = Integer.parseInt(var[i][j]);j++;
				protein[id] = Integer.parseInt(var[i][j]);j++;
				other[id] = Integer.parseInt(var[i][j]);j++;
				calories[id] = Integer.parseInt(var[i][j]);j++;
				id++;
			}
			else{
				throw new IllegalArgumentException();
			}
		}
	}
	
	
	/*
	 * Setter methods.
	 * 
	 * These methods are used to set/change requirements for particular clients.  
	 * 
	 * @param id is the id of the client who's requirements we want to change. 
	 * The second argument is the new value we would like to set. 
	 * 
	 * IllegalArgumentException is thrown if invalid data is provided. 
	 */ 
	public void setWheat(int id, int w){
		if(w >= 0){
			wheat[id] = w;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public void setFruitVeggies(int id, int fV){
		if(fV >= 0){
			fruitVeggies[id] = fV;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public void setProtein(int id, int p){
		if(p >= 0){
			protein[id] = p;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public void setOther(int id, int o){
		if(o >= 0){
			other[id] = o;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public void setCalories(int id, int c){
		if(c >= 0){
			calories[id] = c;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	
	/*
	 * Getter methods.
	 * 
	 * These methods are used to get requirements for particular clients.  
	 * 
	 * @param id is the id of the client who's requirements we want to get. 
	 */
	public static int getWheat(int id){
		return wheat[id];
	}
	
	public static int getFruitVeggies(int id){
		return fruitVeggies[id];
	}
	
	public static int getProtein(int id){
		return protein[id];
	}
	
	public static int getOther(int id){
		return other[id];
	}
	
	public static int getCalories(int id){
		return calories[id];
	}
	
}

