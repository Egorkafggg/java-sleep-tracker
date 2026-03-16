package com.sleeptracker.analyzer;

import com.sleeptracker.model.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SleepTypeTest {
    private final SleepType test = new SleepType();

    @Test
    void detectsOwl() {
        assertEquals("Сова", test.apply(TestData.OWL_DOMINANT).value());
    }

    @Test
    void detectsLark() {
        assertEquals("Жаворонок", test.apply(TestData.LARK_DOMINANT).value());
    }

    @Test
    void tieGoesToPigeon() {
        assertEquals("Голубь", test.apply(TestData.MIXED_TYPES).value());
    }

    @Test
    void emptyListReturnsPigeon() {
        assertEquals("Голубь", test.apply(List.of()).value());
    }
}