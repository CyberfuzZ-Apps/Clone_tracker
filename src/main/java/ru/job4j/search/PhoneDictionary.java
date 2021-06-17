package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = person -> person.getName().equals(key);
        Predicate<Person> surName = person -> person.getSurname().equals(key);
        Predicate<Person> phone = person -> person.getPhone().equals(key);
        Predicate<Person> address = person -> person.getAddress().equals(key);
        Predicate<Person> combine = name.or(surName).or(phone).or(address);
        var result = new ArrayList<Person>();
        for (var p : persons) {
            if (combine.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}
