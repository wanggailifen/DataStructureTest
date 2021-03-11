package com.hoho.leetcode;

import com.hoho.datastruture.array.Array;

import java.util.Arrays;

public class Middle1011 {
    public int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (getDays(weights, mid) <= D) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return l;
    }

    private int getDays(int[] weights, int mid) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];

            if(sum +weight <= mid){
                sum = sum +weight;
            }else {
                count ++;
                sum = weight;
            }
        }
        count ++;
        return count;
    }

    public static void main(String[] args) {
        Middle1011 test = new Middle1011();

        int i = test.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
        System.out.println("结果为" + i);
    }
}
