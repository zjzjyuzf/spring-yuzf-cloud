package com.yuzf.eureka.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yuzf.eureka.consumer.domain.Product;

@Service
public class ProductService {

	@Autowired
	private LoadBalancerClient loadBalancerClient; //ribbon 负载均衡客户端   获取ip和端口号
	
	public List<Product> listProduct(){
		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provider");
		StringBuffer sb = new StringBuffer();
		sb.append("http://");
		sb.append(serviceInstance.getHost());
		sb.append(":");
		sb.append(serviceInstance.getPort());
		sb.append("/list");
		
		System.out.println(sb);
		
		RestTemplate restTemplate = new RestTemplate();
		
		ParameterizedTypeReference<List<Product>> parameterizedTypeReference = new ParameterizedTypeReference<List<Product>>() {
		};
		
		ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(sb.toString(), HttpMethod.GET, null, parameterizedTypeReference);
				
		
		List<Product> list = responseEntity.getBody();
		
		
		return list;
	}
	
}
