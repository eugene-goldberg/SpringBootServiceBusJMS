package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiveController {

    private static final String TOPIC_NAME = "servicebustopic0001968";

    private static final String SUBSCRIPTION_NAME = "sbtopicsubscription0001968";

    private final Logger logger = LoggerFactory.getLogger(TopicReceiveController.class);

    @JmsListener(destination = TOPIC_NAME, containerFactory = "topicJmsListenerContainerFactory",
            subscription = SUBSCRIPTION_NAME)
    public void receiveMessage(User user) {
        logger.info("Received message from topic: {}", user.getName());
    }
}
