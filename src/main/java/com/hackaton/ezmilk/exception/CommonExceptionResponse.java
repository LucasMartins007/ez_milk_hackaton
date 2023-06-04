package com.hackaton.ezmilk.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.regex.Pattern;

@Data
public class CommonExceptionResponse {

    private String message;

    private Integer status;

    public CommonExceptionResponse(String message) {
        this.message = replaceInvalidCaracters(message);
        this.status = HttpStatus.BAD_REQUEST.value();
    }

    private String replaceInvalidCaracters(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }

        return Pattern.compile("\t").matcher(value.replaceAll("\r\n|\r|\n", "<br/>")).replaceAll("&nbsp;&nbsp;");
    }
}
