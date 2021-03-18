package com.hoho.algorithms.sort.shellsort;

import com.hoho.algorithms.api.ArrayGenerator;
import com.hoho.algorithms.api.SortingHelper;
import com.hoho.algorithms.basesort.BubbleSort;
import com.hoho.algorithms.sort.mergesort.MergeSort;
import com.hoho.algorithms.sort.quicksort.QuickSort;
import com.hoho.datastruture.heap.HeapSort;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;

public class ShellSort {
    private ShellSort() {
    }

/*    private static <E extends Comparable<E>> void sort(E[] data) {
        int h = data.length / 2;
        while (h >= 1) {
            // 遍历每一个子数组，每一个子数组第一个元素的位置为0到h-1
            for (int start = 0; start < h; start++) {
                for (int i = start + h; i < data.length; i += h) {
                    E t = data[i];
                    int j;
                    // j-h 前一个元素的位置
                    for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = t;
                }
            }
            h = h / 2;
        }
    }*/

    private static <E extends Comparable<E>> void sort(E[] data) {
        int h = data.length / 2;
        while (h >= 1) {
            for (int i = h; i < data.length; i++) {
                E t = data[i];
                int j;
                // j-h 前一个元素的位置
                for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = t;
            }
            h = h / 2;
        }
    }

    /**
     * 步长序列
     *
     * @param data
     * @param <E>
     */
    private static <E extends Comparable<E>> void sort2(E[] data) {
        int h = 1;
        while (h < data.length) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < data.length; i++) {
                E t = data[i];
                int j;
                // j-h 前一个元素的位置
                for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = t;
            }
            h = h / 2;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {100000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateRandomArray(n, n);
            Integer[] data2 = Arrays.copyOf(data, data.length);
            Integer[] data3 = Arrays.copyOf(data, data.length);
            Integer[] data4 = Arrays.copyOf(data, data.length);

            SortingHelper.sortTest(QuickSort.class, "sort", data);
            SortingHelper.sortTest(MergeSort.class, "sort", data2);
            SortingHelper.sortTest(HeapSort.class, "sort", data3);
            SortingHelper.sortTest(ShellSort.class, "sort2", data4);

        }

    }
}
