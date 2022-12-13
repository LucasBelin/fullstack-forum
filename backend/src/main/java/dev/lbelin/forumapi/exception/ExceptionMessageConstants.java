package dev.lbelin.forumapi.exception;

public final class ExceptionMessageConstants {

    private ExceptionMessageConstants() {
    }

    public static final String USER_ID_NOT_FOUND = "No user with this id persisted in database";
    public static final String USER_USERNAME_NOT_FOUND = "No user with this username persisted in database";
    public static final String USER_USERNAME_ALREADY_EXISTS = "A user with this username already exists in database";
    public static final String USER_EMAIL_ALREADY_EXISTS = "A user with this email already exists in database";
    public static final String USER_PASSWORD_NOT_VALID = "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one number and one special character";
}
