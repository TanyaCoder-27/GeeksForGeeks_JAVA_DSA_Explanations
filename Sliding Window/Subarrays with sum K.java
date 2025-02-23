/*
Subarrays with sum K
Difficulty: MediumAccuracy: 49.74%Submissions: 71K+Points: 4
Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.

Examples:

Input: arr = [10, 2, -2, -20, 10], k = -10
Output: 3
Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
Input: arr = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.
Input: arr = [1, 3, 5], k = 0
Output: 0
Explaination: No subarray with 0 sum.
Constraints:

1 ≤ arr.size() ≤ 105
-103 ≤ arr[i] ≤ 103
-107 ≤ k ≤ 107
*/

import java.util.HashMap;

class Solution {
    public int countSubarrays(int arr[], int k) {
        // Set up a map to keep track of the sums
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        // We've seen a sum of 0 once
        prefixSumMap.put(0, 1);

        // Go through each number in the array
        for (int num : arr) {
            sum += num; // Add the number to our running sum

            // If sum - k exists in our map, we've found a section that adds up to k
            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k); // Add the number of times we've seen that sum
            }

            // Update our map with the current sum
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }
        
        // Return the total count of sections that add up to k
        return count;
    }
}

/*
Steps to Understand the Code:
Set Up Our Counting Tools:

We use a map (like a special kind of treasure map) to keep track of how many times we see certain sums of blocks.

Start Counting:

We start with a sum of 0 (pretend we haven't counted any blocks yet).

We also set up a count to keep track of how many good sections of blocks we find.

The Treasure Map:

We put a special mark on our map to say we have seen the sum 0 once. This helps us in our counting later on.

HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
prefixSumMap.put(0, 1);

Go Through Each Block:

We go through each block one by one.

Add the number on the block to our sum.

Check the Map:

Each time we get a new sum, we check our map. We want to see if we've seen a sum that, if we subtract k from our current sum, gives us a sum we've seen before. This means we've found a section of blocks that adds up to k!

If we find this, we add how many times we've seen that old sum to our count.

Update the Map:

Add our current sum to the map, or if it's already there, we increase the count of times we've seen this sum.

Return the Count:

After checking all the blocks, our count will tell us how many sections of blocks add up to k.
