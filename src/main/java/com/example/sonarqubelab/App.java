package com.example.sonarqubelab;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        int total = add(10, 5);
        if (total <= 0) {
            throw new IllegalStateException("Invalid calculation result");
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
