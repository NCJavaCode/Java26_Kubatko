package ua.edu.op.nkpk;

import ua.edu.op.nkpk.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Іваненко І.І.");
        Test test = teacher.createTest("Основи Java");
        test.addQuestion(new Question("2 + 2 = ?", Arrays.asList("3", "4", "5"), 1, 1));
        test.addQuestion(new Question("Що таке JVM?", Arrays.asList("Віртуальна машина", "Мова", "Редактор"), 0, 1));
        Question q1 = new Question("2 + 2 = ?", Arrays.asList("3", "4", "5"), 1, 1);
        Question q2 = new Question("Інший текст", Arrays.asList("a", "b"), 1, 1);

        Student student = new Student("Петренко П.П.", "АС333");
        int score = test.calculateScore(Arrays.asList(1, 0));
        Question original = new Question("Столиця України?", new ArrayList<>(Arrays.asList("Львів", "Київ", "Одеса")), 1, 1);

        Question clonedByClone = original.clone();
        Question clonedByConstructor = new Question(original);

        clonedByClone.getOptions().set(0, "ЗМІНЕНО");

        Result result = new Result(student, test, score, LocalDate.now());
        student.addResult(result);

        test.printQuestionText(q1);
        test.printQuestionText(null);
        System.out.println("Питання за індексом 0: " + test.getQuestionAtIndex(0));
        System.out.println("Питання за індексом 10 (помилковий): " + test.getQuestionAtIndex(10));
        System.out.println("q1.equals(q2): " + q1.equals(q2));
        System.out.println("q1.hashCode() == q2.hashCode(): " + (q1.hashCode() == q2.hashCode()));
        System.out.println(result);
        System.out.println("Відсоток: " + result.getPercent());
        System.out.println("Оцінка: " + result.getGrade());
        System.out.println("Середній бал: " + student.getAverageScore());
        System.out.println("Знайдено тест: " + teacher.findTestByTitle("основи java"));
        System.out.println("Оригінал: " + original.getOptions());
        System.out.println("Клон (clone()): " + clonedByClone.getOptions());
        System.out.println("Клон (конструктор копіювання): " + clonedByConstructor.getOptions());
        System.out.println("original == clonedByClone: " + (original == clonedByClone));
        System.out.println("original.equals(clonedByClone): " + original.equals(clonedByClone));

        System.out.println("=== Статичний поліморфізм (перевантаження) ===");
        Question capital = new Question("Столиця України?",
                Arrays.asList("Львів", "Київ", "Одеса"), 1, 1);
        System.out.println("isCorrect(int 1): " + capital.isCorrect(1));
        System.out.println("isCorrect(String \"Київ\"): " + capital.isCorrect("Київ"));
        System.out.println("isCorrect(String \"Одеса\"): " + capital.isCorrect("Одеса"));

        test.addQuestion("Скільки буде 3 + 3?", Arrays.asList("5", "6", "7"), 1);
        System.out.println("Питань у тесті після перевантаженого addQuestion: "
                + test.getQuestions().size());

        System.out.println("=== Динамічний поліморфізм (перевизначення) ===");
        Person[] people = {teacher, student};
        for (Person p : people) {
            System.out.println(p.getRole());
            System.out.println(p.describe());
            System.out.println(p);
        }

        // НОВЕ: інтерфейси
        System.out.println("=== Інтерфейси ===");
        Nameble[] nameables = {student, q1};
        for (Nameble n : nameables) {
            System.out.println("Клас: " + n.getClassName());
        }

        Summarizable[] items = {student, q1};
        for (Summarizable s : items) {
            System.out.println(s.getSummary());
        }

        printInfo(student);
        printInfo(q1);
    }

    /**
     * Виводить назву класу та короткий опис будь-якого об'єкта,
     * що реалізує обидва інтерфейси. Конкретний тип не відомий.
     *
     * @param obj об'єкт, який реалізує Nameble та Summarizable
     * @param <T> тип об'єкта
     */
    private static <T extends Nameble & Summarizable> void printInfo(T obj) { // НОВЕ
        System.out.println(obj.getClassName() + " -> " + obj.getSummary());
    }
}