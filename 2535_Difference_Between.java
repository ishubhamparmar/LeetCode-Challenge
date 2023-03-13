/*
 * 2535. Difference Between Element Sum and Digit Sum of an Array
 * Problem Link: https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
 * You are given a positive integer array nums.

The element sum is the sum of all the elements in nums.
The digit sum is the sum of all the digits (not necessarily distinct) that appear in nums.
Return the absolute difference between the element sum and digit sum of nums.

Note that the absolute difference between two integers x and y is defined as |x - y|.

Example 1:

Input: nums = [1,15,6,3]
Output: 9
Explanation: 
The element sum of nums is 1 + 15 + 6 + 3 = 25.
The digit sum of nums is 1 + 1 + 5 + 6 + 3 = 16.
The absolute difference between the element sum and digit sum is |25 - 16| = 9.
 */

// class Solution {
//     public int differenceOfSum(int[] nums) {
//         int elementSum = 0;
//         int digitSum = 0;
//         for(int e : nums){
//             elementSum += e;
//             while(e>0){
//                 digitSum += e%10;
//                 e = e/10;
//             }
//         }
//         return Math.abs(elementSum - digitSum);
//     }
// }

//O(N) Solution
class Solution {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;
        for (int e : nums) {
            elementSum += e;
        }
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                j++;
                continue;
            }
            digitSum += nums[j] % 10;
            nums[j] /= 10;
        }
        return Math.abs(elementSum - digitSum);
    }
}
