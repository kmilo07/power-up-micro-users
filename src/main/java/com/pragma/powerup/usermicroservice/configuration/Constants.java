package com.pragma.powerup.usermicroservice.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final Long OWNER_ROLE_ID = 2L;
    public static final Long EMPLOYER_ROLE_ID = 3L;
    public static final Long CUSTOMER_ROLE_ID = 4L;
    public static final String ADMIN_ROLE_NAME = "ROLE_ADMIN";
    public static final String OWNER_ROLE_NAME = "ROLE_OWNER";
    public static final String EMPLOYER_ROLE_NAME = "ROLE_EMPLOYER";
    public static final String CUSTOMER_ROLE_NAME = "ROLE_CUSTOMER";
    public static final int MAX_PAGE_SIZE = 2;
    public static final String REGEX_PHONE = "^([0-9]{10,11})|(\\+[0-9]{12,13})$";
    public static final String REGEX_DOCUMENT_DIGITS = "^\\d{5,11}$";
    public static final String ROLES = "roles";
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String USER_CREATED_MESSAGE = "User created successfully";
    public static final String USER_DELETED_MESSAGE = "User deleted successfully";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String MAIL_ALREADY_EXISTS_MESSAGE = "A person with that mail already exists";
    public static final String ROLE_NOT_FOUND_MESSAGE = "No role found with the id provided";
    public static final String ROLE_NOT_ALLOWED_MESSAGE = "No permission granted to create users with this role";
    public static final String USER_ALREADY_EXISTS_MESSAGE = "A user already exists with the role provided";
    public static final String USER_NOT_FOUND_MESSAGE = "No user found with the role provided";
    public static final String SWAGGER_TITLE_MESSAGE = "User API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "User microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";

    public static final String BIRTHDATE_CANNOT_BE_EMPTY = "Birthdate cannot be empty";
    public static final String USER_IS_MINOR = "User is minor";
    public static final String USER_DOES_NOT_HAVE_PERMISSION = "User doesn't have permission to create another user";

    public static final String MANDATORY_NAME = "Name is mandatory";
    public static final String MANDATORY_SURNAME = "Surname is mandatory";
    public static final String MANDATORY_DOCUMENT = "Document number is mandatory";
    public static final String MANDATORY_PHONE = "Phone is mandatory";
    public static final String MANDATORY_EMAIL = "Email is mandatory";
    public static final String MANDATORY_PASSWORD = "Password is mandatory";
    public static final String NAME_IS_INVALID = "Name is invalid";
    public static final String SURNAME_IS_INVALID = "Surname is invalid";
    public static final String EMAIL_IS_INVALID = "Email is invalid";
    public static final String DOCUMENT_IS_INVALID = "Document number is invalid";
    public static final String PHONE_IS_INVALID = "Phone is invalid";

}
