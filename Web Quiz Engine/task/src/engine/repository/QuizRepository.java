package engine.repository;

import engine.objects.Quiz;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuizRepository {

    private static final List<Quiz> QUIZ_LIST = new ArrayList<>();
    private static int quizId = 1;
    public List<Quiz> getAllQuizzes() {
        return QUIZ_LIST;
    }

    public Quiz getQuizById(long id) {
        return QUIZ_LIST.stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found the quiz with id="+ id));
    }

    public Quiz saveQuiz(Quiz quiz) {
        quiz.setId(quizId);
        quizId++;

        QUIZ_LIST.add(quiz);
        return quiz;
    }
}
