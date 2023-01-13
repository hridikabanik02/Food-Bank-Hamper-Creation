/*
 * @authour: muteeba jamal <a href="mailto:muteeba.jamal@ucalgary.ca">
 * muteeba.jamal@ucalgary.ca</a>
 * @authour: shahzill naveed <a href="mailto:shahzill.naveed@ucalgary.ca">
 * shahzill.naveed@ucalgary.ca</a>
 * @authour: ahsan zia <a href="mailto:ahsan.zia@ucalgary.ca">
 * ahsan.zia@ucalgary.ca</a>
 * @authour: hridika banik <a href="mailto:hridika.banik@ucalgary.ca">
 * hridika.banik@ucalgary.ca</a>
 * @version 3.2
 * @since 1.0
 */
 
package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Hamper{
    private int maleAdult;
    private int femaleAdult;
    private int childUnder;
    private int childOver;
    private static int totalWheat;
    private static int totalFV;
    private static int totalProtein;
    private static int totalOthers;
    private static int totalCalories;
    private static String error; 

    private static LinkedList<LinkedList<Food>> hamperCombinations;
    private LinkedList<Food> finalHamper;
    
    private static int[] caloriesArrayNon0;
    private static int[] caloriesArrayNon0ID;
   
    private StringBuilder hamper;
    private static String finalHamperStr = new String();

    /*
	 * Hamper Constructor
	 * 
	 * Recieves four integers as an input directly from the user.
     * and calls the calc funtions to calculate the total amount of calories. 
     * 
     * This constructor takes input for a family.
	 * 
	 * @param males is the number of males to be set. 
     * @param females is the number of females to be set. 
     * @param childOver is the number of children over 8 to be set. 
     * @param childUnder is the number of children under 8 to be set.  
	 */ 
    public Hamper(int males, int females, int childOver, int childUnder){
        if(males >= 0 && females >= 0 && childOver >= 0 && childUnder >= 0){
                    
            this.maleAdult = males;
            this.femaleAdult = females;
            this.childUnder = childUnder;
            this.childOver = childOver;
        }
        else{
            throw new IllegalArgumentException();
        }

        calcTWG();
        calcFV();
        calcProtein();
        calcOther();
        calcCalories();
        hamperFunctionalities();
        
    }

    /*
	 * Hamper Constructor
	 * 
	 * Recieves four integers as an input directly from the user. 
	 * 
	 * This constructor takes input for a hamper configuration.
	 * 
	 * @param twg is the number of total Grains Content to be set. 
     * @param fv is the number of total Fruit Veggies Content to be set. 
     * @param p is the number of total Protein content to be set. 
     * @param o is the number of total others content 8 to be set.
     * @param c is the number of total calories content to be set. 
	 */ 
    public Hamper(int twg, int fv, int p, int o, int c){
        totalWheat = twg;
        totalFV = fv;
        totalProtein = p;
        totalOthers = o;
        totalCalories = c;
        hamperFunctionalities();
    }

    /*
	 * Hamper functionalities
	 * 
	 * Calls different methods to make a hamper. 
	 */
    public void hamperFunctionalities(){   
        listMaker();
        combinations();
        
        if (hamperCombinations.size()!=0){
            int i = bestCombo();
            finalHamperStr = createHamper(i);
        }
        else{
           finalHamperStr = error;
          
        }
    }

    /*
	 * Setter methods.
	 * 
	 * These methods are used to set/change requirements for total calories.  
	 * 
	 * @param id is the id of the client who's requirements we want to change. 
	 * The second argument is the new value we would like to set. 
	 * 
	 * IllegalArgumentException is thrown if invalid data is provided. 
	 */ 
    public static void setTWG(int TWG){
        if(TWG >= 0){
			totalWheat = TWG;
		}
		else{
			throw new IllegalArgumentException();
		}
        totalWheat = TWG;
    }

    public void setTFV(int TFV){
        if(TFV >= 0){
			totalFV = TFV;
		}
		else{
			throw new IllegalArgumentException();
		}
        totalFV = TFV;
    }

    public static void setTP(int TP){
        if(TP >= 0){
			totalProtein = TP;
		}
		else{
			throw new IllegalArgumentException();
		}
        totalProtein = TP;
    }

    public static void setTO(int TO){
        if(TO >= 0){
			totalOthers = TO;
		}
		else{
			throw new IllegalArgumentException();
		}
        totalOthers = TO;
    }

    public static void setTC(int TC){
        if(TC >= 0){
			totalCalories = TC;
		}
		else{
			throw new IllegalArgumentException();
		}
        
        totalCalories = TC;
    }
    
    /*
	 * Getter methods.
	 * 
	 * These methods are used to get requirements for particular calories.  
	 * 
	 */
    public int getTWG(){
        return totalWheat;
    }

    public int getFV(){
        return totalFV;
    }

    public int getTP(){
        return totalProtein;
    }

    public int getTO(){
        return totalOthers;
    }

    public int getTC(){
        return totalCalories;
    }
    
    public static String getHamper(){
        return finalHamperStr;
    }

    public static int getHamperSize(){
        return hamperCombinations.size();
    }

    /*
	 * Methods to calc totals.
	 * 
	 * These methods are used to calculate total content required in each category.  
	 *
	 */
    public int calcTWG(){
        totalWheat = (Client.getWheat(1) * maleAdult + Client.getWheat(2) * femaleAdult + Client.getWheat(3) * childOver + Client.getWheat(4) * childUnder)*7;
        return totalWheat;
    }

    public int calcFV(){
        totalFV = (Client.getFruitVeggies(1) * maleAdult + Client.getFruitVeggies(2) * femaleAdult + Client.getFruitVeggies(3) * childOver + Client.getFruitVeggies(4) * childUnder)*7;
        return totalFV;
    }

    public int calcProtein(){
        totalProtein = (Client.getProtein(1) * maleAdult + Client.getProtein(2) * femaleAdult + Client.getProtein(3) * childOver + Client.getProtein(4) * childUnder)*7;
        return totalProtein;
    }

    public int calcOther(){
        totalOthers = (Client.getOther(1) * maleAdult + Client.getOther(2) * femaleAdult + Client.getOther(3) * childOver + Client.getOther(4) * childUnder)*7;
        return totalOthers;
    }

    public int calcCalories(){
        totalCalories = (Client.getCalories(1) * maleAdult + Client.getCalories(2) * femaleAdult + Client.getCalories(3) * childOver + Client.getCalories(4) * childUnder)*7;
        return totalCalories;  
    }

    /*
	 * createHamper
	 * 
	 * This method is used to create a hamper.
     * @param index is the index for the hamperCombiantion number. 
	 * 
	 */
    public String createHamper(int index){ 
        hamper = new StringBuilder();
       
        finalHamper = hamperCombinations.get(index);

        for (int j = 0; j < finalHamper.size(); j++){
            Food food = finalHamper.get(j);
            int id = food.getFoodID();
            hamper.append(food.getFoodID()+"       "+food.getName()+ '\n');
            
            Inventory.removeFood(id);
        }
        return hamper.toString();
    }

    /*
	 * bestCombo()
	 * 
	 * This method is used to find the best hamper 
	 * 
	 */
    public int bestCombo(){
        int index =0;
        
        int min=100000000;

        for (int i = 0; i < hamperCombinations.size(); i++){
            LinkedList<Food> hamp = hamperCombinations.get(i);
        
            int total =0;
            for (int j = 0; j < hamp.size(); j++){
               Food food = hamp.get(j);
               total+=food.getTotalCalorie();
            }
            
            if (total < min ){
                min = total;
                index = i;
            }
        } 

        return index;
    }


    /*
	 * combinations()
	 * 
	 * This method is used to find different multiple combinations of food 
     * hampers with the least amount of wastage
	 * 
	 */
    public void combinations(){
		LinkedList<Food> tempFoodList = Inventory.getFoodList();
		hamperCombinations = new LinkedList<LinkedList<Food>>();

        while (!tempFoodList.isEmpty()){
            int beginningSize = hamperCombinations.size();
            LinkedList<Food> hamperTest = new LinkedList<Food>();
            int tempWC =0;
            int tempP =0;
            int tempFV =0;
            int tempO =0;
            int tempC =0;
            for (int i = 0; i < tempFoodList.size(); i++){
                Food foodTest = tempFoodList.get(i);

                if (tempWC >= totalWheat && tempP  >= totalProtein && tempFV  >= totalFV && tempO  >= totalOthers&& tempC  >= totalCalories ){
                    hamperCombinations.add(hamperTest);
                    break;
                }

                else if (tempWC >= totalWheat && tempP  >= totalProtein && tempFV  >= totalFV && tempO  >= totalOthers){
                    int temp = totalCalories - tempC;
                    int foodIndex = getClosest(caloriesArrayNon0, temp);
                    int id = caloriesArrayNon0ID[foodIndex];
                    
                    for (int k = 0; k < tempFoodList.size(); k++){
                        Food food = tempFoodList.get(k);
                        int testIndex = food.getFoodID();
                        if (testIndex == id ){
                            caloriesArrayNon0ID[foodIndex] = 1000000000;
                            caloriesArrayNon0[foodIndex] = 1000000000;
                            
                            tempWC += food.getGrainC();
                            tempWC += food.getGrainC();
                            tempP += food.getProteinC();
                            tempFV += food.getFruitVegC();
                            tempO += food.getOtherC();
                            tempC += food.getCalorie();
                            
                            hamperTest.add(food);
                        
                            break;
                        }
                        caloriesArrayNon0ID[foodIndex] = 1000000000;
                        caloriesArrayNon0[foodIndex] = 1000000000;
                    }
                }

                else if (tempC >= totalCalories && (tempWC <= totalWheat || tempP  <= totalProtein || tempFV  <= totalFV || tempO  <= totalOthers)){
                    int foodIndex = getMin(caloriesArrayNon0);
                    int id = caloriesArrayNon0ID[foodIndex];
                    
                    for (int k = 0; k < tempFoodList.size(); k++){
                        Food food = tempFoodList.get(k);
                        int testIndex = food.getFoodID();
                      
                        if (testIndex == id ){
                            caloriesArrayNon0ID[foodIndex] = 1000000000;
                            caloriesArrayNon0[foodIndex] = 1000000000;
                            
                            tempWC += food.getGrainC();
                            tempWC += food.getGrainC();
                            tempP += food.getProteinC();
                            tempFV += food.getFruitVegC();
                            tempO += food.getOtherC();
                            tempC += food.getCalorie();
                            
                            hamperTest.add(food);
                            break;
                        }
                        caloriesArrayNon0ID[foodIndex] = 1000000000;
                        caloriesArrayNon0[foodIndex] = 1000000000;
                    }
                }

                else if(tempC <= totalCalories && (tempWC <= totalWheat || tempP  <= totalProtein || tempFV  <= totalFV || tempO  <= totalOthers)){ 
                    int foodIndex = getMin(caloriesArrayNon0);
                    int id = caloriesArrayNon0ID[foodIndex];
                    
                    for (int k = 0; k < tempFoodList.size(); k++){
                        Food food = tempFoodList.get(k);
                        int testIndex = food.getFoodID();
                      
                        if (testIndex == id ){
                           
                            caloriesArrayNon0ID[foodIndex] = 1000000000;
                            caloriesArrayNon0[foodIndex] = 1000000000;
                            
                            tempWC += food.getGrainC();
                            tempWC += food.getGrainC();
                            tempP += food.getProteinC();
                            tempFV += food.getFruitVegC();
                            tempO += food.getOtherC();
                            tempC += food.getCalorie();
                            
                            hamperTest.add(food);
                            break;
                        }
                        caloriesArrayNon0ID[foodIndex] = 1000000000;
                        caloriesArrayNon0[foodIndex] = 1000000000;
                    }
                }
            }
            int endSize = hamperCombinations.size();

            if (beginningSize == endSize){

                if(hamperCombinations.size() == 0){
                    if (tempWC < totalWheat) {
                        error = "Not enough wheat in the Inventory";
                    }
                    else if (tempFV < totalFV) {
                        error = "Not enough Fruit Veggies content in the Inventory";
                    }
                    else if (tempP < totalProtein) {
                        error = "Not enough protein content in the Inventory";
                    }
                    else if (tempO < totalOthers) {
                        error = "Not enough others content in the Inventory";
                    }
                    else if (tempC < totalCalories) {
                        error = "Not enough Calories content in the Inventory";
                    }
                }

                break;
            }
        } 
    }

	/*
	 * listMaker()
	 * 
	 * This method is used to create two arrays.
	 * 		- one array contains all the foods calories
	 * 		- one array contains all the corresponding foods IDs
	 */
    public void listMaker(){
        LinkedList<Food> f = Inventory.getFoodList();
        int[] arr =  new int[Inventory.getFoodList().size()];
        int[] arr2 =  new int[Inventory.getFoodList().size()];

        caloriesArrayNon0 = arrayMaker(f, arr, arr2, "calories", "c", "1");
        caloriesArrayNon0ID = arrayMaker(f,arr, arr2, "calories", "id", "1");
    }

	/*
	 * arrayMaker()
	 * 
	 * Traverses through list of foods and adds all the calorie data/ids 
	 * to arrays. 
	 */
    public int[] arrayMaker(LinkedList<Food> f, int[] array, int[] id, String str, String str1, String str2){
        int j = 0;
        int[] tempFood = new int[Inventory.getFoodList().size()];
        int[] tempID = new int[Inventory.getFoodList().size()];

        if (str.equals("calories")){
            for (int i = 0; i < f.size(); i++){
                Food l = f.get(i);
            
                if(str2.equals("1")){
                    if  (l.getCalorie() != 0){
                        tempFood[j] = l.getCalorie();
                        tempID[j] = l.getFoodID();
                        
                        j++;
                    }
                        
                }
                else{
                    if  (l.getCalorie() == 0){
                        tempFood[j] = l.getCalorie();
                        tempID[j] = l.getFoodID();
                        
                        j++;
                    }

                }
                
            }
        }
        else{
            System.out.println("Wrong food type.");
        }

        if(str1.equals("c")){
            array = new int[j];
            array = Arrays.copyOfRange(tempFood, 0, j);
            return array;
        }
        
        else{
            id = new int[j];
            id = Arrays.copyOfRange(tempID, 0, j);
            return id;
        }
    }

	/*
	 * getMin()
	 * 
	 * Returns the minimum value in an array.  
	 */
    public int getMin(int[] array){
        int min = array[0];
        int index =0;
        for (int i = 0; i < array.length; i++){
            if (array[i]<min){
                min = array[i];
                index = i;
            }
        }
        return index;
    }

	/*
	 * getClosest()
	 * 
	 * Returns value closest to a target value in an array.
	 */
    public int getClosest(int[] array, int target){
        int index =0;
        int temp=0;
        int diff =0;
        int newDiff;
  
        for (int i = 0; i < array.length; i++){
            if(i==0) {
                diff =  Math.abs(target - array[i]) ;
                index = i;
            }

            else{
                newDiff =  Math.abs( target - array[i]);
                if (newDiff<diff){
                    index = i;
                }
            
            }
        }
        return index;
    }

}


    

    






























