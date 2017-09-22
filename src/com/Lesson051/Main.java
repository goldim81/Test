package com.Lesson051;

public class Main {

    volatile static int count = 0;

    public static void main(String[] args) {

        Thread th1 = new Thread(() -> {
            do {
                count++;
//                System.out.println("th1: " + count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);

        }, "th1");

        Thread th2 = new Thread(() -> {
            do {
                System.out.println("th2: " + count);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }, "th2");
        Thread th3 = new Thread(() -> {
            do {
                System.out.println("th3: " + count);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }, "th3");
        th1.start();
        th2.start();
        th3.start();
    }
}
