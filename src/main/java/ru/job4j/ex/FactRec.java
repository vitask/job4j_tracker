package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int res = calc(5);
        System.out.println(res);
    }
}
