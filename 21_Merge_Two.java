/*
21. Merge Two Sorted Lists
Problem Link: https://leetcode.com/problems/merge-two-sorted-lists/
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
Example 1:Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:
Input: list1 = [], list2 = []
Output: []
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //O(n) Beats 100%
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode();
        ListNode current = newList;
        while(list1 != null && list2 != null){
            if(list1.val>=list2.val){
                current.next = list2;
                list2 = list2.next;
            }
            else{
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }
        current.next = list1 != null ? list1 : list2;
        return newList.next;
    }
}