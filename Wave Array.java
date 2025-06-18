/*
Wave Array
Difficulty: EasyAccuracy: 63.69%Submissions: 270K+Points: 2Average Time: 20m
Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place). In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
If there are multiple solutions, find the lexicographically smallest one.

Note: The given array is sorted in ascending order, and you don't need to return anything to change the original array.

Examples:

Input: arr[] = [1, 2, 3, 4, 5]
Output: [2, 1, 4, 3, 5]
Explanation: Array elements after sorting it in the waveform are 2, 1, 4, 3, 5.
Input: arr[] = [2, 4, 7, 8, 9, 10]
Output: [4, 2, 8, 7, 10, 9]
Explanation: Array elements after sorting it in the waveform are 4, 2, 8, 7, 10, 9.

Input: arr[] = [1]
Output: [1]
Constraints:
1 ≤ arr.size ≤ 106
0 ≤ arr[i] ≤107

*/

class Solution {
    public static void convertToWave(int[] arr) {
        // code here
        int n = arr.length;
        //create disturbance --> focus on even indexed --> even indexed elements have to be greater!
        for(int i =0;i<n;i+=2){
            
            if(i>0 && arr[i]<arr[i-1]){
                swap(arr,i,i-1);
            }
            else if (i<n-1 && arr[i]<arr[i+1]){
                swap(arr,i,i+1);
            }
            
            
        }
    }
    
    
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
