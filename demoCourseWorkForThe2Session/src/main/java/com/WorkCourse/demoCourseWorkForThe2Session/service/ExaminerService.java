package com.WorkCourse.demoCourseWorkForThe2Session.service;

import com.WorkCourse.demoCourseWorkForThe2Session.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
