package com.hoho.leetcode;

class Simple303 {

    //存储前n个元素的和 且 sum[0] =0
    // sum[i] 存储 nums[0....i-1]的和
    private int[] sum;
    private int[] data;

    public Simple303(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }


        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

    }

    public void update(int index, int val) {
        data[index] = val;
        for (int i = index + 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }

    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}