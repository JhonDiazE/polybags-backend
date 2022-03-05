package com.model.sistem.exceptions;

import lombok.Setter;

public class CopyPropertiesException extends RuntimeException {

    private static final long serialVersionUID = 5073569174020106454L;

    @Setter
    private String message;

    public CopyPropertiesException(String message) {
        super(message);
    }

    

}