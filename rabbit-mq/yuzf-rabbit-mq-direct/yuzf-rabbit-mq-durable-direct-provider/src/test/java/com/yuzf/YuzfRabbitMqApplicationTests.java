package com.yuzf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuzf.role.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YuzfRabbitMqApplication.class)
public class YuzfRabbitMqApplicationTests {

	@Autowired
	private Sender sender;
	
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void send() throws Exception {
		for (int i = 0; i < 200; i++) {
			Thread.sleep(2000);
			this.sender.send(i);
		}
	}

}
