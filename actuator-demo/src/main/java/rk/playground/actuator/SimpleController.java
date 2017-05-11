package rk.playground.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple REST Endpoint
 */
@RestController
public class SimpleController {

    private TpsHealth tpsHealth;

    @Autowired
    @Qualifier("counterService")
    private CounterService counterService;

    @Autowired
    @Qualifier("gaugeService")
    private GaugeService gaugeService;

    @Autowired
    public SimpleController(TpsHealth tpsHealth) {
        this.tpsHealth = tpsHealth;
    }

    @RequestMapping("/")
    public String sayHello() {
        this.counterService.increment("sayHello.txnCount");
        this.gaugeService.submit("sayHello.customGauge", 1.0);
        tpsHealth.updateTx();
        return ("Hello from the actuator demo");
    }
}
