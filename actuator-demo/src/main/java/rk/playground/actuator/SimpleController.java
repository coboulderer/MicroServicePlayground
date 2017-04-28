package rk.playground.actuator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple REST Endpoint
 */
@RestController
public class SimpleController {

    @RequestMapping("/")
    public String sayHello() {
        return ("Hello from the actuator demo");
    }
}
