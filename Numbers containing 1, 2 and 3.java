/*
Numbers containing 1, 2 and 3
Difficulty: EasyAccuracy: 27.37%Submissions: 56K+Points: 2
You are given an array arr[] of integers. Your task is to find all the numbers in the array whose digits consist only of {1, 2, 3}.

Return an array containing only those numbers from arr. The order of the numbers in the output array should be the same as their order in the input array.

Examples:

Input: arr[] = [4, 6, 7]
Output: [-1]
Explanation: No elements are there in the array which contains digits 1, 2 or 3.
Input: arr[] = [1, 2, 13, 4] 
Output: [1, 2, 3]
Explanation: 1, 2 and 13 are the only elements in the array which contains digits as 1, 2 or 3.
Expected Time Complexity: O(n)
Expected Auxilliary Space: O(n)

Constraints:
1 <= arr.size <= 105
1 <= arr[i] <= 106
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> filterByDigits(List<Integer> arr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (isCheck(arr.get(i))) {
                res.add(arr.get(i));
            }
        }
        return res;
    }

    public static boolean isCheck(int n) {
        while (n != 0) {
            int r = n % 10;
            if (r != 1 && r != 2 && r != 3) {           
                return false;
            }
            n = n / 10;
        }
        return true;
    }
}

/*
Explanation:

--Import Required Packages:

import java.util.ArrayList;
import java.util.List;
This imports the necessary classes for working with lists.

--Define the Solution Class:

Defines the class Solution which contains the methods for filtering numbers.

--Method to Filter by Digits:

List<Integer> filterByDigits(List<Integer> arr): This method takes a list of integers arr and returns a filtered list.

ArrayList<Integer> res = new ArrayList<>();: Initializes an empty list res to store valid numbers.

for (int i = 0; i < arr.size(); i++): Loops through each element in the input list arr.

if (isCheck(arr.get(i))): Checks if the current element satisfies the condition (only contains digits 1, 2, 3).

res.add(arr.get(i));: Adds valid numbers to the res list.

return res;: Returns the filtered list.

--Helper Method to Check Digits:

    public static boolean isCheck(int n) {
        while (n != 0) {
            int r = n % 10;
            if (r != 1 && r != 2 && r != 3) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }
}

boolean isCheck(int n): Checks if a number n only contains digits 1, 2, or 3.

while (n != 0): Loops through each digit of the number.

int r = n % 10;: Extracts the last digit of n.

if (r != 1 && r != 2 && r != 3): Checks if the digit is not 1, 2, or 3. If so, it returns false.

n = n / 10;: Removes the last digit of n.

return true;: If all digits are 1, 2, or 3, it returns true.

This code ensures that only numbers composed of the digits 1, 2, and 3 are included in the result list.


-----NOTE: The condition in your isCheck method is checking each digit of the number. You want the function to return false if the digit is not 1, 2, or 3.

With || (OR), the condition would mean that if the digit is not 1 or not 2 or not 3, return false. However, every digit fails this condition, because every digit is either not 1, not 2, or not 3. So, it would always return false.

With && (AND), the condition means that if the digit is not 1 and not 2 and not 3, return false. This way, it only returns false if the digit is something other than 1, 2, or 3.

In essence, && makes sure that the digit is not any of the valid numbers (1, 2, 3), while || would incorrectly invalidate all digits.

*/
