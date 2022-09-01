package engine.service;

import engine.objects.Answer;
import engine.objects.Feedback;
import engine.objects.FeedbackFactory;
import engine.objects.Quiz;
import engine.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private FeedbackFactory feedbackFactory;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.getAllQuizzes();
    }

    public Quiz getQuizById(long id) {
        return quizRepository.getQuizById(id);
    }

    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.saveQuiz(quiz);
    }

    public Feedback solveQuiz(long id, Answer answer) {
        Quiz quiz = getQuizById(id);
        if (quiz.checkAnswer(answer.getAnswer())) {
            return feedbackFactory.createCorrectFeedback();
        }
        return feedbackFactory.createWrongFeedback();
    }



}
