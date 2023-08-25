package app.thread;

/**
 * @author dimmy
 */
public class Main {

    public static void main(String[] args) {
        new Thread(() -> new SynchronizeTest().p()).start();
        new Thread(() -> new SynchronizeTest().p()).start();

    }
}
