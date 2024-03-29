package com.symbio.demo;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoMqProducerApplication {
	@Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }
	
	@Bean
    public Topic topic() {
        return new ActiveMQTopic("sample.topic");
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoMqProducerApplication.class, args);
	}

}
