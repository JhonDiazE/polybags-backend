package com.model.sistem.exceptions;

import lombok.Setter;

public class ObjectNotFoundException extends Exception {

    private static final long serialVersionUID = 5073569174020106454L;

    @Setter
    private String message;

    public ObjectNotFoundException(String message) {
        super(message);
    }


    
    

}