import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//GUI for adding a new room to a theater. 
public class SeatCreator extends JFrame {
	ArrayList<Room> rl;
	int seatNum;
	int rowNum;
	int colNum;
	JFrame jf;
	JLabel lb1;
	JLabel lbName;
	JLabel lbRows;
	JLabel lbCols;
	JLabel lbDisa;
	JTextField txName;
	JTextField txRows;
	JTextField txCols;
	JButton btGenerate;
	JButton btSave;
	JButton btCancel;
	Seat [][] seatList;
	JButton[][] seatButtonList;
	Container seatGrid;
	Handler hr = new Handler();
	
	public SeatCreator (ArrayList<Room> rl) {
		this.rl = rl;
	}
	
	public void init() {
		jf = new JFrame();
		jf.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		lb1 = new JLabel("Welcome to the room creation system! Enter the room information, then press generate!");
		lbName = new JLabel("Room name:");
		lbRows = new JLabel("Number of rows of seats:");
		lbCols = new JLabel("Number of columns of seats:");
		lbDisa = new JLabel("[ ] are regular seats. { } are handicapped. Click to toggle between them.");
		txName = new JTextField(15);
		txRows = new JTextField(15);
		txCols = new JTextField(15);
		btGenerate = new JButton("Generate Room");
		btSave = new JButton("Save Room");
		btCancel = new JButton("Cancel");
		seatGrid = getContentPane();
		c.fill = GridBagConstraints.HORIZONTAL;
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
		c.gridx = 0;
		c.gridy = 3;
		jf.add(lbCols, c);
		c.gridx = 1;
		c.gridy = 3;
		jf.add(txCols, c);
		//c.weighty = 5;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		jf.add(lbDisa, c);
		c.gridx = 0;
		c.gridy = 5;
		
		jf.add(seatGrid, c);
		//c.weighty = 0;
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
		rowNum = Integer.parseInt(txRows.getText());
		colNum = Integer.parseInt(txCols.getText());
		seatList = new Seat[rowNum][colNum];
		seatButtonList = new JButton[rowNum][colNum];
		GridLayout seatGridLayout = new GridLayout (rowNum, colNum);
		seatGrid.setLayout(seatGridLayout);
		
		for (int i = 0; i < rowNum; i++) {
			
			for (int j = 0; j < colNum; j++) {
				//Seat name format should include theater name, room name, row number/letter, and column number
				seatList[i][j] = new Seat("Seat" + i + ":" + j,false);
				seatButtonList[i][j] = new JButton(seatList[i][j].toString());
				seatButtonList[i][j].addActionListener(hr);
				seatGrid.add(seatButtonList[i][j]);
			}
			System.out.println("Created row " + i);
		}
		
		seatNum = rowNum * colNum;
		
		jf.setSize(600 + (colNum * 30), 500 + (rowNum * 20));
		jf.setVisible(true);
		
		return;
	}
	
	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btGenerate)) {
				// Check if the last two fields are empty and have only numbers
				try {
					if (txRows.getText().equals("") || txCols.getText().equals("")) {
						throw new NullPointerException();
					}
					Integer.parseInt(txRows.getText());
				    Integer.parseInt(txCols.getText());
				}
				catch (NumberFormatException d) {
					d.getMessage();
					System.out.println("Error. Row or column fields do not contain letters.");
					JOptionPane.showMessageDialog(rootPane, "Rows and Columns fields can only contain numbers.");
					return;
				}
				catch (NullPointerException d) {
					d.getMessage();
					System.out.println("Error. One or more text fields is empty.");
					JOptionPane.showMessageDialog(rootPane, "One or more text fields is empty.");
					return;
				}
				
				RoomCreationConceptWithGUI();
				
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
