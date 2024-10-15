/*

Star elements
Difficulty: EasyAccuracy: 18.64%Submissions: 20K+Points: 2
Given an unsorted array arr. Find all the star elements in the array. Star elements are those elements that are strictly greater than all the elements on its right side.

Note: Assume the first element is greater than all the elements on its left side and the last element is greater than all the elements on its right side.

Examples:

Input: arr[] = [1, 6, 5, 4, 7, 8, 4, 3, 2, 1]
Output: [8, 4, 3, 2, 1] 
Explanation: Star elements are 8, 4, 3, 2 and 1.
Input: arr[] = [1, 2, 10, 3, 4, 5, 8, 10, 4]
Output: [10, 4] 
Explanation: Star elements are 10 and 4.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 106

*/

import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> getStar(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();

        int max = arr[arr.length - 1];
        res.add(max);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                res.add(max);
            }
        }

        // Bubble sort to sort `res` in descending order
        for (int i = 0; i < res.size() - 1; i++) {
            for (int j = 0; j < res.size() - 1 - i; j++) {
                if (res.get(j) < res.get(j + 1)) {
                    // Swap res[j] and res[j + 1]
                    int temp = res.get(j);
                    res.set(j, res.get(j + 1));
                    res.set(j + 1, temp);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {10, 5, 9, 15, 7, 12};
        ArrayList<Integer> result = sol.getStar(arr);
        System.out.println(result); // Expected output: [15, 12]
    }
}

/*
Explanation:
Initial Max Value:

Initialize max with the last element in the array.

Add this max value to the result list res.

Iterate Backward Through the Array:

Start from the second last element (arr.length - 2).

Check if the current element arr[i] is greater than max. If so, update max and add it to res.

Bubble Sort:

A nested loop is used to implement the bubble sort algorithm.

The outer loop runs from 0 to res.size() - 1.

The inner loop runs from 0 to res.size() - 1 - i, comparing adjacent elements.

If the current element is less than the next element, they are swapped to move larger elements to the front.

This will sort the res list in descending order without using the Collections class, which is not imported in the driver class of GFG.

*/
