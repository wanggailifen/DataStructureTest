package com.hoho;

/**
 * 线性查找法
 *
 * @author tlc
 */
public class LinearSearch {
    private LinearSearch() {
    }

    
    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        int index = LinearSearch.search(data, 16);
        System.out.println(index);

        int index2 = LinearSearch.search(data, 5);
        System.out.println(index2);
    }
}
