/*
 * 141. Linked List Cycle
 * Problem Link:https://leetcode.com/problems/linked-list-cycle/
 * Given head, the head of a linked list, determine if the linked list has a
 * cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to
 * the 1st node (0-indexed).
 * 
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.

 Approach:
For this problem, let's see what will happen if there's a circle.
If it's a little abstract, then let's think about we are running on a circular track.
If the track is 100m long, your speed is 10m/s, your friend's speed is 5m/s. Then after 20s, you've run 200m, your friend has run 100m. But because the track is circular, so you will be at the same place with your friend since the difference between your distances is exactly 100m.
How about we change another track, change the speed of you and your friend? As long as your speeds are not the same, the faster person will always catch up with the slower person again.
That's the key point for this problem.
Solution
We just need to follow the strategy above - make a slower pointer and a faster pointer. Then we loop and loop again:
if the fast pointer catch up with slow pointer, then it's a circular linked list
if the fast pointer get to the end, then it's not a circular linked list
 * 
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
//Using HashSet - Beats 10%
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         Set<ListNode> set = new HashSet<>();
//         if(head == null || head.next==null)    return false;
//         while(head.next!=null){
//             if(set.contains(head))
//                 return true;
//             else
//                 set.add(head);
//             head = head.next;
//         }
//         return false;
//     }
// }

// Beats 100% - Two Pointers Approach (Tortoise and Hare Algorithm : when one pointer is movies twice as fast as the other one)
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}

