package com.hoho.datastruture.array;


import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/**
 * 自定义数组类
 *
 * @author tlc
 */
public class Array<E> {

    private E[] data;
    private int size;


    public Array(int capacity) {
//        data = new E[capacity]; java中不允许直接这样创建泛型数组，需要绕一个弯
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr) {
        data =(E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
        }
        size = arr.length;
    }


    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public E getFirst() {
        return get(size - 1);
    }

    public E getLast() {
        return get(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 尾部添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 指定位置添加元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast Failed. Require index > 0 & index <= size");
        }

        if (size == data.length) {
            //空间扩容
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;

    }

    private void resize(int newCapasity) {
        E[] newData = (E[]) new Object[newCapasity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast Failed. Require index > 0 & index <= size");
        }
        data[index] = e;
    }


    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast Failed. Require index > 0 & index <= size");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //for GC    loitering objects != memory leak
        data[size] = null;

        //懒缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    //如果存在，只删除一个
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array: size = %d ,capacity = %d \n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
