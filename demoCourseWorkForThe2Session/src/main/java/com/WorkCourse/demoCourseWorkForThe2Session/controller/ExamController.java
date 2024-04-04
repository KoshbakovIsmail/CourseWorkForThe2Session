package com.WorkCourse.demoCourseWorkForThe2Session.controller;

import com.WorkCourse.demoCourseWorkForThe2Session.entity.Question;
import com.WorkCourse.demoCourseWorkForThe2Session.exception.QuestionLimitationException;
import com.WorkCourse.demoCourseWorkForThe2Session.service.ExaminerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Collection;

@RestController
@RequestMapping
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }


    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestion(@PathVariable int amount) {

        return examinerService.getQuestions(amount);
    }
}
