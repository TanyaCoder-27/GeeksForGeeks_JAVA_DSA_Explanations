/*
Second most repeated string in a sequence
Difficulty: EasyAccuracy: 45.95%Submissions: 76K+Points: 2
Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.

Note: No two strings are the second most repeated, there will be always a single string.

Example 1:

Input:
N = 6
arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
Output: bbb
Explanation: "bbb" is the second most 
occurring string with frequency 2.

Example 2:

Input: 
N = 6
arr[] = {geek, for, geek, for, geek, aaa}
Output: for
Explanation: "for" is the second most
occurring string with frequency 2.

Your Task:
You don't need to read input or print anything. Your task is to complete the function secFrequent() which takes the string array arr[] and its size N as inputs and returns the second most frequent string in the array. If no such string exists, then return an empty string.


Expected Time Complexity: O(N*max(|Si|).
Expected Auxiliary Space: O(N*max(|Si|).


Constraints:
1<=N<=103


*/


// User function Template for Java

class Solution {
    String secFrequent(String arr[], int N) {
        // your code here
        HashMap <String, Integer> freq = new HashMap<>();
        
        for(String str : arr){
            freq.put(str,freq.getOrDefault(str,0)+1);
        }
        
        String max1w="", max2w="";
        int max1=0,max2=0;
        
        for(String wordkey :freq.keySet() ){
            int count = freq.get(wordkey);
            String curr_word = wordkey;
            
            
            if(count > max1){
                max2= max1;
                max2w = max1w;
                
                max1 = count;
                max1w = curr_word;
                
            }
            else if(count>max2){
                
                max2 = count;
                max2w = curr_word;
            }
        }
        
        return max2w;
    }
}
