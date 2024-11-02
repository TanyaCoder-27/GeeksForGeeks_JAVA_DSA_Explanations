/*
Reverse alternate words
Difficulty: EasyAccuracy: 55.77%Submissions: 4K+Points: 2
Given a string str consisting of multiple words, reverse alternate words in str. 

Example 1:

Input:
str = geeks for geeks
Output: geeks rof geeks
Explanation: First and thrid word are as it is. 
Second word is reversed.

Example 2:

Input:
str = hello there peter pan
Output: hello ereht peter nap
Explanation: second and fourth words are reversed.

Your Task:  
You dont need to read input or print anything. Complete the function reverseAlternate() which takes string str as input parameter and returns the resultant string.


Expected Time Complexity: O(N) where N is the length of str.
Expected Auxiliary Space: O(N) 


Constraints:
1<= str.length() <= 104

*/

class Solution 
{ 
    String reverseAlternate(String s) 
    {
        // code here
        StringBuilder res = new StringBuilder();
        String[]t = s.split(" ");
        for(int i=0; i<t.length; i++){
            if(i%2==1){
                t[i] = rev(t[i]);
            }
            res.append(t[i]);
            if(i<t.length-1){
                res.append(" ");
            }
        }
        return res.toString();
        
        
    }
    String rev(String s){
        int i = 0, j = s.length()-1;
        char[]c = s.toCharArray();
        while(i<j){
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
            i++;
            j--;
        }
        return new String(c);
    }
} 
