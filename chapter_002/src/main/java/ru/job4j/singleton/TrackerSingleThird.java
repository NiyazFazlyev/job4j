package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingleThird {
    private static final TrackerSingleThird INSTANCE = new TrackerSingleThird();

    private TrackerSingleThird() {
    }

    public static TrackerSingleThird getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        TrackerSingleThird tracker = TrackerSingleThird.getInstance();
    }

    public Item add(Item model) {
        return model;
    }
}