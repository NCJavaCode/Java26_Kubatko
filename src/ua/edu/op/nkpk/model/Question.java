package ua.edu.op.nkpk.model;

import java.util.List;

public class Question {
    private String text;
    private List<String> options;
    private int correctIndex;

    public Question(String text, List<String> options, int correctIndex) {
        this.text = text;
        this.options = options;
        this.correctIndex = correctIndex;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public List<String> getOptions() { return options; }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctIndex;
    }

    @Override
    public String toString() {
        return "Question{text='" + text + "'}";
    }
}