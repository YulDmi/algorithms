package ru.geekbrains.lessons.lesson2;

public class HomeWork2 {


    public static void main(String[] args) {

        int [] param = {500, 2000, 50, 4, 24, 4};
        Supplier supplier = new Supplier(param);

        Notebook [] notebooks = supplier.genNotebook(10);
        for (int i = 0; i < notebooks.length-1 ; i++) {
            System.out.println(notebooks[i]);
        }


    }
}
