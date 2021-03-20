package com.hoho.datastruture.unionfind;

/**
 * 并查集接口
 */
public interface UF {

    boolean isConnected(int p, int q);

    void unionElements(int p,int q);

    int getSize();

}
