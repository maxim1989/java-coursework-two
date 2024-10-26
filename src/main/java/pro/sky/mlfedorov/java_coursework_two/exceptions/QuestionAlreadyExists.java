package pro.sky.mlfedorov.java_coursework_two.exceptions;

public class QuestionAlreadyExists extends RuntimeException {
    public QuestionAlreadyExists() {
    }

    public QuestionAlreadyExists(String message) {
        super(message);
    }
}
