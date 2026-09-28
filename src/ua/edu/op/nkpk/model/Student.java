package ua.edu.op.nkpk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Student описує сутність «Студент», який проходить тести
 * та отримує за них результати.
 *
 * @author Kubatko
 * @version 1.0
 */
public class Student {
    /** Прізвище та ім'я студента. */
    private String name;

    /** Назва навчальної групи студента. */
    private String group;

    /** Список результатів тестів, які пройшов студент. */
    private List<Result> results = new ArrayList<>();

    /**
     * Створює студента із заданими іменем та групою.
     *
     * @param name  прізвище та ім'я студента
     * @param group назва групи
     */
    public Student(String name, String group) {
        this.name = name;
        this.group = group;
    }

    /**
     * Повертає ім'я студента.
     *
     * @return прізвище та ім'я студента
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює ім'я студента.
     *
     * @param name нове прізвище та ім'я
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Повертає групу студента.
     *
     * @return назва групи
     */
    public String getGroup() {
        return group;
    }

    /**
     * Встановлює групу студента.
     *
     * @param group нова назва групи
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Повертає всі результати тестів студента.
     *
     * @return список результатів
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * Додає результат тесту до списку результатів студента.
     *
     * @param result результат, який потрібно додати
     */
    public void addResult(Result result) {
        results.add(result);
    }

    /**
     * Обчислює середній бал студента за всіма пройденими тестами.
     *
     * @return середній бал або 0, якщо результатів ще немає
     */
    public double getAverageScore() {
        if (results.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < results.size(); i++) {
            sum += results.get(i).getScore();
        }
        return (double) sum / results.size();
    }

    /**
     * Повертає текстове представлення студента.
     *
     * @return рядок з іменем і групою студента
     */
    @Override
    public String toString() {
        return "Student{name='" + name + "', group='" + group + "'}";
    }
}