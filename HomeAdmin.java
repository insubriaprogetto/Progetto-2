import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;

public class HomeAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAdmin frame = new HomeAdmin();
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
	public HomeAdmin() {
		setTitle("Home Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrHomeAdmin = new JTextArea();
		txtrHomeAdmin.setBackground(SystemColor.menu);
		txtrHomeAdmin.setText("Home Admin:");
		txtrHomeAdmin.setFont(new Font("Arial", Font.BOLD, 20));
		txtrHomeAdmin.setBounds(136, 11, 146, 28);
		contentPane.add(txtrHomeAdmin);
		
		JButton btnNewButton = new JButton("Modifica profilo");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(121, 50, 171, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Visualizza statistiche");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(121, 89, 171, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Lista giocatori registrati\r\n ");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2.setBounds(121, 128, 171, 28);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Lista partite");
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_3.setBounds(121, 167, 171, 28);
		contentPane.add(btnNewButton_3);
	}

}
