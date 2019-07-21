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
        int index = 0;
        if (tasks.isEmpty()) {
            tasks.add(0, task);
        }
        for (Task t : tasks) {
            if (t.getPriority() > task.getPriority()) {
                tasks.add(index, task);
                break;
            }
            index++;
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
