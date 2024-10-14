/*
Min sum formed by digits
Difficulty: EasyAccuracy: 57.25%Submissions: 44K+Points: 2
Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits of the array. All digits of the given array must be used to form the two numbers.

Any combination of digits may be used to form the two numbers to be summed.  Leading zeroes are permitted.

If forming two numbers is impossible (i.e. when n==0) then the "sum" is the value of the only number that can be formed.


 

 

Example 1:

Input:
N = 6
arr[] = {6, 8, 4, 5, 2, 3}
Output:
604
Explanation:
The minimum sum is formed by numbers 
358 and 246
 

Example 2:

Input:
N = 5
arr[] = {5, 3, 0, 7, 4}
Output:
82
Explanation:
The minimum sum is formed by numbers 
35 and 047


Your Task:
You don't have to print anything, printing is done by the driver code itself. Your task is to complete the function minSum() which takes the array A[] and its size N as inputs and returns the required sum.

Expected Time Complexity: O(N. log(N))
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 35
0 ≤ A[] ≤ 9
*/

class Solution { 
    public static long minSum(int arr[], int n) {
        Arrays.sort(arr); // Sort the array to minimize the resultant numbers

        long num1 = 0, num2 = 0;
        for (int i = 0; i < n; i++) {
            // Distribute digits alternately between num1 and num2
            if (i % 2 == 0) {
                num1 = num1 * 10 + arr[i];
            } else {
                num2 = num2 * 10 + arr[i];
            }
        }
        return num1 + num2; // Return the sum of the two numbers
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {6, 8, 4, 5, 2, 3};
        int n1 = 6;
        System.out.println(sol.minSum(arr1, n1)); // Output: 604

        int[] arr2 = {5, 3, 0, 7, 4};
        int n2 = 5;
        System.out.println(sol.minSum(arr2, n2)); // Output: 82
    }
}

/*

Explanation:
---Sort the Array:

This sorts the digits in ascending order to minimize the resultant numbers.

---Initialize Two Numbers:

long num1 = 0, num2 = 0;
We initialize two long variables num1 and num2 to store the two numbers formed from the digits.

---Distribute Digits Alternately:

for (int i = 0; i < n; i++) {
    if (i % 2 == 0) {
        num1 = num1 * 10 + arr[i];       // just like s=s*10+r  where r=n%10 (digit of number)
    } else {
        num2 = num2 * 10 + arr[i];
    }
}

We use a loop to distribute the digits alternately between num1 and num2.

if (i % 2 == 0): Add the digit to num1 if the index i is even.

else: Add the digit to num2 if the index i is odd.

---Return the Sum:
Finally, we return the sum of the two numbers formed.

This ensures we get the minimum possible sum of the two numbers formed from the array's digits.

*/
