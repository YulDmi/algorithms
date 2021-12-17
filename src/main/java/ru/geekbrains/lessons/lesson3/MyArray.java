package ru.geekbrains.lessons.lesson3;

import java.util.Arrays;

public class MyArray {


    public static void main(String[] args) {
        int[] arr  = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16};
        int[] arr1 = {2};
        int[] arr2 = new int[0];
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr4 = {1, 2, 4, 5, 6};

        printElement(arr, arr1, arr2, arr3, arr4);
    }

    public static void printElement(int[]... arrs) {
        for (int[] arr : arrs) {
            System.out.printf("Способ 1. Element %d - missing %n", findElement(arr));
            System.out.printf("Способ 2. Element %d - missing %n", findElement2(arr));
            System.out.println("____________________");
        }
    }

    // 1й способ - перебором
    public static int findElement(int[] arr) {

        if (arr.length == 0 || arr[0] != 1) return 1;
        int start = 0;
        int end = arr.length - 1;
        while (end >= start) {
            int i = start + (end - start) / 2;
            if (arr[i] == i + 1) {
                start = i + 1;
            } else {
                if (arr[i] - arr[i - 1] == 2) {
                    return arr[i] - 1;
                }
                end = i - 1;
            }
        }
        return arr.length + 1;
    }

    // 2й способ - математикой
    private static int findElement2(int[] arr) {
        int n = arr.length;
        int sum = n * (n + 1) / 2;
        int sum2 = Arrays.stream(arr).sum();
        int elem = 1;
        if (sum2 > 0) {
            if (sum2 == sum) elem = arr[n - 1] + 1;
            else elem = sum - sum2 + arr[n - 1];
        }
        return elem;
    }
}
