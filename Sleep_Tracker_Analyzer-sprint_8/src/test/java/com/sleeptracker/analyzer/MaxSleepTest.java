package com.sleeptracker.analyzer;

import com.sleeptracker.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaxSleepTest {
    private final MaxSleep test = new MaxSleep();

    @Test
    void findsMaximum() {
        assertEquals("510", test.apply(TestData.NORMAL_WEEK).value());
    }
}