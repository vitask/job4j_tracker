package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> userMail = new HashMap<>();
        userMail.put("scalenco@yandex.ru", "Vitaly Skalenko");
        userMail.put("parsentev@yandex.ru", "Petr Arsentev");
        for (String key : userMail.keySet()) {
            String value = userMail.get(key);
            System.out.printf("key: %s value: %s\n", key, value);
        }
    }
}
