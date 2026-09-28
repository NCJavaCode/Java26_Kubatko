package ua.edu.op.nkpk.model;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private String title;
    private Teacher author;
    private List<Question> questions = new ArrayList<>();

    public Test(String title, Teacher author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Teacher getAuthor() {
        return author;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        if (question != null) {
            questions.add(question);
        }
    }

    public int calculateScore(List<Integer> answers) {
        int score = 0;
        for (int i = 0; i < questions.size() && i < answers.size(); i++) {
            if (questions.get(i).isCorrect(answers.get(i))) {
                score++;
            } else {
                System.out.println("Питання " + (i + 1) + ": неправильна відповідь");
            }
        }
        return score;
    }

    @Override
    public String toString() {
        return "Test{title='" + title + "', questions=" + questions.size() + "}";
    }
}