package exceptions;

public class EmptyStackException extends ADTException {
    public EmptyStackException() {
        super("Stack is empty");
    }
}
