package org.homework.step3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputView {
    // private static final Scanner scanner = new Scanner(System.in);
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

//    public int readMenuOption() {
//        // System.out.println("메뉴를 선택하세요: ");
//        return Integer.parseInt(scanner.nextLine());

//    }
    public int readTodoId() {
        System.out.println("찾을 ID를 입력하세요: ");
        // return Integer.parseInt(scanner.nextLine());
        while (!scanner.hasNextInt()) {
            System.out.println("유효한 숫자를 입력해주세요.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String readTodoTitle() {
        System.out.print("할 일 제목을 입력하세요: ");
        // return scanner.nextLine();
        return scanner.next();
    }

    public LocalDate readDueDate() {
        System.out.print("마감일을 입력하세요.(yyyy-MM-dd)");
        String input = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(input, formatter);
        } catch (DateTimeException e) {
            System.out.println("유효한 날짜 형식이 아닙니다.");
            return readDueDate();
        }
    }

    public int readAction() {
        while (!scanner.hasNextInt()) {
            System.out.println("유효한 선택지를 입력해주세요.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
