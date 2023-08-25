package app.thread;

/**
 * @author dimmy
 */
public class SynchronizeTest {
    public void p() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() +  "A" + i);
            }
        }
    }
}
