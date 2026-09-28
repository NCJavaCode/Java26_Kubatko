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

    public Student getStudent() {
        return student;
    }

    public Test getTest() {
        return test;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score >= 0 && score <= test.getQuestions().size()) {
            this.score = score;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPercent() {
        int max = test.getQuestions().size();
        if (max == 0) {
            return 0;
        } else {
            return score * 100.0 / max;
        }
    }

    public String getGrade() {
        int tens = (int) getPercent() / 10;
        switch (tens) {
            case 10:
            case 9:
                return "Відмінно";
            case 8:
            case 7:
                return "Добре";
            case 6:
                return "Задовільно";
            default:
                return "Незадовільно";
        }
    }

    @Override
    public String toString() {
        return "Result{score=" + score + ", date=" + date + "}";
    }
}