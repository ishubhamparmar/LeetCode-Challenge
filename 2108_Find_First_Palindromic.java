/*
2108. Find First Palindromic String in the Array
Problem Link: https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

A string is palindromic if it reads the same forward and backward.

Example 1:

Input: words = ["abc","car","ada","racecar","cool"]
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.
*/

//Beats 11% - O(N2)
// class Solution {
//     public String firstPalindrome(String[] words) {
//         String revs = "";
//         String str = "";
//         for(int i=0; i<words.length; i++){
//             str = words[i];
//             for(int j=str.length()-1; j>=0; j--){
//                 revs += str.charAt(j);
//             }
//             if(revs.equals(str)) return str;
//             revs = "";
//         }
//         return "";
//     }
// }

//Beats 99.7%
class Solution {
    public String firstPalindrome(String[] words) {
        for(String str : words){
            if(isp(str))    return str;
        }
        return "";
    }
    public boolean isp(String str){
        int low = 0; 
        int high = str.length()-1;
        while(low<=high){
            if(str.charAt(low++)!=str.charAt(high--))   
                return false;
        }
        return true;
    }
}