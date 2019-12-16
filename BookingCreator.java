import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingCreator extends JFrame{
	Room rm;
	JFrame jf;
	JLabel lb1;
	JLabel lbName;
	JLabel lbTicket;
	JLabel lbHTicket;
	JTextField txName;
	JTextField txTicket;
	JTextField txHTicket;
	JButton btSave;
	JButton btCancel;
	int x;
	int y;
	
	Handler hr = new Handler();
	
	public BookingCreator () {
		
	}
	
	
	public void init() {
		jf = new JFrame();
		jf = new JFrame();
		jf.setLayout(new FlowLayout(6,2,2));
		GridBagConstraints c = new GridBagConstraints();
		lb1 = new JLabel("Welcome to the ticket booking system! Please Enter your name and tickets you'd like to purchase. \n");
		lbName = new JLabel("Name: ");
		lbTicket = new JLabel("Number of tickets you'd like to purchase: ");
		lbHTicket = new JLabel("Number of tickets for handicap members: ");
		txName = new JTextField(15);
		txTicket = new JTextField(15);
		txHTicket = new JTextField(15);
		btSave = new JButton("Buy tickets");
		btCancel = new JButton("Cancel");
		c.fill = GridBagConstraints.HORIZONTAL;
		
		jf.add(lb1);
		jf.add(lbName);
		jf.add(txName);
		jf.add(lbTicket);
		jf.add(txTicket);
		jf.add(lbHTicket);
		jf.add(txHTicket);
		jf.add(btSave);
		jf.add(btCancel);
		
		btSave.addActionListener(hr);
		btCancel.addActionListener(hr);
		jf.setSize(600, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			 x = Integer.parseInt(txTicket.getText());
		     y = Integer.parseInt(txHTicket.getText());
		     Booking book = new Booking(txTicket.getText(), x, y);
			if(e.getSource().equals(btSave)) {
				
				try {
					if (txName.getText().equals("") || txTicket.getText().equals("") || txHTicket.getText().equals("")) {
						throw new NullPointerException();
					}
				    
					jf.dispose();
					jf.setVisible(false);
					return;
					//Close the window
				}
				catch (NullPointerException d) {
					d.getMessage();
					System.out.println("Error. Text fields are empty");
					JOptionPane.showMessageDialog(jf, "One or more text fields is empty.");
					return;
				}
				catch (NumberFormatException d) {
					d.getMessage();
					System.out.println("Error. Length field do not contain letters.");
					JOptionPane.showMessageDialog(jf, "Length field can only contain numbers.");
					return;
				}
			} else {
				//rm.setBooking(new Booking(txName.getText(),x, y));
				JOptionPane.showMessageDialog(jf, "Finding optimal seating " + rm.getName() + ".");
				//Close button
				jf.dispose();
				jf.setVisible(false);
				return;
			}
		}
		
	}
	

}