package ua.edu.op.nkpk.model;

/**
 * Інтерфейс для об'єктів, що знають назву власного класу.
 *
 * @author Kubatko
 * @version 1.0
 */
public interface Nameble {
    /**
     * Повертає назву класу.
     *
     * @return назва класу
     */
    String getClassName();

    /**
     * Встановлює назву класу.
     *
     * @param className нова назва класу
     */
    void setClassName(String className);
}