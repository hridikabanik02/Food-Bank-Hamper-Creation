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
import java.sql.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class Project{
    private static GUI gui;
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;
    private static String[][] clientDetails = new String[5][7]; 
    private static LinkedList<String[]> allFoodDetails = new LinkedList<String[]>();
    private static LinkedList<Food> allFoodObj = new LinkedList<Food>();
    private static String[] foodDetails;
    
    private static Connection dbConnect;
    private ResultSet results;
    
     ////////////////////////////////////////////////////////////////////
    /*
     * End of Methods required to access and manipulate the SQL Databse. 
     */
    ////////////////////////////////////////////////////////////////////
    public Project(String url, String user, String pw){
        // Database URL
        this.DBURL = url;

        //  Database credentials
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

	//Must create a connection to the database, no arguments, no return value    
    public void initializeConnection(){
        try{
            dbConnect = DriverManager.getConnection(getDburl(),getUsername(),getPassword()); 
        }
        catch(SQLException e){
            e.printStackTrace();
        }             
               

    }

    String getUsername(){
        return this.USERNAME;
    }
    
    String getDburl(){
        return this.DBURL;
    }

    String getPassword(){
        return this.PASSWORD;
    }
    
    public static void deleteFood(String id){
        try{
            
            String str = "DELETE FROM available_food WHERE ItemID = ?";
            PreparedStatement statement = dbConnect.prepareStatement(str);  
            
            statement.setString(1,id);
            int len = statement.executeUpdate();
            
            if(len == 0){
                System.out.println("No updating done");
               }
            
            
            statement.close();}
            
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            
    }           

    public String clients(String tableName){     

        StringBuilder comp = new  StringBuilder();         

        if(tableName.equals("daily_client_needs")){
            try{
                Statement statement = dbConnect.createStatement();  
                results = statement.executeQuery("SELECT ClientID, Client, WholeGrains, FruitVeggies, Protein, Other, Calories from daily_client_needs");
                int i = 0;
                while(results.next()){
                    int j = 0;
                    
                    clientDetails[i][j] = results.getString("ClientID");j++;
                    clientDetails[i][j] = results.getString("Client");j++;
                    clientDetails[i][j] = results.getString("WholeGrains");j++;
                    clientDetails[i][j] = results.getString("FruitVeggies");j++;
                    clientDetails[i][j] = results.getString("Protein");j++;
                    clientDetails[i][j] = results.getString("Other");j++;
                    clientDetails[i][j] = results.getString("Calories");j++;
                    i += 1;
                }
                statement.close();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            String str = comp.toString();
            return str.trim();
        }
        
        if(tableName.equals("available_food")){
            try{
                Statement statement = dbConnect.createStatement();  
                results = statement.executeQuery("SELECT ItemID, Name, GrainContent, FVContent, ProContent, Other, Calories from available_food");
            
                while(results.next()){
                    foodDetails = new String[7];
                     
                    foodDetails[0] = results.getString("ItemID");
                    foodDetails[1] = results.getString("Name");
                    foodDetails[2] = results.getString("GrainContent");
                    foodDetails[3] = results.getString("FVContent");
                    foodDetails[4] = results.getString("ProContent");
                    foodDetails[5] = results.getString("Other");
                    foodDetails[6] = results.getString("Calories");
                    

                    allFoodDetails.add(foodDetails);
                }
                
                statement.close();
            }
            catch(SQLException ex){

                ex.printStackTrace();   
        
            }
            String str = comp.toString();
            return str.trim();
        }

        else{
            String str = "Wrong input";
            return str;
        }
    }
    ////////////////////////////////////////////////////////////////////
    /*
     * End of Methods required to access and manipulate the SQL Databse. 
     */
    ////////////////////////////////////////////////////////////////////
    
   
    public static void main(String[] args) throws FileNotFoundException {
        GUI gui = new GUI();
        Food foodObj;
        
        //Use the following account information: Username = student, Password = ensf
        Project myJDBC = new Project("jdbc:mysql://localhost/food_inventory","student","ensf");
        myJDBC.initializeConnection();

        System.out.println("------------------------------");
        System.out.println();
        System.out.println(myJDBC.clients("daily_client_needs"));
        System.out.println(myJDBC.clients("available_food"));

        String[][] clients = {
            {clientDetails[0][0],clientDetails[0][1],clientDetails[0][2],clientDetails[0][3],clientDetails[0][4],clientDetails[0][5],clientDetails[0][6]},
            {clientDetails[1][0],clientDetails[1][1],clientDetails[1][2],clientDetails[1][3],clientDetails[1][4],clientDetails[1][5],clientDetails[1][6]},
            {clientDetails[2][0],clientDetails[2][1],clientDetails[2][2],clientDetails[2][3],clientDetails[2][4],clientDetails[2][5],clientDetails[2][6]},
            {clientDetails[3][0],clientDetails[3][1],clientDetails[3][2],clientDetails[3][3],clientDetails[3][4],clientDetails[3][5],clientDetails[3][6]}

        };
       
        var clientData = new Client(clients);
 
        for (int i = 0; i < allFoodDetails.size(); i++){
            String[] k = allFoodDetails.get(i);
            foodObj = new Food(k[0], k[1], k[2], k[3], k[4], k[5], k[6]);

            allFoodObj.add(foodObj);          
        }
        Inventory inv = new Inventory(allFoodObj);
        
        try {
    		FileWriter myWriter = new FileWriter("Order.txt", true);
		
			myWriter.write("\n");
			myWriter.write("Group 11 Final Project - ENSF 409" + "\n" + "Names: Shahzill Naveed, Muteeba Jamal, Ahsan Zia, Hridika Banik");
			myWriter.write("\n");
		       
            myWriter.close();
			
		} catch (FileNotFoundException e) {e.printStackTrace();}
            catch (IOException e) {e.printStackTrace();}

 
		GUI.run();

    }
}
