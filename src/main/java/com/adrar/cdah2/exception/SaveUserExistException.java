package com.adrar.cdah2.exception;

import com.adrar.cdah2.model.User;

public class SaveUserExistException extends RuntimeException {
    public SaveUserExistException(User user) {
        super("L'utilisateur avec l'email " + user.getEmail() + " existe déjà.");
    }
}
