import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MovieAssigner extends JFrame{
	ArrayList<Room> rl;
	ArrayList<Movie> ml;
	String[] roomText;
	String[] movieText;
	JFrame jf;
	JLabel lbRooms;
	JLabel lbMovies;
	JComboBox<Room> cbRooms;
	JComboBox<Movie> cbMovies;
	JButton btAssign;
	JButton btCancel;
	Handler hr = new Handler();
	
	
	
	public MovieAssigner (ArrayList<Room> rl, ArrayList<Movie> ml) {
		this.rl = rl;
		this.ml = ml;
		roomText = new String[rl.size()];
		movieText = new String[ml.size()];
		
		for (int i = 0; i < rl.size(); i++) {
			roomText[i] = rl.get(i).getName();
		}
		
		for (int i = 0; i < ml.size(); i++) {
			movieText[i] = ml.get(i).getName();
		}
	}
	
	public void init() {
		jf = new JFrame();
		jf.setLayout(new GridLayout(3,2));
		lbRooms = new JLabel("List of rooms in theater.");
		lbMovies = new JLabel("Movie to assign to selected room.");
		cbRooms = new JComboBox(roomText);
		cbMovies = new JComboBox(movieText);
		btAssign = new JButton("Assign");
		btCancel = new JButton("Cancel");
		
		jf.add(lbRooms);
		jf.add(cbRooms);
		jf.add(lbMovies);
		jf.add(cbMovies);
		jf.add(btAssign);
		jf.add(btCancel);
		
		btAssign.addActionListener(hr);
		btCancel.addActionListener(hr);
		jf.setSize(500, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	public class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btAssign)) {
				ml.get(cbMovies.getSelectedIndex()).setRoom(rl.get(cbRooms.getSelectedIndex()));
				JOptionPane.showMessageDialog(jf, "Movie " + cbMovies.getSelectedItem() + " successfully assigned to " + cbRooms.getSelectedItem() + ".");
				
				System.out.println(ml.get(cbMovies.getSelectedIndex()).toString());
				
				jf.dispose();
				jf.setVisible(false);
				return;
			} else {
				//Cancel button
				jf.dispose();
				jf.setVisible(false);
				return;
			}
		}
		
	}
}