package ua.edu.op.nkpk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Student описує сутність «Студент», який проходить тести
 * та отримує за них результати. Успадковує від {@link Person}
 * спільні дані (ім'я) та реалізує власну роль.
 *
 * @author Kubatko
 * @version 1.2
 */
public class Student extends Person implements Nameble, Summarizable { // НОВЕ: інтерфейси
    /** Назва навчальної групи студента. */
    private String group;

    /** Список результатів тестів, які пройшов студент. */
    private List<Result> results = new ArrayList<>();

    /** Назва класу (для інтерфейсу Nameble). */ // НОВЕ
    private String className = "Student";

    /**
     * Створює студента із заданими іменем та групою.
     *
     * @param name  прізвище та ім'я студента
     * @param group назва групи
     */
    public Student(String name, String group) {
        super(name);
        this.group = group;
    }

    /**
     * Повертає роль особи в системі.
     *
     * @return рядок «Student»
     */
    @Override
    public String getRole() {
        return "Student";
    }

    /**
     * Повертає опис студента разом із групою.
     *
     * @return рядок з роллю, іменем та групою
     */
    @Override
    public String describe() {
        return super.describe() + ", група " + group;
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
     * Повертає назву класу.
     *
     * @return назва класу
     */
    @Override
    public String getClassName() { // НОВЕ
        return className;
    }

    /**
     * Встановлює назву класу. Порожнє значення ігнорується.
     *
     * @param className нова назва класу
     */
    @Override
    public void setClassName(String className) { // НОВЕ
        if (className != null && !className.trim().isEmpty()) {
            this.className = className;
        }
    }

    /**
     * Повертає короткий опис студента.
     *
     * @return рядок з іменем, групою та середнім балом
     */
    @Override
    public String getSummary() { // НОВЕ
        return getName() + " (" + group + "), середній бал: " + getAverageScore();
    }

    /**
     * Повертає текстове представлення студента.
     *
     * @return рядок з іменем і групою студента
     */
    @Override
    public String toString() {
        return "Student{name='" + getName() + "', group='" + group + "'}";
    }
}