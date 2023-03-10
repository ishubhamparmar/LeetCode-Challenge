/*
 * 2574. Left and Right Sum Differences
 * Problem Link: https://leetcode.com/problems/left-and-right-sum-differences/
 * Given a 0-indexed integer array nums, find a 0-indexed integer array answer
 * where:
 * 
 * answer.length == nums.length.
 * answer[i] = |leftSum[i] - rightSum[i]|.
 * Where:
 * 
 * leftSum[i] is the sum of elements to the left of the index i in the array
 * nums. If there is no such element, leftSum[i] = 0.
 * rightSum[i] is the sum of elements to the right of the index i in the array
 * nums. If there is no such element, rightSum[i] = 0.
 * Return the array answer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [10,4,8,3]
 * Output: [15,1,11,22]
 * Explanation: The array leftSum is [0,10,14,22] and the array rightSum is
 * [15,11,3,0].
 * The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
 * 
 */

class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int[] arr = new int[nums.length];
        int[] lSum = new int[nums.length];
        int[] rSum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            lSum[i] = lSum[i - 1] + nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            rSum[i] = rSum[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Math.abs(lSum[i] - rSum[i]);
        }
        return arr;
    }

}