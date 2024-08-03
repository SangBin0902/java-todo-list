package org.homework.step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoRepository {
    private Map<Integer, Todo> todoMap = new HashMap<>();
    private int nextId;

    public void add(Todo todo) {

        todoMap.put(todo.getId(), todo);
    }

    public void remove(int id) {

        // todoMap.remove(todo.getId(), todo);
        if (!todoMap.containsKey(id)) {
            throw new IllegalArgumentException("해당 ID를 찾을 수 없습니다.");
        }
        todoMap.remove(id);
    }

    public Todo findById(int id) {
        return todoMap.get(id);
    }

    public List<Todo> findAll() {
        return new ArrayList<>(todoMap.values());
    }

    public  int getNextId() {
        return ++nextId;
    }
}
