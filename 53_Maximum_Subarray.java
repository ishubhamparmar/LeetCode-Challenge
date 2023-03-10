/*
 * 
 * 53. Maximum Subarra
 * Problem Link: https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the
 * subarray
 * with the largest sum, and return its sum.
 * Example 1:
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * 
 */

// Brute Force Approach - TLE - O(n3)
// class Solution {
//     public int maxSubArray(int[] nums) {

//         int maxSum = Integer.MIN_VALUE;
//         for(int i=0; i<nums.length; i++){
//             for(int j=i; j<nums.length; j++){
//                 int sum = 0;
//                 for(int k=i; k<=j; k++){
//                     sum+=nums[k];
//                     maxSum = Math.max(maxSum, sum);
//                 }
//             }
//         } 
//         return maxSum;       
//     }
// }

// Better Solution - TLE - O(N2)
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxSum = nums[0];
//         for(int i=0; i<nums.length; i++){
//             int sum = 0;
//             for(int j=i; j<nums.length; j++){
//                 sum+=nums[j];
//                 maxSum = Math.max(maxSum, sum);
//             }
//         }    
//     return maxSum;
//     }
// }

//Optimal Solution - Kadane's Algorithm - O(N)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}