import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setTitle("Registrazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrComeTiVuoi = new JTextArea();
		txtrComeTiVuoi.setBackground(SystemColor.menu);
		txtrComeTiVuoi.setFont(new Font("Arial", Font.BOLD, 20));
		txtrComeTiVuoi.setText("Chi si vuole registrare?");
		txtrComeTiVuoi.setBounds(99, 29, 230, 38);
		contentPane.add(txtrComeTiVuoi);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(49, 99, 136, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("User");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(248, 99, 129, 38);
		contentPane.add(btnNewButton_1);
	}
}
