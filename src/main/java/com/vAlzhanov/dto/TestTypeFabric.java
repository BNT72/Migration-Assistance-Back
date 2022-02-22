package com.vAlzhanov.dto;

import com.vAlzhanov.models.test.ETestType;
import com.vAlzhanov.models.test.TestType;

public class TestTypeFabric {
    public static TestType getTestType(String testType) {
        return switch (testType) {
            case "RUSSIAN=" -> new TestType(1, ETestType.RUSSIAN);
            case "HISTORY=" -> new TestType(2, ETestType.HISTORY);
            case "BASIS_OF_LEGISLATION=" -> new TestType(3, ETestType.BASIS_OF_LEGISLATION);
            default -> throw new IllegalStateException("Unexpected value: " + testType);
        };
    }
}
