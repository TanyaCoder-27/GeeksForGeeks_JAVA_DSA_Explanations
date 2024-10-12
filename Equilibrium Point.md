# Equilibrium Point
Difficulty: EasyAccuracy: 28.13%Submissions: 587K+Points: 2
## Given an array arr of non-negative numbers. The task is to find the first equilibrium point in an array. The equilibrium point in an array is an index (or position) such that the sum of all elements before that index is the same as the sum of elements after it.

Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists. 

Examples:

Input: arr[] = [1, 3, 5, 2, 2]
Output: 3 
Explanation: The equilibrium point is at position 3 as the sum of elements before it (1+3) = sum of elements after it (2+2). 
Input: arr[] = [1]
Output: 1
Explanation: Since there's only one element hence it's only the equilibrium point.
Input: n = 3, arr[] = [1, 2, 3]
Output: -1
Explanation: There is no equilibrium point in the given array.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

## Constraints:
1 <= arr.size <= 105
0 <= arr[i] <= 109

## JAVA Code:
```
class Solution {
    // Function to find the equilibrium point in the array.
    public static int equilibriumPoint(long arr[]) {
        int n = arr.length;
        
        // If there is only one element, it is the equilibrium point
        if (n == 1) return 1;

        // Calculate the total sum of the array
        long totalSum = 0;
        for (long num : arr) {
            totalSum += num;
        }

        // Initialize left sum to 0
        long leftSum = 0;

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Update the total sum by subtracting the current element
            totalSum -= arr[i];

            // If left sum equals total sum, we found the equilibrium point
            if (leftSum == totalSum) {
                return i + 1; // Return the position in 1-based indexing
            }

            // Update the left sum for the next iteration
            leftSum += arr[i];
        }

        // If no equilibrium point is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        long arr1[] = {1, 3, 5, 2, 2};
        long arr2[] = {1};
        long arr3[] = {1, 2, 3};

        System.out.println(equilibriumPoint(arr1)); // Output: 3
        System.out.println(equilibriumPoint(arr2)); // Output: 1
        System.out.println(equilibriumPoint(arr3)); // Output: -1
    }
}

```
## Explanation:
Total Sum Calculation:

First, compute the total sum of all elements in the array.

Initialize Left Sum:

Start with leftSum as 0.

Traverse the Array:

For each element in the array, subtract it from totalSum to get the right sum.

Check if leftSum is equal to totalSum. If so, the current index is the equilibrium point.

Add the current element to leftSum for the next iteration.

Return the Result:

If an equilibrium point is found, return its 1-based index.

If no equilibrium point is found, return -1.
