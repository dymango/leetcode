package app.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author dimmy
 */
public class ConcurrentUtil {

    public Semaphore semaphore = new Semaphore(5);
    CyclicBarrier cyclicBarrier;
    CountDownLatch count;
    CompletableFuture<Semaphore> completableFuture =  new CompletableFuture<Semaphore>();


    public void run() {

    }
}
