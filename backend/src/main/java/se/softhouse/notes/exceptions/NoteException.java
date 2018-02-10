package se.softhouse.notes.exceptions;

import javax.ws.rs.WebApplicationException;

public class NoteException extends WebApplicationException {
    public NoteException(int status) {
        super(status);
    }

    public NoteException(String message, int status) {
        super(message, status);
    }

    public NoteException(String message, Throwable cause) {
        super(message, cause);
    }
}
