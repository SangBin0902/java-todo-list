package org.homework.step3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Todo {

    // private static int counter = 0;
    private int id;
    private String title;
    private boolean isCompleted;
    private LocalDate dueDate;

    public Todo(int id, String title, boolean isCompleted, LocalDate dueDate) {
        // this.id = ++counter;
        this.id = id;
        this.title = title;
        this.isCompleted = false;
        this.dueDate = dueDate;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dueDateString = dueDate != null ? dueDate.format(formatter) : "없음";

        return "ID: " + id + ", " + title + ", " + isCompleted + ", 마감일: " + dueDateString;
    }
}
