package pro.sky.mlfedorov.java_coursework_two.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {
    Question out;

    @AfterEach
    public void closeTest() {
        out = null;
    }

    @Test
    public void createQuestion() {
        final String question = "Some question";
        final String answer = "Some answer";
        out = new Question(question, answer);

        assertEquals(question, out.getQuestion());
        assertEquals(answer, out.getAnswer());
    }
}
