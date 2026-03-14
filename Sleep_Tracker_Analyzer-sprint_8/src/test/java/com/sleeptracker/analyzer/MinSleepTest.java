package com.sleeptracker.analyzer;

import com.sleeptracker.model.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MinSleepTest {
    private final MinSleep test = new MinSleep();

    @Test
    void findsMinimum() {
        assertEquals("460", test.apply(TestData.NORMAL_WEEK).value());
    }

    @Test
    void emptyListReturnsZero() {
        assertEquals("0", test.apply(List.of()).value());
    }
}