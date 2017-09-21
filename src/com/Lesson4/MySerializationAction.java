package com.Lesson4;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class MySerializationAction {

    static void serializeGroup (Group group){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("group.txt"))) {
            oos.writeObject(group);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void serializeGroups (Set<Group> groups){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("groups.txt"))) {
            oos.writeInt(groups.size());
            for (Group gr:groups) {
                oos.writeObject(gr);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Group readGroup () {
        File file = new File("group.txt");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (Group) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else System.out.println("Файл группы отсутствует.");
        return null;
    }

    static Set<Group> readGroups () {
        File file = new File("groups.txt");
        Set<Group> groups = new HashSet<>();
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                int size = ois.readInt();
                for (int i = 0; i < size; i++) {
                    groups.add((Group) ois.readObject());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return groups;
        } else System.out.println("Файл группы отсутствует.");
        return null;
    }

    static void serializeJornal (Jornal jornal){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("jornal.txt"))) {
            oos.writeObject(jornal);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Jornal readJornal () {
        File file = new File("jornal.txt");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (Jornal) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else System.out.println("Файл журнала отсутствует.");
        return null;
    }

    static void serializeStudents (Set<Student> students){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.txt"))) {
            oos.writeInt(students.size());
            for (Student st:students) {
                oos.writeObject(st);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Set<Student> readStudents () {
        File file = new File("students.txt");
        Set<Student> students = new HashSet<>();
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                int size = ois.readInt();
                for (int i = 0; i < size; i++) {
                    students.add((Student) ois.readObject());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return students;
        } else System.out.println("Файл группы отсутствует.");
        return null;
    }

}
