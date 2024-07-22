package org.homework.step2;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMenu() {
        System.out.println("옵션을 선택하세요. 1. 추가, 2. 삭제, 3. 조회, 4. 완료, 5. 종료");
    }

    public static void printTodoList(List<Todo> todoList) {
        System.out.println("할 일 목록: ");
        for(Todo todo : todoList) {
            System.out.println(todo);
        }
    }
}
