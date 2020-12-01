package com.hoho.algorithms.basesort;

import com.hoho.algorithms.api.ArrayGenerator;
import com.hoho.algorithms.api.SortingHelper;

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
                E a = (E) arr[j];
                E b = (E) arr[minIndex];
                if (a.compareTo(b) < 0) {
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
        int[] dataSize = {10000,100000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateRandomArray(n,n);
            SortingHelper.sortTest(SelectionSort.class,"sort", data);
        }

    }
}
