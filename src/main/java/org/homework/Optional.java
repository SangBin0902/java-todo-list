package org.homework;

public class Optional {

    public static void main(String[] args) {

        // Optional
        // 1. 널처리 강제 (널포인트 방지)

        java.util.Optional<Object> o = java.util.Optional.ofNullable(null);

        // o.map();
        // o.orElse();
        // o.orElseGet();
        // o.orElseThrow();
    }
}
