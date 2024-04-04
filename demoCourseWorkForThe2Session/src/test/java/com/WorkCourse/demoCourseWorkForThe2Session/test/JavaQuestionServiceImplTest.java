package com.WorkCourse.demoCourseWorkForThe2Session.test;

import com.WorkCourse.demoCourseWorkForThe2Session.entity.Question;
import com.WorkCourse.demoCourseWorkForThe2Session.service.QuestionService;
import com.WorkCourse.demoCourseWorkForThe2Session.serviceImpl.JavaQuestionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceImplTest {
    private final String que1 = "q1";
    private final String que2 = "q2";
    private final String que3 = "q3";
    private final String ans1 = "a1";
    private final String ans2 = "a2";
    private final String ans3 = "a3";
    private Set<Question> questions;

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private JavaQuestionServiceImpl javaQuestionServiceImpl;

    @BeforeEach
    public void setUp() {
        javaQuestionServiceImpl = new JavaQuestionServiceImpl();
    }

    @Test
    void add() {
        Question expQuestion = new Question(que1, ans1);

        when(questionService.add(que1, ans1)).thenReturn(expQuestion);

        Question actual = questionService.add(que1, ans1);

        assertEquals(expQuestion, actual);

        verify(questionService,times(1)).add(que1,ans1);
    }

    @Test
    void testAdd() {
        Question expQusetion = new Question(que1, ans1);

        when(questionService.add(expQusetion)).thenReturn(expQusetion);

        Question actualQuestion = questionService.add(expQusetion);

        assertEquals(expQusetion, actualQuestion);

        verify(questionService, times(1)).add(expQusetion);
    }

    @Test
    void remove() {
        Question question = new Question(que1, ans1);
        Question deleteQuestion = new Question(que1, ans1);

        when(questionService.remove(que1, ans1)).thenReturn(deleteQuestion);

        Question actualQuestion = questionService.remove(que1, ans1);

        assertEquals(deleteQuestion,actualQuestion);

        verify(questionService,times(1)).remove(que1,ans1);

    }

    @Test
    void getAll() {
        Question expQuestion1 = new Question(que1, ans1);
        Question expQuestion2 = new Question(que2, ans2);
        Question expQuestion3 = new Question(que3, ans3);

        Collection<Question> expectedQuestions = new HashSet<>();
        expectedQuestions.add(expQuestion1);
        expectedQuestions.add(expQuestion2);
        expectedQuestions.add(expQuestion3);

        when(questionService.getAll()).thenReturn(expectedQuestions);

        Collection<Question> actualQuestions = questionService.getAll();

        assertEquals(expectedQuestions, actualQuestions);

        verify(questionService, times(1)).getAll();
    }

}