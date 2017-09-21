package com.Lesson4;

import java.util.HashSet;
import java.util.Set;

public class Jornal {
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
}
