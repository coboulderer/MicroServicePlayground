package rk.playground;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller
 */
@RestController
public class GreetingController {

    @RequestMapping("/")
    Greet sayHello() {
        return new Greet("Hello From Spring Boot!!");
    }
}
