package ru.geekbrains.lessons.lesson4;

public class Node<E> {
    protected E item;
    protected    Node<E> next;

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



    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }


}
