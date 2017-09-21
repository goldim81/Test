package com.Lesson4;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student s01 = new Student("Иван", "Иванович", "Иванов", Date.parse("1981/03/01"), 17, (short)1);
        Student s02 = new Student("Петр", "Петрович", "Петров", Date.parse("1981/02/01"), 20, (short)2);
        Student s03 = new Student("Сидор", "Сидорович", "Сидоров", Date.parse("1981/04/01"), 61, (short)3);
        Student s04 = new Student("Сергей", "Сергеевич", "Сергеев", Date.parse("1981/04/01"), 22, (short)4);


        Group group01 = new Group(1, "Группа1");
        group01.add(s01);
        group01.add(s02);
        group01.add(s03);


        Group group02 = new Group (2, "Группа2");
        group02.add(s01);
        group02.add(s04);

        Set<Group> groups = new HashSet<>();
        groups.add(group01);
        groups.add(group02);

        //Проверка чтения и записи студентов
        MySerializationAction.serializeStudents(group01.getStudents());
        Set<Student> restoreStudents = MySerializationAction.readStudents();
        for (Student st:restoreStudents) {
            System.out.println(st);
        }

//        //Проверка записи и чтения групп
//        MySerializationAction.serializeGroups(groups);
//        Set<Group> restoreGroups = MySerializationAction.readGroups();
//        if (restoreGroups!=null) {
//            for (Group gr : restoreGroups) {
//                gr.printGroup();
//            }
//        }else System.out.println("Ошибка восстановления списка групп");

//        //Проверка записи / Чтения журнала уроков
//        Lesson lesson01 = new Lesson("Тема1", Date.parse("2017/09/21"), (short)1, "Артем");
//
//        Jornal jornal1 = new Jornal(lesson01, group02.getStudents(), groups);
//
//        MySerializationAction.serializeJornal(jornal1);
//        MySerializationAction.readJornal().printJornal();

    }
}
