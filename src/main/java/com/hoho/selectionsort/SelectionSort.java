package com.hoho.selectionsort;

import com.hoho.common.Student;

import java.nio.channels.Selector;

/**
 * 选择排序
 *
 * @author tlc
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //选择arr[i...n)中最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 5, 7, 4, 6, 9};
        SelectionSort.sort(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();

        Student[] students = {new Student("Alice", 22), new Student("Bobo", 18), new Student("Jack", 33)};
        SelectionSort.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
