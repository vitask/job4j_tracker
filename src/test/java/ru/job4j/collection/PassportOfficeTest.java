package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void addDub() {
        Citizen citizenOne = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenTwo = new Citizen("2f44a", "Vitaly Skalenko");
        PassportOffice office = new PassportOffice();
        office.add(citizenOne);
        assertThat(office.add(citizenTwo)).isFalse();
    }
}