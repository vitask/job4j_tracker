package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Олегов Олег Олегович");
        student.setGroup("ФК - 1305");
        student.setEntered(new Date());
        System.out.println("ФИО студента: " + student.getFullName()
                + "\nГруппа № " + student.getGroup()
                + "\nДата поступления: " + student.getEntered());
    }
}
