package com.hoho.datastruture.heap;

import com.hoho.datastruture.array.Array;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.IllegalFormatException;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;


    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }


    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("堆为空，没有最大元素");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {
        //leftChild(k) < data.getSize()  当k的左孩子的索引比总元素数量小，就还没有越界。
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            //如果 右孩子的值比左孩子的大
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                //data[j]为左右孩子之间的较大值
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }


    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("参数不合法");
        }
        return (index - 1) / 2;
    }

    //取出堆中最大元素，并替换成e
    public E replacement(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public static void main(String[] args) {
        int n = 10;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.println(arr[i]);
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("测试完成");
    }
}
