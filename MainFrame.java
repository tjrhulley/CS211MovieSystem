import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
//	private JFrame controllingFrame; //dialogs 
//	private JPasswordField passwordField;
	protected ArrayList<String> employeeList = new ArrayList<String>();
	protected ArrayList<String> managerList = new ArrayList<String>();
	//protected ArrayList<String> movieList = new ArrayList<String>();
	protected ArrayList<Double> confirmationNums = new ArrayList<Double>();
	//private int theaterCount;
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
							Scanner s;
							try {
								s = new Scanner(new File("/test/movies.txt"));
								java.util.List<String> list = Files.readAllLines(new File("movies.txt").toPath(), Charset.defaultCharset());
								while (s.hasNext()){
								    list.add(s.next());
								    }
								Object selection1 = JOptionPane.showInputDialog(null, "Choose A Movie To Watch", 
										"Movie Options", JOptionPane.QUESTION_MESSAGE, null, 
										list.toArray(), null);
								Object[] opts = {"   ", "9:00am", "3:00pm", "9:00pm"};
								Object select = JOptionPane.showInputDialog(null, "Choose Show Time", "Show Time Selection",
										JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
										//BookingCreator myBook = new BookingCreator(selection1.g,select);
									s.close();	//Pass over to Abhisek's code 
							}
							catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								
								e1.printStackTrace();
							}
							
						}
						
							
							
							
							//JOptionPane.showMessageDialog(null,  "TBD");
////							//creating movie panel 
////							JPanel movPan = new JPanel();
////							JRadioButton j1 = new JRadioButton("Shrek"); 
////							JRadioButton j2 = new JRadioButton("Finding Nemo");
////							JRadioButton j3 = new JRadioButton("Penguins of Madagascar");
////							movPan.add(j1);
////							movPan.add(j2);
////							movPan.add(j3);
////							//display movie options 
////							//Object[] movieOpts = movieList.toArray();
//////							Object movieChoice = JOptionPane.showInputDialog(null, "Choose Movie", "Movie Selection",
//////									JOptionPane.QUESTION_MESSAGE, null, movieOpts, null);
////							
////							Object newEmp = JOptionPane.showConfirmDialog(null, movPan, 
////									"Movie Options", JOptionPane.OK_CANCEL_OPTION);
//							
//							//BookingCreator newBooking = new BookingCreator();
//							
//							//======================
//							Object[] opts = {"   ", "9:00am", "3:00pm", "9:00pm"};
//							Object select = JOptionPane.showInputDialog(null, "Choose Show Time", "Show Time Selection",
//									JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
////	
//										if (select == opts[0]) {
//											JOptionPane.showMessageDialog(new JFrame(), "Make a selection", 
//													"ERROR", JOptionPane.ERROR_MESSAGE);
//										}	 
//								double confirmation = Math.random()*100000 ;
//								confirmationNums.add(confirmation);
//								JOptionPane.showMessageDialog(null,  "Your Ticket Confirmation number is: " + confirmation +"\n SAVE THIS ");
//							}
//							else if (j2.isSelected()) {
//								Object select = JOptionPane.showInputDialog(null, "Choose Show Time", "Show Time Selection",
//										JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
//	
//										if (select == opts[0]) {
//											JOptionPane.showMessageDialog(new JFrame(), "Make a selection", 
//													"ERROR", JOptionPane.ERROR_MESSAGE);
//										}	 
//								double confirmation =  Math.random()*100000 ;
//								confirmationNums.add(confirmation);
//								JOptionPane.showMessageDialog(null,  "Your Ticket Confirmation number is: " + confirmation +"\n SAVE THIS ");
//							}
//							else if (j3.isSelected()){
//								Object select = JOptionPane.showInputDialog(null, "Choose Show Time", "Show Time Selection",
//										JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
//	
//										if (select == opts[0]) {
//											JOptionPane.showMessageDialog(new JFrame(), "Make a selection", 
//													"ERROR", JOptionPane.ERROR_MESSAGE);
//										}	 
//								double confirmation = Math.random()* 100000;
//								confirmationNums.add(confirmation);
//								JOptionPane.showMessageDialog(null,  "Your Ticket Confirmation number is: " + confirmation +"\n SAVE THIS ");
//							}
										
						
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
//			
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
												int index = confirmationNums.indexOf(confirmation);
														if (confirmationNums.contains(index)) {
														confirmationNums.remove(confirmation);
														JOptionPane.showMessageDialog(null,  "Ticket Successfully Cancelled");
													}
													else {
													JOptionPane.showMessageDialog(new JFrame(), "Code Does Not Exist, Please Try Again", 
															"ERROR", JOptionPane.ERROR_MESSAGE);
													}
										}
										else if (selection == "View Confirmation Codes") {
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
			
							if (managerPass.contentEquals("manager")) {
								
								Object[] options = {"   ", "Create Employee", "Show Current Employees", "Create Room", 
										"Show Current Rooms", "Create New Manager", "Show Current Managers", "Add Movie", "Add Movie To Room", 
										"View Current Movies"};
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
													employeeList.add(first.getText() + " " + last.getText() + "\n");
													Utilities.writeToFile(employeeList, "/test/employeeList.txt");
													//JLabel trial = new JLabel(); 
													JOptionPane.showMessageDialog(null, "Employee Successfully Created");
											//employee list somewhere 
											//create a method to create employee and add to arraylist 
										}
										else if (selection == "Show Current Employees") {
											//JOptionPane.showMessageDialog(null, Arrays.deepToString(employeeList.toArray()));
											//need to retrieve this from txt 
											
											JOptionPane.showMessageDialog(null, Utilities.readFile("/test/Desktop/employeeList.txt"));
										}
										
										
										else if (selection == "Create Room") {
											//direct to timothy code 
											Theater rm = new Theater();
											rm.addRoom();
											
											//theaterCount++;
											
										}
										
										else if (selection == "Show Current Rooms") {
										
											JOptionPane.showMessageDialog(null,  Utilities.readFile("/test/room.txt"));
											//JOptionPane.showMessageDialog(null, Arrays.deepToString(Theater.getRoomList().toArray()));
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
									
											managerList.add(first.getText() + " " + last.getText()+ "\n");
											Utilities.writeToFile(managerList, "/test/managerList.txt");
											//System.out.println(first.getText() +" " + last.getText());
											JOptionPane.showMessageDialog(null, "Manager Successfully Created");
										}
										else if (selection == "Show Current Managers") {
											JOptionPane.showMessageDialog(null, Utilities.readFile("/test/managerList.txt"));
										}
										else if (selection == "Add Movie") {
											Theater th = new Theater();
											th.addMovie();
										}
										else if(selection == "Add Movie To Room") {
											
//											Room r1 = new Room("Room A", new Seat[4][3], 12,4,3);
//											Room r2 = new Room("Room B", new Seat[4][3], 12,4,3);
//											Movie m1 = new Movie("Fateful Findings", "The best movie ever", "3.99", 120, "5pm");
//											Movie m2 = new Movie("Twisted Pair", "The best movie ever", "3.99", 120, "5pm");
//											Movie m3 = new Movie("I am here....now", "The best movie ever", "3.99", 120, "5pm");
											
											Theater th = new Theater();
											th.assignMovie();
											
										}
										else if (selection == "View Current Movies") {
											//JOptionPane.showMessageDialog(null, "Employee Successfully Created");
											//JPanel moviePan = new JPanel();
									
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
										
											
											JOptionPane.showMessageDialog(null, Utilities.readFile("/test/movies.txt"));
											
											
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
}

