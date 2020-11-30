package com.hoho.linnersearch;

/**
 * 线性查找法
 *
 * @author tlc
 */
public class LinearSearch {
    private LinearSearch() {
    }


    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 10000000;

        Integer[] data = ArrayGenerator.generateOrderedArray(n);
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int index = LinearSearch.search(data, n);
        }

        long end = System.nanoTime();
        double time = (end - start) / 1000000.0;
        System.out.println("100次耗时" + time + "ms");


//        Student[] students = {new Student("Alice"), new Student("Bobo"), new Student("Jack")};
//        int index3 = LinearSearch.search(students, new Student("Bobo"));
//        System.out.println(index3);
    }
}
