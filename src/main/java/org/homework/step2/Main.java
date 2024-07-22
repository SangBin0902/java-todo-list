package org.homework.step2;

public class Main {
    public static void main(String[] args) {
        TodoRepository todoRepository = new TodoRepository();
        TodoService todoService = new TodoService(todoRepository);
        TodoController todoController = new TodoController(todoService);
        todoController.run();
    }
}
