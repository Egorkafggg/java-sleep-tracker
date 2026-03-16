package com.sleeptracker.analyzer;

import com.sleeptracker.model.*;
import java.util.List;

public class MaxSleep implements SleepAnalyzer {

    public AnalysisResult apply(List<SleepSession> sleepSessions) {
        long max = sleepSessions.stream()
                .mapToLong(SleepSession::minutes)
                .max()
                .orElse(0);
        return new AnalysisResult("Максимальная длительность сна (мин)", String.valueOf(max));
    }
}