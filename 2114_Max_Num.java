/*

2114. Maximum Number of Words Found in Sentences
Problem Link: https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

A sentence is a list of words that are separated by a single space with no leading or trailing spaces.

You are given an array of strings sentences, where each sentences[i] represents a single sentence.

Return the maximum number of words that appear in a single sentence.
Example 1:

Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
Output: 6
 */


/* Brute Force - Beats 31% - No TLE - O(N2) */
/*

class Solution {
    public int mostWordsFound(String[] sentences) {
       int maxWords = 0;
       for(int i=0; i<sentences.length; i++){
           int words = 0;
           for(int j=0; j<sentences[i].length(); j++){
               if(sentences[i].charAt(j)==' ')
                    words++;
           }
           maxWords = Math.max(maxWords, words+1);
       } 
       return maxWords;
    }
}

*/


// Beats 91% - Optimal - O(N)

class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for(int i=0; i<sentences.length; i++){
           String [] str = sentences[i].split(" ");
           int words = str.length;
           maxWords = Math.max(maxWords, words);
        } 
       return maxWords;
    }
}



