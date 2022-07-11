package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(
                new Person("Petr", "Arsentev", "12345", "Bryansk")
        );
        ArrayList<Person> find = phone.find("Petr");
        assertThat(find.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(
                new Person("Petr", "Arsentev", "12345", "Bryansk")
        );
        ArrayList<Person> find = phone.find("nsk");
        assertThat(find.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenNotFind() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(
                new Person("Petr", "Arsentev", "12345", "Bryansk")
        );
        ArrayList<Person> find = phone.find("Oleg");
        ArrayList<Person> expected = new ArrayList<>();
        assertThat(find, is(expected));
    }
}