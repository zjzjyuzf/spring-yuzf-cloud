package com.yuzf.role;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {
	
	@Autowired
	private AmqpTemplate rabbitMqTemplate;
	
	@Value("${mq.config.exchange}")
	private String exchange;
	
	public void send() {
		this.rabbitMqTemplate.convertAndSend(this.exchange,"order.log.debug", "order.log.debug...............");
		this.rabbitMqTemplate.convertAndSend(this.exchange,"order.log.info", "order.log.info...............");
		this.rabbitMqTemplate.convertAndSend(this.exchange,"order.log.warn", "order.log.warn...............");
		this.rabbitMqTemplate.convertAndSend(this.exchange,"order.log.error", "order.log.error...............");
	}
	
}
