package app.thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dimmy
 */
public class CustomizeThreadPool {

    public List<Thread> threads;

    public void get() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() -> {
            System.out.println(1111);
        });
    }
}
