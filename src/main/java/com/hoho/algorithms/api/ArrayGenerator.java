package com.hoho.algorithms.api;

import java.util.Random;

/**
 * 生成一个数组
 * @author tlc
 */
public class ArrayGenerator {

    private ArrayGenerator() {
    }


    public static Integer[] generateOrderedArray(int n){
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;

        }
        return arr;
    }

    public static Integer[] generateRandomArray(int n,int bound){
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

}
