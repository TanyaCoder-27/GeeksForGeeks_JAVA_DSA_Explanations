/*

3 Sum Closest
Difficulty: MediumAccuracy: 49.69%Submissions: 19K+Points: 4
Given an array arr[] and an integer target, the task is to find the sum of three integers in arr[] such that the sum is closest to target. 

Note: If multiple sums are closest to target, return the maximum one.

Examples:

Input: arr[] = [-1, 2, 2, 4], target = 4
Output: 5
Explanation: All possible triplets
[-1, 2, 2], sum = (-1) + 2 + 2 = 3
[-1, 2, 4], sum = (-1) + 2 + 4 = 5
[-1, 2, 4], sum = (-1) + 2 + 4 = 5
[2, 2, 4], sum = 2 + 2 + 4 = 8
Triplet [-1, 2, 2], [-1, 2, 4] and [-1, 2, 4] have sum closest to target, so return the maximum one, that is 5.
Input: arr[] = [1, 10, 4, 5], target = 10
Output: 10
Explanation: All possible triplets
[1, 10, 4], sum = (1 + 10 + 4) = 15
[1, 10, 5], sum = (1 + 10 + 5) = 16
[1, 4, 5], sum = (1 + 4 + 5) = 10
[10, 4, 5], sum = (10 + 4 + 5) = 19 
Triplet [1, 4, 5] has sum = 10 which is closest to target.
Constraints:
3 <= arr.size() <= 103
-103 ≤ arr[i] ≤ 103
-104 ≤ target ≤ 104

*/

import java.util.Arrays;

class Solution {
    static int closest3Sum(int[] arr, int target) {
        Arrays.sort(arr);
        int closestSum = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                int diff = Math.abs(sum - target);

                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                } else if (diff == minDiff) {
                    closestSum = Math.max(closestSum, sum);
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {-1, 2, 2, 4};
        int target1 = 4;
        System.out.println(closest3Sum(arr1, target1)); // Output: 5

        int[] arr2 = {1, 10, 4, 5};
        int target2 = 10;
        System.out.println(closest3Sum(arr2, target2)); // Output: 10
    }
}


/*
Explanation:
Sorting: The array arr is sorted to apply the two-pointer technique.

Initialization: The variables closestSum and minDiff are initialized to store the closest sum found and the minimum difference between the sum and the target, respectively.

Outer Loop: The loop iterates over the array from the start to the third-last element, using the loop index i.

Two-Pointer Technique: For each i, two pointers (left and right) are initialized to find the closest triplet sum:

The left pointer starts from i + 1.

The right pointer starts from the end of the array.

Sum Calculation: The sum of the triplet (arr[i] + arr[left] + arr[right]) is calculated.

Update Closest Sum: If the absolute difference between the sum and the target is smaller than the current minimum difference, the closestSum and minDiff are updated.

If the difference is the same as the minimum difference, the maximum of the current closest sum and the new sum is stored.

Adjust Pointers: Depending on the sum value:

If the sum is less than the target, the left pointer is incremented.

If the sum is greater than or equal to the target, the right pointer is decremented.


*/
