package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public enum TrackerSingleFirst {
    INSTANCE; // здесь мы указываем перечисления.

    // Конструкторы и методы.
    static {
        System.out.println("Class loaded");
    }

    public Item add(Item model) {
        return model;
    }
}
