package ua.edu.op.nkpk.model;

import java.util.List;

/**
 * Клас Question описує сутність «Питання» тесту з варіантами
 * відповідей, серед яких один правильний.
 *
 * @author Kubatko
 * @version 1.0
 */
public class Question {
    /** Текст питання. */
    private String text;

    /** Варіанти відповідей. */
    private List<String> options;

    /** Індекс правильного варіанта відповіді у списку варіантів. */
    private int correctIndex;

    /**
     * Створює питання із заданим текстом, варіантами відповідей
     * та індексом правильної відповіді.
     *
     * @param text         текст питання
     * @param options      список варіантів відповідей
     * @param correctIndex індекс правильного варіанта (нумерація з нуля)
     */
    public Question(String text, List<String> options, int correctIndex) {
        this.text = text;
        this.options = options;
        this.correctIndex = correctIndex;
    }

    /**
     * Повертає текст питання.
     *
     * @return текст питання
     */
    public String getText() {
        return text;
    }

    /**
     * Встановлює текст питання.
     *
     * @param text новий текст питання
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Повертає варіанти відповідей.
     *
     * @return список варіантів відповідей
     */
    public List<String> getOptions() {
        return options;
    }

    /**
     * Перевіряє, чи є обраний варіант правильною відповіддю.
     * Індекс поза межами списку варіантів вважається неправильною відповіддю.
     *
     * @param answerIndex індекс обраного варіанта
     * @return {@code true}, якщо відповідь правильна, інакше {@code false}
     */
    public boolean isCorrect(int answerIndex) {
        return answerIndex >= 0
                && answerIndex < options.size()
                && answerIndex == correctIndex;
    }

    /**
     * Повертає текстове представлення питання.
     *
     * @return рядок з текстом питання
     */
    @Override
    public String toString() {
        return "Question{text='" + text + "'}";
    }
}