package com.Lesson4;

import java.io.*;

public class MySerializationAction {
    static void serializeGroup (Group group) throws IOException {
        File file = new File("group.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(group);

    }

    static Group readGroup () throws IOException, ClassNotFoundException {
        File file = new File("group.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Group group = (Group) ois.readObject();
        return group;

    }


}
