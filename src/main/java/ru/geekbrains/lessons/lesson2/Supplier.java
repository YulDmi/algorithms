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

    public Supplier(int[] param) {
        titles = new ArrayList<String>(Arrays.asList("Lenovi", "Asun", "MacNote", "Eser", "Xamiou"));
        this.minPrice = param[0];
        this.maxPrice = param[1];
        this.stepPrice = param[2];
        this.minDDR = param[3];
        this.maxDDR = param[4];
        this.stepDDR = param[5];
        Random random;
    }

    private int generated(int max, int min, int step) {
        random = new Random();
        int diff1 = (max - min) / step;
        int i = random.nextInt(diff1 + 1);
        return min + i * step;

    }

    public Notebook[] genNotebook(int count) {
        Notebook[] notebooks = new Notebook[count];
        random = new Random();

        for (int i = 0; i < count - 1; i++) {
            notebooks[i] = new Notebook(
                    titles.get(random.nextInt(titles.size())),
                    generated(maxDDR, minDDR, stepDDR),
                    generated(maxPrice, minPrice, stepPrice));

        }
        return notebooks;
    }
}
