package rk.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller
 */
@RestController
public class GreetingController {

    private static Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    private Environment env;

    @RequestMapping("/")
    Greet sayHello() {
        logger.info("bootrest.customproperty == " + env.getProperty("bootrest.customproperty"));
        return new Greet("Hello From Spring Boot!!");
    }
}
