package org.homework.step2;

public class Todo {

    private static int counter = 0;
    private int id;
    private String title;
    private boolean isCompleted;

    public Todo(String title) {
        this.id = ++counter;
        this.title = title;
        this.isCompleted = false;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void complete() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + title + ", " + (isCompleted ? "완료" : "미완료");
    }
}
