package com.hospital.enumerations;

public enum operationType {
    URGENT("urgent"),
    NORMAL("normal");

    private final String value;
    operationType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

}
