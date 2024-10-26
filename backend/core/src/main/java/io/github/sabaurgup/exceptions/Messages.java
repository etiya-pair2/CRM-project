package io.github.sabaurgup.exceptions;

public record Messages() {

    // User Messages
    public static final String USER_EMAIL_ALREADY_EXISTS = "User email already exists!";
    public static final String USER_ID_NOT_FOUND = "User ID not found!";
    public static final String INCORRECT_LAST_PASSWORD = "Incorrect last password";
    public static final String ADMIN_CANNOT_DELETE_ITSELF = "Admin cannot delete itself";
    public static final String USER_ID_CANNOT_BE_NULL = "User ID cannot be null";
    public static final String FIRST_NAME_CANNOT_BE_NULL = "First name cannot be null";
    public static final String FIRST_NAME_CANNOT_BE_BLANK = "First name cannot be blank";
    public static final String LAST_NAME_CANNOT_BE_NULL = "Last name cannot be null";
    public static final String LAST_NAME_CANNOT_BE_BLANK = "Last name cannot be blank";
    public static final String PASSWORD_MUST_BE_6_CHARACTERS = "Password must be at least 6 characters";
    public static final String ROLES_LIST_CANNOT_BE_NULL = "Roles list cannot be null";
    public static final String ROLES_LIST_CANNOT_BE_BLANK = "Roles list cannot be blank";
}
