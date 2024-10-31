/*
Kadane's Algorithm                                                                                
                                        
Difficulty: MediumAccuracy: 36.28%Submissions: 997K+Points: 4
Given an integer array arr[]. You need to find and return the maximum sum possible from all the subarrays.

Examples:

Input: arr[] = [1, 2, 3, -2, 5]
Output: 9
Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5).
Input: arr[] = [-1, -2, -3, -4]
Output: -1
Explanation: Max subarray sum is -1 of element (-1).
Input: arr[] = [5, 4, 7]
Output: 16
Explanation: Max subarray sum is 16 of elements (5, 4, 7)
Constraints:
1 ≤ arr.size() ≤ 105
-107 ≤ arr[i] ≤ 107
*/

class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        int cs=0;
        int ms=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            //aadding up the elements 
            cs+=arr[i];
            //assigning the maximum sum value to the varriable 
            if(ms<cs){
                ms=cs;
            }
            //if the sum value is less than zero then we will make it zero 
            if(cs<0){
                cs=0;
            }
        }
        return ms;
    }
}

/*

Explanation:
---Initialization:
                                        
int cs = 0; // Current Sum
int ms = Integer.MIN_VALUE; // Maximum Sum, initialized to the smallest possible integer value
---Iterating through the array:
for (int i = 0; i < arr.length; i++) {
    // Adding up the elements
    cs += arr[i];
The loop iterates through each element of the array.

cs keeps track of the current sum of the subarray.

---Updating the Maximum Sum:
                    
    // Assigning the maximum sum value to the variable
    if (ms < cs) {
        ms = cs;
    }
If the current sum (cs) is greater than the maximum sum (ms), update ms to be cs.

---Resetting the Current Sum:

    // If the sum value is less than zero then we will make it zero
    if (cs < 0) {
        cs = 0;
    }
If the current sum (cs) becomes negative, reset it to zero. This is because a negative sum would decrease the sum of any subsequent subarray, so it's better to start fresh from the next element.

---Returning the Maximum Sum:

return ms;
---Summary:
Current Sum (cs): Keeps track of the sum of the current subarray.

Maximum Sum (ms): Stores the maximum sum encountered so far.

---Resetting cs: If cs becomes negative, it is reset to zero to start a new subarray.

This algorithm efficiently finds the maximum sum of a contiguous subarray in linear time, O(n), making it very efficient for large arrays.
*/
