package com.adrar.cdah2.exception;

public class NoUserFoundException extends RuntimeException {
    public NoUserFoundException() {
        super("Aucun utilisateur trouvé.");
    }
}
