package org.homework.step3;

import java.util.List;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printTodoList(List<Todo> todoList) {
//        System.out.println("할 일 목록: ");
//        for(Todo todo : todoList) {
//            System.out.println(todo);
//        }

        if(todoList.isEmpty()) {
            printMessage("할 일이 없습니다.");
        } else {
            for (Todo todo : todoList) {
                System.out.println(todo);
            }
        }
    }

    public void printTodoDetails(Todo todo) {
        if (todo != null) {
            System.out.println(todo);
        } else {
            printMessage("해당 할 일을 찾을 수 없습니다.");
        }
    }
}
