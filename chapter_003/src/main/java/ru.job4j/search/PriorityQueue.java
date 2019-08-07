package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        var index = 0;
        var success = false;
        if (tasks.isEmpty()) {
            tasks.add(0, task);
            success = true;
        }
        for (Task t : tasks) {
            if (t.getPriority() > task.getPriority()) {
                tasks.add(index, task);
                success = true;
                break;
            }
            index++;
        }
        if (!success) {
            tasks.addLast(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
