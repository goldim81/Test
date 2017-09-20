package com.java.goldim;

public class Pair <T extends Number> {
    private T fild1;
    private T fild2;
    //TODO что сделать если типа полей выходит за границы double

    public T getFild1() {
        return fild1;
    }

    public void setFild1(T fild1) {
        this.fild1 = fild1;
    }

    public T getFild2() {
        return fild2;
    }

    public void setFild2(T fild2) {
        this.fild2 = fild2;
    }

    public Number plus () {
        return fild1.intValue() + fild2.intValue();

    }

    public Number minus () {
        return fild1.intValue() - fild2.intValue();
    }

    public Number del () {
        return fild1.doubleValue()/fild2.doubleValue();
    }

    public Number umn () {
        return fild1.intValue()*fild2.intValue();

    }
}
