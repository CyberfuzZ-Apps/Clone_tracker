package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String specification;

    public Doctor(String name, String surname, String education, String birthday,
                  String specification) {
        super(name, surname, education, birthday);
        this.specification = specification;
    }

    public void diagnostics() {
    }

    public void therapy() {
    }
}
