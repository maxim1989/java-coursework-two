package pro.sky.mlfedorov.java_coursework_two.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.mlfedorov.java_coursework_two.entity.Question;
import pro.sky.mlfedorov.java_coursework_two.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("get/{amount}")
    public Collection<Question> getQuestions(@PathVariable Integer amount) {
        return examinerService.getQuestions(amount);
    }
}
