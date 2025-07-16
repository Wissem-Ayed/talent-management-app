package com.mytalent.testapp.entities;

public enum Position {
    // Goalkeepers
    GOALKEEPER("Goalkeeper", "GK"),

    // Defenders
    CENTER_BACK("Center Back", "CB"),
    LEFT_BACK("Left Back", "LB"),
    RIGHT_BACK("Right Back", "RB"),
    LEFT_WING_BACK("Left Wing Back", "LWB"),
    RIGHT_WING_BACK("Right Wing Back", "RWB"),
    SWEEPER("Sweeper", "SW"),

    // Midfielders
    DEFENSIVE_MIDFIELDER("Defensive Midfielder", "DM"),
    CENTRAL_MIDFIELDER("Central Midfielder", "CM"),
    ATTACKING_MIDFIELDER("Attacking Midfielder", "AM"),
    LEFT_MIDFIELDER("Left Midfielder", "LM"),
    RIGHT_MIDFIELDER("Right Midfielder", "RM"),
    LEFT_WINGER("Left Winger", "LW"),
    RIGHT_WINGER("Right Winger", "RW"),

    // Forwards
    STRIKER("Striker", "ST"),
    CENTER_FORWARD("Center Forward", "CF"),
    LEFT_FORWARD("Left Forward", "LF"),
    RIGHT_FORWARD("Right Forward", "RF"),
    SECOND_STRIKER("Second Striker", "SS");

    private final String displayName;
    private final String abbreviation;

    Position(String displayName, String abbreviation) {
        this.displayName = displayName;
        this.abbreviation = abbreviation;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
