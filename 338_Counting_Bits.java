/*
338. Counting Bits
Problem Link: https://leetcode.com/problems/counting-bits/

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

*/

class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        int i = 1;
        while (i <= n) {
            if (i % 2 != 0) {
                arr[i] = arr[i - 1] + 1;
            } else
                arr[i] = arr[i / 2];
            i++;
        }
        return arr;
    }
}
