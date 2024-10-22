/*
Compatible friends
Difficulty: EasyAccuracy: 33.6%Submissions: 1K+Points: 2
Given two arrays arr1 and arr2. Return the count of i such that arr1[i]!=arr2[i] 

Examples:

Input: arr1[] = [3, 1, 2, 4, 5] and arr2[] = [3, 2, 4, 1, 5]
Output: 2
Explanation: Compatibility difference is two because first ranks movie 1 before 2 and 4 but other ranks it after. 
Input: arr1[] = [5, 3, 1, 2, 4] and arr2[] = [3, 1, 2, 4, 5]
Output: 5
Explanation: Total difference is four due to mis-match in position of 5.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106 --write java code with explanation
*/
public class Solution {
    public static int countDifferences(int[] arr1, int[] arr2) {
        int count = 0;
        // Traverse both arrays and compare each element
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1_1 = {3, 1, 2, 4, 5};
        int[] arr2_1 = {3, 2, 4, 1, 5};
        System.out.println(countDifferences(arr1_1, arr2_1)); // Output: 4

        // Example 2
        int[] arr1_2 = {5, 3, 1, 2, 4};
        int[] arr2_2 = {3, 1, 2, 4, 5};
        System.out.println(countDifferences(arr1_2, arr2_2)); // Output: 5
    }
}

/*
Explanation:
Function Definition: countDifferences is a function that takes two integer arrays arr1 and arr2 as inputs and returns the count of positions where the two arrays differ.

Initialization: Initialize a counter count to zero.

Traversal: Use a for loop to traverse the elements of both arrays simultaneously. For each index i, check if arr1[i] is not equal to arr2[i].

Comparison: If an element in arr1 is different from the corresponding element in arr2, increment the counter.

Return Result: Once the loop completes, the function returns the count of differences.

Constraints:
The time complexity is O(n), where n is the length of the arrays.

The auxiliary space is O(1) since no additional space is used except for a few variables.
*/
