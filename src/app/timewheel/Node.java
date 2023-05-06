package app.timewheel;

import java.util.List;

/**
 * @author dimmy
 */
public interface Node {
    void put(Task task);

    void deleteTask(int round);

    void deleteTask(String taskId);

    List<Task> getTasks(int round);
}
