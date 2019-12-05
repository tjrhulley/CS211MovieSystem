import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MainFrame extends JFrame{
	private JButton customerBtn;
	private JButton employeeBtn;
	private JButton managerBtn;
	private JLabel label;
	private JFrame controllingFrame; //dialogs 
	private JPasswordField passwordField;
	protected ArrayList<String> employeeList = new ArrayList<String>();
	protected ArrayList<String> managerList = new ArrayList<String>();
	protected ArrayList<String> movieList = new ArrayList<String>();
	protected ArrayList<Integer> confirmationNums = new ArrayList<Integer>();
	private int theaterCount;
	Object[] possibilities = {'1', '2', '3', '4'};
	public MainFrame(String title) {
		super(title);
		
		
		this.setLayout(new BorderLayout());
		
		//JTextArea textArea = new JTextArea();
		
		
        employeeBtn= new JButton("EMPLOYEE");
        Font newButtonFont=new Font(employeeBtn.getFont().getName(),employeeBtn.getFont().getStyle(),30);
		employeeBtn.setFont(newButtonFont);
        employeeBtn.setPreferredSize(new Dimension(200, 100));
		
		customerBtn = new JButton ("CUSTOMER");
		customerBtn.setFont(newButtonFont);
        customerBtn.setPreferredSize(new Dimension(200, 100));
        customerBtn.setFont(newButtonFont);
      
		managerBtn = new JButton("MANAGER");
		managerBtn.setFont(newButtonFont);
        managerBtn.setPreferredSize(new Dimension(200, 100));
        
		label = new JLabel("WELCOME TO TSA THEATER");
		Font labelFont =new Font(label.getFont().getName(),label.getFont().getStyle(), 50);
		label.setFont(labelFont);
		//label.setAlignmentX(Component.CENTER_ALIGNMENT);
		
//		passwordField = new JPasswordField(10);
//		passwordField.setActionCommand("ok");
//		passwordField.addActionListener(this);
//		
//		
	//add Swing components to content pane 
		Container c = getContentPane();
		//Frame c = new JFrame();
		//c.add(textArea, BorderLayout.CENTER);s
		//c.add(button, BorderLayout.SOUTH);
		c.add(label, BorderLayout.PAGE_START);
		c.add(employeeBtn, BorderLayout.LINE_START);
		c.add(customerBtn, BorderLayout.CENTER);
		c.add(managerBtn, BorderLayout.LINE_END);
		
		//actions for customer button 
		customerBtn.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
//				JButton op1 = new JButton("Buy Ticket");
//				JButton op2 = new JButton("Cancel Ticket");
//				
//				Container c = getContentPane();
//				c.add(op1, BorderLayout.LINE_START);
//				c.add(op2, BorderLayout.LINE_END);
				
			//SHOW MOVIES UPON CLICKING ON CUSTOMER 	
				Object[] options = {"   ", "Buy Ticket", "Cancel Ticket"};
				String initialSelection = "   ";
				Object selection = JOptionPane.showInputDialog(null, "What would you like to do?", 
						"Customer Options", JOptionPane.QUESTION_MESSAGE, null, 
						options, initialSelection);
						if (selection== "Buy Ticket") {
							//JOptionPane.showMessageDialog(null,  "TBD");
							//creating movie panel 
							JPanel movPan = new JPanel();
							JRadioButton j1 = new JRadioButton("Shrek"); 
							JRadioButton j2 = new JRadioButton("Finding Nemo");
							JRadioButton j3 = new JRadioButton("Penguins of Madagascar");
							movPan.add(j1);
							movPan.add(j2);
							movPan.add(j3);
							//display movie options 
							Object newEmp = JOptionPane.showConfirmDialog(null, movPan, 
									"Movie Options", JOptionPane.OK_CANCEL_OPTION);
							Object[] opts = {"   ", "9:00am", "3:00pm", "9:00pm"};
							if (j1.isSelected()) {
								Object select = JOptionPane.showInputDialog(null, "Choose Show Time", "Show Time Selection",
										JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
	
										if (select == opts[0]) {
											JOptionPane.showMessageDialog(new JFrame(), "Make a selection", 
													"ERROR", JOptionPane.ERROR_MESSAGE);
										}	 
								int confirmation = (int) Math.random();
								confirmationNums.add(confirmation);
								JOptionPane.showMessageDialog(null,  "Your Ticket Confirmation number is: " + confirmation);
							}
							else if (j2.isSelected()) {
								Object select = JOptionPane.showInputDialog(null, "Choose Show Time", "Show Time Selection",
										JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
	
										if (select == opts[0]) {
											JOptionPane.showMessageDialog(new JFrame(), "Make a selection", 
													"ERROR", JOptionPane.ERROR_MESSAGE);
										}	 
								int confirmation = (int) Math.random();
								confirmationNums.add(confirmation);
								JOptionPane.showMessageDialog(null,  "Your Ticket Confirmation number is: " + confirmation);
							}
							else if (j3.isSelected()){
								Object select = JOptionPane.showInputDialog(null, "Choose Show Time", "Show Time Selection",
										JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
	
										if (select == opts[0]) {
											JOptionPane.showMessageDialog(new JFrame(), "Make a selection", 
													"ERROR", JOptionPane.ERROR_MESSAGE);
										}	 
								int confirmation = (int) Math.random();
								confirmationNums.add(confirmation);
								JOptionPane.showMessageDialog(null,  "Your Ticket Confirmation number is: " + confirmation);
							}
										
						}
						else if (selection == "Cancel Ticket") {
							//ASK FOR CONFIRMATION NUMBER AND CHECK ARRAYLIST IF IT IS THERE 
							JOptionPane.showMessageDialog(new JFrame(), "Please see Customer Services", 
									"ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(new JFrame(), "Make a selection", 
									"ERROR", JOptionPane.ERROR_MESSAGE);
						}
			}
//			selection.addActionListener(new ActionListener() {
//				
//				@Override 
//				public void actionPerformed(ActionEvent e) {
//					
//				}
//			}
		});
		
		//actions for employee button 
		employeeBtn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String employeePass = (String)JOptionPane.showInputDialog(c, "Enter employee password:\n", 
						"Password", JOptionPane.PLAIN_MESSAGE, null, null, "");
				//check if employee password is correct 
							if (employeePass.contentEquals("employee")) {
								Object[] options = {"   ", "Cancel Ticket", "View Confirmation Codes"};
								String initialSelection = "   ";
								Object selection = JOptionPane.showInputDialog(null, "What would you like to do?", 
										"Employee Options", JOptionPane.QUESTION_MESSAGE, null, 
										options, initialSelection);
										if (selection == "Cancel Ticket") {
											String confirmation = (String)JOptionPane.showInputDialog(c, "Enter ticket confirmation code:\n", 
													"Cancel Customer Ticket", JOptionPane.PLAIN_MESSAGE, null, null, "");
											JOptionPane.showMessageDialog(null,  "Ticket Successfully Cancelled");
										}
										if (selection == "View Confirmation Codes") {
											JOptionPane.showMessageDialog(null, Arrays.deepToString(confirmationNums.toArray()));
										}
										else {
											JOptionPane.showMessageDialog(new JFrame(), "Make a selection", 
													"ERROR", JOptionPane.ERROR_MESSAGE);										}
										}
							else {
								JOptionPane.showMessageDialog(new JFrame(), "Incorrect Password, Try Again", 
										"ERROR", JOptionPane.ERROR_MESSAGE);
							}
//				Login dialog = new Login(c);
//				dialog.setVisible(true);
			}
		
		});
		//actions for manager button
		managerBtn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String managerPass = (String)JOptionPane.showInputDialog(c, "Enter manager password:\n", 
						"Password", JOptionPane.PLAIN_MESSAGE, null, null, "");
				//check if manager password is correct
				//List to keep track of the employees working 
				//ArrayList<String> employeeList = new ArrayList<String>();
				//List to keep track of the managers working 
				//ArrayList<String> managerList = new ArrayList<String>();
							if (managerPass.contentEquals("manager")) {
								//JOptionPane.showMessageDialog(null, "Good job!");
								Object[] options = {"   ", "Create Employee", "Show Current Employees", "Create Theater", 
										"Show Current Theaters", "Create New Manager", "Show Current Managers", "Add Movie", "View Current Movies"};
								String initialSelection = "   ";
								Object selection = JOptionPane.showInputDialog(null, "What would you like to do?", 
										"Manager Options", JOptionPane.QUESTION_MESSAGE, null, 
										options, initialSelection);
										if (selection == "Create Employee") {
											//creating create employee panel 
											JPanel empPanel = new JPanel();
											JTextField first = new JTextField(20);
											JTextField last = new JTextField(20);
											empPanel.add(new JLabel("First Name: "));
											empPanel.add(first);
											empPanel.add(Box.createHorizontalStrut(15));
											empPanel.add(new JLabel("Last Name: "));
											empPanel.add(last);
											//display employee panel 
											Object newEmp = JOptionPane.showConfirmDialog(null, empPanel, 
													"Enter First and Last Name", JOptionPane.OK_CANCEL_OPTION);
												
											//add new employee first and last name to the arraylist
													employeeList.add(first.getText() + " " + last.getText());
													//JLabel trial = new JLabel(); 
													JOptionPane.showMessageDialog(null, "Employee Successfully Created");
											//employee list somewhere 
											//create a method to create employee and add to arraylist 
										}
										else if (selection == "Show Current Employees") {
											JOptionPane.showMessageDialog(null, Arrays.deepToString(employeeList.toArray()));
										}
										
										else if (selection == "Create Theater") {
											//direct to timothy code 
											Theater rm = new Theater();
											rm.addRoom();
											theaterCount++;
										}
										
										else if (selection == "Show Current Theaters") {
											//display the arraylist made in timothy code 
											JOptionPane.showMessageDialog(null, "Amount of theaters: " + theaterCount);
										}
										
										else if (selection == "Create New Manager") {
											//manager list somewhere 
											JPanel manPanel = new JPanel();
											JTextField first = new JTextField(20);
											JTextField last = new JTextField(20);
											manPanel.add(new JLabel("First Name: "));
											manPanel.add(first);
											manPanel.add(Box.createHorizontalStrut(15));
											manPanel.add(new JLabel("Last Name: "));
											manPanel.add(last);
											//display employee panel 
											Object newEmp = JOptionPane.showConfirmDialog(null, manPanel, 
													"Enter First and Last Name", JOptionPane.OK_CANCEL_OPTION);
									
											managerList.add(first.getText() + last.getText());
											System.out.println(first.getText() + last.getText());
											JOptionPane.showMessageDialog(null, "Manager Successfully Created");
										}
										else if (selection == "Show Current Managers") {
											JOptionPane.showMessageDialog(null, Arrays.deepToString(managerList.toArray()));
										}
										else if(selection == "Add Movie") {
											
											Seat[][] dave = new Seat[5][3];
											Room rm = new Room ("ROOM", dave, 10);
											Theater th = new Theater(rm);
											th.addMovie(rm);
									
											
										}
										else if (selection == "View Current Movies") {
											//JOptionPane.showMessageDialog(null, "Employee Successfully Created");
											JPanel moviePan = new JPanel();
									
											//movie.setIcon(new ImageIcon(getClass().getResource("/resources/puppy.png")));
											//try {
//												Image myImage = ImageIO.read(getClass().getResource("/resources/puppy.png"));
//												ImageIcon icon = createImageIcon(myImage);
////												JLabel movie = new JLabel(myImageIcon);
//												JButton btn = new JButton("yellow");
//												//moviePan.add(movie);
//												moviePan.add(btn);
////											} catch (IOException e1) {
////												// TODO Auto-generated catch block
////												e1.printStackTrace();
////											}
											//JLabel movie = new JLabel(myImageIcon);
											//movie.add(myImageIcon);
											JOptionPane.showMessageDialog(null,  "Shrek, Finding Nemo, Penguins of Madagascar");
											//JOptionPane.showMessageDialog(new JFrame(), "No Movies Yet",
													//"ERROR", JOptionPane.ERROR_MESSAGE);
											//JOptionPane.showMessageDialog(null, "Employee Successfully Created");
											
										}
							}
							else {
								JOptionPane.showMessageDialog(new JFrame(), "Incorrect Password, Try Again",
										"ERROR", JOptionPane.ERROR_MESSAGE);
							}
			}
		
		});
		
	}

	//check if the password is correct 
	
//	public static boolean isPasswordCorrect(char[] input) {
//		boolean isCorrect = true;
//		//Object[] possibilities = {'1', '2', '3', '4'};
//	return true;
//	}
}

