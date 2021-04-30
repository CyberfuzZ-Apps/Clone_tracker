package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private boolean dentistSurgeon;

    public Dentist(String name, String surname, String education, String birthday,
                   String specification, boolean dentistSurgeon) {
        super(name, surname, education, birthday, specification);
        this.dentistSurgeon = dentistSurgeon;
    }

    public void implantation() {
    }

    public void teethWhitening() {
    }

    public void toothExtraction() {
    }
}
