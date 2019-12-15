import java.awt.Container;
import java.awt.FlowLayout;
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

public class BookingCreator extends JFrame{
	Room rm;
	String time;
	JLabel lbl;
	JLabel tLbl;
	JLabel tHlbl;
	JTextField txLbl;
	JTextField txHlbl;
	JButton btGenerate;
	JButton btSave;
	JButton btCancel;
	Container seatGrid;
	JFrame jf;
	Handler hr = new Handler();
	
	public BookingCreator(Room rm, String time) {
		this.rm = rm;
		this.time = time;
	}
	
	public void init() {
		jf = new JFrame();
		jf.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		lbl = new JLabel("Welcome to Ticket Booking! /n "
				+ "Please Select how many tickets you would like to purchase then click generate. /n"
				+ "Or simply click on the empty seats to select the seats you'd like to book.");
		tLbl = new JLabel("Please Enter how many regular seats you would like: ");
		tHlbl = new JLabel("Please Enter how many handycap seats you would like: ");
		txLbl = new JTextField(15);
		txLbl = new JTextField(15);
		btGenerate = new JButton("Generate Room");
		btSave = new JButton("Save Room");
		btCancel = new JButton("Cancel");
		seatGrid = getContentPane();
		c.fill = GridBagConstraints.HORIZONTAL;
		btGenerate.addActionListener(hr);
		btSave.addActionListener(hr);
		btCancel.addActionListener(hr);
		jf.setSize(600, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
	}
	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btGenerate)) {
				try {
					if(txLbl.getText().equals("") || txHlbl.getText().equals("")) {
						throw new NullPointerException();
					}
					Integer.parseInt(txLbl.getText());
				    Integer.parseInt(txHlbl.getText());
				    rm.toString();
				    return;
				}
					catch (NumberFormatException d) {
						d.getMessage();
						System.out.println("Error. Please enter number of tickets for both fields. Enter 0 if for no tickets.");
						JOptionPane.showMessageDialog(rootPane, "Rows and Columns fields can only contain numbers.");
						return;
					}
				}
			}
			
		}
	}
	
	
	
