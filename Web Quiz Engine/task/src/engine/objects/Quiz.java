package engine.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Quiz {
    private long id;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotBlank
    private String text;
    @Size(min = 2)
    private List<String> options;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> answer;


    public Quiz(long id, String title, String text, List<String> options, List<Integer> answers) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answers == null ? new ArrayList<>() : answers;
    }

    public Quiz() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answers) {
        this.answer = answers;


    }

    public boolean checkAnswer(List<Integer> userAnswer) {
        if (answer == null) {
            return userAnswer.isEmpty();
        } else {
            return new HashSet(answer).equals(new HashSet(userAnswer));
        }
    }
}
