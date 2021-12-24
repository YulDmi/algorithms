package ru.geekbrains.lessons.lesson5;

public class MyClass {

    public static void main(String[] args) {
        System.out.println(degree(-2, 5));
        System.out.println(degree(2, -5));
        System.out.println(degree(0, -5));
        System.out.println(degree(2, 0));
        System.out.println(degree(9, 1));
    }

    public static double degree(int i, int n) {
        double l = 0;
        if (i == 0) return l;
        else {
            if (n == 0) l = 1;
            if (n > 0) l = findDegreeByN(i, n);
            if (n < 0) l = 1 / findDegreeByN(i, Math.abs(n));
        }
        return l;
    }

    private static double findDegreeByN(int i, int n) {
        if (n == 1) return i;

        return i * findDegreeByN(i, n - 1);
    }


}
