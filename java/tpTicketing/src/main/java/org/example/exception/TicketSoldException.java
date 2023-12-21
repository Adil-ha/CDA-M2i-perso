package org.example.exception;

public class TicketSoldException extends RuntimeException{
    public TicketSoldException(String message) {
        super(message);
    }
}
