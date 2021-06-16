package ru.job4j.stream;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PupilTest {

    @Test
    public void createPupilByBuilder() {
        Pupil pupil = new Pupil.Builder()
                .buildName("Evgeniy")
                .buildAge((byte) 10)
                .buildScore(90)
                .build();
        assertThat(pupil.toString(), is("Pupil{name='Evgeniy', "
                + "surname='null', "
                + "middleName='null', "
                + "gender='null', "
                + "age=10, "
                + "score=90, "
                + "classLeader=false}"));
    }
}