/*
Longest Bitonic subsequence
Difficulty: MediumAccuracy: 47.34%Submissions: 122K+Points: 4
Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing. Return the maximum length of bitonic subsequence.
 
Note : A strictly increasing or a strictly decreasing sequence should not be considered as a bitonic sequence

Examples :

Input: n = 5, nums[] = [1, 2, 5, 3, 2]
Output: 5
Explanation: The sequence {1, 2, 5} is increasing and the sequence {3, 2} is decreasing so merging both we will get length 5.
Input: n = 8, nums[] = [1, 11, 2, 10, 4, 5, 2, 1]
Output: 6
Explanation: The bitonic sequence {1, 2, 10, 4, 2, 1} has length 6.
Input: n = 3, nums[] = [10, 20, 30]
Output: 0
Explanation: The decreasing or increasing part cannot be empty
Input: n = 3, nums[] = [10, 10, 10]
Output: 0
Explanation: The subsequences must be strictly increasing or decreasing
Constraints:
1 ≤ length of array ≤ 103
1 ≤ arr[i] ≤ 104

*/

class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        int lenBit = 0;
        int lis[] = new int[n];
        int lds[] = new int[n];
        
        //LIS
        
        for(int i=0;i<n;i++){    //i is the index ending
            lis[i] = 1;
            for(int j=0;j<i;j++){    // j -> previous indices
                if(nums[j] < nums[i]){
                    lis[i] = Math.max(lis[i], lis[j]+1); 
                }
            }
        }
        
        //LDS
        
        for(int i=n-1;i>=0;i--){  //i is the index starting (in array view)
            lds[i] =1;  
            for(int j=n-1 ; j>i;j--){   //j -> next indecies (in array view)
                if(nums[j]<nums[i]){
                    lds[i] = Math.max(lds[i],lds[j]+1);
                }
            }            
        }
        
        
        //LIS + LDS 
        
        for(int i=0;i<n;i++){
            if (lis[i] > 1 && lds[i] > 1){
                lenBit = Math.max(lenBit, lis[i]+lds[i]-1);
            }
            
        }
        
        return lenBit;
        
    }
}
