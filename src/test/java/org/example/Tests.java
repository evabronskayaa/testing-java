package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Tests {

    @Test
    public void test_symbol() {
        assertEquals(1, Int1.decode("+1"));
        assertEquals(1, Int1.decode("1"));
        assertEquals(-1, Int1.decode("-1"));
    }

    @Test
    public void test_zero() {
        assertEquals(Int1.decode("+0"), Int1.decode("-0"));
    }

    @Test
    public void test_hex() {
        assertEquals(32, Int1.decode("0x20"));
        assertEquals(32, Int1.decode("0X20"));
        assertEquals(32, Int1.decode("#20"));
        assertEquals(-32, Int1.decode("-#20"));
    }

    @Test
    public void test_oct() {
        assertEquals(15, Int1.decode("017"));
    }

    @Test
    public void test_wrong_format() {
        assertThrows(NumberFormatException.class, () -> Int1.decode(""));
        assertThrows(NumberFormatException.class, () -> Int1.decode("str"));
        assertThrows(NumberFormatException.class, () -> Int1.decode("1,25"));
        assertThrows(NumberFormatException.class, () -> Int1.decode("0x-16"));
    }

    @Test
    public void test_min_and_max_value() {
        assertEquals(Integer.MIN_VALUE, Int1.decode(String.valueOf(Integer.MIN_VALUE)));
        assertEquals(Integer.MAX_VALUE, Int1.decode(String.valueOf(Integer.MAX_VALUE)));
    }
}