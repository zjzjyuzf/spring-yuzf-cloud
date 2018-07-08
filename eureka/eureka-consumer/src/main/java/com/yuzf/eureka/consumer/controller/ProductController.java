package com.yuzf.eureka.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yuzf.eureka.consumer.domain.Product;
import com.yuzf.eureka.consumer.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value= "list" ,method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public List<Product> productList(){
		
		List<Product> list = productService.listProduct();
		return list;
	}
	
	
	
	
}
