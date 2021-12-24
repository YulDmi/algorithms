package ru.geekbrains.lessons.lesson5;

import java.util.Objects;

public class Thing implements Comparable<Thing>{
    ThingsName name;
    int price;
    int weight;


    public Thing(ThingsName name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }


    public ThingsName getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return price == thing.price &&
                weight == thing.weight &&
                name == thing.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }

    @Override
    public int compareTo(Thing o) {
        int result = Integer.compare(this.price, o.price);
        if (result == 0) {
            result = Integer.compare(o.weight, this.weight);
        }
        return result;
    }

    @Override
    public String toString() {
        return "{ " +
                 name +
                ", price=" + price +
                 "руб., weight=" + weight +
                '}';
    }

    public enum ThingsName {
        NOTEBOOK,
        WATCH,
        IRON,
        DUMBBELL



    }


}
