//package fenetre;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextArea;
import java.util.LinkedList;

public class ChatRoomGUI extends JFrame {

	public JPanel contentPane;
	public JTextField msg_text;
	public JTextField addContactField;
	public JLabel lblNewLabel;
	public LinkedList<Contact> cList;
	public JList<Contact> cJList;
	public JList<Message> mJList;
	public DefaultListModel<Contact> model;
	public DefaultListModel<Message> modelMessage;
	public int indexSelected;
	public JButton msg_send;
	private JButton addContactButton;
	public Boolean addContactButtonValue;
	public boolean boutonEnvoyer;
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

	/* Création de la fenêtre */
	public ChatRoomGUI() {
		//this.cList = cList;
		setBackground(new Color(0, 0, 139));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(400, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addContactButtonValue = false;
		msg_text = new JTextField();
		msg_text.setBounds(6, 515, 481, 42);
		//contentPane.add(msg_text);
		msg_text.setColumns(10);
		
		msg_send = new JButton("Envoyer");
		msg_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boutonEnvoyer = true;
			}
		});
		msg_send.setBounds(487, 519, 107, 36);
		//contentPane.add(msg_send);
		
		lblNewLabel = new JLabel("Chat Room");
		lblNewLabel.setFont(new Font("Monaco", Font.PLAIN, 25));
		lblNewLabel.setBounds(36, 6, 400, 42);
		contentPane.add(lblNewLabel);
		/*
		TextArea textArea = new TextArea();
		textArea.setBackground(new Color(255, 250, 240));
		textArea.setBounds(232, 71, 358, 438);
		contentPane.add(textArea);
		*/
		cJList = new JList<>();
		model= new DefaultListModel<>();
		cJList.setModel(model);
		
		mJList = new JList<>();
		modelMessage= new DefaultListModel<>();
		mJList.setModel(modelMessage);
		
       // for(int num=0; num<cList.size(); num++)
        //{
      	  //model.addElement(cList.get(num));//.getContactPseudo());
       // }
        
        //for(int num=0; num<cList.size(); num++)
        //{
      	//  System.out.println(cList.get(num).getContactPseudo() );//.getContactPseudo());
        //}
		contentPane.add(msg_text);
		contentPane.add(msg_send);
		
		JScrollPane sp = new JScrollPane(cJList);
		sp.setBackground(new Color(255, 250, 240));
		sp.setBounds(6, 71, 221, 438);
		contentPane.add(sp);
		
		JScrollPane sp2 = new JScrollPane(mJList);
		sp2.setBackground(new Color(255, 250, 240));
		sp2.setBounds(232, 71, 358, 438);
		contentPane.add(sp2);

		
		addContactField = new JTextField();
		addContactField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addContactField.setBounds(6, 575, 150, 25);
		addContactField.setColumns(10);
		addContactField.setText("Ajouter un contact");
		addContactField.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	addContactField.setText("");
		    	addContactField.setBackground(Color.WHITE);
		    }

		    public void focusLost(FocusEvent e) {
		        // nothing
		    }
		});
		contentPane.add(addContactField);
		
		addContactButton = new JButton("Ajouter");
		addContactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addContactButtonValue = true;
				addContactField.setBackground(Color.RED);
			}
		});
		addContactButton.setBounds(170, 570, 100, 30);
		contentPane.add(addContactButton);
		/*
		TextArea textArea_1 = new TextArea();
		textArea_1.setBackground(new Color(255, 250, 240));
		textArea_1.setBounds(6, 71, 221, 438);
		contentPane.add(textArea_1);
	*/
	}

}
