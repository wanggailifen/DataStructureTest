package com.hoho.datastruture.heap;

import java.util.Random;

public class HeapSort {
    public HeapSort() {
    }

    /**
     * 最基础的堆排序
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : data) {
            maxHeap.add(e);
        }
        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    /**
     * 原地完成的堆排序
     */
    public static <E extends Comparable<E>> void sort2(E[] data) {
        if (data.length <= 1) return;
        /*
        (data.length - 1-1) /2 求最后一个节点的parent
         从最后一个非叶子节点开始倒序往前siftdown
         */
        for (int i = (data.length - 1 - 1) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            //依次将当前最大的元素放在数组的末尾，第二大的元素放在倒数第二位。。。。。
            swap(data, 0, i);
            //然后将剩余的数组继续转化成堆
            siftDown(data, 0, i);
        }

    }

    /**
     * 对data[0, n)所形成的最大堆中，索引k的元素，执行siftDown
     */
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;// 左孩子节点的索引
            //如果 右孩子的值比左孩子的大
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0) {
                //data[j]为左右孩子之间的较大值
                j++;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < n; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test maxHeap completed.");
    }
}



