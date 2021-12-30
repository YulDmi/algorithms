package ru.geekbrains.lessons.lesson6;

import java.util.Random;

public class TestTree {
    public static void main(String[] args) {

        Tree<Integer> tree = new TreeImpl<>();
        Random r = new Random();
        tree.add(1 - r.nextInt(3));
        for (int i = 0; i < 20; i++) {
            int m = 25 - r.nextInt(50);
            tree.add(m);

        }

        tree.display();


//        tree.add(60);
//        tree.add(31);
//        tree.add(50);
//        tree.add(66);
//        tree.add(10);
//        tree.add(40);
//        tree.add(5);
//        tree.add(55);
//        tree.add(71);
//        tree.add(45);
//        tree.add(42);
//        tree.add(43);
//        tree.add(69);
//        tree.add(67);
//        tree.add(68);
//        tree.add(71);
//        tree.add(28);
//        tree.add(83);
//        tree.add(84);
//
//        tree.display();

    }





}
