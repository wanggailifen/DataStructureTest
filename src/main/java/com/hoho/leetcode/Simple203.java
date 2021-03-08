package com.hoho.leetcode;



public class Simple203 {
    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 6, 5, 7, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode listNode = new Solution().removeElements(head, 6);
        System.out.println(listNode);
    }
}
