/*
The Even Array
Difficulty: EasyAccuracy: 46.21%Submissions: 5K+Points: 2
Given a string contains 'E' and 'O', 'E' represents a number is even and 'O' represents a number is odd. To make an element even, you can add 1 to any odd element of the array. Also, when any element of the array is converted to even, any neighboring element which is odd, can also be made even without adding 1. The task is to find the minimum number of additions required to make all the elements even.

Example 1:

Input: S = "EOOE"
Output: 1
Explanation: Add 1 to 2nd element, 
it's neighbour 3rd element will 
convert into even. 
Example 1:

Input: S = "EOOOOE"
Output: 1
Explanation: Add 1 to 2nd element, 
it's neighbour 3rd element will 
convert into even. Then 4th and 
5th elements too
Your Task:
You don't need to read input or print anything. Your task is to complete the function convertToEven() which takes a string as inputs and returns the minimum number of additions required.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).
*/

class Solution
{
    public int convertToEven(String s)
    {
        // Your code goes here
        int count = 0, n = s.length();
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='O'){
                while(i<n&&s.charAt(i)=='O'){
                    i++;
                }
                count++;
            }
            
        }
        return count;
    }
}
