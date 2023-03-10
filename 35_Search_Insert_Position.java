/*
 * 
 * 35. Search Insert Position
 * Problem Link: https://leetcode.com/problems/search-insert-position/
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * 
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * 
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int f = 0, l = nums.length - 1;
        while (f <= l) {
            int mid = f + (l - f) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                f = mid + 1;
            else
                l = mid - 1;

        }
        return f;
    }
}