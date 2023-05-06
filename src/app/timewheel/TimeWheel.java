package app.timewheel;


import java.util.List;

/**
 * @author dimmy
 */
public class TimeWheel {
    public int timePerUnit = 1;
    public int wheelLength = 60;
    public Node[] nodes;
    public long baseTimeStamp = System.currentTimeMillis();

    private TimeWheel() {
        nodes = new NodeImpl[wheelLength];
    }

    private static class TimeWheelHolder {
        private static final TimeWheel timeWheel = new TimeWheel();
    }

    public static TimeWheel getInstance() {
        return TimeWheelHolder.timeWheel;
    }

    public List<Task> get(long timeStamp) {
        int seconds = (int) ((timeStamp - baseTimeStamp) / (timePerUnit * 1000));
        int round = seconds / wheelLength;
        int position = seconds % wheelLength;
        Node node = nodes[position];
        if (node == null) node = new NodeImpl();
        List<Task> tasks = node.getTasks(round);
        return tasks;
    }

    public void put(Action action, long executeTime) {
        int seconds = (int) ((executeTime - baseTimeStamp) / (timePerUnit * 1000));
        int round = seconds / wheelLength;
        int position = seconds % wheelLength;
        Task task = new TaskImpl(round, position, executeTime, action);
        Node node = nodes[position];
        if (node == null) {
            nodes[position] = new NodeImpl();
        }

        nodes[position].put(task);
    }

    public void delete(Task task) {
        int position = task.position();
        Node node = nodes[position];
        node.deleteTask(task.id());
    }
}
