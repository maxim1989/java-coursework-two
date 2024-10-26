package pro.sky.mlfedorov.java_coursework_two.service;

import pro.sky.mlfedorov.java_coursework_two.entity.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public interface QuestionService {
    final Set<Question> questions = new HashSet<>();

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    Question find(String question, String answer);
}
