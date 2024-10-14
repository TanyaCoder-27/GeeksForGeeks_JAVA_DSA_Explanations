/*
Pairs with Positive Negative values
Difficulty: EasyAccuracy: 20.79%Submissions: 31K+Points: 2
Given an array of integers, return all the elements having positive and negative values of a number that exists in the array.

Note : If no such pair exists, simply return an empty array, also multiple pairs of the same number could exist and you need to put each of them in the array. Return the pairs in sorted order.

Examples:

Input: arr[] = [1, -3, 2, 3, 6, -1, -3, 3]
Output: [-1, 1, -3, 3, -3, 3]
Explanation: The array contains both 1 and -1, and 3 & -3 two time.
Input: arr[] = [4, 8, 9, -4, 1, -1, -8, -9]
Output: [-1, 1, -4, 4, -8, 8, -9, 9]
Explanation: Here, the array contains the pairs 1 & -1, 4 & -4, 8 & -8, and 9 & -9.
Expected Time Complexity: O(n*log(n))
Expected Auxiliary Space: O(n)

Constraints:
1 <= arr.size() <= 105
-105 <= a[i] <= 105
*/

import java.util.*;

public class Solution {
    public static List<Integer> posNegPair(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            if (set.contains(-num)) {
                result.add(-Math.abs(num));
                result.add(Math.abs(num));
            } else {
                set.add(num);
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, -3, 2, 3, 6, -1, -3, 3};
        System.out.println(posNegPair(arr1)); // Output: [-1, 1, -3, 3, -3, 3]

        int[] arr2 = {4, 8, 9, -4, 1, -1, -8, -9};
        System.out.println(posNegPair(arr2)); // Output: [-1, 1, -4, 4, -8, 8, -9, 9]
    }
}

/*
Explanation:

Initialize Data Structures:
HashSet<Integer> named set to keep track of the numbers we've seen so far.
ArrayList<Integer> named result to store the pairs of positive and negative values.

Loop Through Array:
For each number num in the array:
Check if the HashSet contains -num (the opposite sign of num).
If it does, it means we have found a pair. Add both -Math.abs(num) and Math.abs(num) to the result list. Using Math.abs ensures the values are always sorted correctly (negative first, then positive).
If not, add num to the HashSet.

Sort and Return:
Sort the result list to ensure the pairs are in sorted order.
Return the result list.

This program efficiently finds pairs of positive and negative numbers and returns them in sorted order. 

Let's break down the for loop in more detail:

for (int num : arr) {
    if (set.contains(-num)) {
        result.add(-Math.abs(num));
        result.add(Math.abs(num));
    } else {
        set.add(num);
    }
}
Step-by-Step Explanation:
Initialize the Loop:
This loop iterates over each element num in the array arr.

Check for Complement:
if (set.contains(-num)) { checks if the set already contains the negative of the current number.
This is crucial because it determines if we've encountered both the positive and negative forms of the number.

Add to Result:
If the condition is true, it means both num and -num exist in the array.
We add both -Math.abs(num) and Math.abs(num) to the result list.

Math.abs ensures that we get the absolute value of num, and adding - ensures we are adding both the negative and positive forms in the correct order.

Add to Set:
If the condition is false, it means this is the first time we are seeing num, or we've only seen the negative or positive form of it so far.
else { set.add(num); } adds the current number to the set for future checks.

-----------------------------------
What Happens When the Condition is False
When if (set.contains(-num)) is false, it simply means we haven't seen the complementary pair (i.e., the negative of a positive number, or the positive of a negative number) before.

If the condition is false, it means that up to this point, the complementary pair hasn't been encountered.

Therefore, the current number (num) should be added to the set to account for future encounters with its complementary pair.

Example:
Let's use the input array [1, -3, 2, 3, 6, -1, -3, 3] to explain further:

Iteration 1 (num = 1):

set is empty, so it doesn't contain -1.

Add 1 to set.

set: {1}

Iteration 2 (num = -3):

set doesn't contain 3.

Add -3 to set.

set: {1, -3}

Iteration 3 (num = 2):

set doesn't contain -2.

Add 2 to set.

set: {1, -3, 2}

Iteration 4 (num = 3):

set contains -3.

Add -3 and 3 to result.

result: [-3, 3]

*/
