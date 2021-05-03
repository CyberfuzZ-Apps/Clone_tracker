package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void drive() {

    }

    @Override
    public void passengers(int number) {

    }

    @Override
    public double refuel(int quantity) {
        return 0;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по дороге.");
    }
}
