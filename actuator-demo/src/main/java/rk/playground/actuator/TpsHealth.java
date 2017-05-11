package rk.playground.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import rk.playground.actuator.pojos.TpsCounter;

/**
 * New Actuator endpoint
 */
@Component
public class TpsHealth implements HealthIndicator{

    private TpsCounter tpsCounter;

    public TpsHealth() {
        tpsCounter = new TpsCounter();
    }

    @Override
    public Health health() {
        if (tpsCounter.isWeak()) {
            return Health.outOfService().withDetail("Too many requests", "OutOfService").build();
        } else {
            return Health.up().build();
        }
    }

    public void updateTx(){
        if (tpsCounter.isExpired()) {
            tpsCounter = new TpsCounter();
        }
        tpsCounter.increment();
    }
}
