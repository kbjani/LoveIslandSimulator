package com.loveislandsimulator.enums;

public enum Role {
    OUTSIDER,
    DOUBLE_FACED,
    FLIRT,
    LEADER;

    public static String getRoleName(Role role){
        return switch (role) {
            case Role.DOUBLE_FACED -> "Double Faced";
            case Role.FLIRT -> "Flirt";
            case Role.LEADER -> "Leader";
            case Role.OUTSIDER -> "Outsider";
        };
    }
}
