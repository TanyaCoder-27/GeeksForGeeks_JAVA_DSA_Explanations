/*
Longest Common Subsequence
Moderate
80/80
Contributed by
43 upvotes
Asked in companies
Problem statement
You have been given two Strings “STR1” and “STR2” of characters. Your task is to find the length of the longest common subsequence.

A String ‘a’ is a subsequence of a String ‘b’ if ‘a’ can be obtained from ‘b’ by deletion of several (possibly, zero or all) characters. A common subsequence of two Strings is a subsequence that is common to both Strings.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 50 
1 <= |STR1| <= 10^2
1 <= |STR2| <= 10^2

Where |STR1| and |STR2| denote the length of “STR1” and “STR2” respectively. 

Time Limit: 1 sec 
Sample Input 1 :
2
abc cadb
pqr tpuqvr
Sample output 1 :
2
3
Explanation For Sample Input 1 :
For the first test case, the longest common subsequence is “ab” and its length is 2.

For the second test case, the longest common subsequence is “pqr” and its length is 3.    
Sample Input 2 :
2
a b
a a
Sample output 2 :
0
1
Explanation For Sample Input 2 :
For the first test case, any non-empty common subsequence doesn’t exist. 

For the second test case, the longest common subsequence is “a” and its length is 1.    
*/

import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static int getLengthOfLCS(String  str1, String  str2)
    {
        // Write your code here.

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int row[] : dp){
            Arrays.fill(row,-1);
        }

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }

        for(int index = 1; index<=n;index++){
            for(int index2 = 1;index2 <=m ; index2++){
                if(str1.charAt(index-1) == str2.charAt(index2-1)){
                    dp[index][index2] = 1 + dp[index-1][index2-1];
                }
                else{
                    dp[index][index2] = Math.max(dp[index-1][index2], dp[index][index2-1]);
                }
            }
        }
        return dp[n][m];

        
    }
}
