
//package ia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton Button_Inscription;
	public String champPseudo;
	public String champMDP;
	boolean loginButton = false;
	boolean creerButton = false;
	public boolean closeButtonValue = false;
	
	/* Lance l'application 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/* Création de la fenêtre */
	
	public LoginGUI() {
	
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(320, 180, 630, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(174, 103, 279, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(174, 173, 279, 38);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				champPseudo = textField.getText();
				champMDP = String.valueOf(passwordField.getPassword());
				loginButton = true;
			}
		});
		btnNewButton.setBackground(UIManager.getColor("desktop"));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnNewButton.setBounds(174, 247, 117, 29);
		contentPane.add(btnNewButton);
		
		Button_Inscription = new JButton("Créer un compte");
		Button_Inscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creerButton = true;
			}
		});
		Button_Inscription.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Button_Inscription.setBackground(new Color(255, 165, 0));
		Button_Inscription.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Button_Inscription.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		Button_Inscription.setBounds(303, 247, 150, 29);
		contentPane.add(Button_Inscription);
		
		JButton btnCrerUnCompte = new JButton("Close");
		btnCrerUnCompte.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCrerUnCompte.setBackground(new Color(255, 0, 0));
		btnCrerUnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeButtonValue = true;
				dispose(); //ferme la page si on clique sur close
			}
		});
		btnCrerUnCompte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrerUnCompte.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnCrerUnCompte.setBounds(521, 304, 103, 29);
		contentPane.add(btnCrerUnCompte);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(UIManager.getColor("ComboBox.disabledBackground"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(263, 20, 92, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("mot de passe");
		lblMotDePasse.setBounds(70, 178, 92, 33);
		contentPane.add(lblMotDePasse);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(102, 103, 25, 38);
		contentPane.add(lblId);
		
		setUndecorated(true); // permet de suprimer le bouton fermer en haut 
	}
}




