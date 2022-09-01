package engine.controller;

import engine.objects.Answer;
import engine.objects.Feedback;
import engine.objects.Quiz;
import engine.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping()
    public List<Quiz> getALlQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable long id) {
        return quizService.getQuizById(id);
    }

    @PostMapping()
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return quizService.addQuiz(quiz);
    }

    @PostMapping("/{id}/solve")
    public Feedback solveQuiz(@PathVariable long id, @RequestBody Answer answer) {
        return quizService.solveQuiz(id, answer);
    }
}
