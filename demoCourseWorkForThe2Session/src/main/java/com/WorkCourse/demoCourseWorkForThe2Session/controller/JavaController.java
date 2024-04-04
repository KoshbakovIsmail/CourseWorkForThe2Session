package com.WorkCourse.demoCourseWorkForThe2Session.controller;

import com.WorkCourse.demoCourseWorkForThe2Session.entity.Question;
import com.WorkCourse.demoCourseWorkForThe2Session.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/addQuestion")
    public Question addQuestion(@RequestParam Question question) {
        return questionService.add(question);
    }

    @GetMapping("remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> get() {
        return questionService.getAll();
    }
}
