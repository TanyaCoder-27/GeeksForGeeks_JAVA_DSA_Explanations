/*

Count Odd Even - Java
Difficulty: EasyAccuracy: 41.31%Submissions: 37K+Points: 2
Given an array arr[]. The task is to find the number of odd and even elements in the array.

Examples:

Input: arr[] = [1, 2, 3, 4, 5]
Output: 3 2
Explanation: In the given array, there are 3 odd elements (1, 3, 5) and 2 even elements (2 and 4).
Input: arr[] = [1, 6, 18, 7]
Output: 2 2
Explanation: In the given array, there are 2 odd elements (1, 7) and 2 even elements (6 and 18).
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size() <= 106
1 <= arri <= 106

*/
class Solution {
    public static void countOddEven(Integer arr[]) {
        int even = 0, odd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {       //Basic even and odd logic
                even++;
            } else {
                odd++;
            }
        }
        System.out.println(even + " " + odd);
    }
}
