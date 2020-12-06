package com.hoho.datastruture.queue;

import java.lang.ref.WeakReference;

public interface Queue<E> {
    void enqueue(E e);
    E deque();
    E getFront();
    int getSize();
    boolean isEmpty();



}
