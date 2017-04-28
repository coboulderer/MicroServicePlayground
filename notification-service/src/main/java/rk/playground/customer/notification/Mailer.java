package rk.playground.customer.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Mail Service
 */
@Component
public class Mailer {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String emailAddress) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailAddress);
        simpleMailMessage.setSubject("Registration Notification");
        simpleMailMessage.setText("Registration Successful.");
        javaMailSender.send(simpleMailMessage);
    }
}
