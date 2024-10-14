/*

Remove duplicates in array
Difficulty: EasyAccuracy: 35.86%Submissions: 37K+Points: 2
Given an array arr consisting of positive integers numbers, remove all duplicates.

Example:

Input: arr[] = [2, 2, 3, 3, 7, 5] 
Output: [2, 3, 7, 5]
Explanation: After removing the duplicates 2 and 3 we get 2 3 7 5.
Input: arr[] = [2, 2, 5, 5, 7, 7] 
Output: [2, 5, 7]
Explanation: After removing the duplicates 2, 5 and 7 we get 2 5 7.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1<= arr.size() <=106
2<=arr[i]<=100

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {    
    ArrayList<Integer> removeDuplicate(int arr[]) {        
        ArrayList<Integer> res = new ArrayList<>();        
        Set<Integer> unique = new HashSet<>();        
        int n = arr.length;        
        
        for (int i = 0; i < n; i++) {            
            if (!unique.contains(arr[i])) {          //Entry Check  (for present)    
                res.add(arr[i]);                
                unique.add(arr[i]);                  //Exit Check (for future)
            }        
        }        
        return res;    
    }
}

/*
---Import Statements:

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

These statements import the necessary classes. ArrayList for dynamic arrays, HashSet for a collection that does not allow duplicates.

---Class and Method Definition:

class Solution {    
    ArrayList<Integer> removeDuplicate(int arr[]) { 
    
A class Solution is defined with a method removeDuplicate which takes an array of integers as input.

---Variable Initialization:

ArrayList<Integer> res = new ArrayList<>();        
Set<Integer> unique = new HashSet<>();        
int n = arr.length;

res is an ArrayList that will store the result without duplicates.
unique is a HashSet used to track elements that have already been added to res.
n stores the length of the array arr.

---Loop Through Array:

for (int i = 0; i < n; i++) {            
    if (!unique.contains(arr[i])) {                
        res.add(arr[i]);                
        unique.add(arr[i]);            
    }        
}

This is the most crucial part of the code.
The for loop iterates over each element in the array arr.
i is the loop variable starting from 0 up to n-1.

-**Inside the loop:

*Check for Duplicates:

if (!unique.contains(arr[i])) {
This line checks if the current element arr[i] is not already in the unique set. If it's not, it means this is the first time encountering this element.

*Add Element to Result:

res.add(arr[i]);
If the element is unique (not found in the unique set), it gets added to the res list.

*Track the Added Element:

unique.add(arr[i]);
After adding the element to res, it also gets added to the unique set to ensure it won't be added again in subsequent iterations.

---Return Result:

return res;    
Finally, after the loop has processed all elements, the method returns the res list, which now contains the elements of the original array without duplicates.

This code effectively removes duplicates by using a HashSet to track elements and ensures that each element is added only once to the result list.

*/
