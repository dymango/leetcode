package app.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author dimmy
 */
public class Item implements Delayed {
    public int score;
    public long startTime;

    public Item(int score, long startTime) {
        this.score = score;
        this.startTime = startTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long time = startTime - System.currentTimeMillis();
        return unit.convert(time, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
    }
}
