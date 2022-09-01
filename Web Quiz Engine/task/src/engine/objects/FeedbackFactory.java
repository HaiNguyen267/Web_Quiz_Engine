package engine.objects;

import org.springframework.stereotype.Component;

@Component
public class FeedbackFactory {

    public Feedback createCorrectFeedback() {
        return new Feedback(true, "Congratulations, you're right!");
    }

    public Feedback createWrongFeedback() {
        return new Feedback(false, "Wrong answer! Please, try again.");
    }
}
