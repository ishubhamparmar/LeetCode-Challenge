/*

1480. Running sum in 1d Array.
Problem Link: https://leetcode.com/problems/running-sum-of-1d-array/

Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.

Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4]. 
*/

class Solution {
    public int[] runningSum(int[] nums) {
        int [] res = new int [nums.length];
        for(int i=1; i<nums.length; i++){
            res[0] = nums[0];
            res[i] = res[i-1]+nums[i];
            
        }
        return res;
    }
}