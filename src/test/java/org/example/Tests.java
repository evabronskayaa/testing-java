package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Tests {

    @Test
    public void test_symbol() {
        assertEquals(1, Integer.decode("+1"));
        assertEquals(1, Integer.decode("1"));
        assertEquals(-1, Integer.decode("-1"));
    }

    @Test
    public void test_zero() {
        assertEquals(Integer.decode("+0"), Integer.decode("-0"));
    }

    @Test
    public void test_hex() {
        assertEquals(32, Integer.decode("0x20"));
        assertEquals(32, Integer.decode("0X20"));
        assertEquals(32, Integer.decode("#20"));
        assertEquals(-32, Integer.decode("-#20"));
    }

    @Test
    public void test_wrong_format() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("str"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("1,25"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("0x-16"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("#+32"));
    }

    @Test
    public void test_min_and_max_value() {
        assertEquals(Integer.MIN_VALUE, Integer.decode(String.valueOf(Integer.MIN_VALUE)));
        assertEquals(Integer.MIN_VALUE, Integer.decode(String.valueOf(Integer.MIN_VALUE)));
    }
}