package pro.sky.mlfedorov.java_coursework_two.exceptions;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException() {
    }

    public QuestionNotFoundException(String message) {
        super(message);
    }
}
