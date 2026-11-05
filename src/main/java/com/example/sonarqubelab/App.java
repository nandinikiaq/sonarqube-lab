package com.example.sonarqubelab;

public class App {
    public static void main(String[] args) {
        String message = getWelcomeMessage();
        int total = calculateTotal(10, 5);
        if (message == null || total <= 0) {
            throw new IllegalStateException("App initialization failed");
        }
    }

    public static String getWelcomeMessage() {
        return "Hello from SonarQube lab";
    }

    public static int calculateTotal(int a, int b) {
        return a + b;
    }
}
