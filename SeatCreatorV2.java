import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * GUI for adding a new room to a theater. 
 * @author Timothy Hulley
 *
 */
public class SeatCreatorV2 extends JFrame {
	/**
	 * The roomlist that a room will be added to if the user hits "Save"
	 */
	ArrayList<Room> rl;
	/**
	 * The current number of seats in the room
	 */
	int seatNum;
	/**
	 * The number of rows of seats
	 */
	int rowNum;
	int colNum; //DELETE LATER IF IT WORKS
	JFrame jf;
	JLabel lb1;
	JLabel lbName;
	JLabel lbRows;
	JLabel lbDisa;
	JTextField txName;
	JTextField txRows;
	JButton btRows;
	JButton btGenerate;
	JButton btSave;
	JButton btCancel;
	Seat [][] seatList;
	JButton[][] seatButtonList;
	JTextField[] sizeFieldList;
	Container sizeSetGrid;
	Container seatGrid;
	GridLayout sizeSetLayout;
	Handler hr = new Handler();
	
	public SeatCreatorV2 (ArrayList<Room> rl) {
		this.rl = rl;
	}
	
	/**
	 * Initializes the user interface
	 */
	public void init() {
		jf = new JFrame();
		jf.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		lb1 = new JLabel("Welcome to the room creation system! Enter the room information below!");
		lbName = new JLabel("Room name:");
		lbRows = new JLabel("Number of rows of seats:");
		lbDisa = new JLabel("Press Set Rows to display the number of rows in the room.");
		txName = new JTextField(15);
		txRows = new JTextField(15);
		btRows = new JButton("Set Rows");
		btGenerate = new JButton("Generate Room");
		btSave = new JButton("Save Room");
		btCancel = new JButton("Cancel");
		sizeSetGrid = getContentPane();
		seatGrid = getContentPane();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 0.5;
		c.insets = new Insets(0,30,0,10);
		jf.add(lb1, c);
		c.ipadx = 2000;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		jf.add(lbName, c);
		c.gridx = 1;
		c.gridy = 1;
		jf.add(txName, c);
		c.gridx = 0;
		c.gridy = 2;
		jf.add(lbRows, c);
		c.gridx = 1;
		c.gridy = 2;
		jf.add(txRows, c);
		c.gridx = 1;
		c.gridy = 3;
		jf.add(btRows, c);
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		jf.add(lbDisa, c);
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		jf.add(sizeSetGrid, c);
		c.gridx = 1;
		c.gridy = 5;
		//c.gridwidth = 2;
		jf.add(seatGrid, c);
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		jf.add(btGenerate, c);
		c.gridx = 1;
		c.gridy = 6;
		jf.add(btSave, c);
		c.gridx = 2;
		c.gridy = 6;
		jf.add(btCancel, c);
		btRows.addActionListener(hr);
		btGenerate.addActionListener(hr);
		btSave.addActionListener(hr);
		btCancel.addActionListener(hr);
		jf.setSize(600, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	
	public Seat[][] getSeatList() {
		return seatList;
	}
	
	public void RoomCreationConceptWithGUI () {
		
		seatGrid.removeAll();
		seatNum = 0;
		int gridNum = 0;
		
		seatList = new Seat[rowNum][0];
		seatButtonList = new JButton[rowNum][0];
		GridBagLayout seatGridLayout = new GridBagLayout ();
		seatGrid.setLayout(seatGridLayout);
		GridBagConstraints c = new GridBagConstraints();
		int biggestRow = Integer.parseInt(sizeFieldList[0].getText());
		
		for (int i = 0; i < rowNum; i++) {
			if (Integer.parseInt(sizeFieldList[i].getText()) > biggestRow) {
				biggestRow = Integer.parseInt(sizeFieldList[i].getText());
			}
		}
		
		for (int i = 0; i < rowNum; i++) {
			gridNum = Integer.parseInt(sizeFieldList[i].getText());
			seatList[i] = new Seat[gridNum];
			seatButtonList[i] = new JButton[gridNum];
			c.gridy = i;
			c.gridx = 0;
			seatGrid.add(new JLabel("Row " + (rowNum - i) + ":"), c);
			
			if (gridNum < biggestRow) {
				gridNum = (biggestRow - gridNum) / 2;
			} else {
				gridNum = 0;
			}
			
			for (int j = 0; j < seatList[i].length; j++) {
				c.gridx = j + 1 + gridNum;
				seatList[i][j] = new Seat("Seat" + i + ":" + j,false);
				seatButtonList[i][j] = new JButton(seatList[i][j].toString());
				seatButtonList[i][j].addActionListener(hr);
				seatGrid.add(seatButtonList[i][j], c);
				seatNum++;
			}
			System.out.println("Created row " + i);
		}
		
		lbDisa.setText("[ ] are regular seats. { } are handicapped. Click to toggle between them.");
		jf.setSize(600 + (biggestRow * 40), 500 + (rowNum * 20));
		jf.setVisible(true);
		
		return;
	}
	
	public void SetRowSize() {
		sizeSetGrid.removeAll();
		seatGrid.removeAll();
		
		rowNum = Integer.parseInt(txRows.getText());
		sizeFieldList = new JTextField[rowNum];
		sizeSetLayout = new GridLayout (rowNum, 2);
		sizeSetGrid.setLayout(sizeSetLayout);
		
		for (int i = 0; i < rowNum; i++) {
			sizeSetGrid.add(new JLabel("Row " + (rowNum - i) + ":"));
			sizeFieldList[i] = (new JTextField(3));
			sizeSetGrid.add(sizeFieldList[i]);
		}
		
		lbDisa.setText("Enter the number of seats in each row, the press Generate.");
		jf.setSize(600, 500 + (rowNum * 20));
		jf.setVisible(true);
		
		return;
	}
	
	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btRows)){
				try {
					if (txRows.getText().equals("")) {
						throw new NullPointerException();
					}
					Integer.parseInt(txRows.getText());
					
					SetRowSize();
				}
				catch (NumberFormatException d) {
					d.getMessage();
					System.out.println("Error. Row field does not contain letters.");
					JOptionPane.showMessageDialog(rootPane, "Rows field can only contain numbers.");
					return;
				}
				catch (NullPointerException d) {
					d.getMessage();
					System.out.println("Error. Row field text fields is empty.");
					JOptionPane.showMessageDialog(rootPane, "Enter the number of rows in the room and then press Set Rows.");
					return;
				}
				
			} else if(e.getSource().equals(btGenerate)) {
				// Check if the last two fields are empty and have only numbers
				try {
					for (int i = 0; i < sizeFieldList.length; i++) {
						Integer.parseInt(sizeFieldList[i].getText());
					}
					
					RoomCreationConceptWithGUI();
					return;
				}
				catch (NumberFormatException d) {
					d.getMessage();
					System.out.println("Error. Row or column fields do not contain letters.");
					JOptionPane.showMessageDialog(rootPane, "Rows fields can only contain numbers.");
					return;
				}
				catch (NullPointerException d) {
					d.getMessage();
					System.out.println("Error. One or more text fields is empty.");
					JOptionPane.showMessageDialog(rootPane, "Enter the number of rows in the room and then press Set Rows.");
					return;
				}
				
			} else if(e.getSource().equals(btSave)) {
				//Save and return the seatList
				//Check if fields are empty. Maybe make this an exception
				
				try {
					if (txName.getText().equals("")) {
						throw new IllegalArgumentException();
					}
					if (seatList.length == 0) {
						
					}
					rl.add(new Room(txName.getText(),seatList,seatNum,rowNum,colNum));
					
					//ADDED THIS SECTION ----SARA 
					String roomStr = "Theater name: " + txName.getText() + "\n" + 
					"Handicap seating arrangement: " + Arrays.deepToString(seatList)+ "\n" +
					"Seat Num: " + seatNum+ "\n" +
					"Row Num: " + rowNum + "\n"+ 
					"Column Num: " + colNum + "\n";
					Utilities.writeToFile(roomStr, "/Users/sarashabon/Desktop/room.txt");
					//end of new addition
					
					JOptionPane.showMessageDialog(rootPane, "Room layout successfully saved.");
					System.out.println(rl.toString());
					jf.dispose();
					jf.setVisible(false);
					return;
					//Close the window
				}
				catch (IllegalArgumentException d) {
					d.getMessage();
					System.out.println("Error. Name field is empty.");
					JOptionPane.showMessageDialog(rootPane, "Please enter a name for the room.");
					return;
				}
				catch (NullPointerException d) {
					d.getMessage();
					System.out.println("Error. Room not yet generated");
					JOptionPane.showMessageDialog(rootPane, "Room cannot be saved until seat layout has been generated.");
					return;
				}
			} else if(e.getSource().equals(btCancel)) {
				//Cancels without saving
				jf.dispose();
				jf.setVisible(false);
				return;
			} else {
				for (int i = 0; i < seatButtonList.length; i++) {
					for (int j = 0; j < seatButtonList[i].length; j++) {
						if (seatButtonList[i][j] == e.getSource()) {
							seatList[i][j].toggleDisabled();
							seatButtonList[i][j].setText(seatList[i][j].toString());
							return;
						}
					}
				}
			}
		}
		
	}
}