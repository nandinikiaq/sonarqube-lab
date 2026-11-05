package com.example.sonarqubelab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void shouldAddNumbers() {
        assertEquals(15, App.calculateTotal(10, 5));
    }

    @Test
    void shouldReturnWelcomeMessage() {
        assertEquals("Hello from SonarQube lab", App.getWelcomeMessage());
    }

    @Test
    void shouldRunMainWithoutErrors() {
        assertDoesNotThrow(() -> App.main(new String[0]));
    }
}
