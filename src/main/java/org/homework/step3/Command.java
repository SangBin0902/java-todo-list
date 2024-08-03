package org.homework.step3;

public enum Command {
    ADD,
    REMOVE,
    VIEW,
    COMPLETE,
    VIEW_ALL,
    EXIT;

    public static Command fromInt(int input) {
        switch (input) {
            case 1:
                return ADD;
            case 2:
                return REMOVE;
            case 3:
                return VIEW;
            case 4:
                return COMPLETE;
            case 5:
                return VIEW_ALL;
            case 6:
                return EXIT;
            default:
                throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}