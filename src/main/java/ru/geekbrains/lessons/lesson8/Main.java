package ru.geekbrains.lessons.lesson8;

public class Main {
    public static void main(String[] args) {
        var hashTable = new HashTableImpl(5);

        hashTable.put(new Product(1, "Orange"), 150);
        hashTable.put(new Product(77, "Banana"), 100);
        hashTable.put(new Product(177, "Milk"), 100);

        hashTable.display();

    }
}
