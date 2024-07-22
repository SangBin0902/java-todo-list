package org.homework.step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    public void run() {
        while(true) {
            OutputView.printMenu();
            int option = InputView.readMenuOption();

            try {
                Command command = Command.fromValue(option);

                switch (command) {
                    case ADD:
                        handleAdd();
                        break;
                    case REMOVE:
                        handelRemove();
                        break;
                    case VIEW:
                        handleSearch();
                        break;
                    case COMPLETE:
                        handleComplete();
                        break;
                    case EXIT:
                        OutputView.printMessage("프로그램을 종료합니다.");
                        return;
                    default:
                        OutputView.printMessage("올바른 옵션을 선택하세요.");
                        break;

                }
            } catch (IllegalArgumentException e) {
                OutputView.printMessage("잘못된 입력입니다.");
            }
        }
    }

    private void handleAdd() {
        String title = InputView.readTodoTitle();
        todoService.addTodo(title);
    }

    private void handelRemove() {
        int id = InputView.readTodoId();
        try {
            todoService.removeTodo(id);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private void handleView() {
        List<Todo> todoList = todoService.getAllTodos();
        OutputView.printTodoList(todoList);
    }

    private void handleSearch() {
        int id = InputView.readTodoId();
        try {
            String todoTitle = todoService.viewTodoById(id);
            System.out.println(todoTitle);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private void handleComplete() {
        int id = InputView.readTodoId();
        try {
            todoService.completeTodoById(id);
            OutputView.printMessage("할 일이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }
}
