package ru.geekbrains.lessons.lesson2;

public class HomeWork2 {


    public static void main(String[] args) {

        int[] param = {500, 2000, 50, 4, 24, 4};
        String[] producers = {"Lenovi", "Asun", "MacNote", "Eser", "Xamiou"};
        Supplier supplier = new Supplier(param, producers);

        Notebook[] notebooks = supplier.giveNotebooks(10);
//        for (int i = 0; i < notebooks.length - 1; i++) {
//            System.out.println(notebooks[i]);
//        }
        // тестовые данные
//        Notebook[]notebooks = new Notebook[10];
//        notebooks[0] = new Notebook("Xamiou",  16, 1600);
//        notebooks[1] = new Notebook("Eser",  16, 1600);
//        notebooks[2] = new Notebook("Eser",  4, 850);
//        notebooks[4] = new Notebook("Asun",  4, 850);
//        notebooks[5] = new Notebook("MacNote",  16, 1600);
//        notebooks[3] = new Notebook("Lenovi",  24, 1350);
//        notebooks[6] = new Notebook("Xamiou",  8, 1600);
//        notebooks[7] = new Notebook("Lenovi",  4, 850);
//        notebooks[8] = new Notebook("Lenovi",  20, 1350);
//        notebooks[9] = new Notebook("Lenovi",  4, 850);

        supplier.sort(notebooks);

    }
}
