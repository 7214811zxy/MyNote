package com.app.basic;

class Box<T> {
    private T object;

    public void set(T object) { this.object = object; }
    public T get() { return object; }
}

class OrderedPair<K, V>  {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey()	{ return key; }

    public V getValue() { return value; }
}

public class TestGeneric {
    public static void main(String[] args) {
        OrderedPair<String, Integer> orderedPair = new OrderedPair<>("age", 18);
        System.out.println(orderedPair.getKey());
        System.out.println(orderedPair.getValue());
    }
}
