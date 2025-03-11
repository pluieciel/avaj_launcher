package avajLauncher;

class InvalidMethodException extends Exception {
    public InvalidMethodException() { super(); }
    public InvalidMethodException(String message) { super(message); }
}

class UnknownAircraftException extends Exception {
    public UnknownAircraftException() { super(); }
    public UnknownAircraftException(String message) { super(message); }
}

class InputException extends Exception {
    public InputException() { super(); }
    public InputException(String message) { super(message); }
}
