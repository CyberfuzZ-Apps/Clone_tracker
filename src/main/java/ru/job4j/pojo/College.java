package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Зайцев Евгений Владимирович");
        student.setGroup("Java");
        student.setDate(new Date());
        System.out.println("Студент " + student.getFio() + " зачислен в группу: "
                + student.getGroup() + " c " + student.getDate());
    }
}
