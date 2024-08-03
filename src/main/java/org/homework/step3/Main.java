package org.homework.step3;

public class Main {
    public static void main(String[] args) {
        TodoRepository todoRepository = new TodoRepository();
        TodoService todoService = new TodoService(todoRepository);
        TodoController todoController = new TodoController(todoService);
        todoController.run();
    }
}
