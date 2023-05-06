package app.timewheel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class NodeImpl implements Node {
    public List<Task> tasks;

    public NodeImpl() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void put(Task task) {
        tasks.add(task);
    }

    @Override
    public void deleteTask(int round) {
        tasks.removeIf(task -> task.round() == round);
    }

    @Override
    public void deleteTask(String taskId) {
        tasks.removeIf(task -> taskId.equals(task.id()));
    }

    @Override
    public List<Task> getTasks(int round) {
        return tasks.stream().filter(task -> task.round() == round).collect(Collectors.toList());
    }
}
