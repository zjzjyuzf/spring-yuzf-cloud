package com.yuzf.role;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	@Autowired
	private AmqpTemplate rabbitMqTemplate;
	
	@Value("${mq.config.exchange}")
	private String exchange;
	
	public void send() {
		String msg = "hello" + new Date();
		this.rabbitMqTemplate.convertAndSend(this.exchange,"", msg);
	}
	
}
