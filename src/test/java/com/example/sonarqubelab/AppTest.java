package com.example.sonarqubelab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {
    @Test
    void shouldAddNumbers() {
        assertEquals(15, App.add(10, 5));
    }

    @Test
    void shouldDetectEvenNumbers() {
        assertTrue(App.isEven(10));
        assertFalse(App.isEven(11));
    }

    @Test
    void shouldRunMainWithoutErrors() {
        assertDoesNotThrow(() -> App.main(new String[0]));
    }
}
