package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        int res;
        if (n == 0 || n == 1) {
            res = 1;
        } else {
            res = calc(n - 1) * n;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = calc(5);
        System.out.println(res);
    }
}
