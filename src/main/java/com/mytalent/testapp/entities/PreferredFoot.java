package com.mytalent.testapp.entities;


public enum PreferredFoot {
    LEFT("Left"),
    RIGHT("Right"),
    BOTH("Both");

    private final String value;

    PreferredFoot(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static PreferredFoot fromString(String value) {
        for (PreferredFoot foot : PreferredFoot.values()) {
            if (foot.value.equalsIgnoreCase(value)) {
                return foot;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}