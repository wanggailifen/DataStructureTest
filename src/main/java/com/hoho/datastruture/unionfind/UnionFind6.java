package com.hoho.datastruture.unionfind;

public class UnionFind6 implements UF {

    private int[] parent;
    //rank[i]表示以i为根的集合对应的层数
    private int[] rank;

    public UnionFind6(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        //让元素个数比较小的根节点指向元素个数比较多的根节点
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }

    }

    private int find(int p) {
        if (p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        if (p != parent[p]) {
            // 路径压缩 直接找到根节点
            parent[p] =find(parent[p]);
        }
        return parent[p];
    }

    @Override
    public int getSize() {
        return parent.length;
    }


}
