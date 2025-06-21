/*

Anagram
Difficulty: EasyAccuracy: 44.93%Submissions: 409K+Points: 2Average Time: 20m
Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, "act" and "tac" are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

Note: You can assume both the strings s1 & s2 are non-empty.

Examples :

Input: s1 = "geeks", s2 = "kseeg"
Output: true
Explanation: Both the string have same characters with same frequency. So, they are anagrams.
Input: s1 = "allergy", s2 = "allergic"
Output: false
Explanation: Characters in both the strings are not same, so they are not anagrams.
Input: s1 = "g", s2 = "g"
Output: true
Explanation: Character in both the strings are same, so they are anagrams.
Constraints:
1 ≤ s1.size(), s2.size() ≤ 105

*/

class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        int[] freq = new int[26];  // 0 (a)  to 25(z)
        
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i) - 'a']++;
        }
        
        for(int j=0;j<s2.length();j++){
            freq[s2.charAt(j) - 'a']--;
        }
        
        for(int i=0;i<freq.length;i++){
            if(freq[i] !=0) return false;
        }
        
        return true;
    }
}
