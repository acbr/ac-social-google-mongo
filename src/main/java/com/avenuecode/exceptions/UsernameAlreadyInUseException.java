package com.avenuecode.exceptions;

/**
 * Created by ac-jlima on 11/29/15.
 */
public class UsernameAlreadyInUseException  extends Exception {

    public UsernameAlreadyInUseException(String username) {
        super("The username '" + username + "' is already in use.");
    }
}
