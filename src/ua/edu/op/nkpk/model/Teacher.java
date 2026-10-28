package ua.edu.op.nkpk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Teacher описує сутність «Викладач», який створює тести
 * для перевірки знань студентів. Успадковує від {@link Person}
 * спільні дані (ім'я) та реалізує власну роль.
 *
 * @author Kubatko
 * @version 1.1
 */
public class Teacher extends Person {
    /** Список тестів, створених викладачем. */
    private List<Test> tests = new ArrayList<>();

    /**
     * Створює викладача із заданим іменем.
     *
     * @param name прізвище та ім'я викладача
     */
    public Teacher(String name) {
        super(name);
    }

    /**
     * Повертає роль особи в системі.
     *
     * @return рядок «Teacher»
     */
    @Override
    public String getRole() {
        return "Teacher";
    }

    /**
     * Повертає всі тести, створені викладачем.
     *
     * @return список тестів
     */
    public List<Test> getTests() {
        return tests;
    }

    /**
     * Створює новий тест із заданою назвою та додає його до списку тестів викладача.
     *
     * @param title назва нового тесту
     * @return створений тест
     */
    public Test createTest(String title) {
        Test test = new Test(title, this);
        tests.add(test);
        return test;
    }

    /**
     * Шукає тест викладача за назвою без урахування регістру.
     *
     * @param title назва тесту, який шукаємо
     * @return знайдений тест або {@code null}, якщо тесту з такою назвою немає
     */
    public Test findTestByTitle(String title) {
        int i = 0;
        while (i < tests.size()) {
            if (tests.get(i).getTitle().equalsIgnoreCase(title)) {
                return tests.get(i);
            }
            i++;
        }
        return null;
    }
}