package com.sleeptracker.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestData {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

    private static SleepSession create(String start, String end, SleepState state) {
        LocalDateTime startTime = LocalDateTime.parse(start, FORMATTER);
        LocalDateTime endTime = LocalDateTime.parse(end, FORMATTER);
        return new SleepSession(startTime, endTime, state);
    }

    public static final List<SleepSession> NORMAL_WEEK = List.of(
            create("01.10.25 23:30", "02.10.25 07:30", SleepState.GOOD),
            create("02.10.25 23:15", "03.10.25 07:45", SleepState.NORMAL),
            create("03.10.25 22:50", "04.10.25 06:30", SleepState.GOOD),
            create("04.10.25 00:15", "04.10.25 08:20", SleepState.NORMAL),
            create("05.10.25 23:00", "06.10.25 07:00", SleepState.BAD)
    );

    public static final List<SleepSession> ONE_SLEEPLESS = List.of(
            create("01.10.25 22:00", "02.10.25 06:00", SleepState.GOOD),
            create("03.10.25 22:00", "04.10.25 06:00", SleepState.GOOD)
    );

    public static final List<SleepSession> OWL_DOMINANT = List.of(
            create("01.10.25 23:30", "02.10.25 09:30", SleepState.NORMAL),
            create("02.10.25 23:45", "03.10.25 10:00", SleepState.NORMAL),
            create("03.10.25 23:15", "04.10.25 09:15", SleepState.GOOD)
    );

    public static final List<SleepSession> LARK_DOMINANT = List.of(
            create("01.10.25 21:30", "02.10.25 06:30", SleepState.GOOD),
            create("02.10.25 21:45", "03.10.25 06:00", SleepState.GOOD),
            create("03.10.25 21:00", "04.10.25 05:30", SleepState.GOOD)
    );

    public static final List<SleepSession> MIXED_TYPES = List.of(
            create("01.10.25 23:30", "02.10.25 09:30", SleepState.NORMAL),
            create("02.10.25 21:30", "03.10.25 06:30", SleepState.GOOD)
    );
}