/*
    1539. Kth Missing Positive Number
    Problem Link: https://leetcode.com/problems/kth-missing-positive-number/
    
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
Return the kth positive integer that is missing from this array.
Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
*/

// Beats 5% O(N)
// class Solution {
//     public int findKthPositive(int[] arr, int k) {
//         List<Integer> al = new ArrayList<>();
//         List<Integer> al2 = new ArrayList<>();
//         for(int i=0; i<arr.length; i++){
//             al.add(arr[i]);
//         }
//         for(int i=1; i<arr[arr.length-1]; i++){
//             if(al.contains(i))  continue;
//             al2.add(i);
//         }
//         if(al2.size()<k)
//             return arr[arr.length-1]+k-al2.size();
//         return al2.get(k-1);
//     }
// }

//By Binary Search O(logn) Beats 100%
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]-(mid+1)>=k)
                high=mid-1;
            else
                low=mid+1;
        }
        return low+k;
    }
}

