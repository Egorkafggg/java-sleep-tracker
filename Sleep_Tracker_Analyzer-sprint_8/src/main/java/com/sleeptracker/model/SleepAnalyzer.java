package com.sleeptracker.model;

import java.util.List;

public interface SleepAnalyzer {
    AnalysisResult apply(List<SleepSession> sessions);
}