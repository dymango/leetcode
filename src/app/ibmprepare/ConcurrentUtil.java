package app.ibmprepare;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dimmy
 */
public class ConcurrentUtil {

    public static void main(String[] args) {
        ConcurrentUtil concurrentUtil = new ConcurrentUtil();
        concurrentUtil.exec();
        List<String> strings = List.of("1");
        List<Integer> strings2 = List.of(1);
        System.out.println(compare(strings, strings2));
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Thread a = new Thread(() -> {
            int i = 1;
            while (true) {
                threadLocal.set(i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();

        Thread b = new Thread(() -> {
            int i = 100;
            while (true) {
                threadLocal.set(i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        b.start();
        threadLocal.get();

        while (true) {
            int shj = 1;
        }

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    public static int get() {
        try {
            System.out.println("ab");
            return 1;
        } finally {
            System.out.println("cd");
            return 10;
        }
    }

    public static <T, Y> boolean compare(List<T> list, List<Y> list2) {
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            if (!t.equals(list2.get(i))) return false;
        }

        return true;
    }

    public void exec() {
        ThreadFactory threadFactory = new ThreadFactoryImpl("a");
        ExecutorService executorService = Executors.newSingleThreadExecutor(threadFactory);
        executorService.execute(() -> {
            System.out.println("ExecutorService future");
            System.out.println(Thread.currentThread().getName());
        });


//        try {
//            executorService_future.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("CompletableFuture");
//            int i = 1/0;
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 7;
        }, executorService).exceptionally(throwable -> {
            System.out.println(throwable.getMessage());
            return null;
        });
//

        Integer integer1 = null;
        try {
            integer1 = completableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer1);
        System.out.println("jhaiosjdhjlasd");
        completableFuture.whenComplete((integer, throwable) -> {
            System.out.println("whenComplete: " + integer);
        });
//
//        CompletableFuture<Integer> linkCompletableFuture = completableFuture.thenApply(integer -> {
//            System.out.println("thenApply completableFuture");
//            return 10;
//        });
//
//        CompletableFuture.allOf(completableFuture, linkCompletableFuture).whenComplete((unused, throwable) -> {
//            try {
//                Integer integer = completableFuture.get();
//                Integer integer1 = linkCompletableFuture.get();
//                System.out.println("CompletableFuture.allOf: " + Integer.sum(integer1, integer));
//            } catch (InterruptedException e) {
//
//
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });
//
//        linkCompletableFuture.thenAccept(integer -> {
//            System.out.println("thenAccept completableFuture" + integer);
//            int i = 1 / 0;
//        }).exceptionally(throwable -> {
//            System.out.println(throwable.getMessage());
//            return null;
//        });
//
//        try {
//            System.out.println(completableFuture.get());
////            System.out.println(linkCompletableFuture.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println("start");
    }

    static class ThreadFactoryImpl implements ThreadFactory {
        private final AtomicInteger count = new AtomicInteger(1);
        private final String prefix;

        ThreadFactoryImpl(String prefix) {
            this.prefix = prefix;
        }

        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, prefix + count.getAndIncrement());
            System.out.println("custom thread" + count);
            return thread;
        }
    }
}
