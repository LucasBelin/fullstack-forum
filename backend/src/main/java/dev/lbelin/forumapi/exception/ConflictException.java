package dev.lbelin.forumapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ConflictException extends ResponseStatusException {

    public ConflictException(final String reason) {
        super(HttpStatus.CONFLICT, reason);
    }

    public ConflictException() {
        super(HttpStatus.CONFLICT);
    }
}
