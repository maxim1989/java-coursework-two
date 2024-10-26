package pro.sky.mlfedorov.java_coursework_two.service;

import org.springframework.stereotype.Service;
import pro.sky.mlfedorov.java_coursework_two.entity.Question;
import pro.sky.mlfedorov.java_coursework_two.exceptions.BadRequestException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        final List<Question> questionList = questionService.getAll();
        if (questionList.size() < amount) {
            throw new BadRequestException(
                    "ExaminerServiceImpl: getQuestions(int amount): too many questions were requested"
            );
        }

        final Set<Question> result = new HashSet<>();

        while (result.size() < amount) {
            final Question question = questionService.getRandomQuestion();
            result.add(question);
        }

        return Collections.unmodifiableList(new ArrayList<>(result));
    }
}
