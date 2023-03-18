/*
 * 876. Middle of the Linked List
 * Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/
 * Given the head of a singly linked list, return the middle node of the linked
 * list.
 * 
 * If there are two middle nodes, return the second middle node.
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we
 * return the second one.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Beats 100% Tortoise-Hare-Approach:
/*
 * class Solution {
 * public ListNode middleNode(ListNode head) {
 * ListNode fast = head;
 * ListNode slow = head;
 * while(fast.next != null && fast.next.next != null){
 * fast = fast.next;
 * fast = fast.next;
 * slow = slow.next;
 * }
 * if(fast.next!=null) slow = slow.next;
 * return slow;
 * }
 * }
 */

// Beats 100% Naive - Approach
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int cnt = 0;
        while (current != null) {
            cnt++;
            current = current.next;
        }
        for (int i = 0; i < cnt / 2; i++) {
            head = head.next;
        }
        return head;

    }
}
