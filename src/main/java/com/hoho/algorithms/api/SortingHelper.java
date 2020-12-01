package com.hoho.algorithms.api;

import java.lang.reflect.*;

/**
 * @author tlc
 */
public class SortingHelper {
    private SortingHelper() {
    }

    /**
     * 判断数组是否有序
     *
     * @param arr
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>, T> void sortTest(Class type, String methodName, E[] arr) {
        long start = System.nanoTime();
        try {
            Constructor con = type.getDeclaredConstructor(null);
            con.setAccessible(true);
            Object instance = con.newInstance(null);
            Method method = type.getDeclaredMethod(methodName, Comparable[].class);
            method.setAccessible(true);
            Object object = arr;
            method.invoke(instance, object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();

        double time = (end - start) / 1000000.0;
        System.out.println(type.getSimpleName() + "-"+ methodName + " n =  " + arr.length + "  耗时:" + time + "ms");

        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException("排序失败");
        }

    }
}
