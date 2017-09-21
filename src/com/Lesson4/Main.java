package com.Lesson4;

import java.io.IOException;
import java.sql.Date;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Student s01 = new Student("Иван", "Иванович", "Иванов", Date.parse("1981/03/01"), (short)1);
        Student s02 = new Student("Петр", "Петрович", "Петров", Date.parse("1981/02/01"), (short)2);
        Student s03 = new Student("Сидор", "Сидорович", "Сидоров", Date.parse("1981/04/01"), (short)3);

        Group group01 = new Group(1, "Группа1");
        group01.add(s01);
        group01.add(s02);
        group01.add(s03);

        Lesson lesson01 = new Lesson("Тема1", Date.parse("2017/09/21"), (short)1, "Артем");

        Jornal jornal1 = new Jornal(lesson01, group01.getStudents(), Collections.singleton(group01));

        try {
            MySerializationAction.serializeGroup(group01);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Group restoredGroup = MySerializationAction.readGroup();
            System.out.println(restoredGroup.getGroupName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
