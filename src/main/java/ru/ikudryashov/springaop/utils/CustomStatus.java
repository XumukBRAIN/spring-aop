package ru.ikudryashov.springaop.utils;

import lombok.Getter;

@Getter
public enum CustomStatus {
    SUCCESS(0, "Success"),
    NOT_FOUND(1, "Not found"),
    EXCEPTION(2, "Exception");

    private final Integer code;
    private final String name;

    CustomStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
