package com.example.sonarqubelab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void shouldAddNumbers() {
        assertEquals(15, App.calculateTotal(10, 5));
    }
}
