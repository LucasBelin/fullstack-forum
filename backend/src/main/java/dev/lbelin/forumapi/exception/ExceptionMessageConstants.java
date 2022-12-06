package dev.lbelin.forumapi.exception;

public final class ExceptionMessageConstants {

    private ExceptionMessageConstants() {
    }

    public static final String USER_ID_NOT_FOUND = "No user with this id persisted in database";
    public static final String USER_USERNAME_NOT_FOUND = "No user with this username persisted in database";
    public static final String USER_USERNAME_ALREADY_EXISTS = "A user with this username already exists in database";

}
