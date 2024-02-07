package com.example.designpattern.collections.generic;

public class GenericMethod {
    public <T,V> void printItems(T t, V v){
        System.out.println(t.toString());
        System.out.println(v.toString());
    }

    public <T> void showItem(T[] items){
        for (T item : items)
            System.out.println(item);
    }

    public <T>T showItem(T item){
        System.out.println("The item is : "+ item.toString());
        return item;
    }

    public <T,V>boolean checkEquality(T t,V v){
        return t.equals(v);
    }

}
