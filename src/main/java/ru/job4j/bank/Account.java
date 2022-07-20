package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс Account содержит описание модели данных банковского счёта
 *
 * @author Vitaly Skalenko
 * @version 1.0
 */

public class Account {

    /**
     * Приватное поле requisite - хранит информацию о реквизите счёт
     * Приватное поле balance - хранит информацию о денежный средствах на счёте
     */

    private String requisite;
    private double balance;

    /**
     * Конструктор класса Account
     *
     * @param requisite - реквициты счета
     * @param balance   - баланс счёта
     */

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод геттер - получает информацию о реквизите счёта
     *
     * @return - возвращает реквизиты счёта
     */

    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод сеттер - устанавливает информацию о реквизите счёта
     *
     * @param requisite - передаюются реквизиты счёта
     */

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод геттер - получает информацию о балансе счётв
     *
     * @return - возвращает баланс счёта
     */

    public double getBalance() {
        return balance;
    }

    /**
     * Метод сеттер - устанавливает информацию о балансе счёта
     *
     * @param balance - возвращает баланс счёта
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределения метода equals
     * В качестве параметров использую поле requisite
     *
     * @param o - параметр передает объект для сравнения
     * @return - возвращает true, если реквициты счёта одинаковые,
     * возвращает false, если реквизиты счёта разные
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение метода hashCode
     *
     * @return - возвращает hashCode
     */

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
