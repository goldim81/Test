package com.Lesson4;

import java.io.Serializable;

public class Lesson implements Serializable{
    private final String topic;
    private final long dateTime;
    private final short roomNum;
    private final String teacher;

    public Lesson(String topic, long dateTime, short roomNum, String teacher) {
        this.topic = topic;
        this.dateTime = dateTime;
        this.roomNum = roomNum;
        this.teacher = teacher;
    }

    public String getTopic() {
        return topic;
    }

    public long getDateTime() {
        return dateTime;
    }

    public short getRoomNum() {
        return roomNum;
    }

    public String getTeacher() {
        return teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lesson)) return false;

        Lesson lesson = (Lesson) o;

        if (getDateTime() != lesson.getDateTime()) return false;
        if (getRoomNum() != lesson.getRoomNum()) return false;
        if (!getTopic().equals(lesson.getTopic())) return false;
        return getTeacher().equals(lesson.getTeacher());
    }

    @Override
    public int hashCode() {
        int result = getTopic().hashCode();
        result = 31 * result + (int) (getDateTime() ^ (getDateTime() >>> 32));
        result = 31 * result + (int) getRoomNum();
        result = 31 * result + getTeacher().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Урок на тему: " + topic;
    }
}
