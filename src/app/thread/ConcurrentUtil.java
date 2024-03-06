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
    CompletableFuture<String> completableFuture = new CompletableFuture<>();


    public void run() {
        completableFuture.handleAsync((s, throwable) -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(10);
            return "2";
        }).thenAccept(s -> {
            System.out.println(s);
        }).thenRun(() -> {});


//        CompletableFuture<String> f = completableFuture.completeAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(1);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "1";
//        });

        System.out.println("start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        try {
//            String s = completableFuture.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static void main(String[] args) {
        new ConcurrentUtil().run();
    }
}
