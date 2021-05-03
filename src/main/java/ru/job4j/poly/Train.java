package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по рельсам.");
    }

    public static void main(String[] args) {
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle plane1 = new Plane();
        Vehicle plane2 = new Plane();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle[] vehicles = {train1, train2, plane1, plane2, bus1, bus2};
        for (Vehicle v: vehicles) {
            v.move();
        }
    }
}