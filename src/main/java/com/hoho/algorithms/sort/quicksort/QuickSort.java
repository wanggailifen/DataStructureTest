package com.hoho.algorithms.sort.quicksort;

import com.hoho.algorithms.api.ArrayGenerator;
import com.hoho.algorithms.api.SortingHelper;
import com.hoho.algorithms.sort.mergesort.MergeSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    //循环不变量   arr[l+1,j] <v      arr[j+1,i) >=v
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {

        //生成[l,r] 之间的随机索引，解决在有序数组中的性能退化问题。
        int p  = l + (new Random()).nextInt(r - l + 1);

        swap(arr, l, p);

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
//        SortingHelper.sortTest(MergeSort.class, "sort", arr);
        SortingHelper.sortTest(QuickSort.class, "sort", arr2);

    }
}
