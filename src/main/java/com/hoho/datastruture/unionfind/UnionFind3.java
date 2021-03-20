package com.hoho.datastruture.unionfind;

public class UnionFind3 implements UF {

    private int[] parent;
    //sz[i]表示以i为根的集合中元素个数
    private int[] sz;

    public UnionFind3(int size) {
        this.parent = new int[size];
        this.sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
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
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[qRoot] += sz[pRoot];
        }

    }

    private int find(int p) {
        if (p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

}
