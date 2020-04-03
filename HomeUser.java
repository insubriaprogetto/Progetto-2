import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class HomeUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUser frame = new HomeUser();
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
	public HomeUser() {
		setTitle("Home User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrHomeAdmin = new JTextArea();
		txtrHomeAdmin.setBounds(186, 12, 123, 28);
		txtrHomeAdmin.setBackground(SystemColor.menu);
		txtrHomeAdmin.setText("Home User:");
		txtrHomeAdmin.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(txtrHomeAdmin);
		
		JButton btnNewButton = new JButton("Crea una nuova partita");
		btnNewButton.setBounds(155, 51, 198, 28);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Unisciti a una partita");
		btnNewButton_1.setBounds(155, 90, 198, 28);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Visualizza partite disponibili");
		btnNewButton_2.setBounds(155, 129, 198, 28);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Lista partite in corso");
		btnNewButton_3.setBounds(155, 168, 198, 28);
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Visualizza statistiche");
		btnNewButton_4.setBounds(155, 207, 198, 28);
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Modifica profilo");
		btnNewButton_4_1.setBounds(155, 246, 198, 28);
		btnNewButton_4_1.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(btnNewButton_4_1);
	}

}
