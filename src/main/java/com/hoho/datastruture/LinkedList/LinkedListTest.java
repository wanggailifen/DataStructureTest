package com.hoho.datastruture.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<>();
        list1.addLast("a");
        list1.addLast("b");
        list1.addLast("x");
        list1.addLast("y");
        list1.addLast("z");
        System.out.println(list1);
        list1.add(2, "666");
        System.out.println(list1);

        list1.remove(2);
        System.out.println(list1);
    }


}
