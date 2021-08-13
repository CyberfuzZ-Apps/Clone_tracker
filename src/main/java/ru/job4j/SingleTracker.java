package ru.job4j;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;

import java.util.List;

public final class SingleTracker {
    private static MemTracker memTracker;

    private SingleTracker() {

    }

    public static MemTracker getTracker() {
        if (memTracker == null) {
            memTracker = new MemTracker();
        }
        return memTracker;
    }

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public boolean delete(int id) {
        return memTracker.delete(id);
    }
}
