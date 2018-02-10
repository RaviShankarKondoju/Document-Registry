package se.softhouse.notes.exceptions;

import java.util.function.Supplier;

public enum NoteExceptions implements Supplier<RuntimeException> {
    BAD_REQUEST(with(400, "Bad request to resource")), //
    NOT_AUTHORIZED(with(401, "Unauthorized")), //
    FORBIDDEN(with(403, "Unauthorized")), //
    NOT_FOUND(with(404, "Resource not found")), //
    FATAL(new RuntimeException()), //
    NOT_IMPLEMENTED(with(501, "Not implemented yet"));

    private RuntimeException runtimeException;

    NoteExceptions(RuntimeException exception) {
        this.runtimeException = exception;
    }

    private static NoteException with(Integer statusCode) {
        return new NoteException(statusCode);
    }

    private static NoteException with(Integer statusCode, String message) {
        return new NoteException(message, statusCode);
    }

    public void raise() {
        throw runtimeException;
    }

    public void raise(String errorMessageFormat, Object... objects) {
        throw new NoteException(String.format(errorMessageFormat, objects), runtimeException);
    }

    @Override
    public RuntimeException get() {
        return runtimeException;
    }
}
