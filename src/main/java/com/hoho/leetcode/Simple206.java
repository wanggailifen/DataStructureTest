package com.hoho.leetcode;

public class Simple206 {
    //非递归实现
/*    public ListNode reverseList(ListNode head) {
        ListNode pre =null;
        ListNode cur =head;

        while(cur !=null){
            ListNode next = head.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return cur;
    }*/

    /**
     * 递归实现
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rev = reverseList(head.next);
        head.next.next =head;
        head.next = null;
        return rev;
    }
}
