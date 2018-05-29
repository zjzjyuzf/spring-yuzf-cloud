package com.yuzf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuzf.role.OrderSender;
import com.yuzf.role.ProductSender;
import com.yuzf.role.UserSender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YuzfRabbitMqApplication.class)
public class YuzfRabbitMqApplicationTests {

	@Autowired
	private UserSender userSender;
	
	@Autowired
	private ProductSender productSender;
	
	@Autowired
	private OrderSender orderSender;
	
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void send() throws Exception {
			this.userSender.send();
			this.productSender.send();
			this.orderSender.send();
			
	}

}
