## Wave Array
Difficulty: EasyAccuracy: 63.69%Submissions: 254K+Points: 2
Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place). In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
If there are multiple solutions, find the lexicographically smallest one.

Note: The given array is sorted in ascending order, and you don't need to return anything to change the original array.

Examples:

Input: n = 5, arr[] = {1,2,3,4,5}
Output: 2 1 4 3 5
Explanation: Array elements after sorting it in the waveform are 2 1 4 3 5.
Input: n = 6, arr[] = {2,4,7,8,9,10}
Output: 4 2 8 7 10 9
Explanation: Array elements after sorting it in the waveform are 4 2 8 7 10 9.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ n ≤ 106
0 ≤ arr[i] ≤107

## JAVA CODE:
```
class Solution {
    public static void convertToWave(int n, int[] arr) {
        // Traverse all even indexed elements
        for (int i = 0; i < n - 1; i += 2) {
            // Swap the current element with the next element
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}

```

## Explanation:
Traverse all even indexed elements using a loop simply and then swap the current element of even indexed elements with the next element.
