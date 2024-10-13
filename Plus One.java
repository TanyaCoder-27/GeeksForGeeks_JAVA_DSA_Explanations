/*
Plus One
Difficulty: EasyAccuracy: 28.75%Submissions: 73K+Points: 2
Given a non-negative number represented as a list of digits, add 1 to the number (increment the number represented by the digits). The digits are stored such that the most significant digit is first element of array.
 

Example 1:

Input: 
N = 3
arr[] = {1, 2, 4}
Output: 
1 2 5
Explanation:
124+1 = 125, and so the Output
Example 2:

Input: 
N = 3
arr[] = {9,9,9}
Output: 
1 0 0 0
Explanation:
999+1 = 1000, and so the output

Your Task:
You don't need to read input or print anything. You only need to complete the function increment() that takes an integer N, and an array arr of size N as input and returns a list of integers denoting the new number which we get after adding one to the number denoted by the array arr.


Expected Time Complexity:  O(N)
Expected Auxilliary Space: O(1)
 

Constraints:
1 <= N <= 105
0 <= arri <= 9
*/

import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> increment(ArrayList<Integer> arr , int N) {
        // Start from the last digit and move backwards
        for (int i = N - 1; i >= 0; i--) {
            // If the digit is less than 9, just increment the digit and return the array
            if (arr.get(i) < 9) {
                arr.set(i, arr.get(i) + 1);
                return arr;
            }
            // If the digit is 9, set it to 0 and continue the loop
            arr.set(i, 0);
        }
        // If all digits were 9, we need to add an additional 1 at the beginning
        arr.add(0, 1);
        return arr;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(4);
        System.out.println(sol.increment(arr1, arr1.size())); // Output: [1, 2, 5]

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(9);
        arr2.add(9);
        arr2.add(9);
        System.out.println(sol.increment(arr2, arr2.size())); // Output: [1, 0, 0, 0]
    }
}
/*

Explanation:
-Initialization:

The method increment takes an ArrayList<Integer> arr and its size N.

-Iterate from Last to First:

A loop starts from the last digit (index N-1) and moves backwards to the first digit (index 0).

-Check Each Digit:

If the current digit is less than 9, increment it by 1 and return the array since no further changes are needed.

If the current digit is 9, set it to 0 and continue to the next digit.

-Handle All Nines Case:

If all digits are 9, after the loop ends, the array will have all 0s. In this case, add 1 at the beginning of the array.

-Return Result:

Return the modified array.

This ensures that the time complexity is O(N) and the auxiliary space is O(1).
*/
