package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> res = new HashSet<>();
        for (Account acc : accounts) {
            res.add(acc);
        }
        return res;
    }
}
