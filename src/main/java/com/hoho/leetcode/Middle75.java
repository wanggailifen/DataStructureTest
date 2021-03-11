package com.hoho.leetcode;

public class Middle75 {
    static class Solution {
        public void sortColors(int[] nums) {
            //三路快速排序

            int l = -1, i = 0, r = nums.length;
            while (i < r) {
                if (nums[i] == 0) {
                    l++;
                    swap(nums, l, i);
                    i++;
                } else if (nums[i] == 2) {
                    r--;
                    swap(nums, i, r);
                } else {
                    i++;
                }
            }

        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

    }
}
