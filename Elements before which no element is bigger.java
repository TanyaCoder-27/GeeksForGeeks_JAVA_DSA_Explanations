/*
Elements before which no element is bigger
Difficulty: BasicAccuracy: 45.81%Submissions: 6K+Points: 1
You are given an array arr[] of integers. Your task is to find the count of elements before which all the elements are smaller. The first element is always counted as there are no elements before it.

Examples:

Input: arr[] = [10, 40, 23, 35, 50, 7]
Output: 3
Explanation: The elements 10, 40, and 50 are such that all preceding elements are smaller. Thus, the count is 3.
Input: arr[] = [5, 4, 1]
Output: 1
Explanation: Only the first element 5 is such that all preceding elements (none in this case) are smaller. Thus, the count is 1.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:

1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^9
*/

class Solution {
    public int countElements(int[] arr) {
        if (arr.length == 0)
        {
            return 0;
        }
        int count = 1;  
        int maxEle = arr[0];  
        for (int i = 1; i < arr.length; i++) 
        {
            if (arr[i] > maxEle) {
                count++;  
                maxEle = arr[i];  
            }
        }
        return count;
    
    }
}

/*
Explanation:
Step 1: Check if the Array is Empty
checks if the array arr is empty. If it is, the function returns 0 because there are no elements to count.

Step 2: Initialize Variables
count is initialized to 1 because we start by counting the first element.
maxEle is initialized to the first element of the array arr[0].

Step 3: Loop Through the Array
This loop starts from the second element (index 1) and goes through the entire array.
For each element arr[i], it checks if it is greater than maxEle.
If it is, it means we've found a new maximum element, so we:
Increment the count by 1.
Update maxEle to the current element arr[i].

Step 4: Return the Count
After the loop, the function returns the total count of elements that were greater than all previous elements.

This code counts how many times a new maximum element appears as you go through the array from left to right. It starts with the first element and checks each subsequent element to see if it's greater than the current maximum. If it is, it increments the count and updates the maximum.

*/
