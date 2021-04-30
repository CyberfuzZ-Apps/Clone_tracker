package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String programmingLanguage;

    public Programmer(String name, String surname, String education, String birthday,
                      String specialization, String programmingLanguage) {
        super(name, surname, education, birthday, specialization);
        this.programmingLanguage = programmingLanguage;
    }

    public void writeProgram() {
    }

    public void writeTests() {
    }
}
