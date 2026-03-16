package com.sleeptracker.analyzer;

import com.sleeptracker.model.*;
import java.util.List;

public class CsSleep implements SleepAnalyzer {

    public AnalysisResult apply(List<SleepSession> sleepSessions) {
        double avg = sleepSessions.stream()
                .filter(ss -> ss.state() != SleepState.BAD)
                .mapToLong(SleepSession::minutes)
                .average()
                .orElse(0.0);
        return new AnalysisResult("Типичная длительность сна (мин)", String.format("%.1f", avg));
    }
}