package com.epam.firsttask.pattern;

import java.util.regex.Pattern;

public class SetOfPatterns {
    public static final Pattern POINT_PATTERN = Pattern.compile("\\s*(\\-?\\d+\\.?\\d*)\\s+(\\-?\\d+\\.?\\d*)\\s+(\\-?\\d+\\.?\\d*)\\s*");
    public static final Pattern CIRCLE_PATTERN = Pattern.compile( "\\s*(\\-?\\d+\\.?\\d*)\\s+(\\-?\\d+\\.?\\d*)\\s+(\\-?\\d+\\.?\\d*)\\s+" +
            "(\\-?\\d+\\.?\\d*)\\s*");
    public static final Pattern QUADRANGLE_PATTERN = Pattern.compile("\\s*(\\-?\\d+\\.?\\d*)\\s+(\\-?\\d+\\.?\\d*)\\s+(\\-?\\d+\\.?\\d*)" +
            "\\s+(\\-?\\d+\\.?\\d*)\\s+(\\-?\\d+\\.?\\d*)\\s+(\\-?\\d+\\.?\\d*)\\s+(\\-?\\d+\\.?\\d*)\\s+(\\-?\\d+\\.?\\d*)" +
            "\\s+(\\-?\\d+\\.?\\d*)\\s*");
    private SetOfPatterns() {
    }
}
