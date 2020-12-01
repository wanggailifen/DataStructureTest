package com.hoho.algorithms.basesort;

import com.hoho.algorithms.api.ArrayGenerator;
import com.hoho.algorithms.api.SortingHelper;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    private InsertSort() {

    }


    private static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适的位置
            for (int j = i; j - 1 >= 0 ; j--) {
                //依次当前值是否比前一个位置的值小，如果小就交换位置
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }

    }
    private static <E extends Comparable<E>> void sort2(E[] arr) {
        //插入排序的优化
        // 临时变量缓存，就只用移动一次，不再依次向前交换了
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适的位置
            E temp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                    arr[j] = arr[j - 1];
            }
            arr[j] = temp;
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
            Integer[] data2 = Arrays.copyOf(data, data.length);

            SortingHelper.sortTest(InsertSort.class, "sort", data);
            SortingHelper.sortTest(InsertSort.class, "sort2", data2);

        }

    }
}
