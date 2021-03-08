package com.hoho.algorithms.sort.mergesort;

import com.hoho.algorithms.api.ArrayGenerator;
import com.hoho.algorithms.api.SortingHelper;
import com.hoho.algorithms.basesort.InsertSort;

import java.util.Arrays;
import java.util.SortedMap;

public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // 优化：不需要每次都去开辟数组，只在递归调用前拷贝一次，以后都在这个数组空间内操作。
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }


    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
        if (l >= r) {
            return;
        }
        //如果数据规模很小，使用插入排序法会很快，在其他语言不一定会提高效率
        if (r - l <= 15) {
            InsertSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        //优化：如果已经有序了，就不需要merge过程了
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }

    }

    //自底向上归并排序
    public static <E extends Comparable<E>> void sortBU(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        //size:合并的区间的长度
        for (int size = 1; size < n; size += size) {
            //每次往后面挪两个size的长度
            //每次合并的两个区间为 [i, i+size-1]   [i+size, i+ size*2 -1]
            for (int i = 0; i + size < n; i += size * 2) {
                //Math.min(i + size * 2 - 1, n - 1) 防止索引越界
                //如果第一个区间的最后一个元素已经小于第二个区间的第一个元素，表示已经有序，不需要再merge
                if (arr[i + size - 1].compareTo(arr[i + size]) > 0) {
                    merge(arr, i, i + size - 1, Math.min(i + size * 2 - 1, n - 1), temp);
                }

            }
        }

    }


//    /**
//     * 合并两个有序的数组 arr[l,mid] 与 arr[mid+1,r]
//     *
//     * @param arr
//     * @param l
//     * @param mid
//     * @param r
//     * @param <E>
//     */
//    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
//         E[] temp = Arrays.copyOfRange(arr, l, r + 1);
//        int i = l;
//        int j = mid + 1;
//        //每轮循环为arr[k]赋值
//        for (int k = l; k <= r; k++) {
//            //判断i与j是否越界
//            if (i > mid) {
//                //i越界
//                //j-l: arr数组是从l开始的，temp数组是从0开始的，所以要用j-l表示j在temp中的位置
//                arr[k] = temp[j - l];
//                j++;
//            } else if (j > r) {
//                //j越界
//                arr[k] = temp[i - l];
//                i++;
//            } else {
//                //都没有越界
//                if (temp[i - l].compareTo(temp[j - l]) <= 0) {
//                    arr[k] = temp[i - l];
//                    i++;
//                } else {
//                    arr[k] = temp[j - l];
//                    j++;
//                }
//            }
//        }
//
//    }

    /**
     * 对merge优化，不再每次开辟数组空间
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @param temp
     * @param <E>
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        // E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l;
        int j = mid + 1;
        //每轮循环为arr[k]赋值
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
                if (temp[i].compareTo(temp[j]) <= 0) {
                    arr[k] = temp[i];
                    i++;
                } else {
                    arr[k] = temp[j];
                    j++;
                }
            }
        }

    }


    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//        SortingHelper.sortTest(MergeSort.class, "sort", arr);
        SortingHelper.sortTest(MergeSort.class, "sortBU", arr);
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }
}
