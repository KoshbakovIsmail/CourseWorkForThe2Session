package com.WorkCourse.demoCourseWorkForThe2Session.serviceImpl;

import com.WorkCourse.demoCourseWorkForThe2Session.entity.Question;
import com.WorkCourse.demoCourseWorkForThe2Session.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question deleteQuestion = new Question(question, answer);
        questions.remove(deleteQuestion);
        return deleteQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(index);
    }
}
