package com.symbio.demo;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableScheduling
public class Producer {
	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;
    
    @Autowired
    private Topic topic;
    
    @Scheduled(fixedDelay = 3000)
    // 每3s执行1次
    public void send() {
        log.info(">> send queue !!!");
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ queue");
    }
    
    @Scheduled(fixedDelay = 5000)
    // 每5s执行1次
    public void topic() {
        log.info(">> send topic !!!");
        this.jmsMessagingTemplate.convertAndSend(this.topic, "hi,activeMQ topic");
    }
    
    @JmsListener(destination = "out.queue")
    public void consumerMsg(String msg){
        System.out.println(msg);
    }

}
