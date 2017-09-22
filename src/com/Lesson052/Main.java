package com.Lesson052;

public class Main {
    static Integer count = 0;
    public static void main(String[] args) {
        Integer count = 0;
        Object locker = new Object();

        Counter counter = new Counter(count, locker);
        Messenger messenger = new Messenger(count, (byte) 5, locker);
        Messenger messenger2 = new Messenger(count, (byte) 7, locker);

        new Thread(counter).start();
        new Thread(messenger).start();
        new Thread(messenger2).start();
    }
}
