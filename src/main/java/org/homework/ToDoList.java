package org.homework;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<Task> tasks;
    private int sequence;

    public ToDoList() {

        this.tasks = new ArrayList<>();
        this.sequence = 1;
    }

    public void addTask(String description) {
        Task task = new Task(sequence++, description);
        tasks.add(task);
        System.out.println("할 일이 추가되었습니다. ID: " + task.getId());
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("할 일이 삭제되었습니다. ID: ");
    }

    public Task getTaskById(int id) {
        for(Task task : tasks) {
            if(task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
