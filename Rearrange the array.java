/*
Rearrange the array
Difficulty: EasyAccuracy: 48.03%Submissions: 15K+Points: 2
Given an array arr[] containing integers,  your task is to print the array in the order – smallest number, largest number, 2nd smallest number, 2nd largest number, 3rd smallest number, 3rd largest number and so on.

Examples:

Input: arr[] = [1, 9, 2, 8, 3, 7, 4, 6, 5]
Output: [1, 9, 2, 8, 3, 7, 4, 6, 5]
Explanation: Smallest number is 1. Largest number is 9. 2nd smallest number is 2. Then 2nd largest number is 8. And so on.
Input: arr[] = [1, 2, 3, 4]
Output: [1, 4, 2, 3]
Expected Time Complexity: O(n*logn)
Expected Auxiliary Space: O(n)

Constraints: 
1 <= arr.size()<= 105
1 <= arr[i] <=106

*/

class Solution {
    public void rearrangeArray(int arr[]) {
        // code here.
        Arrays.sort(arr);
        int n=arr.length;
        int[] result= new int[n];
        int left=0;
        int right=n-1;
        for(int i=0;i<n;i++){
            if(i%2==0){
                result[i]=arr[left++];
            }else{
                result[i]=arr[right--];
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }
    }
}

/*

Sorting the Array: The array arr is sorted in ascending order using Arrays.sort(arr).

Initializations:

n is set to the length of arr.

An array res of the same length n is created to store the rearranged elements.

Two pointers, l (left) and r (right), are initialized to the start (0) and end (n-1) of arr respectively.

Rearrangement Loop:

A loop runs from 0 to n-1.

On even indices (i%2==0), elements from the left (l) of the sorted arr are placed into res, and l is incremented.

On odd indices, elements from the right (r) are placed into res, and r is decremented.

Copy Back to Original Array:

The rearranged elements in res are copied back to arr to reflect the new arrangement.

This code ensures that the array is sorted and then rearranged such that the smallest elements occupy even positions, and the largest elements occupy odd positions, resulting in a zigzag-like pattern.

*/
