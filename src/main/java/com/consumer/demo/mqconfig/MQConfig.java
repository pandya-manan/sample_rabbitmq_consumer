package com.consumer.demo.mqconfig;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
	
	public static final String QUEUE="test_quorum";
	public static final String EXCHANGE="test_exchange";
	public static final String ROUTINGKEY="test_routing_key_quorum";
	
	
	@Bean
	public Queue queue()
	{
		return new Queue(QUEUE);
	}
	
	@Bean
	public TopicExchange exchange()
	{
		return new TopicExchange(EXCHANGE);
	}
	
	@Bean
	public Binding binding(Queue queue,TopicExchange exchange)
	{
		return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY);
	}
	
	@Bean
	 public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }
	
	 @Bean
	 public AmqpTemplate template(ConnectionFactory connectionFactory) {
	        RabbitTemplate template = new RabbitTemplate(connectionFactory);
	        template.setMessageConverter(messageConverter());
	        return  template;
	 }

}
