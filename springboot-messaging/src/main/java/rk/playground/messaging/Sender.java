package rk.playground.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    RabbitMessagingTemplate rabbitMessagingTemplate;

    @Bean
    Queue queue() {
        return new Queue("Test_Queue", false);
    }

    public void send(String message) {
        rabbitMessagingTemplate.convertAndSend("Test_Queue", message);
    }
}
