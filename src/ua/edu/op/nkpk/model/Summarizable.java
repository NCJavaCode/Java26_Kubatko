package ua.edu.op.nkpk.model;

/**
 * Інтерфейс для об'єктів, які вміють коротко описати себе одним рядком.
 *
 * @author Kubatko
 * @version 1.0
 */
public interface Summarizable {
    /**
     * Повертає короткий опис об'єкта.
     *
     * @return рядок з описом
     */
    String getSummary();
}