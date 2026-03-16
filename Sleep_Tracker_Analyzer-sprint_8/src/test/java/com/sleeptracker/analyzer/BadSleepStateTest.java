package com.sleeptracker.analyzer;

import com.sleeptracker.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BadSleepStateTest {
    private final BadSleepState test = new BadSleepState();

    @Test
    void countsBadSessions() {
        assertEquals("1", test.apply(TestData.NORMAL_WEEK).value());
    }
}