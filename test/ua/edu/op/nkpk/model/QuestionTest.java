package ua.edu.op.nkpk.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Тестовий клас для перевірки роботи класу {@link Question}.
 */
public class QuestionTest {

    /** Виконується один раз перед усіма тестами. */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Початок тестування класу Question");
    }

    /** Виконується один раз після всіх тестів. */
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Тестування класу Question завершено");
    }

    /**
     * Перевіряє, що правильна відповідь визначається коректно.
     */
    @Test
    public void testIsCorrect_correctAnswer() {
        List<String> options = Arrays.asList("3", "4", "5");
        Question question = new Question("2 + 2 = ?", options, 1, 1);

        assertTrue("Відповідь з правильним індексом повинна вважатись правильною",
                question.isCorrect(1));
    }

    /**
     * Перевіряє, що неправильна відповідь визначається коректно.
     */
    @Test
    public void testIsCorrect_wrongAnswer() {
        List<String> options = Arrays.asList("3", "4", "5");
        Question question = new Question("2 + 2 = ?", options, 1, 1);

        assertTrue("Відповідь з неправильним індексом не повинна вважатись правильною",
                !question.isCorrect(0));
    }

    /**
     * Перевіряє, що equals() повертає true для питань
     * з однаковими correctIndex і points.
     */
    @Test
    public void testEquals_sameFields() {
        Question q1 = new Question("Текст 1", Arrays.asList("a", "b"), 1, 1);
        Question q2 = new Question("Текст 2", Arrays.asList("x", "y"), 1, 1);

        assertEquals("Питання з однаковими correctIndex і points повинні бути рівними",
                q1, q2);
    }

    /**
     * Перевіряє, що clone() створює новий об'єкт зі списком-копією,
     * а не посилання на той самий список.
     */
    @Test
    public void testClone_deepCopy() {
        Question original = new Question("Текст", Arrays.asList("a", "b"), 0, 1);
        Question cloned = original.clone();

        cloned.getOptions().set(0, "змінено");

        assertEquals("Оригінальний список не повинен змінюватись після зміни клону",
                "a", original.getOptions().get(0));
    }

    /**
     * Перевіряє, що метод getQuestionAtIndex у класі Test
     * повертає null для некоректного індексу (а не кидає виняток назовні).
     */
    @Test
    public void testGetQuestionAtIndex_outOfBounds_returnsNull() {
        Teacher teacher = new Teacher("Викладач");
        ua.edu.op.nkpk.model.Test test = teacher.createTest("Тест");
        test.addQuestion(new Question("Питання", Arrays.asList("a", "b"), 0, 1));

        Question result = test.getQuestionAtIndex(10);

        assertNull("За некоректним індексом метод повинен повертати null", result);
    }

    /**
     * Перевіряє, що спроба створити питання з null-списком варіантів
     * призводить до NullPointerException при зверненні до options.
     */
    @Test(expected = NullPointerException.class)
    public void testIsCorrect_nullOptions_throwsException() {
        Question question = new Question("Текст", null, 0, 1);
        question.isCorrect(0);
    }
}
