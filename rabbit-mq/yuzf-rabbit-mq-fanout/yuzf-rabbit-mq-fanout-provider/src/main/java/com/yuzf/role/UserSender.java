package com.yuzf.role;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserSender {
	
	@Autowired
	private AmqpTemplate rabbitMqTemplate;
	
	@Value("${mq.config.exchange}")
	private String exchange;
	
	public void send() {
		this.rabbitMqTemplate.convertAndSend(this.exchange,"user.log.debug", "user.log.debug...............");
		this.rabbitMqTemplate.convertAndSend(this.exchange,"user.log.info", "user.log.info...............");
		this.rabbitMqTemplate.convertAndSend(this.exchange,"user.log.warn", "user.log.warn...............");
		this.rabbitMqTemplate.convertAndSend(this.exchange,"user.log.error", "user.log.error...............");
	}
	
}
