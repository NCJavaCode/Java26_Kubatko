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
     * Повертає питання за індексом, конвертуючи список питань у масив
     * та звертаючись до його елемента. Обробляє вихід за межі масиву.
     *
     * @param index індекс питання, яке потрібно отримати
     * @return питання за вказаним індексом або {@code null}, якщо індекс некоректний
     */
    public Question getQuestionAtIndex(int index) {
        Question[] questionsArray = questions.toArray(new Question[0]);
        try {
            return questionsArray[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Помилка: вихід за межі масиву. "
                    + "Допустимі індекси: від 0 до " + (questionsArray.length - 1)
                    + ", отримано індекс: " + index);
            return null;
        }
    }

    /**
     * Виводить у консоль текст переданого питання.
     * Обробляє ситуацію, коли передано {@code null} замість питання.
     *
     * @param question питання, текст якого потрібно вивести
     */
    public void printQuestionText(Question question) {
        try {
            System.out.println("Текст питання: " + question.getText());
        } catch (NullPointerException e) {
            System.err.println("Помилка: об'єкт класу Question відсутній (null). "
                    + "Неможливо отримати текст питання.");
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