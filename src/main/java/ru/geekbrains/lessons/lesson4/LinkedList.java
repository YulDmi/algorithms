package ru.geekbrains.lessons.lesson4;

public interface LinkedList<E> {
    void insertFirst (E value);

    E removeFirst();
    boolean remove (E value);
    boolean contains (E value);
    int size();
    boolean isEmpty();
    void display();
    E getFist();
}
