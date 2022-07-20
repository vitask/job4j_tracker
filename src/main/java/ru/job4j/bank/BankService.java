package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс BankService содержит описание работы данных пользователа с его счётом
 *
 * @author Vitaly Skalenko
 * @version 1.0
 */

public class BankService {

    /**
     * Хранение данных осуществляется с помощью коллекции типа HashMap
     */

    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод осуществляет операцию добавления пользователя в систему
     *
     * @param user - пользователь
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод осуществляет операцию добавления нового счета на аккаунт пользователа
     *
     * @param passport - номер паспорта
     * @param account  - новый счёт
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя по номеру паспорта
     *
     * @param passport - номер паспорта
     * @return - возвращает пользователя или null, если пользователь не найден
     */

    public User findByPassport(String passport) {
        User user = null;
        for (User key : users.keySet()) {
            if (passport.equals(key.getPassport())) {
                user = key;
                break;
            }
        }
        return user;
    }

    /**
     * Метод осуществляет поиск счёта по реквизитам
     *
     * @param passport  - номер паспорта
     * @param requisite - реквизиты счёта
     * @return - возращает счёт или null, если счёт не найден
     */

    public Account findByRequisite(String passport, String requisite) {
        Account userAccount = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    userAccount = account;
                    break;
                }
            }
        }
        return userAccount;
    }

    /**
     * Метод осуществляет перевод некоторое кол-во денежных средст с одного счета на другой по реквизитам
     *
     * @param srcPassport   - номер паспорта отправителя
     * @param srcRequisite  - реквизиты счёта отправителя
     * @param destPassport  - номер паспорта получателя
     * @param destRequisite - реквизиты счёта получателя
     * @param amount        - сумма перевода
     * @return - возвращает результат перевода: true при успешном переводе, false - при ошибке
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= 0) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }
}
