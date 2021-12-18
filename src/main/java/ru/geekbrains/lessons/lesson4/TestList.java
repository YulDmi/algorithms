package ru.geekbrains.lessons.lesson4;

public class TestList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new SimpleLinkedListImp<>();

        ll.insertFirst(1);
        ll.insertFirst(2);
        ll.insertFirst(3);
        ll.insertFirst(4);
        ll.insertFirst(5);
        ll.insertFirst(6);
        ll.insertFirst(7);
        ll.insertFirst(8);

        ll.display();
        ll.removeFirst();
        ll.display();
        ll.remove(2);
        ll.display();

        System.out.println(ll.contains(5));
        System.out.println(ll.contains(55));
    }
}
