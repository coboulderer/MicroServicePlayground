package rk.playground.customer.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Implementation for Sender
 */
@Service
@Lazy
public class SenderImpl implements Sender{

    @Autowired
    private RabbitMessagingTemplate template;

    @Bean
    Queue queue() {
        return new Queue("CustomerQ", false);
    }

    @Override
    public void send(String message) {
        template.convertAndSend("CustomerQ", message);
    }
}
