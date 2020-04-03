import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;

public class InsertDataBase extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertDataBase frame = new InsertDataBase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertDataBase() {
		setTitle("Inserire Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 251);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 32, 538, 20);
		contentPane.add(textPane);
		
		JTextArea txtrInserireUserHost = new JTextArea();
		txtrInserireUserHost.setBackground(SystemColor.menu);
		txtrInserireUserHost.setFont(new Font("Arial", Font.BOLD, 12));
		txtrInserireUserHost.setText("Inserire host database:");
		txtrInserireUserHost.setBounds(10, 11, 141, 22);
		contentPane.add(txtrInserireUserHost);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(10, 84, 538, 20);
		contentPane.add(textPane_1);
		
		JTextArea txtrInserireUrlusername = new JTextArea();
		txtrInserireUrlusername.setBackground(SystemColor.menu);
		txtrInserireUrlusername.setText("Inserire url database:");
		txtrInserireUrlusername.setFont(new Font("Arial", Font.BOLD, 12));
		txtrInserireUrlusername.setBounds(10, 63, 131, 22);
		contentPane.add(txtrInserireUrlusername);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(10, 136, 538, 20);
		contentPane.add(textPane_1_1);
		
		JTextArea txtrInserirePasswordDatabase = new JTextArea();
		txtrInserirePasswordDatabase.setBackground(SystemColor.menu);
		txtrInserirePasswordDatabase.setText("Inserire password database:");
		txtrInserirePasswordDatabase.setFont(new Font("Arial", Font.BOLD, 12));
		txtrInserirePasswordDatabase.setBounds(10, 115, 175, 22);
		contentPane.add(txtrInserirePasswordDatabase);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.setBackground(SystemColor.controlHighlight);
		btnEsci.setFont(new Font("Arial", Font.BOLD, 12));
		btnEsci.setBounds(346, 177, 95, 29);
		contentPane.add(btnEsci);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setBackground(SystemColor.controlShadow);
		btnConferma.setFont(new Font("Arial", Font.BOLD, 12));
		btnConferma.setBounds(453, 178, 95, 26);
		contentPane.add(btnConferma);
		btnConferma.addActionListener(e -> {
			
			//cosa succede se schiaccio i bottoni
			
		});
		
		}
	}
