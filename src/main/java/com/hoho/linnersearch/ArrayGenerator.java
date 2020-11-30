package com.hoho.linnersearch;

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
}
