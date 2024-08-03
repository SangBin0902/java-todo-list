package org.homework.step3;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TodoController {
    private TodoService todoService;
    private InputView inputView;
    private OutputView outputView;
    private boolean isRunning;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.isRunning = true;
    }

    private void handleAdd() {
        String title = inputView.readTodoTitle();
        LocalDate dueDate = inputView.readDueDate();
        todoService.addTodo(title, dueDate);
    }

    private void handelRemove() {
        int id = inputView.readTodoId();
        try {
            todoService.removeTodo(id);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
        }
    }

    private void handleView() {
        List<Todo> todoList = todoService.getAllTodos();
        // outputView.printTodoList(todoList);

        LocalDate today = LocalDate.now();
        LocalDate weekLater = today.plusWeeks(7);

        List<Todo> upcomingTodos = todoList.stream()
                .filter(todo -> !todo.getDueDate().isBefore(today) && !todo.getDueDate().isAfter(weekLater))
                .collect(Collectors.toList());

        Collections.sort(upcomingTodos, Comparator.comparing(Todo::getDueDate));
        outputView.printTodoList(upcomingTodos);
    }

    private void handleSearch() {
        int id = inputView.readTodoId();
        try {
            String todoTitle = todoService.viewTodoById(id);
            System.out.println(todoTitle);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
        }
    }

    private void handleComplete() {
        int id = inputView.readTodoId();
        try {
            todoService.completeTodoById(id);
            outputView.printMessage("할 일이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
        }
    }

    public void run() {
        while(isRunning) {
            outputView.printMessage("옵션을 선택하세요. 1. 추가, 2. 삭제, 3. 조회, 4. 완료, 5. 전체 조회, 6. 종료");
            int action = inputView.readAction();

            try {
                Command command = Optional.ofNullable(Command.fromInt(action))
                        .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));

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
                    case VIEW_ALL:
                        handleView();
                        break;
                    case EXIT:
                        outputView.printMessage("프로그램을 종료합니다.");
                        isRunning = false;
                        return;
                    default:
                        outputView.printMessage("올바른 옵션을 선택하세요.");
                        break;

                }
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
}
