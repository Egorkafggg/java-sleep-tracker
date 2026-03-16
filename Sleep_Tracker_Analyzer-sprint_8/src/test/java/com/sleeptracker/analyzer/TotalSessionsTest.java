package com.sleeptracker.analyzer;

import com.sleeptracker.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TotalSessionsTest {
    private final TotalSessions test = new TotalSessions();

    @Test
    void countsTotal() {
        assertEquals("5", test.apply(TestData.NORMAL_WEEK).value());
    }
}