package com.yuzf.eureka.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yuzf.eureka.provider.domain.Product;

@RestController
public class ProductController {

	@RequestMapping(value= "list" ,method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public List<Product> productList(){
		
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1,"james"));
		list.add(new Product(2,"wade"));
		list.add(new Product(3,"kobe"));
		return list;
	}
	
	
	
	
}
