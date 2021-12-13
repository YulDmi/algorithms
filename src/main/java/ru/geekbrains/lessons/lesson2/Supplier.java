package ru.geekbrains.lessons.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Supplier {

    int minPrice;
    int maxPrice;
    int stepPrice;
    int minDDR;
    int maxDDR;
    int stepDDR;
    ArrayList<String> titles;
    Random random;
    Notebook[] notebooks;

    public Supplier(int[] param, String[] producers) {
        titles = new ArrayList<>(Arrays.asList(producers));
        this.minPrice = param[0];
        this.maxPrice = param[1];
        this.stepPrice = param[2];
        this.minDDR = param[3];
        this.maxDDR = param[4];
        this.stepDDR = param[5];

    }

    private int generated(int max, int min, int step) {
        random = new Random();
        int diff1 = (max - min) / step;
        int i = random.nextInt(diff1 + 1);
        return min + i * step;
    }

//    public Notebook[] getNotebooks(){
    // тестовые данные
//       notebooks = new Notebook[10];
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
//        return notebooks;
//    }

    public Notebook[] getNotebooks(int count) {
        notebooks = new Notebook[count];
        random = new Random();

        for (int i = 0; i < count; i++) {
            notebooks[i] = new Notebook(
                    titles.get(random.nextInt(titles.size())),
                    generated(maxDDR, minDDR, stepDDR),
                    generated(maxPrice, minPrice, stepPrice));

        }
        return notebooks;
    }

//    public void sort() {
//        Arrays.sort(notebooks, (o1, o2) -> {
//            int value = o1.getPrice().compareTo(o2.getPrice());
//            if (value == 0) {
//                int value2 = o1.getDdr().compareTo(o2.getDdr());
//                if (value2 == 0) {
//                    int value3 = titles.indexOf(o1.getTitle()) - titles.indexOf(o2.getTitle());
//                    return Integer.compare(value3, 0);
//                }
//                return value2;
//            }
//            return value;
//        });
//    }

    public void  sortInsert() {
        int index;
        for (int out = 1; out < notebooks.length; out++) {
            Notebook notebook = notebooks[out];
            index = out;
            while (index > 0 && needToChange(notebooks[index - 1], notebook)) {
                notebooks[index] = notebooks[index - 1];
                --index;
            }
            notebooks[index] = notebook;
        }
    }

    private boolean needToChange(Notebook o1, Notebook o2) {
        int value = o1.getPrice().compareTo(o2.getPrice());
        if (value == 0) {
            int value2 = o1.getDdr().compareTo(o2.getDdr());
            if (value2 == 0) {
                int value3 = titles.indexOf(o1.getTitle()) - titles.indexOf(o2.getTitle());
                return value3 > 0;
            }
            return value2 > 0;
        }
        return value > 0;
    }
}

