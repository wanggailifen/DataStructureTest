package com.hoho.leetcode;

public class Offer51 {
    class Solution {
        private int res = 0;

        public int reversePairs(int[] nums) {
            int[] temp = new int[nums.length];
            res = 0;
            sort(nums, 0, nums.length - 1, temp);

            return res;
        }

        private void sort(int[] arr, int l, int r, int[] temp) {
            if (l >=r) {
                return;
            }
            int mid = l + (r - l) / 2;
            sort(arr, l, mid, temp);
            sort(arr, mid + 1, r, temp);
            if (arr[mid] > arr[mid + 1]) {
                merge(arr, l, mid, r, temp);
            }
        }

        private void merge(int[] arr, int l, int mid, int r, int[] temp) {
            System.arraycopy(arr, l, temp, l, r - l + 1);
            int i = l;
            int j = mid + 1;
            for (int k = l; k <= r; k++) {
                //判断i与j是否越界
                if (i > mid) {
                    //i越界
                    arr[k] = temp[j];
                    j++;
                } else if (j > r) {
                    //j越界
                    arr[k] = temp[i];
                    i++;
                } else {
                    //都没有越界
                    if (temp[i] <= temp[j]) {
                        arr[k] = temp[i];
                        i++;
                    } else {
                        arr[k] = temp[j];
                        res += mid - i + 1;
                        j++;
                    }
                }
            }
        }
    }
}
