package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingleSecond {
    private static TrackerSingleSecond instance;

    private TrackerSingleSecond() {
    }

    public static TrackerSingleSecond getInstance() {
        if (instance == null) {
            instance = new TrackerSingleSecond();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }
}
