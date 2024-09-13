package app.thread;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
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
        Map<String, Integer> map = new ConcurrentHashMap<>();
        var voidCompletionStage = CompletableFuture.completedStage(2).thenAcceptAsync(integer -> {

        });

        var future = CompletableFuture.allOf(
            CompletableFuture.supplyAsync(() -> {

//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

                for (int i = 0; i < 10000; i++) {
                    map.merge("ID", 1, Integer::sum);
                }

                System.out.printf("execute thread: %s \n", Thread.currentThread().getName());
                throw new RuntimeException("A");
            }),
            CompletableFuture.supplyAsync(() -> {
                for (int i = 0; i < 29000; i++) {
                    map.merge("ID", 1, Integer::sum);
                }
                System.out.printf("execute thread: %s \n", Thread.currentThread().getName());
                return 1;
            }),
            CompletableFuture.supplyAsync(() -> {
                for (int i = 0; i < 11000; i++) {
                    map.merge("ID", 1, Integer::sum);
                }
                System.out.printf("execute thread: %s \n", Thread.currentThread().getName());
                return 1;
            })
        ).exceptionally(throwable -> {
            System.out.printf("%s - %s", Thread.currentThread().getName(), throwable.getMessage());
            return null;
        });

        var objectCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            var complete = future.complete(null);
            System.out.printf("complete %s", complete);
            return null;
        });
        objectCompletableFuture.join();
        try {
            future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(map.get("ID"));

        var integerCompletableFuture = new CompletableFuture<Integer>();
        integerCompletableFuture.completeAsync(() -> {
            System.out.println("integerCompletableFuture");
            return 1;
        }).handleAsync((integer, throwable) -> System.out.printf("result: %d", integer));
        try {
            integerCompletableFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        var id = CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 11000; i++) {
                map.merge("ID", 1, Integer::sum);
            }

            return 1;
        });
        id.handleAsync((integer, throwable) -> System.out.printf("result: %d", integer));
//        completableFuture.handleAsync((s, throwable) -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(10);
//            return "2";
//        }).thenAccept(s -> {
//            System.out.println(s);
//        }).thenRun(() -> {
//        });


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
            Thread.sleep(1000);
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
