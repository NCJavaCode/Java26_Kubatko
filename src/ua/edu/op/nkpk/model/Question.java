package ua.edu.op.nkpk.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Клас Question описує сутність «Питання» тесту з варіантами
 * відповідей, серед яких один правильний.
 *
 * @author Kubatko
 * @version 1.0
 */
public class Question implements Cloneable {
    /** Текст питання. */
    private String text;

    /** Варіанти відповідей. */
    private List<String> options;

    /** Індекс правильного варіанта відповіді у списку варіантів. */
    private int correctIndex;

    /** Кількість балів, яку дає правильна відповідь на питання. */
    private int points;

    /**
     * Створює питання із заданим текстом, варіантами відповідей,
     * індексом правильної відповіді та кількістю балів.
     *
     * @param text         текст питання
     * @param options      список варіантів відповідей
     * @param correctIndex індекс правильного варіанта (нумерація з нуля)
     * @param points       кількість балів за правильну відповідь
     */
    public Question(String text, List<String> options, int correctIndex, int points) {
        this.text = text;
        this.options = options;
        this.correctIndex = correctIndex;
        this.points = points;
    }

    /**
     * Конструктор копіювання. Створює нове питання на основі іншого,
     * виконуючи глибоке копіювання списку варіантів відповідей,
     * щоб зміни в новому об'єкті не впливали на оригінал.
     *
     * @param other питання, яке потрібно скопіювати
     */
    public Question(Question other) {
        this.text = other.text;
        this.options = new ArrayList<>(other.options);
        this.correctIndex = other.correctIndex;
        this.points = other.points;
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
     * Повертає кількість балів за правильну відповідь.
     *
     * @return кількість балів
     */
    public int getPoints() {
        return points;
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

    /**
     * Створює глибоку копію цього питання: список варіантів відповідей
     * копіюється в новий об'єкт, щоб зміни в копії не впливали на оригінал.
     *
     * @return клон цього питання
     */
    @Override
    public Question clone() {
        try {
            Question cloned = (Question) super.clone();
            cloned.options = new ArrayList<>(this.options);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Question повинен підтримувати клонування", e);
        }
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