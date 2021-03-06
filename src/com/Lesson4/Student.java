package com.Lesson4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String secondName;
    private String familyName;
    private final long bdate;
    private final int age;
    private short num;

    public Student(String firstName, String secondName, String familyName, long bdate, int age, short num) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.familyName = familyName;
        this.bdate = bdate;
        this.age = age;
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getBdate() != student.getBdate()) return false;
        return getNum() == student.getNum();
    }

    @Override
    public int hashCode() {
        int result = (int) (getBdate() ^ (getBdate() >>> 32));
        result = 31 * result + (int) getNum();
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public long getBdate() {
        return bdate;
    }

    public short getNum() {
        return num;
    }

    public void setNum(short num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Student{" +
                firstName + ' ' +
                secondName + ' ' +
                familyName + ", " +
                ", Возвраст: " + age +
                '}';
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        if (age >= 18) {
            stream.writeObject(this);
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.readObject();
        if (age <= 60) {

        }
    }
}
