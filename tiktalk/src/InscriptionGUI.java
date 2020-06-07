

//package ia;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class InscriptionGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnValider;
	private JButton btnCrerUnCompte;
	public String champPseudo;
	public String champMDP;
	boolean validerButton = false;

	/*Lance l'application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionGUI frame = new InscriptionGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/* Création de la fenêtre */
	
	public InscriptionGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBounds(160, 143, 280, 36);
		textField.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setColumns(10);
		textField_1.setBounds(160, 222, 280, 36);
		contentPane.add(textField_1);
		
		lblNewLabel_2 = new JLabel("INSCRIPTION");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(160, 33, 255, 36);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("id");
		lblNewLabel_3.setBounds(163, 108, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("mot de passe");
		lblNewLabel_4.setBounds(160, 194, 92, 16);
		contentPane.add(lblNewLabel_4);
		
		btnValider = new JButton("Valider");
		btnValider.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnValider.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnValider.setBackground(Color.GREEN);
		btnValider.setBounds(180, 277, 103, 29);
		contentPane.add(btnValider);
		
		btnCrerUnCompte = new JButton("Close");
		btnCrerUnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); //ferme la page si on clique sur close
			}
		});
		btnCrerUnCompte.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		btnCrerUnCompte.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCrerUnCompte.setBackground(Color.RED);
		btnCrerUnCompte.setBounds(322, 277, 103, 29);
		contentPane.add(btnCrerUnCompte);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				champPseudo = textField.getText();
				champMDP = textField_1.getText();
	
				validerButton = true;
			}
		});
		setUndecorated(true); // permet de supprimer le bouton fermer en haut 
	}

}
