package ua.edu.op.nkpk.model;

import java.time.LocalDate;

public class Result {
    private Student student;
    private Test test;
    private int score;
    private LocalDate date;

    public Result(Student student, Test test, int score, LocalDate date) {
        this.student = student;
        this.test = test;
        this.score = score;
        this.date = date;
    }

    public Student getStudent() { return student; }
    public Test getTest() { return test; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return "Result{score=" + score + ", date=" + date + "}";
    }
}