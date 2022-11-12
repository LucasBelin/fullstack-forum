package com.lbelin.forumapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public final class NotFoundException extends ResponseStatusException {

    public NotFoundException(final String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
    
    public NotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
}
