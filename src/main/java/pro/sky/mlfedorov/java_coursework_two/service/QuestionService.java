package pro.sky.mlfedorov.java_coursework_two.service;

import pro.sky.mlfedorov.java_coursework_two.entity.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface QuestionService {
    final Set<Question> questions = new HashSet<>();

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    List<Question> getAll();

    Question getRandomQuestion();

    Question find(String question, String answer);
}
