package ru.geekbrains.lessons.lesson4;

public class Node<E> {
    protected E item;
    protected Node<E> next;
    protected Node<E> prev;

    public Node(E item, Node<E> next, Node<E> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
    public Node(E item, Node<E> next ) {
        this(item, next, null);
    }
    public Node<E> getLast() {
        return prev;
    }

    public void setLast(Node<E> prev) {
        this.prev = prev;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }






}
