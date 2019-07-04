package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingleFourth {
    private TrackerSingleFourth() {
    }

    public static TrackerSingleFourth getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        TrackerSingleFourth tracker = TrackerSingleFourth.getInstance();
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingleFourth INSTANCE = new TrackerSingleFourth();
    }
}
