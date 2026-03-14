package com.sleeptracker;

import com.sleeptracker.analyzer.*;
import com.sleeptracker.model.*;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SleepTracker {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

    private static final List<SleepAnalyzer> ANALYZERS = List.of(
            new TotalSessions(),
            new MinSleep(),
            new MaxSleep(),
            new CsSleep(),
            new BadSleepState(),
            new SleepNights(),
            new SleepType()
    );

    private static final String DEFAULT_LOG = """
            01.10.25 23:30;02.10.25 07:30;GOOD
            02.10.25 23:15;03.10.25 07:45;NORMAL
            03.10.25 22:50;04.10.25 06:30;GOOD
            04.10.25 00:15;04.10.25 08:20;NORMAL
            05.10.25 23:00;06.10.25 07:00;BAD
            06.10.25 01:30;06.10.25 10:15;GOOD
            07.10.25 02:00;07.10.25 11:00;NORMAL
            """;

    public static void main(String[] args) throws Exception {
        String path;
        if (args.length == 0) {
            path = createDefaultLogFile();
            System.out.println("Файл не указан — создан временный: " + path);
        } else {
            path = args[0];
        }

        var sessions = load(path);

        ANALYZERS.forEach(analyzer -> {
            AnalysisResult r = analyzer.apply(sessions);
            System.out.println(r.description() + ": " + r.value());
        });
    }

    private static String createDefaultLogFile() throws IOException {
        Path temp = Files.createTempFile("sleep_log_", ".txt");
        Files.writeString(temp, DEFAULT_LOG.strip());
        temp.toFile().deleteOnExit();
        return temp.toString();
    }

    private static List<SleepSession> load(String path) throws Exception {
        return Files.lines(Paths.get(path))
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(line -> {
                    String[] p = line.split(";");
                    LocalDateTime start = LocalDateTime.parse(p[0], FORMATTER);
                    LocalDateTime end = LocalDateTime.parse(p[1], FORMATTER);
                    SleepState state = SleepState.valueOf(p[2]);
                    return new SleepSession(start, end, state);
                })
                .toList();
    }
}