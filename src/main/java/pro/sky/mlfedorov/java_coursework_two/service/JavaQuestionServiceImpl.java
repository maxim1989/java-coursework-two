package pro.sky.mlfedorov.java_coursework_two.service;

import pro.sky.mlfedorov.java_coursework_two.entity.Question;
import pro.sky.mlfedorov.java_coursework_two.exceptions.QuestionAlreadyExists;
import pro.sky.mlfedorov.java_coursework_two.exceptions.QuestionNotFoundException;

import java.util.*;

public class JavaQuestionServiceImpl implements QuestionService {
    @Override
    public Question add(String question, String answer) {
        final Question questionObject = new Question(question, answer);

        if (questions.contains(questionObject)) {
            throw new QuestionAlreadyExists(
                    "JavaQuestionServiceImpl: add(String question, String answer): question already exists"
            );
        }

        questions.add(questionObject);
        return questionObject;
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExists(
                    "JavaQuestionServiceImpl: add(Question question): question already exists"
            );
        }

        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException(
                    "JavaQuestionServiceImpl: remove(Question question): question not found"
            );
        }

        questions.remove(question);
        return question;
    }

    @Override
    public List<Question> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(questions));
    }

    @Override
    public Question getRandomQuestion() {
        final List<Question> questionList = getAll();

        if (!questionList.isEmpty()) {
            final int range = questionList.size();
            final int idx = (int) (Math.random() * range);
            return questionList.get(idx);
        }

        throw new QuestionNotFoundException(
                "JavaQuestionServiceImpl: getRandomQuestion(): question not found"
        );
    }

    @Override
    public Question find(String question, String answer) {
        final Question questionObject = new Question(question, answer);

        if (questions.contains(questionObject)) {
            return questionObject;
        }

        throw new QuestionNotFoundException(
                "JavaQuestionServiceImpl: find(String question, String answer): question not found"
        );
    }
}
