/*

Friendly Array
Difficulty: BasicAccuracy: 54.89%Submissions: 6K+Points: 1
Numbers have a measure of friendliness defined as the absolute difference between them. Given an circular array of integers arr[], calculate the friendliness of the array. Friendliness is the sum of the absolute differences between each element and its closest friend in the array.

Examples:

Input: arr[] = [4, 1, 5]
Output: 8
Explanation: The sum of absolute differences with closest neighbors is |4-1| + |1-5| + |5-4| = 8.
Input: arr[] = [1, 1, 1]
Output: 0
Explanation: All elements are identical, so the sum of differences is zero.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
2 < arr.size() ≤ 106
1 ≤ arr[i] ≤ 105

*/

class Solution {
    public int calculateFriendliness(int[] arr) {
        int n = arr.length, s=0;
        
        for(int i=0;i<n-1;i++){
            s+=Math.abs(arr[i]-arr[i+1]);
        }
        s+=Math.abs(arr[0]-arr[n-1]);
        return s;
    }
}
