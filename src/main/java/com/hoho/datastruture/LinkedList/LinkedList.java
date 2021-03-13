package com.hoho.datastruture.LinkedList;



/**
 * 链表
 *
 * @author tlc
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //虚拟头结点
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //在链表头添加
    public void addFirst(E e) {
        add(0, e);
    }

    //在链表中间 添加
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed. Require index > 0 & index <= size");
        }

        //先要找到待插入节点的前一个节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //插入新的节点
        prev.next = new Node(e, prev.next);

        size++;
    }

//    //在以node为头结点的链表中的index位置添加元素e；递归
//    public Node add(Node node, int index, E e) {
//
//        if (index == 0) {
//            return new Node(e, node);
//        }
//        node.next = add(node.next, index - 1, e);
//        return node;
//    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get Failed. Require index > 0 & index <= size");
        }
        //链表的实际第一个节点
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void setDummyHead(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set Failed. Require index > 0 & index <= size");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set Failed. Require index > 0 & index <= size");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e){
        Node prev = dummyHead;
        while (prev.next !=null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev =prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }








    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node current = dummyHead.next;
        while (current != null) {
            res.append(current + " -> ");
            current = current.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
