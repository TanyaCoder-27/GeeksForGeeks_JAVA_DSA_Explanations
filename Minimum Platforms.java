/*
Minimum Platforms
Difficulty: MediumAccuracy: 26.84%Submissions: 477K+Points: 4
Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.

Note: Time intervals are in the 24-hour format(HHMM) , where the first two characters represent hour (between 00 to 23 ) and the last two characters represent minutes (this will be <= 59 and >= 0).

Examples:

Input: arr[] = [0900, 0940, 0950, 1100, 1500, 1800], 
            dep[] = [0910, 1200, 1120, 1130, 1900, 2000]
Output: 3
Explanation: There are three trains during the time 0940 to 1200. So we need minimum 3 platforms.
Input: arr[] = [0900, 1235, 1100], 
            dep[] = [1000, 1240, 1200]
Output: 1
Explanation: All train times are mutually exlusive. So we need only one platform
Input: arr[] = [1000, 0935, 1100], 
            dep[] = [1200, 1240, 1130]
Output: 3
Explanation: All 3 trains have to be their from 11:00 to 11:30
Expected Time Complexity: O(nLogn)
Expected Auxiliary Space: O(n)

Constraints:

1≤ number of trains ≤ 50000
0000 ≤ arr[i] ≤ dep[i] ≤ 2359
*/

import java.util.Arrays;

class Solution {
    // Function to find the minimum number of platforms required at the railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Initialize pointers for arrival and departure arrays
        int i = 0, j = 0;
        int currentPlatforms = 0, maxPlatforms = 0;

        // Traverse both arrays
        while (i < n && j < n) {
            // If next event is arrival, increment current platforms count
            if (arr[i] <= dep[j]) {
                currentPlatforms++;
                i++;
            } else { // If next event is departure, decrement current platforms count
                currentPlatforms--;
                j++;
            }
            // Update the maximum platforms required
            maxPlatforms = Math.max(maxPlatforms, currentPlatforms);
        }
        return maxPlatforms;
    }

    public static void main(String[] args) {
        int arr1[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep1[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println("Minimum platforms needed: " + findPlatform(arr1, dep1)); // Output: 3

        int arr2[] = { 900, 1235, 1100 };
        int dep2[] = { 1000, 1240, 1200 };
        System.out.println("Minimum platforms needed: " + findPlatform(arr2, dep2)); // Output: 1

        int arr3[] = { 1000, 935, 1100 };
        int dep3[] = { 1200, 1240, 1130 };
        System.out.println("Minimum platforms needed: " + findPlatform(arr3, dep3)); // Output: 3
    }
}


/*
Problem Explanation
The problem is to find the minimum number of platforms required at a railway station so that no train has to wait. We are given arrival and departure times of trains, and we need to ensure that at no point in time two trains are using the same platform.

Approach
Sort Arrival and Departure Times:

Sort the arrival times array and the departure times array.

This helps in efficiently tracking when a platform gets free and when it's occupied again.

Use Two Pointers to Traverse Arrival and Departure Arrays:

Use two pointers to traverse through the arrival and departure times.

Use a variable to keep track of the current number of platforms needed and another to keep track of the maximum platforms required at any time.

Compare Times:

If the arrival time of the next train is less than or equal to the departure time of the currently considered train, increment the current platform count.

Otherwise, decrement the current platform count as a train departs.

Update Maximum Platforms Required:

Update the maximum platforms required if the current platform count exceeds the previously recorded maximum.

Explanation:
Sorting:

The arrival and departure times are sorted to process them in the order of events.

Two Pointers and Counters:

i and j pointers traverse the arrival and departure times respectively.

currentPlatforms tracks the number of platforms needed at any given time.

maxPlatforms tracks the maximum platforms needed.

Comparison and Update:

If the next event is an arrival (arr[i] <= dep[j]), increment currentPlatforms.

If the next event is a departure, decrement currentPlatforms.

Update maxPlatforms whenever currentPlatforms exceeds its current value.

This solution ensures efficient computation with a time complexity of O(n log n), making it suitable for large inputs as mentioned in the constraints.
*/
