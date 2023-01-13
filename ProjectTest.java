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

/* This test class is designed to test a food ordering system
 * The tests are all formed keeping in mind the boundary conditions
 * that may be provided.
*/
package edu.ucalgary.ensf409;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

/* *********** Tests for the Project.  *********** */
public class ProjectTest {

    String[][] clients = {
        {"1", "male" , "45" , "22" , "53" , "32" ,"2154"},
        {"2", "female" , "45" , "56" , "53" , "32" ,"1134"}, 
        {"3", "childu" , "45" , "22" , "21" , "62" ,"1834"}, 
        {"4", "childo" , "45" , "22" , "53" , "32" ,"1959"}

    };

    String[][] clientsOverLoad = {
        {"1", "male" , "4500" , "25646" , "53466" , "32" ,"215465"},
        {"2", "female" , "45006" , "564654" , "53" , "32" ,"113468"}, 
        {"3", "childu" , "45646" , "2248646" , "21" , "6246846" ,"183445"}, 
        {"4", "childo" , "457898" , "224684" , "53468" , "32" ,"65465"}

    };

    String[][] clientsBadData = {
        {"1", "male" , "-545" , "-22" , "53" , "32" ,"2154"},
        {"2", "female" , "45" , "56" , "53" , "-32" ,"1134"}, 
        {"3", "childu" , "-45" , "-522" , "21" , "62" ,"1834"}, 
        {"4", "childo" , "45" , "22" , "53" , "32" ,"1959"}

    };
    
    private LinkedList<Food> foods =new LinkedList<Food>();
    Food f1 = new Food("24" ,"Tomato Sauce, jar", "0", "80", "10", "10", "120");
    Food f2 = new Food("14" ,"Tomato Sauce, jar", "0", "80", "10", "10", "120");
    Food f3 = new Food("133" ,"Apple, dozen","0"  ,"100", "0", "0", "624");
    Food f4 = new Food("132" ,"Apple, dozen","1000"  ,"1000", "1000", "1000", "3000");
    
   

   
    /* The following methods are designed to test the 
     * constructors by inputting the correct data
    */

    @Test

    public void testClientConstructorGoodData() {
        Client oneClient = new Client(clients);
        assertNotNull("CLient constructor did not create an object when given a valid array of log entries.", oneClient);
    }

    @Test
    public void testInventoryConstructorGoodData() {
        
        foods.add(f1);
        foods.add(f2);
        foods.add(f3);
         
        Inventory array = new Inventory(foods);

        assertNotNull("Inventory constructor did not create an object when given a valid log string.", array);
    }

    @Test
    public void testFoodConstructorGoodData() {
        Food food = new Food("45","Tomato Sauce, jar", "0", "80", "10", "10", "120");
        assertNotNull("Food constructor did not create an object when given a valid log string.", food);
    }

    @Test
    public void testHamperConstructorGoodData() {
         
        Inventory array = new Inventory(foods);
        Hamper testing = new Hamper(2 , 3 , 5 , 6);
        assertNotNull("Hamper constructor did not create an object when given a valid log string.", testing);
    }

    @Test
    public void testHamperOneConstructorGoodData() {
        Inventory array = new Inventory(foods);

        Hamper testing = new Hamper(1156 , 756 , 55 , 353, 815);
        assertNotNull("Hamper constructor did not create an object when given a valid log string.", testing);
    }

