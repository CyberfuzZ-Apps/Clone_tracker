package ru.job4j.stream;

import java.util.Objects;

public class Pupil {
    private String name;
    private String surname;
    private String middleName;
    private String gender;
    private byte age;
    private int score;
    private boolean classLeader;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pupil pupil = (Pupil) o;
        return age == pupil.age
                && score == pupil.score
                && classLeader == pupil.classLeader
                && Objects.equals(name, pupil.name)
                && Objects.equals(surname, pupil.surname)
                && Objects.equals(middleName, pupil.middleName)
                && Objects.equals(gender, pupil.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, middleName, gender, age, score, classLeader);
    }

    @Override
    public String toString() {
        return "Pupil{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", middleName='" + middleName + '\''
                + ", gender='" + gender + '\''
                + ", age=" + age
                + ", score=" + score
                + ", classLeader=" + classLeader
                + '}';
    }

    static class Builder {
        private String name;
        private String surname;
        private String middleName;
        private String gender;
        private byte age;
        private int score;
        private boolean classLeader;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildScore(int score) {
            this.score = score;
            return this;
        }

        Builder buildClassLeader(boolean classLeader) {
            this.classLeader = classLeader;
            return this;
        }

        Pupil build() {
            Pupil pupil = new Pupil();
            pupil.name = name;
            pupil.surname = surname;
            pupil.middleName = middleName;
            pupil.gender = gender;
            pupil.age = age;
            pupil.score = score;
            pupil.classLeader = classLeader;
            return pupil;
        }
    }

    public static void main(String[] args) {
        Pupil pupil = new Pupil.Builder()
                .buildName("Evgeniy")
                .buildAge((byte) 10)
                .buildScore(90)
                .build();
        System.out.println(pupil);
    }
}
