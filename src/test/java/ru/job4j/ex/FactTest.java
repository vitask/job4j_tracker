package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNMinus1() {
        new Fact().calc(-1);
    }

    @Test
    public void whenN5To120() {
        int n = 5;
        int expected = 120;
        int res = new Fact().calc(n);
        Assert.assertEquals(expected, res);
    }
}