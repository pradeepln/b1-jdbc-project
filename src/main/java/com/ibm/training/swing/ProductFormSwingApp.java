package com.ibm.training.swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ProductFormSwingApp implements ItemListener {
	
	//declarations of ui components
	JFrame frame = new JFrame("Hello Swing!");
	JPanel contentPane = new JPanel();
	JLabel lblName = new JLabel("Product Name");
	JLabel lblPrice = new JLabel("Product Price");
	JLabel lblQoh = new JLabel("Qty On Hand");
	JTextField txtName = new JTextField(15);
	JTextField txtPrice = new JTextField(15);
	JTextField txtQoh = new JTextField(15);
	JButton btnOk = new JButton("Save");
	JButton btnCancel = new JButton("Cancel");
	JTextField txtStatus = new JTextField(15);
	
	//Look and Feel
	String[] looks = {"Metal","Motif","Windows","Nimbus","Mac"};
	JComboBox<String> comboLNF = new JComboBox<>(looks);
	
	//init ui
	ProductFormSwingApp(){
		frame.setSize(300, 300);
		frame.setLocation(300, 300);
		
		contentPane.add(lblName);
		contentPane.add(txtName);
		contentPane.add(lblPrice);
		contentPane.add(txtPrice);
		contentPane.add(lblQoh);
		contentPane.add(txtQoh);
		contentPane.add(btnOk);
		contentPane.add(btnCancel);
		contentPane.add(txtStatus);
		txtStatus.setEditable(false);
		contentPane.add(comboLNF);
		comboLNF.addItemListener(this);
		frame.setContentPane(contentPane);
		
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new ProductFormSwingApp();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String newSelection = (String) comboLNF.getSelectedItem();
		try {
			switch (newSelection) {
			case "Windows":
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				break;
			case "Motif":
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				break;
			case "Nimbus":
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				break;
			case "Mac":
				UIManager.setLookAndFeel("javax.swing.plaf.mac.MacLookAndFeel");

				break;
			case "Metal":
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				break;
			}
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
