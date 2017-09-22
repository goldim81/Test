package com.Lesson052;

public class Counter {
    volatile private int counter;
//    Object locker;

    public Counter(Integer counter, Object locker) {
//        this.counter = counter;
//        this.locker = locker;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
