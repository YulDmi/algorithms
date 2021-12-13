package ru.geekbrains.lessons.lesson2;

import java.util.Arrays;

public class HomeWork2 {


    public static void main(String[] args) {

        int[] param = {500, 2000, 50, 4, 24, 4};
        String[] producers = {"Lenovi", "Asun", "MacNote", "Eser", "Xamiou"};
        Supplier supplier = new Supplier(param, producers);


        Notebook[] notebooks = supplier.getNotebooks(20);
        System.out.println(Arrays.asList(notebooks));
        //     Notebook[] notebooks = supplier.getNotebooks(); test

        supplier.sortInsert();
        System.out.println(Arrays.asList(notebooks));
    }
}

