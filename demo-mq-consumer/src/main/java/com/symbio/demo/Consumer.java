package com.symbio.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {
	@JmsListener(destination = "sample.queue", containerFactory="jmsListenerContainerQueue")
	@SendTo("out.queue")
    public void receiveQueue(String text) {
        log.info("queue >> {}", text);
    }
	
	@JmsListener(destination = "sample.topic", containerFactory="jmsListenerContainerTopic")
    public void receiveTopic(String text) {
        log.info("topic >> {}", text);
    }
}
