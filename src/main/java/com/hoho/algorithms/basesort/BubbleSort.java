package com.hoho.algorithms.basesort;

import com.hoho.algorithms.api.ArrayGenerator;
import com.hoho.algorithms.api.SortingHelper;
import com.hoho.algorithms.sort.quicksort.QuickSort;

import java.util.Arrays;

public class BubbleSort {
    private BubbleSort() {
    }

    private static <E extends Comparable<E>> void sort(E[] data) {
        //因为每次是比较相邻的两个元素，所以只需要n-1轮循环
        for (int i = 0; i < data.length - 1; i++) {
            //arr[n - i, n)已排好序
            //通过冒泡在arr[n - i - 1]位置放上合适的元素
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    private static <E extends Comparable<E>> void sort2(E[] data) {

        for (int i = 0; i < data.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    isSwapped = true;
                }
            }
            //及时停止排序
            if (!isSwapped) break;
        }
    }

    private static <E extends Comparable<E>> void sort3(E[] data) {

        for (int i = 0; i < data.length - 1;) {
            int lastSwappedIndex = 0;

            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }
            //arr[n - i, n)已排好序
            i = data.length-lastSwappedIndex;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] dataSize = {10000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(10000);
            Integer[] data2 = Arrays.copyOf(data, data.length);

            SortingHelper.sortTest(BubbleSort.class, "sort", data);
            SortingHelper.sortTest(BubbleSort.class, "sort3", data2);
//            SortingHelper.sortTest(QuickSort.class, "sort", data2);

        }

    }
}
