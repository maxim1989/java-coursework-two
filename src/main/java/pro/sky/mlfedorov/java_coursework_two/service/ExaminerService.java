package pro.sky.mlfedorov.java_coursework_two.service;

import pro.sky.mlfedorov.java_coursework_two.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
