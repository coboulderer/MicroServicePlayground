package rk.playground.legacy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Legacy Spring Home Controller
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public Greet sayHello() {
        return new Greet("Hello, Legacy REST Controller!");
    }
}
