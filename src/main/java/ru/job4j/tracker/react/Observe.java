package ru.job4j.tracker.react;

/**
 * Класс Observe
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public interface Observe<T> {

    void receive(T model);

}
