package com.ibm.training.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.ibm.training.jdbc.Product;
import com.ibm.training.jdbc.ProductDAO;

public class ProductFormUIApp extends Frame implements ActionListener{
	Label lblName = new Label("Product Name");
	Label lblPrice = new Label("Product Price");
	Label lblQoh = new Label("Qty on Hand");
	TextField txtName = new TextField(15);
	TextField txtPrice = new TextField(15);
	TextField txtQoh = new TextField(15);
	Button btnOk = new Button("Save My Data Please");
	Button btnCancel = new Button("Cancel");
	
	TextField lblStatus = new TextField(15);
	
	ProductFormUIApp(){
		super("Product Creation Form");
		this.setSize(300, 300);
		this.setLocation(300, 300);
		
		Panel panel = new Panel();
		panel.add(lblName);
		panel.add(txtName);
		panel.add(lblPrice);
		panel.add(txtPrice);
		panel.add(lblQoh);
		panel.add(txtQoh);
		panel.add(btnOk);
		panel.add(btnCancel);
		panel.add(lblStatus);
		
		this.add(panel);
		
		btnCancel.addActionListener(this);
		btnOk.addActionListener(this);
		lblStatus.setEditable(false);
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ProductFormUIApp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object srcOfEvent = e.getSource();
		if(srcOfEvent == btnCancel) {
			txtName.setText("");
			txtPrice.setText("");
			txtQoh.setText("");
		}else if(srcOfEvent == btnOk) {
			String nameText = txtName.getText();
			String priceText = txtPrice.getText();
			String qohText = txtQoh.getText();
			
			float price = 0;
			
			try {
				price = Float.parseFloat(priceText);
			} catch (NumberFormatException e2) {
				txtPrice.setForeground(Color.RED);
				return;
			}
			
			int qoh = 0;
			try {
				qoh = Integer.parseInt(qohText);
			} catch (NumberFormatException e2) {
				txtQoh.setForeground(Color.RED);
				return;
			}
			
			Product p = new Product(nameText,price,qoh);
			ProductDAO dao = new ProductDAO();
			int id = dao.save(p);
			
			lblStatus.setText("Saved with Id: "+id);
			txtName.setText("");
			txtPrice.setText("");
			txtQoh.setText("");
			txtPrice.setForeground(Color.BLACK);
			txtQoh.setForeground(Color.BLACK);
		}
	}
}
