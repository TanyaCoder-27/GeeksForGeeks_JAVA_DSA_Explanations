/*
Minimal Cost
Difficulty: MediumAccuracy: 51.08%Submissions: 94K+Points: 4Average Time: 20m
Given an array arr[] of size n, where arr[i] denotes the height of ith stone. Geek starts from stone 0 and from stone i, he can jump to stones i + 1, i + 2, … i + k. The cost for jumping from stone i to stone j is abs(arr[i] – arr[j]). Find the minimum cost for Geek to reach the last stone.

Example:

Input: k = 3, arr[]= [10, 30, 40, 50, 20]
Output: 30
Explanation: Geek will follow the path 1->2->5, the total cost would be |10-30| + |30-20| = 30, which is minimum.
Input: k = 1, arr[]= [10, 20, 10]
Output: 20
Explanation: Geek will follow the path 1->2->3, the total cost would be |10 - 20| + |20 - 10| = 20.
Constraints:

1 <= arr.size() <=104
1 <= k <= 100
1 <= arr[i] <= 104
*/

class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return comp(n-1,arr,dp,k);
    }
    
    public static int comp(int i, int[] arr,int[] dp, int k){
        if(i==0) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        int min_jumps = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(i-j>=0){
                int jumps = comp(i-j,arr,dp,k) + Math.abs(arr[i] - arr[i-j]);
                min_jumps = Math.min(jumps,min_jumps);
            }
        }
        return dp[i] = min_jumps;
    }
}
