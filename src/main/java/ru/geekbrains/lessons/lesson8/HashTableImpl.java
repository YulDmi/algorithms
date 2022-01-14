package ru.geekbrains.lessons.lesson8;

import java.util.ArrayList;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final ArrayList<Item<K, V>>[] list;
    //private final Item<K, V>[] data;
//   private int size;


    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public HashTableImpl(int initialCapacity) {
        list = new ArrayList[initialCapacity * 2];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
//        if(size() == list.length){
//            return false;
//        }
        int index = hashFunc(key);

        ArrayList<Item<K, V>> arr = list[index];
        Item<K, V> item = new Item<>(key, value);
        arr.add(item);
        //  size++;
        return true;
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % list.length);
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        return (item.getKey() == null) ? (key == null) : item.getKey().equals(key);
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            sb.append(String.format("%s = %s%n", i, list[i]));
        }
        sb.append("____________________");
        return sb.toString();
    }
}
