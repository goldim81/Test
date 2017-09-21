package com.Lesson4;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Jornal implements Serializable{
    private Lesson lesson;
    private Set<Student> presentStudents = new HashSet<>();
    private Set<Group> group = new HashSet<>();

    public Jornal(Lesson lesson, Set<Student> presentStudents, Set<Group> group) {
        this.lesson = lesson;
        this.presentStudents = presentStudents;
        this.group = group;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Set<Student> getPresentStudents() {
        return presentStudents;
    }

    public void setPresentStudents(Set<Student> presentStudents) {
        this.presentStudents = presentStudents;
    }

    public Set<Group> getGroup() {
        return group;
    }

    public void setGroup(Set<Group> group) {
        this.group = group;
    }

    public void printJornal () {

        //Объеденяем список стундентов в группах с исключением дубликатов
        Set<Group> grSet = getGroup();
        Group[] groups = grSet.toArray(new Group[grSet.size()]);

        Set<Student> lStud1 = groups[0].getStudents();
        Set<Student> allStudent = new HashSet<>();
        for (Group gr: groups) {
            allStudent.addAll(gr.getStudents());
        }

        //Вывод на консоль
        Set<Student> presSt = getPresentStudents();
        System.out.println(getLesson());
        for (Student st:allStudent) {
            String  fio = st.getFamilyName() + " " + st.getFirstName() + " " + st.getSecondName();
            String topic = getLesson().getTopic();
            String dateLesson = new Date(getLesson().getDateTime()).toString();
            String attended = presSt.contains(st) ? "Был" : "Нет";
            System.out.println(fio + " | " + topic + " | " + dateLesson + " | " + attended);
        }
        System.out.println("Всего учеников: " + allStudent.size() + " Присутсвовало на уроке: " + presSt.size());


    }
}
