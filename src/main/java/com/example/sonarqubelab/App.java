package com.example.sonarqubelab;

public class App {
    public static void main(String[] args) {
        String message = "Hello from SonarQube lab";
        System.out.println(message);
        System.out.println(calculateTotal(10, 5));
    }

    public static int calculateTotal(int a, int b) {
        int result = a + b;
        return result;
    }
}
