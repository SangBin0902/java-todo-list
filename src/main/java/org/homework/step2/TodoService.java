package org.homework.step2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TodoService {
    private final TodoRepository todoRepository;
    private Map<Integer, String> todos;

    public TodoService (TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void addTodo(String title) {
        Todo todo = new Todo(title);
        todoRepository.add(todo);
        System.out.println("할 일이 추가되었습니다. ID: " + todo.getId());
    }

    public void removeTodo(int id) {
        Todo todo = todoRepository.findById(id);
        if(todo != null) {
            todoRepository.remove(todo);
            System.out.println("할 일이 삭제되었습니다. ID: " + todo.getId());
        } else {
            throw new IllegalArgumentException("해당 ID를 찾을 수 없습니다.");
        }
    }

    public List<Todo> getAllTodos() { return todoRepository.findAll();}

    public String viewTodoById(int id) {
        Todo todo = todoRepository.findById(id);
        if(todo != null) {
            return todo.toString();
        } else {
            return "해당 ID를 찾을 수 없습니다.";
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
