package org.example.exoEnum;

public enum MessageType {
    A, B, C, D;

    public Priority getPriority() {
        switch (this) {
            case A:
                return Priority.HIGH;
            case B:
                return Priority.MEDIUM;
            case C:
            case D:
                return Priority.LOW;
            default:
                throw new IllegalArgumentException("Invalid message type");
        }
    }
}