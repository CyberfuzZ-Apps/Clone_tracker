package ru.job4j.casting;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по дороге.");
    }
}
