/*
Given an array and a number k, find the largest sum of contiguous array in the modified array which is formed by repeating the given array k times. 

Examples : 

Input  : arr[] = {-1, 10, 20}, k = 2
Output : 59
After concatenating array twice, we get {-1, 10, 20, -1, 10, 20} which has maximum subarray sum as 59.

Input  : arr[] = {-1, -2, -3}, k = 3
Output : -1
*/

public class MaxSubArraySumRepeated {

    // Classic Kadane’s Algorithm 
    private static long kadane(int[] arr) {
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            cs += arr[i];
            if (ms < cs) {
                ms = cs;
            }
            if (cs < 0) {
                cs = 0;
            }
        }
        return ms;
    }

    public static long maxSubArraySumRepeated(int[] arr, int k) {
        int n = arr.length;

        // Step 1: Run Kadane's once
        long kadaneOne = kadane(arr);

        // Step 2: Compute total, prefix, and suffix sums
        long totalSum = 0;
        long prefixSum = 0, maxPrefix = Long.MIN_VALUE;
        long suffixSum = 0, maxSuffix = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            prefixSum += arr[i];
            maxPrefix = Math.max(maxPrefix, prefixSum);
        }

        for (int i = n - 1; i >= 0; i--) {
            suffixSum += arr[i];
            maxSuffix = Math.max(maxSuffix, suffixSum);
        }

        // Step 3: Handle cases based on k
        if (k == 1) {
            return kadaneOne;
        }

        // Best sum could be a cross-boundary bridge
        long bridgeSum = maxPrefix + maxSuffix + (k - 2) * totalSum;

        return Math.max(kadaneOne, bridgeSum);
    }

    // Optional: main method to test
    public static void main(String[] args) {
        int[] arr1 = {-1, 10, 20};
        int k1 = 2;
        System.out.println("Max sum: " + maxSubArraySumRepeated(arr1, k1));  // Should print 59

        int[] arr2 = {-1, -2, -3};
        int k2 = 3;
        System.out.println("Max sum: " + maxSubArraySumRepeated(arr2, k2));  // Should print -1
    }
}
