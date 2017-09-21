package com.Lesson4;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Group implements Serializable {
    private final int groupNum;
    private final String groupName;
    private Set<Student> students = new HashSet<>();

    public Group(int gNum, String gName) {
        this.groupNum = gNum;
        groupName = gName;
    }

    public void add (Student student) {
        students.add(student);
    }

    public void remove (Student student) {
        students.remove(students);
    }

    public int getGroupNum() {
        return groupNum;
    }

    public String getGroupName() {
        return groupName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group group = (Group) o;

        if (groupNum != group.groupNum) return false;
        return groupName.equals(group.groupName);
    }

    @Override
    public int hashCode() {
        int result = groupNum;
        result = 31 * result + groupName.hashCode();
        return result;
    }
}
