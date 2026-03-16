package com.sleeptracker.analyzer;

import com.sleeptracker.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SleepNightsTest {
    private final SleepNights test = new SleepNights();

    @Test
    void normalWeekNoSleepless() {
        assertEquals("1", test.apply(TestData.NORMAL_WEEK).value());
    }

    @Test
    void oneGapOneSleepless() {
        assertEquals("1", test.apply(TestData.ONE_SLEEPLESS).value());
    }
}