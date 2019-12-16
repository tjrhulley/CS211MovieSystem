import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class App {
	
	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MainFrame("TSA Theater");
				frame.setSize(1000,700);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
	
	}
	
	}

