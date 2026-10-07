package ua.edu.op.nkpk.model;

import java.util.List;
import java.util.Objects;
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
    /** Кількість балів, яку дає правильна відповідь на питання. */
    private int points;

    /**
     * Створює питання із заданим текстом, варіантами відповідей
     * та індексом правильної відповіді.
     *
     * @param text         текст питання
     * @param options      список варіантів відповідей
     * @param correctIndex індекс правильного варіанта (нумерація з нуля)
     */
    public Question(String text, List<String> options, int correctIndex, int points) {
        this.text = text;
        this.options = options;
        this.correctIndex = correctIndex;
        this.points = points;
    }

    /**
     * Повертає кількість балів за правильну відповідь.
     *
     * @return кількість балів
     */
    public int getPoints() {
        return points;
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
    /**
     * Порівнює це питання з іншим об'єктом за примітивними полями
     * {@code correctIndex} та {@code points}.
     *
     * @param obj об'єкт, з яким порівнюється це питання
     * @return {@code true}, якщо об'єкти рівні за правилом еквівалентності
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Question question = (Question) obj;
        return correctIndex == question.correctIndex && points == question.points;
    }
    /**
     * Обчислює хеш-код питання на основі тих самих полів,
     * що використовуються в методі {@link #equals(Object)}.
     *
     * @return хеш-код питання
     */
    @Override
    public int hashCode() {
        return Objects.hash(correctIndex, points);
    }
}