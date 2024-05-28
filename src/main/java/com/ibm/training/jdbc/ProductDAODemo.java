package com.ibm.training.jdbc;

import java.util.List;
import java.util.Optional;

public class ProductDAODemo {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		
		Product testData = new Product("sample1", 1234f, 127);
		
//		int id = dao.save(testData);
//		System.out.println("Inserted product with id: "+id);
		
//		Optional<Product> o = dao.findById(5);
//		if(o.isPresent()) {
//			System.out.println(o.get());
//		}else {
//			System.out.println("not found");
//		}
		
//		List<Product> all = dao.findAll();
//		all.forEach(p -> System.out.println(p));
		
//		Product p = o.get();
//		p.setName("changed!!");
//		p.setPrice(3456f);
//		
//		int rows = dao.update(p);
//		System.out.println("Updated "+rows+" row(s)");
		
		System.out.println(dao.deleteById(4));
		
	}

}
