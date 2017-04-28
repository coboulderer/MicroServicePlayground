package rk.playground.customer.notification;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ Listener
 */
@Component
public class Receiver {

    @Autowired
    private Mailer mailer;

    @Bean
    Queue queue() {
        return new Queue("CustomerQ", false);
    }

    @RabbitListener(queues = "CustomerQ")
    public void processMessage(String emailAddress) {
        System.out.println(emailAddress);
        mailer.sendMail(emailAddress);
    }
}
