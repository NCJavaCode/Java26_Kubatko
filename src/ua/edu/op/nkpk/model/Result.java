package ua.edu.op.nkpk.model;

import java.time.LocalDate;

/**
 * Клас Result описує сутність «Результат»: підсумок проходження
 * певного тесту певним студентом.
 *
 * @author Kubatko
 * @version 1.0
 */
public class Result {
    /** Студент, який пройшов тест. */
    private Student student;

    /** Тест, який пройшов студент. */
    private Test test;

    /** Кількість набраних балів (правильних відповідей). */
    private int score;

    /** Дата проходження тесту. */
    private LocalDate date;

    /**
     * Створює результат проходження тесту.
     *
     * @param student студент, який пройшов тест
     * @param test    пройдений тест
     * @param score   кількість набраних балів
     * @param date    дата проходження
     */
    public Result(Student student, Test test, int score, LocalDate date) {
        this.student = student;
        this.test = test;
        this.score = score;
        this.date = date;
    }

    /**
     * Повертає студента.
     *
     * @return студент, якому належить результат
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Повертає тест.
     *
     * @return тест, за який отримано результат
     */
    public Test getTest() {
        return test;
    }

    /**
     * Повертає кількість набраних балів.
     *
     * @return кількість балів
     */
    public int getScore() {
        return score;
    }

    /**
     * Встановлює кількість балів. Значення поза межами від 0
     * до кількості питань тесту ігнорується.
     *
     * @param score нова кількість балів
     */
    public void setScore(int score) {
        if (score >= 0 && score <= test.getQuestions().size()) {
            this.score = score;
        }
    }

    /**
     * Повертає дату проходження тесту.
     *
     * @return дата проходження
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Обчислює відсоток правильних відповідей.
     *
     * @return відсоток від 0 до 100 або 0, якщо в тесті немає питань
     */
    public double getPercent() {
        int max = test.getQuestions().size();
        if (max == 0) {
            return 0;
        } else {
            return score * 100.0 / max;
        }
    }

    /**
     * Перетворює відсоток правильних відповідей на словесну оцінку.
     *
     * @return «Відмінно», «Добре», «Задовільно» або «Незадовільно»
     */
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

    /**
     * Повертає текстове представлення результату.
     *
     * @return рядок з балами та датою
     */
    @Override
    public String toString() {
        return "Result{score=" + score + ", date=" + date + "}";
    }
}