import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

public class Login extends JDialog{
	private JPasswordField pass;
	private JLabel passLabel;
	private JButton loginBtn;
	private JButton cancelBtn;
	private boolean success;
	
	
	public Login (Container c){
		super();
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		passLabel = new JLabel("Password: ");
		panel.add(passLabel, cs);
		
		pass = new JPasswordField(10);
		panel.add(pass, cs);
		panel.setBorder(new LineBorder(Color.RED));
		
		loginBtn = new JButton("Login");
		
		loginBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(authenticate(getPassword())) {
					//FIX ME 
					Object[] options = {"   ", "Buy Ticket", "Cancel Ticket"};
					String initialSelection = "   ";
					Object selection = JOptionPane.showInputDialog(null, "What would you like to do?", 
							"Customer Options", JOptionPane.QUESTION_MESSAGE, null, 
							options, initialSelection);
							success = true;
							dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "INVALID PASSWORD", null, JOptionPane.ERROR_MESSAGE);
					success = false;
				}
			}
		});
	}
			private boolean authenticate(Object password) {
				// TODO Auto-generated method stub
				return false;
			}

			private Object getPassword() {
				// TODO Auto-generated method stub
				return null;
			}
	}
	

