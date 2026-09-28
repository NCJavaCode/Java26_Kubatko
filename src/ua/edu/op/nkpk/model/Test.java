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

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Teacher getAuthor() { return author; }

    public List<Question> getQuestions() { return questions; }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public String toString() {
        return "Test{title='" + title + "', questions=" + questions.size() + "}";
    }
}
