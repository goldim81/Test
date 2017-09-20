package com.java.goldim;

public class BoxGeneric <T extends Comparable> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void print () {
        System.out.println(value);
    }

    public int compareTo (T arg) {
        return this.value.compareTo(arg);
    }

}
