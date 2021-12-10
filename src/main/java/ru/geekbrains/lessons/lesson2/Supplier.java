package ru.geekbrains.lessons.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

    public Supplier(int[] param, String [] producers) {
        titles = new ArrayList<>(Arrays.asList(producers));
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

    public Notebook[] giveNotebooks(int count) {
        Notebook[] notebooks = new Notebook[count];
        random = new Random();

        for (int i = 0; i < count; i++) {
            notebooks[i] = new Notebook(
                    titles.get(random.nextInt(titles.size())),
                    generated(maxDDR, minDDR, stepDDR),
                    generated(maxPrice, minPrice, stepPrice));

        }
        return notebooks;
    }

    public void sort (Notebook[] notebooks) {
        Comparator<Notebook> comparator = (o1, o2) -> {
            int value = o1.getPrice().compareTo(o2.getPrice());
            if (value == 0) {
                int value2 = o1.getDdr().compareTo(o2.getDdr());
                if (value2 == 0) {
                    int value3 = titles.indexOf(o1.getTitle()) - titles.indexOf(o2.getTitle());
                    return Integer.compare(value3, 0);

                }
                return value2;
            }
            return value;
        };

        ArrayList<Notebook> list = new ArrayList<>(Arrays.asList(notebooks));
        list.sort(comparator);
 // System.out.println(list);
    }
}
