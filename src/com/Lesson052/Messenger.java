package com.Lesson052;

public class Messenger implements Runnable {
    Integer counter;
    byte timer;
//    Object locker;

    public Messenger(Integer c, byte t, Object locker) {
        this.counter = c;
        this.timer = t;
//        this.locker = locker;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Main.count) {
                try {
                    Main.count.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Main.count % timer == 0) {
                    System.out.println(Main.count);
                }
            }
        }
    }
}
