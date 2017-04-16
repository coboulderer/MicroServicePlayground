package rk.playground.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMessagingApplication implements CommandLineRunner {

    @Autowired
    Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMessagingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sender.send("Hello From RabbitMQ");
    }
}
