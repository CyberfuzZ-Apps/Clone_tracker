package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery() {
    }

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(50);
        Battery battery2 = new Battery(20);
        battery1.exchange(battery2);
        System.out.println(battery2.load);
        System.out.println(battery1.load);
    }
}