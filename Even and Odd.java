/*
Even and Odd
Difficulty: EasyAccuracy: 59.75%Submissions: 23K+Points: 2
Given an array arr[] of size N containing equal number of odd and even numbers. Arrange the numbers in such a way that all the even numbers get the even index and odd numbers get the odd index.
Note: There are multiple possible solutions, Print any one of them. Also, 0-based indexing is considered.

Example 1:

Input:
N = 6
arr[] = {3, 6, 12, 1, 5, 8}
Output:
1
Explanation:
6 3 12 1 8 5 is a possible solution.
The output will always be 1 if your
rearrangement is correct.
Example 2:
Input:
N = 4
arr[] = {1, 2, 3, 4}
Output :
1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function reArrange() which takes an integer N and an array arr of size N as input and reArranges the array in Place without any extra space.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
*/

class Solution {
    static void reArrange(int[] arr, int N) {
        int evenIndex = 0;
        int oddIndex = 1;

        while (evenIndex < N && oddIndex < N) {
            if (arr[evenIndex] % 2 == 0) {
                evenIndex += 2;
            } else if (arr[oddIndex] % 2 == 1) {
                oddIndex += 2;
            } else {
                // Swap elements to place even at even index and odd at odd index
                int temp = arr[evenIndex];
                arr[evenIndex] = arr[oddIndex];
                arr[oddIndex] = temp;
                evenIndex += 2;
                oddIndex += 2;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {3, 6, 12, 1, 5, 8};
        sol.reArrange(arr, arr.length);
        for (int num : arr) {
            System.out.print(num + " ");
        } // Output will always be valid if the rearrangement is correct.
    }
}

/*
 Let's solve this problem by rearranging the array such that even numbers are at even indices and odd numbers are at odd indices.
 The constraints require us to perform this rearrangement in place without using any extra space, so we'll directly swap elements within the array.

Explanation:

Initialize Indices:

evenIndex is initialized to 0 (the first even index).

oddIndex is initialized to 1 (the first odd index).

Loop Through Array:

The while loop continues until both evenIndex and oddIndex are within the bounds of the array.

Check and Swap:

If arr[evenIndex] is even, increment evenIndex by 2 to check the next even index.

If arr[oddIndex] is odd, increment oddIndex by 2 to check the next odd index.

If an even number is found at an odd index or an odd number is found at an even index, swap them to correct their positions. Then, increment both evenIndex and oddIndex by 2.
*/
