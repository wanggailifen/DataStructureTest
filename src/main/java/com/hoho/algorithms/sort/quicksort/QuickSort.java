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
        int p = l + (new Random()).nextInt(r - l + 1);
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

    //---------------------------sort2ways 双路快速排序--------------------------

    public static <E extends Comparable<E>> void sort2ways(E[] arr) {
        sort2ways(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition2(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    // 循环不变量   arr[l+1,i-1] <=v    arr[j+1,r) >=v
    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r) {
        //生成[l,r] 之间的随机索引，解决在有序数组中的性能退化问题。
        int p = l + (new Random()).nextInt(r - l + 1);
        swap(arr, l, p);

        int i = l + 1, j = r;

        //arr[l] 为 标定点
        while (true) {
            //i 从前向后找
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            //j 从后向前找
            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            //数组中已经没有元素
            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;

        }

        //最后把标定点l的元素放到数组中间，也就是和j交换位置。
        swap(arr, l, j);
        return j;
    }

    //--------------------------sort3ways 三路快速排序----------------------------
    public static <E extends Comparable<E>> void sort3ways(E[] arr) {
        sort3ways(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        //生成[l,r] 之间的随机索引，解决在有序数组中的性能退化问题。
        int p = l + (new Random()).nextInt(r - l + 1);
        swap(arr, l, p);

        //  循环不变量   arr[l+1,lt] <v    arr[lt+1,i-1] =v     arr[gt,r] >=v
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else {
                //相等的情况，不做处理，直接i++
                i++;
            }
        }
        //将标定点交换到中间相等的区域
        swap(arr, l, lt);

        //到这一步，数组的情况是 arr[l+1,lt-1] <v    arr[lt,gt-1] =v     arr[gt,r] >=v
        //向左递归
        sort3ways(arr, l,lt-1);
        //向右递归
        sort3ways(arr, gt,r);
    }

    //------------------------------------------------------
    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 100000; //-Xss10m 记得增加栈大小，不然会栈溢出
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        // 无序数组
        //快速排序测试
        SortingHelper.sortTest(QuickSort.class, "sort", arr);
        //双路快速排序测试
        SortingHelper.sortTest(QuickSort.class, "sort2ways", arr2);
        //三路快速排序测试
        SortingHelper.sortTest(QuickSort.class, "sort3ways", arr3);

        // 全为0的数组数组
        arr = ArrayGenerator.generateRandomArray(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        //快速排序测试
        SortingHelper.sortTest(QuickSort.class, "sort", arr);
        //双路快速排序测试
        SortingHelper.sortTest(QuickSort.class, "sort2ways", arr2);
        //三路快速排序测试
        SortingHelper.sortTest(QuickSort.class, "sort3ways", arr3);


    }
}
