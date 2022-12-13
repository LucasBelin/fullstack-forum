package dev.lbelin.forumapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadRequestException extends ResponseStatusException {

    public BadRequestException(final String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }

    public BadRequestException() {
        super(HttpStatus.BAD_REQUEST);
    }

}
