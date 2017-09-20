package com.goldim;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialize {
    public static void main(String[] args) {
        //Чтение данных из текстового файла
        List <Student> stList = new ArrayList<>();
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] arg1 = line.split(" ");
                String name = arg1[0].split("=")[1];
                int age = 0;
                try {
                    age = Integer.parseInt(arg1[1].split("=")[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат числа.");
                }
                stList.add(new Student(name, age));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student st:stList) {
            System.out.println(st.toString());
        }
        writeAllObj(stList, "student.dat");
        List<Student> stList2 = readAllObj("student.dat");

        for (Student st:stList) {
            System.out.println(st.toString());
        }

    }

    private static void writeAllObj (List<Student> stList, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeInt(stList.size());
            for (Student st:stList) {
                oos.writeObject(st);
            }
        }catch (IOException e) {
            System.out.println("Ошибка записи объекта в файл");
        }
    }

    private static List<Student> readAllObj (String fileName) {
        List<Student> stList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            int size = ois.readInt();
            for (int i = 0; i < size; i++) {
                stList.add((Student) ois.readObject());
            }

        }catch (IOException e) {
            System.out.println("Ошибка записи объекта в файл");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stList;
    }

}

class Student implements Serializable {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
