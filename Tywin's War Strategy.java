/*
Tywin's War Strategy
Difficulty: BasicAccuracy: 30.61%Submissions: 4K+Points: 1
You are given an array arr where arr[i] represents the number of soldiers in the i-th troop. You are also given an integer k. A troop is considered "lucky" if its number of soldiers is a multiple of k. To win, at least half of the troops must be lucky. Your task is to calculate the minimum number of additional soldiers that need to be trained to achieve victory.

Examples:

Input: arr = [5, 6, 3, 2, 1], k = 2
Output: 1
Explanation: By training 1 additional soldier for the troop with 1 soldier, we get [5, 6, 3, 2, 2]. Now 3 out of 5 troops (6, 2, and 2) are multiples of 2, which is more than half.
Input: arr = [2, 3, 4, 9, 8, 7], k = 4
Output: 1
Explanation: By training 1 additional soldier for the troop with 3 soldiers, we get [2, 4, 4, 9, 8, 7]. Now 3 out of 6 troops (4, 4, and 8) are multiples of 4, which is exactly half.
Expected Time Complexity: O(n * log(n))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ k ≤ 10^5
1 ≤ arr[i] ≤ 10^5
*/

import java.util.Arrays;

class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int luckyCount = 0;
        
        // Count how many troops are already "lucky"
        for (int i : arr) {
            if (i % k == 0) {
                luckyCount++;
            }
        }
        
        // Calculate how many more "lucky" troops we need to win
        int requiredLucky = (n + 1) / 2; // half of the troops +1 if odd
        
        // If already enough lucky troops, return 0
        if (luckyCount >= requiredLucky) {
            return 0;
        }
        
        // Calculate the number of additional soldiers needed for each troop to become "lucky"
        int[] additionalSoldiers = new int[n];
        for (int i = 0; i < n; i++) {
            additionalSoldiers[i] = k - arr[i] % k;
        }
        
        // Sort the array to get the smallest additions first
        Arrays.sort(additionalSoldiers);
        
        // Add soldiers to make required number of troops "lucky"
        int soldiersNeeded = 0;
        for (int i = 0; i < requiredLucky - luckyCount; i++) {
            soldiersNeeded += additionalSoldiers[i];
        }
        
        return soldiersNeeded;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {5, 6, 3, 2, 1};
        int k1 = 2;
        System.out.println(sol.minSoldiers(arr1, k1)); // Output: 1

        int[] arr2 = {2, 3, 4, 9, 8, 7};
        int k2 = 4;
        System.out.println(sol.minSoldiers(arr2, k2)); // Output: 1
    }
}

/*
Step-by-Step Explanation:

-Count Existing Lucky Troops:

We start by counting how many troops are already "lucky" (i.e., arr[i] % k == 0).

-Determine Required Lucky Troops:

Calculate the required number of lucky troops to win (requiredLucky). This is at least half of the total troops, rounded up if the number of troops is odd ((n + 1) / 2).

-Check if Already Winning:

If we already have enough lucky troops (luckyCount >= requiredLucky), no additional soldiers are needed, so return 0.

-Calculate Additional Soldiers Needed:

For each troop, calculate how many additional soldiers are needed to make it "lucky" (additionalSoldiers[i] = k - arr[i] % k).

-Sort the Array:

Sort the additionalSoldiers array to ensure we add the smallest number of soldiers first.

-Sum the Required Additions:

Sum up the smallest required additions until we have enough lucky troops.

*/
