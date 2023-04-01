/*
 * 852. Peak Index in a Mountain Array
 * Problem Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * An array arr a mountain if the following properties hold:
 * 
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] <
 * ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 * 
 * You must solve it in O(log(arr.length)) time complexity.
 * 
 * Example 1:
 * Input: arr = [0,1,0]
 * Output: 1
 * Example 2:
 * Input: arr = [0,2,1,0]
 * Output: 1
 * Example 3:
 * Input: arr = [0,10,5,2]
 * Output: 1
 * 
 * Constraints:
 * 
 * 3 <= arr.length <= 105
 * 0 <= arr[i] <= 106
 * arr is guaranteed to be a mountain array.
 */
//Beats 14% | O(N)
// class Solution {
//     public int peakIndexInMountainArray(int[] arr) {
//         int i=1;
//         while(i<arr.length-1){
//             if(arr[i]>arr[i+1])
//                 return i;
//             i++;
//         }
//         return 0;
//     }
// }

//Beats 100% l| Binary Search | O(LogN)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else
                high = mid;
        }
        return low;
    }
}