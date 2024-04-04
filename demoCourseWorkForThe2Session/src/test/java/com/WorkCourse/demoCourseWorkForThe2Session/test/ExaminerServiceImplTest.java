package com.WorkCourse.demoCourseWorkForThe2Session.test;

import com.WorkCourse.demoCourseWorkForThe2Session.entity.Question;
import com.WorkCourse.demoCourseWorkForThe2Session.exception.QuestionLimitationException;
import com.WorkCourse.demoCourseWorkForThe2Session.service.QuestionService;
import com.WorkCourse.demoCourseWorkForThe2Session.serviceImpl.ExaminerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    private final String q1 = "q1";
    private final String q2 = "q2";
    private final String q3 = "q3";
    private final String a1 = "a1";
    private final String a2 = "a2";
    private final String a3 = "a3";
    private final String errorQ = "eQ1";
    private final String errorA = "eA1";
    private Set<Question> allQuestions;
    private Collection<Question> allQuestionsResult;

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;


    @BeforeEach
    public void setUp() {
        allQuestions = new HashSet<>();
    }

    @Test
    void testGetQuestions_withException() {
        int amount = 5;
        Question question1 = new Question(q1, a1);
        Question question2 = new Question(q2, a2);
        Question question3 = new Question(q3, a3);
        Question errorQuestion = new Question(errorQ, errorA);

        allQuestions.add(new Question(q1, a1));
        allQuestions.add(new Question(q2, a2));
        allQuestions.add(new Question(q3, a3));

        when(questionService.getAll()).thenReturn(allQuestions);

        allQuestionsResult = questionService.getAll();
        assertTrue(allQuestionsResult.contains(question1));
        assertTrue(allQuestionsResult.contains(question2));
        assertTrue(allQuestionsResult.contains(question3));
        assertFalse(allQuestionsResult.contains(errorQuestion));

        Exception actualMessage = assertThrows(QuestionLimitationException.class,
                () -> examinerService.getQuestions(amount));
        String expectedMessage = "Запросов задано больше, чем есть в базе данных! Количество вопросов в базе данных равно: " + allQuestions.size();
        assertEquals(expectedMessage, actualMessage.getMessage());
    }

    @Test
    void getQuestions_success() {
        int amount = 1;

        Question question1 = new Question(q1, a1);
        Question question2 = new Question(q2, a2);

        allQuestions.add(question1);
        allQuestions.add(question2);

        when(questionService.getAll()).thenReturn(allQuestions);
        when(questionService.getAll()).thenReturn(allQuestions);
        when(questionService.getRandomQuestion()).thenReturn(question1);
        when(questionService.getRandomQuestion()).thenReturn(question2);

        allQuestionsResult = examinerService.getQuestions(amount);
        verify(questionService).getAll();
        verify(questionService).getAll();
        verify(questionService).getRandomQuestion();
    }

    @Test
    void getQuestion_Random() {
        int amount = 2;
        Question question1 = new Question(q1, a1);
        Question question2 = new Question(q2, a2);
        Question question3 = new Question(q3,a2);

        allQuestions.add(question1);
        allQuestions.add(question2);
        allQuestions.add(question3);

        when(questionService.getAll()).thenReturn(allQuestions);
        when(questionService.getRandomQuestion()).thenReturn(question1).thenReturn(question2).thenReturn(question3);

        Collection<Question> returnQuestions = examinerService.getQuestions(amount);
        verify(questionService).getAll();
        verify(questionService, times(amount)).getRandomQuestion();
        assertEquals(amount, returnQuestions.size());
    }
}