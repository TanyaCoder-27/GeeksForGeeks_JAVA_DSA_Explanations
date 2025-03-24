/*
Find length of the longest subarray containing atmost two distinct integers (Fruit into Baskets)
Difficulty: MediumAccuracy: 47.98%Submissions: 101K+Points: 4Average Time: 30m
Given an array arr[] containing positive elements, the task is to find the length of the longest subarray of an input array containing at most two distinct integers.

Examples:

Input: arr[]= [2, 1, 2]
Output: 3
Explanation: The entire array [2, 1, 2] contains at most two distinct integers (2 and 1). Hence, the length of the longest subarray is 3.
Input: arr[] = [3, 1, 2, 2, 2, 2]
Output: 5
Explanation: The longest subarray containing at most two distinct integers is [1, 2, 2, 2, 2], which has a length of 5. The subarray starts at the second element 1 and ends at the last element. It contains at most two distinct integers (1 and 2).
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] <=105

*/

import java.util.HashMap;

class Solution {
    public static int totalElements(Integer[] arr) {
        //sub array --> sliding window
        // longest --> length --> 2 pointers
        // atmost 2 distinct integers && freq --> HashMap
      
        int l = 0, r = 0, max_len = 0;
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            // Add the element at the right pointer to the map
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            // Shrink the window if there are more than 2 distinct integers
            while (map.size() > 2) {
                map.put(arr[l], map.get(arr[l]) - 1); // Decrease frequency,.get(key) to get the frequency count(value) of key
                if (map.get(arr[l]) == 0) {
                    map.remove(arr[l]); // Remove the key if frequency is 0, removing the key will lead to deletion of entire key-value pair
                }
                l++; // Move left pointer
            }

            // Update the maximum length of the subarray
            max_len = Math.max(max_len, r - l + 1);

            // Expand the window by moving the right pointer
            r++;
        }

        return max_len;
    }
}
