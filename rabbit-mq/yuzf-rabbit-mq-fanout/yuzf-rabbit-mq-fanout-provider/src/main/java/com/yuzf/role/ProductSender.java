package com.yuzf.role;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductSender {
	
	@Autowired
	private AmqpTemplate rabbitMqTemplate;
	
	@Value("${mq.config.exchange}")
	private String exchange;
	
	public void send() {
		this.rabbitMqTemplate.convertAndSend(this.exchange,"product.log.debug", "product.log.debug...............");
		this.rabbitMqTemplate.convertAndSend(this.exchange,"product.log.info", "product.log.info...............");
		this.rabbitMqTemplate.convertAndSend(this.exchange,"product.log.warn", "product.log.warn...............");
		this.rabbitMqTemplate.convertAndSend(this.exchange,"product.log.error", "product.log.error...............");
	}
	
}
