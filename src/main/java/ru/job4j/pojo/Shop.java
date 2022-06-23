package ru.job4j.pojo;

public class Shop {

    public static int indexOfNull(Product[] products) {
        int result = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 15);
        products[1] = new Product("Bread", 10);
        products[2] = new Product("Egg", 20);
        System.out.println(indexOfNull(products));
    }
}
