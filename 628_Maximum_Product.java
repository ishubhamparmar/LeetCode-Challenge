/*
 * 628. Maximum Product of Three Numbers
 * Problem Link: https://leetcode.com/problems/maximum-product-of-three-numbers/
 * Given an integer array nums, find three numbers whose product is maximum and
 * return the maximum product.
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 6
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 24
 * Example 3:
 * Input: nums = [-1,-2,-3]
 * Output: -6
 */

//Beats 37%
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        // Checking out the multiplication of first two smallest negative numbers
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
    }
}