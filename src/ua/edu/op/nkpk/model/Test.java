package ua.edu.op.nkpk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Test описує сутність «Тест»: набір питань, створений
 * викладачем для перевірки знань студентів.
 *
 * @author Kubatko
 * @version 1.0
 */
public class Test {
    /** Назва тесту. */
    private String title;

    /** Викладач, який створив тест. */
    private Teacher author;

    /** Список питань тесту. */
    private List<Question> questions = new ArrayList<>();

    /**
     * Створює тест із заданою назвою та автором.
     *
     * @param title  назва тесту
     * @param author викладач, який створює тест
     */
    public Test(String title, Teacher author) {
        this.title = title;
        this.author = author;
    }

    /**
     * Повертає назву тесту.
     *
     * @return назва тесту
     */
    public String getTitle() {
        return title;
    }

    /**
     * Встановлює назву тесту.
     *
     * @param title нова назва тесту
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Повертає автора тесту.
     *
     * @return викладач, який створив тест
     */
    public Teacher getAuthor() {
        return author;
    }

    /**
     * Повертає всі питання тесту.
     *
     * @return список питань
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Додає питання до тесту. Порожнє питання ({@code null}) ігнорується.
     *
     * @param question питання, яке потрібно додати
     */
    public void addQuestion(Question question) {
        if (question != null) {
            questions.add(question);
        }
    }

    /**
     * Підраховує кількість правильних відповідей студента.
     * Для кожної неправильної відповіді виводить повідомлення в консоль.
     *
     * @param answers список індексів обраних варіантів відповідей
     *                у порядку питань тесту
     * @return кількість правильних відповідей
     */
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

    /**
     * Повертає текстове представлення тесту.
     *
     * @return рядок з назвою тесту та кількістю питань
     */
    @Override
    public String toString() {
        return "Test{title='" + title + "', questions=" + questions.size() + "}";
    }
}