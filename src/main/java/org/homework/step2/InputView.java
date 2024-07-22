package org.homework.step2;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readMenuOption() {
        // System.out.println("메뉴를 선택하세요: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String readTodoTitle() {
        System.out.println("할 일 제목을 입력하세요: ");
        return scanner.nextLine();
    }

    public static int readTodoId() {
        System.out.println("찾을 ID를 입력하세요: ");
        return Integer.parseInt(scanner.nextLine());
    }

}
