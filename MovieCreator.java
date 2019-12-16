import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MovieCreator extends JFrame{
	ArrayList<Movie> ml;
	JFrame jf;
	JLabel lbName;
	JLabel lbDescription;
	JLabel lbPrice;
	JLabel lbLength;
	JLabel lbShowTime;
	JTextField txName;
	JTextField txDescription;
	JTextField txPrice;
	JTextField txLength;
	JTextField txShowTime;
	JButton btSave;
	JButton btCancel;
	Handler hr = new Handler();
	
	public MovieCreator (ArrayList<Movie> ml) {
		this.ml = ml;
	}
	
	public void init() {
		jf = new JFrame();
		jf.setLayout(new GridLayout(6,2));
		lbName = new JLabel("Movie Name:");
		lbDescription = new JLabel("Description:");
		lbPrice = new JLabel("Price:");
		lbLength = new JLabel("Length:");
		lbShowTime = new JLabel("Show time:");
		txName = new JTextField(15);
		txDescription = new JTextField(15);
		txPrice = new JTextField(15);
		txLength = new JTextField(15);
		txShowTime = new JTextField(15);
		btSave = new JButton("Save Movie");
		btCancel = new JButton("Cancel");
		
		jf.add(lbName);
		jf.add(txName);
		jf.add(lbDescription);
		jf.add(txDescription);
		jf.add(lbPrice);
		jf.add(txPrice);
		jf.add(lbLength);
		jf.add(txLength);
		jf.add(lbShowTime);
		jf.add(txShowTime);
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
			if(e.getSource().equals(btSave)) {
				
				try {
					if (txName.getText().equals("") || txDescription.getText().equals("") || txPrice.getText().equals("") || txLength.getText().equals("")) {
						throw new NullPointerException();
					}
					
					ml.add(new Movie(txName.getText(),txDescription.getText(),txPrice.getText(),Integer.parseInt(txLength.getText()),txShowTime.getText()));
					//ADDED THIS SECTION --Sara 
					String movieStr = "Movie name: " + txName.getText() + "\n" + 
							"Ticket Price: " + txPrice.getText()+ "\n" +
							"Movie length: " + txLength.getText()+ "\n" +
							"Show Time: " + txShowTime.getText() + "\n";
							Utilities.writeToFile(movieStr, "/Users/sarashabon/Desktop/movies.txt");
							//end of added section -s
					JOptionPane.showMessageDialog(jf, "Movie successfully saved.");

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
				//Cancel button
				jf.dispose();
				jf.setVisible(false);
				return;
			}
		}
		
	}
}