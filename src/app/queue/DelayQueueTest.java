package app.queue;

import app.timewheel.TimePoint;

import java.util.concurrent.DelayQueue;

/**
 * @author dimmy
 */
public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        Item item = new Item(1, new TimePoint(2021, 10, 19, 11, 42, 0).format());
        Item item2 = new Item(3, new TimePoint(2021, 10, 19, 11, 42, 20).format());
        Item item3 = new Item(5, new TimePoint(2021, 10, 19, 11, 42, 25).format());
        Item item4 = new Item(6, new TimePoint(2021, 10, 19, 11, 42, 40).format());
        DelayQueue<Item> items = new DelayQueue<>();
        items.offer(item);
        items.offer(item2);
        items.offer(item3);
        items.offer(item4);
        while (true) {
            Item poll = items.take();
            System.out.println(poll.score);
        }
    }
}
