package com.ibm.training.servicelayer;

import com.ibm.training.jdbc.Product;
import com.ibm.training.jdbc.ProductDAO;

public class ProductService {
	
	
	ProductDAO dao;
	
	public ProductService(ProductDAO dao) {
		this.dao = dao;
	}

	public int addProduct(Product p) {
		if(p.getPrice() * p.getQoh() < 10_000) {
			throw new IllegalArgumentException("Can't add product if value is < 10k");
		}
		return dao.save(p);
	}
}
