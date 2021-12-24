package ru.geekbrains.lessons.lesson5;

import java.util.ArrayList;

public class Backpack {

    private int bestPrice;
    private final int WEIGHT_BAG;
    private ArrayList<Thing> backPack;
    private static ArrayList<Thing> things;

    public Backpack(ArrayList<Thing> list, int weight) {
        this.WEIGHT_BAG = weight;
        init(list);
    }


    public ArrayList<Thing> getBackPack() {
        things.sort((o1, o2) -> o2.compareTo(o1)); //самый дорогой, самый легкий

        getBestValue(things);
        return backPack;
    }

    private void init(ArrayList<Thing> list) {
        things = new ArrayList<>();
        for (Thing s : list) {//отсекаю тяжелые вещи
            if (s.getWeight() <= WEIGHT_BAG) {
                things.add(s);
            }
        }
    }
    public int getBestPrice() {
        return bestPrice;
    }
    private void getBestValue(ArrayList<Thing> list) {
        int count = 1;
        int sum = sumAllThings(list);
        getValue(list, sum, count);

    }

    private void getValue(ArrayList<Thing> newThings, int sumAll, int count) {

        if (sumAll <= bestPrice) { // проверяю ценность всех оставшихся вещей
         //   System.out.println("Кол-во вызовов : " + count);//4
            return;
        }
        ArrayList<Thing> list = new ArrayList<>(newThings);
        Thing thing = list.remove(0);
        ArrayList<Thing> bag = new ArrayList<>();
        bag.add(thing);
        int price = thing.getPrice();
        sumAll -= price;
        int weightSpaceEmpty = WEIGHT_BAG - thing.getWeight();

        for (Thing th : list) {
            int thWeight = th.getWeight();
            if (thWeight > weightSpaceEmpty) continue;
            if (thWeight == weightSpaceEmpty) {
                price = getPrice(bag, price, th);
                break;
            }
            price = getPrice(bag, price, th);
            weightSpaceEmpty -= thWeight;
        }

        if (price > bestPrice) {
            bestPrice = price;
            backPack = new ArrayList<>(bag);
        }
        count++;
        getValue(list, sumAll, count);
    }

    private int getPrice(ArrayList<Thing> bag, int price, Thing th) {
        bag.add(th);
        price += th.getPrice();
        return price;
    }

    public int sumAllThings(ArrayList<Thing> things) {
        int sum = 0;
        for (Thing s : things) {
            sum += s.getPrice();
        }
        return sum;
    }
}