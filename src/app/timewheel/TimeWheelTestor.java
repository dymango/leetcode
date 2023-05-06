package app.timewheel;

/**
 * @author dimmy
 */
public class TimeWheelTestor {
    public static void main(String[] args) {
        TimeWheel timeWheel = TimeWheel.getInstance();
        timeWheel.put(() -> System.out.println("I'm execute in 30s"), new TimePoint(2021, 10,18, 16, 14,0).format());
        ScheduleWorker scheduleWorker = new ScheduleWorker();
        scheduleWorker.work();
    }
}
