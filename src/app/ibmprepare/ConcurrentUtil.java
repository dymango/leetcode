package app.ibmprepare;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author dimmy
 */
public class ConcurrentUtil {

    public static void main(String[] args) {
        ConcurrentUtil concurrentUtil = new ConcurrentUtil();
        concurrentUtil.exec();
    }

    public void exec() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> executorServiceFuture = executorService.submit(() -> {
            System.out.println("ExecutorService future");
            return 1;
        });

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("CompletableFuture");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 1;
        });

        completableFuture.whenComplete((integer, throwable) -> {
            System.out.println("whenComplete: " + integer);
        });

        CompletableFuture<Integer> linkCompletableFuture = completableFuture.thenApply(integer -> {
            System.out.println("thenApply completableFuture");
            return 10;
        });

        CompletableFuture.allOf(completableFuture, linkCompletableFuture).whenComplete((unused, throwable) -> {
            try {
                Integer integer = completableFuture.get();
                Integer integer1 = linkCompletableFuture.get();
                System.out.println("CompletableFuture.allOf: " + Integer.sum(integer1, integer));
            } catch (InterruptedException e) {


            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        linkCompletableFuture.thenAccept(integer -> {
            System.out.println("thenAccept completableFuture" + integer);
            int i = 1 / 0;
        }).exceptionally(throwable -> {
            System.out.println(throwable.getMessage());
            return null;
        });

        try {
            System.out.println(completableFuture.get());
//            System.out.println(linkCompletableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("start");
    }
}
