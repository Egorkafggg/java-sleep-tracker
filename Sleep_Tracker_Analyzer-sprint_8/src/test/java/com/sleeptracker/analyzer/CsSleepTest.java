package com.sleeptracker.analyzer;

import com.sleeptracker.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CsSleepTest {
    private final CsSleep test = new CsSleep();

    @Test
    void calculatesAverage() {
        String result = test.apply(TestData.NORMAL_WEEK).value();
        assertTrue("483.8".equals(result) || "483,8".equals(result));
    }
}