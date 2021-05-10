package ru.job4j;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public final class SingleTracker {
    private static Tracker tracker = new Tracker();

    private SingleTracker() {

    }

    public static Tracker getTracker() {
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
