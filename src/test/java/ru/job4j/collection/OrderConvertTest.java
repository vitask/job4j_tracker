package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3dfe5c", "Dress"));
        HashMap<String, Order> convert = OrderConvert.process(orders);
        assertThat(convert.get("3dfe5c"))
                            .isEqualTo(new Order("3dfe5c", "Dress"));
    }

    @Test
    public void whenDuplicateOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3dfe5c", "Dress"));
        orders.add(new Order("3dfe5c", "Dress"));
        HashMap<String, Order> convert = OrderConvert.process(orders);
        assertThat(convert.get("3dfe5c"))
                .isEqualTo(new Order("3dfe5c", "Dress"));
    }
}