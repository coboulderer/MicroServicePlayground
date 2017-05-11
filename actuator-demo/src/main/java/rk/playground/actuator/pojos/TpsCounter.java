package rk.playground.actuator.pojos;

import java.util.Calendar;
import java.util.concurrent.atomic.LongAdder;

/**
 * POJO for holding Transactions Per Second info
 */
public class TpsCounter {

    private LongAdder count;
    private int threshold;
    private Calendar expiry;

    public TpsCounter() {
        count = new LongAdder();
        expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, 1);
        this.threshold = 2;
    }

    public boolean isExpired() {
        return Calendar.getInstance().after(expiry);
    }

    public boolean isWeak() {
        return (count.intValue() > threshold);
    }

    public void increment() {
        count.increment();
    }
}
