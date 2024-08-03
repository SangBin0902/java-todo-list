package org.homework.step3;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TodoService {
    private TodoRepository todoRepository;
    // private Map<Integer, String> todos;

    public TodoService (TodoRepository todoRepository) {

        this.todoRepository = todoRepository;
    }

    public void addTodo(String title, LocalDate dueDate) {
        int id = todoRepository.getNextId();
        Todo todo = new Todo(id, title, false, dueDate);
        todoRepository.add(todo);
        System.out.println("할 일이 추가되었습니다. ID: " + todo.getId());
    }

    public void removeTodo(int id) {
        todoRepository.remove(id);
        System.out.println("할 일이 삭제되었습니다.");
    }

    public List<Todo> getAllTodos() { return todoRepository.findAll();}

    public String viewTodoById(int id) {
        Todo todo = todoRepository.findById(id);
        if(todo != null) {
            return todo.toString();
        } else {
            throw new IllegalArgumentException("해당 ID를 찾을 수 없습니다.");
        }
    }

    public void completeTodoById(int id) {
        Todo todo = todoRepository.findById(id);
        if(todo != null) {
            todo.complete();
        } else {
            throw new IllegalArgumentException("해당 ID를 찾을 수 없습니다.");
        }
    }
}
