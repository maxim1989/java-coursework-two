package pro.sky.mlfedorov.java_coursework_two.service;

import org.junit.jupiter.api.Test;
import pro.sky.mlfedorov.java_coursework_two.entity.Question;
import pro.sky.mlfedorov.java_coursework_two.exceptions.QuestionAlreadyExists;
import pro.sky.mlfedorov.java_coursework_two.exceptions.QuestionNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceImplTest {
    JavaQuestionServiceImpl out = new JavaQuestionServiceImpl();

    @Test
    public void addNewQuestionByQuestionAndAnswer() {
        out.add("The biggest city?", "Moscow");
        final Question expected = out.find("The biggest city?", "Moscow");

        assertNotNull(expected);
        assertEquals(expected.getQuestion(), "The biggest city?");
        assertEquals(expected.getAnswer(), "Moscow");
    }

    @Test
    public void addExistedQuestionByQuestionAndAnswer() {
        out.add("The biggest city 2?", "St. Petersburg");
        assertThrows(QuestionAlreadyExists.class, () -> out.add("The biggest city 2?", "St. Petersburg"));
    }

    @Test
    public void addNewQuestionByQuestionObject() {
        out.add("The biggest animal?", "Elephant");
        final Question expected = out.find("The biggest animal?", "Elephant");

        assertNotNull(expected);
        assertEquals(expected.getQuestion(), "The biggest animal?");
        assertEquals(expected.getAnswer(), "Elephant");
    }

    @Test
    public void addExistedQuestionByQuestionObject() {
        out.add("The smallest animal?", "Mouse");

        assertThrows(QuestionAlreadyExists.class, () -> out.add("The smallest animal?", "Mouse"));
    }

    @Test
    public void removeQuestionByQuestionObject() {
        final Question question = new Question("Delete", "Value");

        out.add(question);
        final Question expected = out.find("Delete", "Value");

        assertNotNull(expected);
        assertEquals(expected.getQuestion(), "Delete");
        assertEquals(expected.getAnswer(), "Value");

        out.remove(question);
        assertThrows(QuestionNotFoundException.class, () -> out.find("Delete", "Value"));
    }

    @Test
    public void removeUnExistsQuestionByQuestionObject() {
        final Question question = new Question("Delete 2", "Value 2");

        assertThrows(QuestionNotFoundException.class, () -> out.remove(question));
    }

    @Test
    public void getAllOneElement() {
        out.add("What to ask?", "I do not know");

        assertFalse(out.getAll().isEmpty());
    }

    @Test
    public void getRandomQuestionExist() {
        out.add("What to ask again?", "I do not know");
        final Question question = out.getRandomQuestion();

        assertNotNull(question);
    }

    @Test
    public void findExist() {
        out.add("Question 1", "Answer 1");

        final Question expected = out.find("Question 1", "Answer 1");

        assertNotNull(expected);
        assertEquals(expected.getQuestion(), "Question 1");
        assertEquals(expected.getAnswer(), "Answer 1");
    }

    @Test
    public void findNotExist() {
        assertThrows(QuestionNotFoundException.class, () -> out.find("Question 2", "Answer 2"));
    }
}
