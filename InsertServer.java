import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InsertServer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertServer frame = new InsertServer();
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
	public InsertServer() {
		setTitle("Inserire Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 36, 414, 20);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(10, 100, 414, 20);
		contentPane.add(textPane_1);
		
		JTextArea txtrInserireMailServer = new JTextArea();
		txtrInserireMailServer.setBackground(SystemColor.menu);
		txtrInserireMailServer.setFont(new Font("Arial", Font.BOLD, 12));
		txtrInserireMailServer.setText("Inserire mail server:");
		txtrInserireMailServer.setBounds(10, 14, 127, 22);
		contentPane.add(txtrInserireMailServer);
		
		JTextArea txtrInserirePasswordServer = new JTextArea();
		txtrInserirePasswordServer.setBackground(SystemColor.menu);
		txtrInserirePasswordServer.setText("Inserire password server:");
		txtrInserirePasswordServer.setFont(new Font("Arial", Font.BOLD, 12));
		txtrInserirePasswordServer.setBounds(10, 78, 162, 22);
		contentPane.add(txtrInserirePasswordServer);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.setFont(new Font("Arial", Font.BOLD, 12));
		btnEsci.setBounds(226, 149, 95, 23);
		contentPane.add(btnEsci);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Arial", Font.BOLD, 12));
		btnConferma.setBounds(331, 149, 95, 23);
		contentPane.add(btnConferma);
	}
}