    @Test
    public void testOrderConstructorGoodData() {
        Order testing = null;
        try {
            testing = new Order("people" ,"peopleeeee" , 13);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertNotNull("Order constructor did not create an object when given a valid log string.", testing);
    }

    /* The following methods are designed to test the 
     * constructors by inputting the incorrect data
    */

    @Test
    public void testClientConstructorInvalidData() {
        
        boolean correctException = false;
        
        try{
            Client invalidClient = new Client(clientsBadData);
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }

        assertEquals("Client constructor did not throw an IllegalArgumentException when given an invalid Client constructor: ", true, correctException);        
    }

    @Test
    public void testFoodConstructorInvalidData() {
        
        boolean correctException = false;
        
        try{
            Food invalidFood = new Food("45","Tomato Sauce, jar", "0", "-80", "10", "-10", "120");
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }

        assertEquals("Food constructor did not throw an IllegalArgumentException when given an invalid Food Constructor: ", true, correctException);        
    }


    @Test
    public void testHamperConstructorInvalidData() {
        
        boolean correctException = false;
        
        try{
            Hamper invalidHamper = new Hamper(2 , -3 , 5 , -6);
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }

        assertEquals("Hamper constructor did not throw an IllegalArgumentException when given an invalid Hamper constructor: ", true, correctException);        
    }

    @Test
    public void testOrderConstructorInvalidData() {
        
        boolean correctException = false;
        
        try{
            Order invalidOrder = new Order("SDbjjh", "hiji", -9);
        }
        catch(IllegalArgumentException e){
            correctException = true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assertEquals("Order constructor did not throw an IllegalArgumentException when given an invalid Order Constructor: ", true, correctException);        
    }

    /* The following methods test the functionality of
     * all the setter and getter methods for the 
     * Client class
    */

    @Test
    public void testSetWheat() {
        Client testing = new Client(clients);
        testing.setWheat(1, 56);
        int foundUserID = testing.getWheat(1);
        int expectedUserID = 56;
        assertEquals("Method SetWheat did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetFruitVeggies() {
        Client testing = new Client(clients);
        testing.setFruitVeggies(1,56);
        int foundUserID = testing.getFruitVeggies(1);
        int expectedUserID = 56;
        assertEquals("Method SetFruitVeggies did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetProtein() {
        Client testing = new Client(clients);
        testing.setProtein(1,56);
        int foundUserID = testing.getProtein(1);
        int expectedUserID = 56;
        assertEquals("Method testSetProtein did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetOthers() {
        Client testing = new Client(clients);
        testing.setOther(1,56);
        int foundUserID = testing.getOther(1);
        int expectedUserID = 56;
        assertEquals("Method setOthers did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetCalories() {
        Client testing = new Client(clients);
        testing.setCalories(1,5658);
        int foundUserID = testing.getCalories(1);
        int expectedUserID = 5658;
        assertEquals("Method setCalories did not return the expected result: ", expectedUserID, foundUserID);
    }

    /* The following methods test the functionality of
     * all the setter and getter methods for the 
     * Food class
    */

    @Test
    public void testSetGrainC() {
        Food testing = new Food("45","Tomato Sauce, jar", "0", "80", "10", "10", "120");;
        testing.setGrainC(56);
        int foundUserID = testing.getGrainC();
        int expectedUserID = 56;
        assertEquals("Method setGrainC did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetFruitVegC() {
        Food testing = new Food("45","Tomato Sauce, jar", "0", "80", "10", "10", "120");;
        testing.setFruitVegC(56);
        int foundUserID = testing.getFruitVegC();
        int expectedUserID = 56;
        assertEquals("Method setFruitVegC did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetProteinC() {
        Food testing = new Food("45","Tomato Sauce, jar", "0", "80", "10", "10", "120");;
        testing.setProtenC(56);
        int foundUserID = testing.getProteinC();
        int expectedUserID = 56;
        assertEquals("Method setProteinC did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetOtherC() {
        Food testing = new Food("45","Tomato Sauce, jar", "0", "80", "10", "10", "120");;
        testing.setOtherC(56);
        int foundUserID = testing.getOtherC();
        int expectedUserID = 56;
        assertEquals("Method setOtherC did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetCalorieC() {
        Food testing = new Food("45","Tomato Sauce, jar", "0", "80", "10", "10", "120");;
        testing.setCalorie(56);
        int foundUserID = testing.getCalorie();
        int expectedUserID = 56;
        assertEquals("Method setCalorieC did not return the expected result: ", expectedUserID, foundUserID);
    }

    /* The following methods test the functionality of
     * all the setter and getter methods for the 
     * Food class by inputting the wrong data and seeing
     * if an error is thrown.
    */

    @Test
    public void testsetCalorieException() {
        boolean correctException = false;
        try{
            Food food = new Food("45","Tomato Sauce, jar", "0", "80", "10", "10", "120");
            food.setCalorie(-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setCalorie did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }


    @Test
    public void testsetWheatCException() {
        boolean correctException = false;
        try{
            Food food = new Food("45","Tomato Sauce, jar", "0", "80", "10", "10", "120");
            food.setGrainC(-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setGrainC did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }

    @Test
    public void testProteinCException() {
        boolean correctException = false;
        try{
            Food food = new Food("45","Tomato Sauce, jar", "0", "80", "10", "10", "120");
            food.setProtenC(-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setProteinC did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }

    @Test
    public void testsetFruitVegCException() {
        boolean correctException = false;
        try{
            Food food = new Food("45","Tomato Sauce, jar", "0", "80", "10", "10", "120");
            food.setFruitVegC(-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setFruitVegC did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }

    @Test
    public void testsetOtherCException() {
        boolean correctException = false;
        try{
            Food food = new Food("45","Tomato Sauce, jar", "0", "80", "10", "10", "120");
            food.setOtherC(-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setOtherC did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }

    
    /* The following methods test the functionality of
     * all the setter and getter methods for the 
     * Client class by inputting the wrong data and seeing
     * if an error is thrown.
    */

    @Test
    public void testsetWheatException() {
        boolean correctException = false;
        try{
            Client client = new Client(clients);
            client.setWheat(1,-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setWheat did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }

    @Test
    public void testsetProteinException() {
        boolean correctException = false;
        try{
            Client client = new Client(clients);
            client.setProtein(1,-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setProtein did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }

    @Test
    public void testsetFruitVeggiesException() {
        boolean correctException = false;
        try{
            Client client = new Client(clients);
            client.setFruitVeggies(1,-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setFruitVeggies did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }

    @Test
    public void testsetOthersException() {
        boolean correctException = false;
        try{
            Client client = new Client(clients);
            client.setOther(1,-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setOthers did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }

    @Test
    public void testsetCaloriesException() {
        boolean correctException = false;
        try{
            Client client = new Client(clients);
            client.setCalories(1,-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setCalories did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }
    


    /* The following methods test the functionality of
     * all the setter and getter methods for the 
     * Hamper class by inputting the right data.
    */

    @Test
    public void testSetTWG() {
        Inventory array = new Inventory(foods);

        Hamper testing = new Hamper(275, 145, 435 ,315, 825);
        testing.setTWG(89);
        int foundUserID = testing.getTWG();
        int expectedUserID = 89;
        assertEquals("Method setUserTWG did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetTFV() {
        Inventory array = new Inventory(foods);

        Hamper testing = new Hamper(275, 145, 435 ,315, 825);
        testing.setTFV(89);
        int foundUserID = testing.getFV();
        int expectedUserID = 89;
        assertEquals("Method setUserTFV did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetTP() {
        Inventory array = new Inventory(foods);

        Hamper testing = new Hamper(275, 145, 435 ,315, 825);
        testing.setTP(89);
        int foundUserID = testing.getTP();
        int expectedUserID = 89;
        assertEquals("Method setTP did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetTO() {
        Inventory array = new Inventory(foods);

        Hamper testing = new Hamper(275, 145, 435 ,315, 825);
        testing.setTO(89);
        int foundUserID = testing.getTO();
        int expectedUserID = 89;
        assertEquals("Method setUserTO did not return the expected result: ", expectedUserID, foundUserID);
    }

    @Test
    public void testSetTC() {
        Inventory array = new Inventory(foods);

        Hamper testing = new Hamper(275, 145, 435 ,315, 825);
        testing.setTC(89);
        int foundUserID = testing.getTC();
        int expectedUserID = 89;
        assertEquals("Method setTC did not return the expected result: ", expectedUserID, foundUserID);
    }

    /* The following methods test the functionality of
     * all the setter and getter methods for the 
     * class by inputting the wrong data and seeing
     * if an error is thrown.
    */
    @Test
    public void testSetTWGException() {
        boolean correctException = false;
        try{
            Inventory array = new Inventory(foods);

            Hamper client = new Hamper(2, 1, 4 , 0);
            Hamper.setTWG(-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setTWG did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }

    @Test
    public void testSetTPException() {
        boolean correctException = false;
        try{
            Inventory array = new Inventory(foods);

            Hamper client = new Hamper(2, 1, 4 , 0);
            Hamper.setTP(-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setTP did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }

    @Test
    public void testSetTOException() {
        boolean correctException = false;
        try{
            Inventory array = new Inventory(foods);

            Hamper client = new Hamper(2, 1, 4 , 0);
            Hamper.setTO(-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("setTO did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }

    @Test
    public void testSetTCException() {
        boolean correctException = false;
        try{
            Inventory array = new Inventory(foods);

            Hamper client = new Hamper(2, 1, 4 , 0);
            Hamper.setTC(-1); 
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
        assertEquals("SetTC did not throw an IllegalArgumentException when given invalid input: ", true, correctException);
    }
    
}
