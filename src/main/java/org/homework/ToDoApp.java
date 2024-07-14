package org.homework;

import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("할 일을 입력하세요.");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    System.out.print("삭제할 ID를 입력하세요.");
                    int removeId = scanner.nextInt();
                    toDoList.removeTask(removeId);
                    break;
                case 3:
                    int viewId = Integer.parseInt(scanner.nextLine());
                    Task task = toDoList.getTaskById(viewId);
                    if(task != null) {
                        System.out.println(task);
                    } else {
                        System.out.println("해당 ID의 할 일이 없습니다.");
                    }
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}
