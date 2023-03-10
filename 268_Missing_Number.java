/*
 * 268. Missing Number
 * Problem Link:https://leetcode.com/problems/missing-number/
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array.
 * 
 * Example 1:
 * 
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range
 * [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * Example 2:
 * 
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range
 * [0,2]. 2 is the missing number in the range since it does not appear in nums.
 */
// class Solution {
// public int missingNumber(int[] nums) {
// int n = nums.length;
// int[] checkList = new int[n+1];

// for (int num : nums) {
// checkList[num] = 1;
// }

// for (int i = 0; i <= n; i++) {
// if (checkList[i] == 0) {
// return i;
// }
// }

// return -1;
// }
// }

//Optimized solution - Beats 100% - O(N)
class Solution {
    public int missingNumber(int[] nums) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];

        }
        sum2 = nums.length * (nums.length + 1) / 2;
        return sum2 - sum1;

    }
}