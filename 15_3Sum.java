/*
 * 15. 3Sum - Medium
 * Problem Link: https://leetcode.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 
Constraints:
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */

//TLE
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         Arrays.sort(nums);
//         int n = nums.length;
//         for(int i=0; i<n; i++){
//             if(nums[i] > 0) return ans;
//             int start = i+1;
//             int end = n-1;
//             while(start < end) {
//                 if(nums[i] + nums[start] + nums[end] == 0) {
//                     List<Integer> al = new ArrayList<>();
//                     al.add(nums[i]);
//                     al.add(nums[start]);
//                     al.add(nums[end]);
//                     if(!ans.contains(al))   ans.add(al);
//                     start++;
//                     end--;
//                 }
//                 else if(nums[i] + nums[start] + nums[end] > 0) {
//                     end--;
//                 }
//                 else {
//                     start++;
//                 }
//             }
//         }
//         return ans;
//     }
// }

class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
                Set<List<Integer>> s = new HashSet<>();
                int n = nums.length;
                for (int i = 0; i < n; i++) {
                        Set<Integer> al = new HashSet<>();
                        for (int j = i + 1; j < n; j++) {
                                int k = -(nums[i] + nums[j]);
                                if (al.contains(k)) {
                                        List<Integer> h = Arrays.asList(nums[i], nums[j], k);
                                        Collections.sort(h);
                                        s.add(h);
                                }
                                al.add(nums[j]);
                        }
                }
                List<List<Integer>> m = new ArrayList<>(s);
                return m;
        }
}