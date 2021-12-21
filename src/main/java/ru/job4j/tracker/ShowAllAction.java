package ru.job4j.tracker;

import ru.job4j.tracker.react.Observe;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Show all items ===");
        tracker.findAllByReact(out::println);
        return true;
    }
}
