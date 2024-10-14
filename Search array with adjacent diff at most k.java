/*
Search array with adjacent diff at most k
Difficulty: EasyAccuracy: 57.91%Submissions: 50K+Points: 2
Given a step array arr[], its step value k, and a key x, we need to find the index of key x in the array arr[]. If multiple occurrences of key x exist, return the first occurrence of the key. In case of no occurrence of key x exists return -1.

Note: A step array is an array of integers where the difference between adjacent elements is at most k. For example: arr[] = [4, 6, 7, 9] and k = 2 is a step array as the difference between the adjacent elements in the arr[] is at most 2.  

Examples

Input: arr[] = [4, 5, 6, 7, 6] , k = 1 , x = 6
Output: 2
Explanation: In an array arr 6 is present at index 2. So, return 2.
Input: arr[] = [20, 40, 50], k = 20 , x = 70
Output: -1 
Explaination: As there is no occurrence of 70. So, return -1.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size ≤ 105
1 ≤ k ≤ 102
1 ≤ arr[i], x ≤ 105
*/

class Solution {
    public int findStepKeyIndex(int[] arr, int k, int x) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == x) {
                return i;
            }
            int step = Math.max(1, Math.abs(arr[i] - x) / k); // Calculate the step size
            i += step; // Move to the next relevant index
        }
        return -1; // Key not found
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {4, 5, 6, 7, 6};
        int k1 = 1, x1 = 6;
        System.out.println(sol.findStepKeyIndex(arr1, k1, x1)); // Output: 2

        int[] arr2 = {20, 40, 50};
        int k2 = 20, x2 = 70;
        System.out.println(sol.findStepKeyIndex(arr2, k2, x2)); // Output: -1
    }
}

/*
Explanation:
---Initialize Index: Start from the beginning of the array (i = 0).

---Loop Through Array:
Check if the current element equals the key x.
If found, return the current index i.
Calculate the step size: int step = Math.max(1, Math.abs(arr[i] - x) / k);. This ensures you move ahead by the maximum possible steps without skipping the key.
Move to the next relevant index by adding the step size to i.

---Return -1 If Not Found: If the loop completes without finding the key, return -1.

This approach ensures you utilize the step value k to efficiently search through the array, keeping the time complexity at O(n) while reducing unnecessary iterations.

***Calculation of Step Size***
int step = Math.max(1, Math.abs(arr[i] - x) / k);

Explanation:
Math.abs(arr[i] - x): This part calculates the absolute difference between the current element arr[i] and the target value x.
Math.abs is used to ensure the difference is always positive.

Math.abs(arr[i] - x) / k: This divides the absolute difference by the step value k.
This tells you how many steps of size k you need to skip over elements to directly reach closer to x.

Math.max(1, ...): This ensures that the step size is at least 1.
Without this, if the difference is smaller than k, the result of the division could be less than 1 (which isn't valid for an index move). Hence, the minimum step size is capped at 1 to ensure forward movement.

Example:
Consider the input array [4, 5, 6, 7, 6], k=1, and x=6.

Iteration 1 (i = 0, arr[i] = 4):

Math.abs(arr[0] - x) = Math.abs(4 - 6) = 2

2 / 1 = 2

Math.max(1, 2) = 2

Step size = 2, so the next index to check is i + 2 = 2.

Iteration 2 (i = 2, arr[i] = 6):

arr[2] equals x.

Return index 2.

Why This Works:
It ensures we skip over unnecessary elements efficiently.

By leveraging the property of step arrays (where the difference between adjacent elements is at most k), we can jump directly to indices that are more likely to contain x, rather than incrementing one by one.
*/
