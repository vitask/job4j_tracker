package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizenHashMap = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean result = false;
        if (!citizenHashMap.containsKey(citizen.getPassport())) {
            citizenHashMap.put(citizen.getPassport(), citizen);
            result = true;
        }
        return result;
    }

    public Citizen get(String passport) {
        return citizenHashMap.get(passport);
    }
}
