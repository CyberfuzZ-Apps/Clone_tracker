package ru.job4j.stream;

import java.util.Objects;

public class PupilBuilder {
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
        PupilBuilder pupilBuilder = (PupilBuilder) o;
        return age == pupilBuilder.age
                && score == pupilBuilder.score
                && classLeader == pupilBuilder.classLeader
                && Objects.equals(name, pupilBuilder.name)
                && Objects.equals(surname, pupilBuilder.surname)
                && Objects.equals(middleName, pupilBuilder.middleName)
                && Objects.equals(gender, pupilBuilder.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, middleName, gender, age, score, classLeader);
    }

    @Override
    public String toString() {
        return "PupilBuilder{"
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

        PupilBuilder build() {
            PupilBuilder pupilBuilder = new PupilBuilder();
            pupilBuilder.name = name;
            pupilBuilder.surname = surname;
            pupilBuilder.middleName = middleName;
            pupilBuilder.gender = gender;
            pupilBuilder.age = age;
            pupilBuilder.score = score;
            pupilBuilder.classLeader = classLeader;
            return pupilBuilder;
        }
    }

    public static void main(String[] args) {
        PupilBuilder pupilBuilder = new PupilBuilder.Builder()
                .buildName("Evgeniy")
                .buildAge((byte) 10)
                .buildScore(90)
                .build();
        System.out.println(pupilBuilder);
    }
}
