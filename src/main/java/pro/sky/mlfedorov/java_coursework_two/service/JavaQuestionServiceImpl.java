package pro.sky.mlfedorov.java_coursework_two.service;

import pro.sky.mlfedorov.java_coursework_two.entity.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaQuestionServiceImpl implements QuestionService {
    @Override
    public Question add(String question, String answer) {
        final Question questionObject = new Question(question, answer);
        questions.add(questionObject);
        return questionObject;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
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

        return null;
    }

    @Override
    public Question find(String question, String answer) {
        final Question questionObject = new Question(question, answer);

        if (questions.contains(questionObject)) {
            return questionObject;
        }

        return null;
    }
}
