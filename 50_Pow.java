/*
 * 50. Pow(x, n)
 * Problem Link:https://leetcode.com/problems/powx-n/
 * 
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * 
 * Example 1:
 * 
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 * 
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 * 
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */

//Brute Force - TLE - O(n)
/*
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        int y = n;
        if(n < 0) n = -1 * n;
        for(int i=0; i<n; i++){
            res = res * x;
        }
        if(y<0) return 1/res;
        return res;
}
}
*/

//Optimized Solution - Beats 100% - O(logn)
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        long pow = n;
        if (pow < 0)
            pow = -1 * pow;
        while (pow > 0) {
            if (pow % 2 == 0) {
                x = x * x;
                pow = pow / 2;
            } else {
                res = res * x;
                pow = pow - 1;
            }
        }
        if (n < 0)
            return 1 / res;
        return res;
    }
}