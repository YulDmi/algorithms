package ru.geekbrains.lessons.lesson4;

public class SimpleLinkedListImp<E> implements LinkedList<E> {
    protected int size;
    private Node<E> first;



    @Override
    public void insertFirst(E value) {

        Node<E> newNode = new Node<E>(value, first);

        newNode.next = first;
        first = newNode;
        size++;
    }




    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removed = first;
        first = removed.next;
        removed.next = null;
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
        }
        previous.next = current.next;
        current.next = null;
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

    @Override
    public E getFist() {
        return first.item;
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
}
