/*
Tough Competitors
Difficulty: BasicAccuracy: 45.39%Submissions: 7K+Points: 1
Given an array arr[] of non-negative integers representing the skill levels of competitors, determine the minimum absolute difference between the skills of any two competitors. Competitors are considered tough if their skill difference is the smallest among all possible pairs.

Examples:

Input: arr[] = [9, 4, 12, 6]
Output: 2
Explanation: The smallest difference between skill values is |4-6| = 2.
Input: arr[] = [4, 9, 1, 32, 12]
Output: 3
Explanation: The smallest differences are |4-1| = 3 and |9-12| = 3. Thus, the smallest difference is 3.
Expected Time Complexity: O(n log n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 106
*/

class Solution {
    public int minDiff(int[] arr) {
        Arrays.sort(arr); // to furtherly avoid negative values when calculating difference between current element and previous element
        int min_diff = Integer.MAX_VALUE;
        
        for(int i=1;i<=arr.length-1;i++){
            if((arr[i]-arr[i-1])<min_diff){
                min_diff = arr[i]-arr[i-1];
            }
        }
        return min_diff;
    }
}
