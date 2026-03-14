package com.sleeptracker.analyzer;

import com.sleeptracker.model.*;
import java.util.List;

public class BadSleepState implements SleepAnalyzer {

    public AnalysisResult apply(List<SleepSession> s) {
        long bad = s.stream()
                .filter(ss -> ss.state() == SleepState.BAD)
                .count();
        return new AnalysisResult("Сессий с плохим качеством сна", String.valueOf(bad));
    }
}