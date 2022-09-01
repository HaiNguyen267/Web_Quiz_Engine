package engine.objects;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Integer> answer;

    public Answer(List<Integer> choices) {
        this.answer = choices;
    }

    public Answer() {
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
