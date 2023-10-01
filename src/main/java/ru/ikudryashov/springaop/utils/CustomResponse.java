package ru.ikudryashov.springaop.utils;

import lombok.Data;

import java.util.Collection;

@Data
public class CustomResponse<T> {
    private Integer code;
    private String message;
    private Collection<T> responseList;

    public CustomResponse(Collection<T> response, CustomStatus status) {
        this.code = status.getCode();
        this.message = status.getName();
        this.responseList = response;
    }
}
