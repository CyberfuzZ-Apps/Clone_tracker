package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void addressCollect() {
        List<Profile> profileList = List.of(
                new Profile(new Address("Moscow", "Lubyanka", 4, 12)),
                new Profile(new Address("Kostroma", "Lenina", 45, 3)),
                new Profile(new Address("Bryansk", "Sovetskaya", 32, 5)));
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(profileList);
        List<Address> expected = List.of(
                new Address("Moscow", "Lubyanka", 4, 12),
                new Address("Kostroma", "Lenina", 45, 3),
                new Address("Bryansk", "Sovetskaya", 32, 5)
        );
        assertThat(rsl, is(expected));
    }
}