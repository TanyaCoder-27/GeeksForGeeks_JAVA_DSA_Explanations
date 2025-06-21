/*
k-Anagram
Difficulty: MediumAccuracy: 26.28%Submissions: 69K+Points: 4
Two strings are called k-anagrams if both of the below conditions are true.
1. Both have same number of characters.
2. Two strings can become anagram by changing at most k characters in a string.

Given two strings of lowercase alphabets and an integer value k, the task is to find if two strings are k-anagrams of each other or not.

Example:

Input: s1 = "fodr", s2 = "gork", k = 2
Output: true
Explanation: We can change 'f' -> 'g' and 'd' -> 'k' in s1.
Input: s1 = "geeks", s2 = "eggkf", k = 1
Output: false
Explanation: We can update or modify only 1 value but there is a need of modifying 2 characters i.e. 'g' and 'f' in s2.
Input: s1 = "adb", s2 = "fdab", k = 2
Output: false
Explanation: Both the strings have different numbers of characters.
Constraints:
1 ≤ s1.size(), s2.size() ≤ 105
1 ≤ k ≤ 105

*/

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        // code here
        // frequency map 
        int[] freq = new int[26];
        int count =0;
        
        //base case --> length equality
        if(s1.length() != s2.length()) return false;
        
        
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s2.length();i++){
            if(freq[s2.charAt(i)-'a'] > 0){    //correctly finds out where s2 lacks that s1 has
                freq[s2.charAt(i)-'a']--;
            }
            else{
                count++;
            }
            
            
            if(count > k){
                return false;
            }
        }
        
        return true;
    }
}
