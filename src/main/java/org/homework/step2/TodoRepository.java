package org.homework.step2;

import org.homework.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoRepository {
    private Map<Integer, Todo> todoMap = new HashMap<>();

    public void add(Todo todo) {
        todoMap.put(todo.getId(), todo);
    }

    public void remove(Todo todo) {
        todoMap.remove(todo.getId(), todo);
    }

    public Todo findById(int id) {
        return todoMap.get(id);
    }

    public List<Todo> findAll() {
        return new ArrayList<>(todoMap.values());
    }
}
