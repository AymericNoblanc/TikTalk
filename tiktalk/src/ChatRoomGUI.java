//package fenetre;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextArea;

public class ChatRoomGUI extends JFrame {

	private JPanel contentPane;
	private JTextField msg_text;
	public JLabel lblNewLabel;

	/*Lance l'application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatRoomGUI frame = new ChatRoomGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/* Cr�ation de la fen�tre */
	public ChatRoomGUI() {
		setBackground(new Color(0, 0, 139));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		msg_text = new JTextField();
		msg_text.setBounds(6, 515, 481, 42);
		contentPane.add(msg_text);
		msg_text.setColumns(10);
		
		JButton msg_send = new JButton("Envoyer");
		msg_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		msg_send.setBounds(487, 519, 107, 36);
		contentPane.add(msg_send);
		
		lblNewLabel = new JLabel("Chat Room");
		lblNewLabel.setFont(new Font("Monaco", Font.PLAIN, 25));
		lblNewLabel.setBounds(36, 6, 400, 42);
		contentPane.add(lblNewLabel);
		
		TextArea textArea = new TextArea();
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setBounds(232, 71, 358, 438);
		contentPane.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBackground(new Color(255, 250, 240));
		textArea_1.setBounds(6, 71, 221, 438);
		contentPane.add(textArea_1);
	}
}
