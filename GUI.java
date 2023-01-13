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

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.FlowLayout;

public class GUI extends JFrame implements ActionListener, MouseListener{
	// variables required for implementation
	private int totalFemale;
	private int totalMale;
	private int totalChildrenU8;
	private int totalChildrenO8;
	private int grainC;
	private int fvc;
	private int proC;
	private int OthersC;
	private int CaloriesC;
	private int hamperNumber = 1;
	
	// variables required ofr the GUI
    private JLabel instructions;
    private JLabel instructions1;
    private JLabel instructions2;
    private JLabel instructions3;
    private JLabel option1;
    private JLabel option2;
    private JLabel mLabel;
    private JLabel fLabel;
    private JLabel coLabel;
    private JLabel cuLabel;
    private JLabel twgLabel;
    private JLabel fvLabel;
    private JLabel proLabel;
    private JLabel oLabel;
    private JLabel cLabel;
    private javax.swing.JPanel jPanel1;
    private JTextField fInput;
    private JTextField mInput;
    private JTextField coInput;
    private JTextField cuInput;
    private JTextField twgInput;
    private JTextField fvInput;
    private JTextField proInput;
    private JTextField oInput;
    private JTextField cInput;
    
    /*
     * GUI() Constructor
     */ 
    public GUI(){
        super("Group 11 Project");
        setupGUI();
        setSize(1200,800);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    /*
     * setupGUI() Method
     * 
     * Sets up the GUI for users to interact with.
     */ 
    public void setupGUI(){
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new java.awt.Color(30, 31, 38));
        jPanel1.setForeground(new java.awt.Color(153, 255, 102));
        
        instructions = new JLabel("Group 11 Project - ENSF409");
        instructions.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        instructions.setForeground(new java.awt.Color(0,0,0));

        instructions1 = new JLabel("For Option 1: Please put a valid number of clients and click submit. Dont use negative numbers or decimal numbers." );
        instructions1.setFont(new java.awt.Font("Segoe UI", 0, 17));
        instructions1.setForeground(new java.awt.Color(0,0,0));

        instructions2 = new JLabel("For Option 2: Please put valid number of contents for each food group and click sumbmit. Dont use negative numbers or decimal numbers." );
        instructions2.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        instructions2.setForeground(new java.awt.Color(0,0,0));

        instructions3 = new JLabel("Welcome! This application will provide you with a Hamper according to your needs. You are required to fill out only one option." );
        instructions3.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        instructions3.setForeground(new java.awt.Color(0,0,0));

        option1 = new JLabel("OPTION 1");
        option1.setFont(new java.awt.Font("Segoe UI", 0, 17)); 
        option1.setForeground(new java.awt.Color(0,0,0));

        mLabel = new JLabel("Males:");
        mLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        mLabel.setForeground(new java.awt.Color(0,0,0));
        fLabel = new JLabel("Females:");
        fLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        fLabel.setForeground(new java.awt.Color(0,0,0));
        coLabel = new JLabel("Children Over 8:");
        coLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        coLabel.setForeground(new java.awt.Color(0,0,0));
        cuLabel = new JLabel("Children Under 8:");
        cuLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        cuLabel.setForeground(new java.awt.Color(0,0,0));

        option2 = new JLabel("OPTION 2 \n");
        option2.setFont(new java.awt.Font("Segoe UI", 0, 17));
        option2.setForeground(new java.awt.Color(0,0,0));

        twgLabel = new JLabel("Wheat:");
        twgLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        twgLabel.setForeground(new java.awt.Color(0,0,0));
        fvLabel = new JLabel("Fruit Veggies");
        fvLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        fvLabel.setForeground(new java.awt.Color(0,0,0));
        proLabel = new JLabel("Protein");
        proLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        proLabel.setForeground(new java.awt.Color(0,0,0));
        oLabel = new JLabel("Others");
        oLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        oLabel.setForeground(new java.awt.Color(0,0,0));
        cLabel = new JLabel("Calories:");
        cLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        cLabel.setForeground(new java.awt.Color(0,0,0));
        
        mInput = new JTextField("0", 15);
        fInput = new JTextField("0", 15);
        coInput = new JTextField("0", 15);
        cuInput = new JTextField("0", 15); 
        
        twgInput = new JTextField("0", 15);
        fvInput = new JTextField("0", 15); 
        proInput = new JTextField("0", 15); 
        oInput = new JTextField("0", 15); 
        cInput =new JTextField("0", 15); 

        mInput.addMouseListener(this);
        fInput.addMouseListener(this);
        coInput.addMouseListener(this);
        cuInput.addMouseListener(this);

        twgInput.addMouseListener(this);
        fvInput.addMouseListener(this);
        proInput.addMouseListener(this);
        oInput.addMouseListener(this);
        cInput.addMouseListener(this);

        
        JButton submitInfo = new JButton("Submit");
        submitInfo.addActionListener(this);

        JButton exit = new JButton("Exit");
		exit.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) {
			System.exit(0);
			}
        });

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new BoxLayout(clientPanel, 1));

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new FlowLayout());
        
        headerPanel.add(instructions);
        clientPanel.add(instructions3);
        clientPanel.add(instructions1);
        clientPanel.add(instructions2);
        clientPanel.add(option1);
        clientPanel.add(mLabel);
        clientPanel.add(mInput);
        clientPanel.add(fLabel);
        clientPanel.add(fInput);
        clientPanel.add(coLabel);
        clientPanel.add(coInput);
        clientPanel.add(cuLabel);
        clientPanel.add(cuInput);
        clientPanel.add(option2);
        clientPanel.add(twgLabel);
        clientPanel.add(twgInput);
        clientPanel.add(fvLabel);
        clientPanel.add(fvInput);
        clientPanel.add(proLabel);
        clientPanel.add(proInput);
        clientPanel.add(oLabel);
        clientPanel.add(oInput);
        clientPanel.add(cLabel);
        clientPanel.add(cInput);

        submitPanel.add(submitInfo);
        exitPanel.add(exit);
       
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.SOUTH);
        this.add(exitPanel, BorderLayout.EAST);
    }
    
    /*
     * actionPerformed(ActionEvent event) Method
     * 
     * Once the user inputs data and presses submit, the data is assigned 
     * to the variables we defined above.
     * 
     * Depending on which option the user decided to fill out, the 
     * corresponding Hamper constructor is called to create an object of
     * Hamper.Then an order object is created.
     * 
     * The details of the hamper created or an error messgae is displayed 
     * depending on wether or not a hamper was able to be created. 
     * 
     * There is a popup error message if:
     * 		- both options are filled out,
     * 		- invalid data (e.g. negative numbers) is inputted.
     */ 
    public void actionPerformed(ActionEvent event){
        totalMale = Integer.parseInt(mInput.getText());
        totalFemale =  Integer.parseInt(fInput.getText());
        totalChildrenO8 =  Integer.parseInt(coInput.getText());
        totalChildrenU8 = Integer.parseInt(cuInput.getText());
        grainC = Integer.parseInt(twgInput.getText());
        fvc = Integer.parseInt(fvInput.getText());
        proC = Integer.parseInt(proInput.getText());
        OthersC = Integer.parseInt(oInput.getText());
        CaloriesC = Integer.parseInt(cInput.getText());

        String orders;
        String request =null;

        int decision = validateInput();
        
        if(decision == 1){
            int option = validateOption();

            if(option == 1){
                
                Hamper testHamper = new Hamper(totalMale, totalFemale, 
				totalChildrenO8, totalChildrenU8);
                orders = testHamper.getHamper();
                request = totalMale + " Males, " + totalFemale + " Females, " 
                + totalChildrenO8 + " Children over 8, " + totalChildrenU8 + " Children under 8";
                
                try {
                    Order orderrr = new Order(request, orders, hamperNumber);
                    JOptionPane.showMessageDialog(this,orderrr.returnFinalOrder());
                    hamperNumber ++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            else if(option == 2){
				Hamper testHamper = new Hamper(grainC, fvc, proC,OthersC, CaloriesC);
				orders = testHamper.getHamper();
				request = grainC + " Wheat Content, " + fvc + " Fruit Veggies Content, " 
				+ proC + " Protein Content, " + OthersC + " Other Content, " + CaloriesC + 
				" Calories Content";

                try {
                    Order orderrr = new Order(request, orders, hamperNumber);
                    JOptionPane.showMessageDialog(this,orderrr.returnFinalOrder());
                    hamperNumber++;
                    
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            else{
                JOptionPane.showMessageDialog(this,
                "Invalid Input: Ummm looks like you filled out both options. Please only fill out the one you need. :(");
            }
        }
        
        else{
            JOptionPane.showMessageDialog(this,
            "Invalid Input: Ummm looks like you entered negative number(s) :(");
        }
    }

    /*
     * validateInput() Method
     * 
     * Ensures data entered by the user is valid (e.g. not negative values)
     */
    public int validateInput(){
        if(totalMale < 0 || totalFemale < 0 || totalChildrenU8 < 0 || totalChildrenO8 < 0 ){
            return 0;
        }
        else if(grainC < 0 || fvc < 0 || proC < 0 || OthersC < 0 || CaloriesC < 0 ){
            return 0;
        }
        else{
            return 1;
        }
    }

    /*
     * validateOption() Method
     * 
     * Ensures user only inputted data for a single option.
     */
    public int validateOption(){
        if(totalMale ==0 && totalFemale == 0 && totalChildrenU8 == 0 && totalChildrenO8 == 0 ){
            return 2;
        }
        else if(grainC == 0&& fvc == 0 && proC == 0 && OthersC == 0 && CaloriesC == 0 ){
            return 1;
        }
        else{
            return 0;
        }
    }
    
   
    public void mouseClicked(MouseEvent event){
        
        if(event.getSource().equals(mInput))
            
            mInput.setText("");

        if(event.getSource().equals(fInput))
            fInput.setText("");

        if(event.getSource().equals(coInput))
            coInput.setText("");

        if(event.getSource().equals(cuInput))
            cuInput.setText("");
        
        if(event.getSource().equals(twgInput))
            twgInput.setText("");    
        
        if(event.getSource().equals(fvInput))
            fvInput.setText("");

        if(event.getSource().equals(proInput))
            proInput.setText("");

        if(event.getSource().equals(oInput))
            oInput.setText("");

        if(event.getSource().equals(cInput))
            cInput.setText("");
    
    }
    
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }
      
	/*
	 * run() Method
	 * 
	 * Runs the GUI.
	 */ 
    public static void run() { 
        GUI X = new GUI();
        X.setVisible(true);
    }     
}
