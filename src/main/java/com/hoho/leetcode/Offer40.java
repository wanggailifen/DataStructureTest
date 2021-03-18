package com.hoho.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer40 {
    /**
     * top K问题
     * 在N个元素中选出最小的K个元素
     * 使用优先队列，维护当前看到的最小的K个元素
     * 对于每一个新的数据，如果比这K个最小元素中最大的还小，则替换
     *
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue =new PriorityQueue<Integer>(k, (o1, o2) -> o2-o1);
        for (int i = 0; i < k; i++) {
            priorityQueue.add(k);
        }
        for ( int i = 0; i < arr.length; i++) {
            if(!priorityQueue.isEmpty() && arr[i] < priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        int [] result= new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }

        return result;
    }

    /**
     * 第K大的元素
     * 最小堆，存当前看到的最大的k个元素
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue =new PriorityQueue<Integer>(k, Comparator.comparingInt(o -> o));
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        for ( int i = k; i < nums.length; i++) {
            if(!priorityQueue.isEmpty() && nums[i] > priorityQueue.peek()){
                priorityQueue.remove();
                priorityQueue.add(nums[i]);
            }
        }

        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        int [] arr  = {1,2};
        int res = findKthLargest(arr, 2);
        System.out.println("res = " + res);
    }
}
