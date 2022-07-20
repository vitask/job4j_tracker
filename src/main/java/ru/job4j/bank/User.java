package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс User содержит описание пользователя счёта
 *
 * @author Vitaly Skalenko
 * @version 1.0
 */

public class User {

    /**
     * Приватное поле passport - хранит информацию о паспорте пользователя
     * Приватное поле username - хранит информацию о ФИО пользователя
     */
    private String passport;
    private String username;

    /**
     * Конструктор класса User
     *
     * @param passport - паспорт пользователя
     * @param username - ФИО пользователя
     */

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод геттер - получает информацию о номере паспорта пользователя
     *
     * @return - возвращает номер паспорта
     */

    public String getPassport() {
        return passport;
    }

    /**
     * Метод сеттер - устанавливает номер паспорта пользователя
     *
     * @param passport - передается номер паспорта
     */

    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод геттер - получает информацию о ФИО пользователя
     *
     * @return - возвращает ФИО
     */

    public String getUsername() {
        return username;
    }

    /**
     * Метод сеттер - устанавливает ФИО пользователя
     *
     * @param username - передается ФИО
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод equals
     * В качестве параметров использую поле passport
     *
     * @param o - передает объект для сравнения
     * @return - возвращает true, если номера паспортов одинаковые,
     * возвращает false, если номера паспортов разные
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод hashCode
     *
     * @return - возвращает hashCode
     */

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
