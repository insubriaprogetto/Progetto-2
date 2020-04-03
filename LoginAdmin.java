import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class LoginAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
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
	public LoginAdmin() {
		setTitle("Registrazione Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 53, 530, 20);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(10, 147, 530, 20);
		contentPane.add(textPane_1);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setBackground(SystemColor.menu);
		txtrPassword.setFont(new Font("Arial", Font.BOLD, 12));
		txtrPassword.setText("Password:");
		txtrPassword.setBounds(10, 123, 71, 22);
		contentPane.add(txtrPassword);
		
		JTextArea txtrInserireEmailO = new JTextArea();
		txtrInserireEmailO.setText("Inserire email o nome admin:");
		txtrInserireEmailO.setFont(new Font("Arial", Font.BOLD, 12));
		txtrInserireEmailO.setBackground(SystemColor.menu);
		txtrInserireEmailO.setBounds(10, 33, 177, 22);
		contentPane.add(txtrInserireEmailO);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Arial", Font.BOLD, 12));
		btnConferma.setBounds(451, 198, 89, 29);
		contentPane.add(btnConferma);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.setFont(new Font("Arial", Font.BOLD, 12));
		btnEsci.setBounds(352, 198, 89, 29);
		contentPane.add(btnEsci);
	}

}
