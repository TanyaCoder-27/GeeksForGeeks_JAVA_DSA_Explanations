/*
Longest Subarray with Sum K
Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
Constraints:
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104
-109 ≤ k ≤ 109
*/

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here

        int n = arr.length; 
        Map<Integer, Integer> preSumMap = new HashMap<>(); // sum,i
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            
            sum += arr[i];

            if (sum == k) {
                maxLen = i+1;
            }

            int rem = sum - k;

            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
}

/*
Prepare a Map for Prefix Sums:

A prefix sum is the sum of elements from the start of the array to a particular index.

We use a map to store these prefix sums and their corresponding indices.

Initialize Variables:

sum to keep the running sum of elements as we iterate through the array.

maxLen to keep track of the maximum length of subarrays that add up to k.

Iterate Through the Array:

For each element in the array, add it to sum.

If sum is equal to k, update maxLen to the current index plus one (i + 1).

Check for Remaining Sum:

Calculate the remaining sum (rem = sum - k).

If this remaining sum exists in our map, it means there's a subarray that adds up to k.

Calculate the length of this subarray and update maxLen if this length is greater than the current maxLen.

Update the Map:

If the current sum is not already in the map, add it along with the current index.
*/



  
