package ru.geekbrains.lessons.lesson4;

import java.util.Iterator;

public class TestList {
    public static void main(String[] args) {
        //    LinkedList<Integer> ll = new SimpleLinkedListImp<>();
        DequeListImp<Integer> ll = new DequeListImp<>();
        ll.insertFirst(1);
        ll.insertFirst(2);
        ll.insertFirst(3);
        ll.insertFirst(7);
        ll.insertFirst(8);
        ll.insertLast(55);
        ll.insertLast(56);
        ll.insertLast(59);
        ll.display();
        ll.displayReverse();
        ll.removeFirst();
        ll.display();
        ll.removeLast();
        ll.remove(2);
        ll.display();

        System.out.println(ll.contains(555));
        System.out.println(ll.contains(55));

        ll.insert(66, 0);
        ll.insert(66, 0);
        ll.insert(66, 15);
        ll.display();
        ll.insert(66, 4);
        ll.display();

       Iterator<Integer> iterator =  ll.iterator();
        while (iterator.hasNext()) {
          Integer i = iterator.next();
          if (i.equals(66)) {
            iterator.remove();
          }
        }
        for (Integer value : ll) {
            System.out.println(value);
        }
    }
}
