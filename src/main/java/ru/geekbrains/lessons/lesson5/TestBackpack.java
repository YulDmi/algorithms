package ru.geekbrains.lessons.lesson5;

import java.util.ArrayList;
import java.util.Arrays;

public class TestBackpack {
    static ArrayList<Thing> things;

    public static void main(String[] args) {
        init();
        Backpack bp = new Backpack(things, 4);
        ArrayList<Thing> list = bp.getBackPack();
        System.out.println(list);
        System.out.println(bp.getBestPrice());
    }

    public static void init() {
        things = new ArrayList<>(Arrays.asList(
                new Thing(Thing.ThingsName.NOTEBOOK, 6000, 3),
                new Thing(Thing.ThingsName.WATCH, 1000, 1),
                new Thing(Thing.ThingsName.DUMBBELL, 1000, 1),
                new Thing(Thing.ThingsName.IRON, 2000, 1),
                new Thing(Thing.ThingsName.NOTEBOOK, 5000, 2),
                new Thing(Thing.ThingsName.DUMBBELL, 4000, 2),
                new Thing(Thing.ThingsName.NOTEBOOK, 9000, 3),
                new Thing(Thing.ThingsName.DUMBBELL, 500, 5)
        ));
    }
}

