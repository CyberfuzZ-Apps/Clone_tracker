package ru.job4j.inheritance;

public class Builder extends Engineer {
    private int category;

    public Builder(String name, String surname, String education, String birthday,
                   String specialization, int category) {
        super(name, surname, education, birthday, specialization);
        this.category = category;
    }

    public void drawing() {
    }

    public void calculations() {
    }
}
