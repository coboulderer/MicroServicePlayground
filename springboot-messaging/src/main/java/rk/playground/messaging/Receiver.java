package rk.playground.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "Test_Queue")
    public void processMessage(String content) {
        System.out.println(content);
    }
}
