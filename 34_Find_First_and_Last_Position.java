/*
 * 34. Find First and Last Position of Element in Sorted Array - Medium
 * Problem Link:
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-
 * sorted-array/
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
//Beats 100% | Binary Search
// class Solution {
//         public int[] searchRange(int[] nums, int target) {
//                 int[] ans = { -1, -1 };
//                 int low = 0;
//                 int high = nums.length - 1;

//                 while (low <= high) {
//                         int mid = low + (high - low) / 2;
//                         if (nums[mid] < target) {
//                                 low = mid + 1;
//                         } else if (nums[mid] > target) {
//                                 high = mid - 1;
//                         } else if (nums[mid] == target) {
//                                 int i = mid;
//                                 while (mid > 0 && nums[mid] == nums[mid - 1]) {
//                                         mid--;
//                                 }
//                                 ans[0] = mid;
//                                 while (i < (nums.length - 1) && nums[i] == nums[i + 1]) {
//                                         i++;
//                                 }
//                                 ans[1] = i;
//                                 return ans;
//                         }
//                 }
//                 return ans;
//         }
// }

//Beats 100% | O(logN)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] ans = {-1, -1};

        ans[0] = search(nums, target, true);    
        ans[1] = search(nums, target, false);    
        return ans;
    }
    
    public int search(int [] nums, int target, boolean findFirstIndex){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > target){
                high = mid-1;
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else {
                //May be the potential answer
                if(findFirstIndex) {
                    ans = mid;
                    high = mid-1;
                }
                else {
                    ans = mid;
                    low = mid + 1;
                }
            }   
        }
        return ans;
    }
}