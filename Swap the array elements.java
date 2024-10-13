/*
Swap the array elements
Difficulty: EasyAccuracy: 64.61%Submissions: 87K+Points: 2
Given an array arr of n positive integers. The task is to swap every ith element of the array with (i+2)th element.

Example 1:

Input:
n = 3
arr[] = 1 2 3
Output:
3 2 1
Explanation:
Swapping 1 and 3, makes the array 3 2 1. There is only one swap possible in this array.
Example 2:

Input:
n = 5
arr[] = 1 2 3 4 5
Output:
3 4 5 2 1
Explanation:
Swapping 1 and 3, makes the array 3 2 1 4 5.
Now, swapping 2 and 4, makes the array 3 4 1 2 5. 
Again,swapping 1 and 5, makes the array 3 4 5 2 1.
Your Task:
Your task is to complete the function swapElements(), which should swap each ith element with (i+2)th element.

Expected Time Complexity: O(n)
Expected Auxilary Space: O(1)

Constraints:
1 <= n <= 106
0 <= arri <= 109


*/
class Solution
{
    public void swapElements(int[] arr, int n)
    {
        for(int i=0;i<n-2;i++){
            swap(arr[i],arr[i+2]);
        }
    }
    public static void swap(int a , int b){
        int temp = a;
        a=b;
        b=temp;
    }
}


//OR

class Solution {
    public void swapElements(int[] arr, int n) {
        for (int i = 0; i < n - 2; i++) {
            swap(arr, i, i + 2);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        sol.swapElements(arr, arr.length);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

/*
Explanation:
-swapElements Method:

Loop through the array up to n - 2 (to ensure i + 2 is within bounds).

Call the swap method to swap arr[i] and arr[i + 2].

-swap Method:

This method now takes the array and the indices i and j of the elements to be swapped.

Performs the swap within the array.

-main Method:

Demonstrates the usage of swapElements by initializing an example array and calling the method.

Prints the modified array.

*/
