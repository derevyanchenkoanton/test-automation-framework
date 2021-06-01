package com.mobymax.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class TestResultStatusCollector {
    private static final Semaphore SEMAPHORE = new Semaphore(1);
    private static final Map<Integer, TestStatus> RESULTS = new ConcurrentHashMap<>();

    public static void addResult(int testId, TestStatus status) {
        try {
            SEMAPHORE.acquire();
            switch (status) {
                case FAILED:
                    RESULTS.put(testId, status);
                    break;
                case PASSED:
                    RESULTS.putIfAbsent(testId, status);
                    break;
                default:
                    throw new RuntimeException("Provide implementation for '" + status + "'");
            }
            SEMAPHORE.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, TestStatus> getResults() {
        return new HashMap<>(RESULTS);
    }

    public enum TestStatus {
        PASSED, FAILED
    }
}
