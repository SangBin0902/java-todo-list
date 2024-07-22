package org.homework.step2;

public enum Command {
    ADD(1),
    REMOVE(2),
    VIEW(3),
    COMPLETE(4),
    EXIT(5);

    private final int value;

    Command(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Command fromValue(int value) {
        for (Command command : values()) {
            if(command.getValue() == value) {
                return command;
            }
        }
        throw new IllegalArgumentException("Invalid command value: " + value);
    }
}