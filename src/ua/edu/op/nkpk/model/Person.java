package ua.edu.op.nkpk.model;

/**
 * Абстрактний клас Person описує загальну сутність «Користувач системи»
 * (викладач, студент тощо) та містить спільні для всіх ролей дані й поведінку.
 *
 * @author Kubatko
 * @version 1.1
 */
public abstract class Person {
    /** Прізвище та ім'я особи. */
    private String name;

    /**
     * Створює особу із заданим іменем.
     *
     * @param name прізвище та ім'я
     */
    protected Person(String name) {
        this.name = name;
    }

    /**
     * Повертає ім'я особи.
     *
     * @return прізвище та ім'я
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює ім'я особи.
     *
     * @param name нове прізвище та ім'я
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Повертає роль особи в системі. Кожен нащадок реалізує цей метод по-своєму.
     *
     * @return назва ролі, наприклад «Викладач»
     */
    public abstract String getRole();

    /**
     * Повертає текстове представлення особи. Спільний шаблон для всіх нащадків,
     * роль підставляється через абстрактний метод {@link #getRole()}.
     *
     * @return рядок із роллю та іменем
     */
    @Override
    public String toString() {
        return getRole() + "{name='" + name + "'}";
    }
}