package app.timewheel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author dimmy
 */
public class ScheduleWorker {
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private ExecutorService executor = Executors.newFixedThreadPool(3);

    public void work() {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            TimeWheel timeWheel = TimeWheel.getInstance();
            long timeStamp = System.currentTimeMillis();
            List<Task> tasks = timeWheel.get(timeStamp);
            tasks.forEach(task -> executor.execute(() -> {
                task.execute();
                timeWheel.delete(task);
            }));
            System.out.println("execute task, time stamp =" + formatTime(timeStamp));
        }, 0, 1, TimeUnit.SECONDS);
    }

    public String formatTime(long time) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        res = simpleDateFormat.format(date);
        return res;
    }
}
