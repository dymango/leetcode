package app.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dimmy
 */
public class DeadLock {

    public ReentrantLock lockA;
    public ReentrantLock lockB;

    public void run() throws InterruptedException {
        lockA = new ReentrantLock();
        lockB = new ReentrantLock();
        new Thread(() -> {
            for (; ; ) {
                lockA.lock();
                System.out.println(Thread.currentThread().getName() + " lock A");
                lockB.lock();
                System.out.println(Thread.currentThread().getName() + " lock B");
                lockA.unlock();
                lockB.unlock();
            }

        }).start();

        Thread.sleep(10);
        new Thread(() -> {
            for (; ; ) {
                lockB.lock();
                System.out.println(Thread.currentThread().getName() + " lock B");
                lockA.lock();
                System.out.println(Thread.currentThread().getName() + " lock A");
                lockB.unlock();
                lockA.unlock();
            }

        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        new DeadLock().run();
    }
}
