package ru.geekbrains.lessons.lesson4;

import java.util.Iterator;
import java.util.function.Consumer;

public class DequeListImp<E> implements LinkedList<E>, Iterable<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;


    @Override
    public void insertFirst(E value) {
        Node<E> newNode = new Node<>(value, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (isEmpty()) {
            insertFirst(value);
            return;
        }
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
        size++;
    }

    public void insert(E value, int index) {
        if (isEmpty() || index == 0) {
            insertFirst(value);
            return;
        }
        if (index >= size) {
            insertLast(value);
            return;
        }
        int count = 1;
        Node<E> current;
        if (index < size / 2) {
            current = first;
            while (index != count) {
                current = current.next;
                count++;
            }
        } else {
            current = last;
            count = size;
            while (index != count) {
                current = current.prev;
                count--;
            }
        }
        Node<E> newNode = new Node<>(value, current.next, current);
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removed = first;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = removed.next;
            removed.next = null;
            first.prev = null;
        }
        size--;
        return removed.item;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removed = last;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
            removed.prev = null;
        }
        size--;
        return removed.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> previous = first;
        while (current != null) {
            if (current.item == value) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if (current == first) {
            removeFirst();
            return true;
        } else if (current == last) {
            removeLast();
            return true;
        }
        previous.next = current.next;
        current.next.prev = previous;
        current.next = null;
        current.prev = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.item.equals(value))
                return true;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    public void displayReverse() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = last;
        while (current != null) {
            sb.append(current.item);
            if (current.prev != null)
                sb.append(" < ");
            current = current.prev;
        }
        System.out.println(sb.append("]").toString());
    }


    @Override
    public E getFist() {
        return first.item;
    }

    public E getLast() {
        return last.item;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null)
                sb.append(" > ");
            current = current.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<E> {

        private Node<E> current;
        private Node<E> next;

        public DequeIterator() {
            next = first;
            current = first;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            if (!hasNext()) return null;
            current = next;
            next = next.next;
            return current.item;
        }

        @Override
        public void remove() {
            if (current != null)
            DequeListImp.this.remove(current.item);
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }
}

