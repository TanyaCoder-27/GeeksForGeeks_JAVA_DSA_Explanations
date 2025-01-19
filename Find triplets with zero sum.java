/*
Find triplets with zero sum
Difficulty: MediumAccuracy: 25.81%Submissions: 332K+Points: 4
Given an array arr[] of integers, determine whether it contains a triplet whose sum equals zero. Return true if such a triplet exists, otherwise, return false.

Examples:

Input: arr[] = [0, -1, 2, -3, 1]
Output: true
Explanation: The triplet [0, -1, 1] has a sum equal to zero.
Input: arr[] = [1, 2, 3]
Output: false
Explanation: No triplet with a sum of zero exists.
Input: arr[] = [-5, 3, 2, -1, 0, 1]
Output: true
Explanation: The triplet [-5, 3, 2] has a sum equal to zero.
Constraints:
1 <= arr.size() <= 103
-106 <= arr[i] <= 106

*/
import java.util.Arrays;

public class Solution {
    public boolean findTriplets(int arr[], int n) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) { // Changed to n - 2 to ensure at least 3 elements
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue; // Skip duplicate elements
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    return true; // Triplet found
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false; // No triplet found
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(sol.findTriplets(arr1, arr1.length)); // Output: true

        int[] arr2 = {1, 2, 3};
        System.out.println(sol.findTriplets(arr2, arr2.length)); // Output: false
    }
}


