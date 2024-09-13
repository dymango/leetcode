package leetcodepractice.executor;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.util.concurrent.Executors.newThreadPerTaskExecutor;

/**
 * @author dimmy
 */
public class VirtualThread {

    public static void main(String[] args) throws InterruptedException {
//        Thread.Builder.OfVirtual thread  = ThreadPools.virtualThreadBuilder("vir" + "-");   // used in single thread, no need to use factory()
//        for (int i = 0; i < 20; i++) {
//            int tag = i;
//            thread.start(() -> {
//                try {
//                    Thread.sleep(2000);
//                    System.out.println("delay" + tag);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }
        executeTaskWithTP();
        Thread.sleep(10000);
    }

    private static void executeTaskWithTP() {
        try (var executorService = Executors.newFixedThreadPool(10)) {
            for (int i = 0; i < 20; i++) {
                executorService.submit(() -> {
                    try {
                        Thread.sleep(Duration.ofSeconds(5));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName());
                });
            }
        }
    }

    private static void executeTaskWithVT() throws InterruptedException {
        ThreadFactory factory = Thread.ofVirtual().name("custome", 10).factory();

        try (var executorService = newThreadPerTaskExecutor(factory)) {
            for (int i = 0; i < 20; i++) {
                executorService.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(5));
                    System.out.println("name" + Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().isVirtual());
                    System.out.println(Thread.currentThread().threadId());
                    return Thread.currentThread().getName();
                });
            }
        }  // executor.close() is called implicitly, and waits
        Thread.sleep(10000);
    }

    private static Runnable createTask() {
        return () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("task finish");
        };
    }
}
