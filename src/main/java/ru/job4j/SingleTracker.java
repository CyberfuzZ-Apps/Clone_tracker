package ru.job4j;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public final class SingleTracker {
    private static Tracker tracker = null;

    private SingleTracker() {

    }

    private static Tracker getTracker() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        return getTracker().add(item);
    }

    public Item findById(int id) {
        return getTracker().findById(id);
    }

    public Item[] findAll() {
        return getTracker().findAll();
    }

    public Item[] findByName(String key) {
        return getTracker().findByName(key);
    }

    public boolean replace(int id, Item item) {
        return getTracker().replace(id, item);
    }

    public boolean delete(int id) {
        return getTracker().delete(id);
    }
}
