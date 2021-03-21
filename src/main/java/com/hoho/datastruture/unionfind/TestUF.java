package com.hoho.datastruture.unionfind;

import java.util.Random;

public class TestUF {

    public static void main(String[] args) {
        int size = 100000;
        int m = 10000;
        UnionFind1 uf1 = new UnionFind1(size);
        double uf1test = testUF(uf1, m);
        System.out.println("uf1test = " + uf1test);

        UnionFind2 uf2 = new UnionFind2(size);
        double uf2test = testUF(uf2, m);
        System.out.println("uf2test = " + uf2test);


        UnionFind3 uf3 = new UnionFind3(size);
        double uf3test = testUF(uf3, m);
        System.out.println("uf3test = " + uf3test);

        UnionFind4 uf4 = new UnionFind4(size);
        double uf4test = testUF(uf4, m);
        System.out.println("uf4test = " + uf4test);

        UnionFind5 uf5 = new UnionFind5(size);
        double uf5test = testUF(uf5, m);
        System.out.println("uf5test = " + uf5test);

        UnionFind6 uf6 = new UnionFind6(size);
        double uf6test = testUF(uf6, m);
        System.out.println("uf6test = " + uf6test);
    }

    private static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long before = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }
        long after = System.nanoTime();

        return (after - before) / 1000000000.0;
    }
}
