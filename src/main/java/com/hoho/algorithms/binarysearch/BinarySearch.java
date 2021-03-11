package com.hoho.algorithms.binarysearch;



public class BinarySearch {
    public BinarySearch() {
    }

    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    /**
     * 递归
     */
    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0) return mid;
        if (data[mid].compareTo(target) < 0) return searchR(data, mid + 1, r, target);
        return searchR(data, l, mid - 1, target);
    }

    /**
     * 非递归
     */
    private static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) return mid;
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 找到大于target的最小值
     *
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0, r = data.length;
        //在搜索范围data[l,r]中寻找解，data.length虽然不是数组中的合法位置，但可以表示找不到。
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }

    /**
     * 如果存在target，返回最大的target的索引
     * 如果没有，返回upper
     */
    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int u = upper(data, target);
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        return u;
    }

    public static <E extends Comparable<E>> int lowerCeil(E[] data, E target) {
        int u = upper(data, target);

        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            //存在
            while (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
                u--;
            }
            return u;
        }
        // 不存在，即返回upper
        return u;
    }

    /**
     * 查找小于等于目标的最大值
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1, r = data.length - 1;
        while (l < r) {
            // mid向上取整 避免相邻情况下的问题
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    /**
     * 存在的话返回最小索引
     * 不存在的话返回小于它的最大索引
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int lowerFloor(E[] data, E target) {
        int l = lower(data,target);
        if(l + 1 < data.length && data[l + 1].compareTo(target) == 0){
            return l + 1;
        }
        return l;
    }

    /**
     * 存在，返回最大索引
     * 不存在的话，返回小于它的最大索引
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int upperFloor(E[] data, E target) {
        int l = -1, r = data.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
