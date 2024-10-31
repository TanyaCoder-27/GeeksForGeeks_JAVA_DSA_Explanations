/*
Minimize the Heights II
Difficulty: MediumAccuracy: 15.06%Submissions: 618K+Points: 4
Given an array arr[] denoting heights of N towers and a positive integer K.

For each tower, you must perform exactly one of the following operations exactly once.

Increase the height of the tower by K
Decrease the height of the tower by K
Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

You can find a slight modification of the problem here.
Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.

Examples :

Input: k = 2, arr[] = {1, 5, 8, 10}
Output: 5
Explanation: The array can be modified as {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.The difference between the largest and the smallest is 8-3 = 5.
Input: k = 3, arr[] = {3, 9, 12, 16, 20}
Output: 11
Explanation: The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.The difference between the largest and the smallest is 17-6 = 11. 
Expected Time Complexity: O(n*logn)
Expected Auxiliary Space: O(n)

Constraints
1 ≤ k ≤ 107
1 ≤ n ≤ 105
1 ≤ arr[i] ≤ 107
*/

class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;
        if (n == 1) {
            return 0;  // If there's only one element, the difference is 0
        }
        // Sort the array
        Arrays.sort(arr);
        // Initial difference between the largest and smallest values
        int ans = arr[n - 1] - arr[0];
        // Consider the smallest and largest possible heights
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        
        // Traverse through the array and calculate the minimum difference
        for (int i = 0; i < n - 1; i++) {
            int minHeight = Math.min(smallest, arr[i + 1] - k);
            int maxHeight = Math.max(largest, arr[i] + k);
            if (minHeight < 0) continue; // Skip negative heights
            ans = Math.min(ans, maxHeight - minHeight);
        }
        return ans;
    }
}







/*
Overview
The goal of this function is to minimize the difference between the highest and lowest values in an array after modifying each element by either adding or subtracting a given integer k.

Detailed Explanation
Function Definition:

class Solution {
    int getMinDiff(int[] arr, int k) {
---Initialization:

    int n = arr.length;
    if (n == 1) {
        return 0;  // If there's only one element, the difference is 0
    }
n holds the length of the array.

If the array has only one element, return 0 since there's no difference to minimize.

---Sort the Array:


    Arrays.sort(arr);
Sort the array to work with ordered elements, simplifying the calculations for differences.

---Initial Difference:

    int ans = arr[n - 1] - arr[0];
ans initializes to the difference between the largest and smallest elements in the sorted array.

---Define New Smallest and Largest Possible Heights:

    int smallest = arr[0] + k;
    int largest = arr[n - 1] - k;
smallest considers the smallest element increased by k.

largest considers the largest element decreased by k.

---Traverse Through the Array and Calculate the Minimum Difference:

    for (int i = 0; i < n - 1; i++) {
        int minHeight = Math.min(smallest, arr[i + 1] - k);
        int maxHeight = Math.max(largest, arr[i] + k);
        if (minHeight < 0) continue; // Skip negative heights
        ans = Math.min(ans, maxHeight - minHeight);
    }
Loop through each element (excluding the last one to avoid out-of-bounds error).

minHeight is the minimum between the smallest (considering the first element increased by k) and the next element decreased by k.

maxHeight is the maximum between the largest (considering the last element decreased by k) and the current element increased by k.

Skip iterations where minHeight becomes negative.

Update ans with the minimum difference found so far.

---Return the Result:
    return ans;
}
Example Walkthrough
Let's consider an example to understand better:

Input: arr = [1, 5, 8, 10], k = 2

Sorted Array: [1, 5, 8, 10]

Initial Difference: ans = 10 - 1 = 9

Smallest: 1 + 2 = 3

Largest: 10 - 2 = 8

Iteration:

For i = 0:

minHeight = min(3, 5 - 2) = min(3, 3) = 3

maxHeight = max(8, 1 + 2) = max(8, 3) = 8

ans = min(9, 8 - 3) = min(9, 5) = 5

For i = 1:

minHeight = min(3, 8 - 2) = min(3, 6) = 3

maxHeight = max(8, 5 + 2) = max(8, 7) = 8

ans = min(5, 8 - 3) = min(5, 5) = 5

For i = 2:

minHeight = min(3, 10 - 2) = min(3, 8) = 3

maxHeight = max(8, 8 + 2) = max(8, 10) = 10

ans = min(5, 10 - 3) = min(5, 7) = 5

Output: The function returns 5.

This solution efficiently minimizes the difference after adjusting the array elements using k.



*/
