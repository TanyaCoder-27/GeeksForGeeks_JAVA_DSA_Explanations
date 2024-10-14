/*

Sum of elements between k1'th and k2'th smallest elements
Difficulty: EasyAccuracy: 32.02%Submissions: 44K+Points: 2
Given an array A[] of N positive integers and two positive integers K1 and K2. Find the sum of all elements between K1th and K2th smallest elements of the array. It may be assumed that (1 <= k1 < k2 <= n).

 

Example 1:

Input:
N  = 7
A[] = {20, 8, 22, 4, 12, 10, 14}
K1 = 3, K2 = 6
Output:
26
Explanation:
3rd smallest element is 10
6th smallest element is 20
Element between 10 and 20 
12,14. Their sum = 26.
 

Example 2:

Input
N = 6
A[] = {10, 2, 50, 12, 48, 13}
K1= 2, K2 = 6
Output:
73
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function sumBetweenTwoKth() which takes the array A[], its size N and two integers K1 and K2 as inputs and returns the sum of all the elements between K1th and K2th smallest elements.
 

Expected Time Complexity: O(N. log(N))
Expected Auxiliary Space: O(N)

 

Constraints:
1 ≤ N ≤ 105
1 ≤ K1, K2 ≤ 105

*/

class Solution {
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        Arrays.sort(A);
        long sum = 0;

        // Sum elements between (K1-th + 1) and (K2-th - 1) smallest elements
        for (int i = (int) K1; i < (int) (K2 - 1); i++) {
            sum += A[i];
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        long[] arr = {8, 22, 4, 12, 10, 143, 6};
        long N = 7;
        long K1 = 2, K2 = 6;
        System.out.println(sol.sumBetweenTwoKth(arr, N, K1, K2)); // Output: 26
    }
}

/*
Explanation:
---Sort the Array:
Arrays.sort(A);
This step sorts the array so that we can determine the K1-th and K2-th smallest elements accurately.

---Initialize Sum:
long sum = 0;
We initialize the sum to zero.

---Sum Elements Between K1and K2:

for (int i = (int) K1; i < (int) (K2 - 1); i++) {
    sum += A[i];
}
Start from K1+1: Since array indexing starts at 0, the K1-th smallest element is at index K1−1. So, we start summing from the next element which is at index K1.

Stop at K2−1: Similarly, we stop before the K2-th smallest element, ensuring the range is between these two positions.

This ensures that we correctly sum the elements between the K1-th and K2-th smallest elements without including either.

*/
