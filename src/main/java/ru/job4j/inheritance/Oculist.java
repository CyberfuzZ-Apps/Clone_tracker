package ru.job4j.inheritance;

public class Oculist extends Doctor {
    private boolean eyeSurgeon;

    public Oculist(String name, String surname, String education, String birthday,
                   String specification, boolean eyeSurgeon) {
        super(name, surname, education, birthday, specification);
        this.eyeSurgeon = eyeSurgeon;
    }

    public void checkVision() {
    }

    public void laserVisionCorrection() {
    }
}
