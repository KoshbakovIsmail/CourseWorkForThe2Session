package com.WorkCourse.demoCourseWorkForThe2Session.serviceImpl;

import com.WorkCourse.demoCourseWorkForThe2Session.entity.Question;
import com.WorkCourse.demoCourseWorkForThe2Session.exception.QuestionLimitationException;
import com.WorkCourse.demoCourseWorkForThe2Session.service.ExaminerService;
import com.WorkCourse.demoCourseWorkForThe2Session.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> allQuestions = questionService.getAll();
        if (allQuestions.size() < amount) {
            throw new QuestionLimitationException(
                    "Запросов задано больше, чем есть в базе данных! Количество вопросов в базе данных равно: " + allQuestions.size());
        }
        Set<Question> getResultRandomQuestions = new HashSet<>();
        while (getResultRandomQuestions.size() < amount) {
            getResultRandomQuestions.add(questionService.getRandomQuestion());
        }
        return getResultRandomQuestions;
    }
}
