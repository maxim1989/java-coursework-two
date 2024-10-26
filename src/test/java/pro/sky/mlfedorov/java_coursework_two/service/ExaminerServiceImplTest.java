package pro.sky.mlfedorov.java_coursework_two.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.mlfedorov.java_coursework_two.entity.Question;
import pro.sky.mlfedorov.java_coursework_two.exceptions.BadRequestException;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    private final JavaQuestionServiceImpl javaQuestionServiceMock = mock(JavaQuestionServiceImpl.class);

    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    public void getQuestionsFewQuestions() {
        final List<Question> questions = new ArrayList<>(Arrays.asList(
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3")
        ));
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        assertThrows(BadRequestException.class, () -> out.getQuestions(10));
    }

    @Test
    public void getQuestions() {
        final List<Question> questions = new ArrayList<>(Arrays.asList(
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3")
        ));
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(questions.get(0));
        final List<Question> result = out.getQuestions(1);
        assertEquals(1, result.size());
        assertEquals("q1", result.get(0).getQuestion());
        assertEquals("a1", result.get(0).getAnswer());
    }

    @Test
    public void getQuestionsThree() {
        final List<Question> questions = new ArrayList<>(Arrays.asList(
                new Question("q1", "a1"),
                new Question("q2", "a2"),
                new Question("q3", "a3")
        ));
        when(javaQuestionServiceMock.getAll()).thenReturn(questions);
        when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(questions.get(0))
                .thenReturn(questions.get(1))
                .thenReturn(questions.get(2));
        final List<Question> result = out.getQuestions(3);
        assertEquals(3, result.size());
        assertEquals("q1", result.get(0).getQuestion());
        assertEquals("a1", result.get(0).getAnswer());
        assertEquals("q2", result.get(1).getQuestion());
        assertEquals("a2", result.get(1).getAnswer());
        assertEquals("q3", result.get(2).getQuestion());
        assertEquals("a3", result.get(2).getAnswer());
    }
}
