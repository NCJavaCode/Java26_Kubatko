package ua.edu.op.nkpk;

import ua.edu.op.nkpk.model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.ArrayList;

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
    }
}