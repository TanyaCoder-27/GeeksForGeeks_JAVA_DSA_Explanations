/*
Magical Number
Difficulty: EasyAccuracy: 40.35%Submissions: 19K+Points: 2
Your friend loves magic and he has coined a new term - "Magical number". To perform his magic, he needs that magic number. You are given a sorted array arr of distinct integers. A number arr[i] is a magical number if arr[i] = i (0-based indexing).
You have to return the leftmost magical number present in the given array arr, if there is no magical number in the array arr then return -1

Examples:

Input: arr = [-2, -1, 2, 4, 6]
Output: 2
Explanation: There is only one magical number present at index 2 because arr[2] = 2.
Input: arr = [-1, 1, 2, 3, 5, 7]
Output: 1
Explanation: There are three magical numbers 1,2 and 3 present in the array, so leftmost magical number is 1.
Input: arr = [-12, 0, 1, 2, 3, 4]
Output: -1
Explanation: There is no magical numbers present in the array, so the output is -1. 
Expected Time Complexity: O(log(n))
Expected Space Complexity: O(1)

Constraints:
1 ≤ arr.size() ≤ 106
-109 ≤ arr[i] ≤ 109
*/

class Solution {
    public int findMagicalNumber(int[] arr) {
        //array traversal -> arr[i]==i
        //return as soon as you get the element since needed leftmost
        // return -1 if no such element
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==i){
                return i;
            }
        }
        return -1;
    }
}
