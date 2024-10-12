/*
Face off Tournament
Difficulty: BasicAccuracy: 40.47%Submissions: 5K+Points: 1
Ram and Rohan are participating in a tournament where they must compete against contenders whose strengths are given in an array arr[]. Ram's strength is m, and Rohan's strength is n. They take turns competing against the contenders, with Ram always going first. A contender is defeated if their strength is an exact multiple of either Ram's or Rohan's strength. Once defeated, a contender cannot compete again.

Determine who wins more matches: Ram or Rohan. If both win the same number of matches, declare both as winners.

Examples:

Input: arr[] = [4, 5, 7, 6, 9, 10, 14], m = 2, n = 3
Output: "Ram"
Explanation: Ram wins against contenders with strengths [4, 6, 10, 14]. Rohan wins against the contender with strength [9].
Input: arr[] = [1, 9, 9, 10, 9, 18], m = 5, n = 3
Output: "Rohan"
Explanation: Ram wins against the contender with strength [10]. Rohan wins against contenders with strengths [9, 9, 9, 18].
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ m, n ≤ 106
1 ≤ arr[i] ≤ 106
*/
class Solution {
    public String winner(int[] arr, int m, int n) {
        int ram =0 , rohan =0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]%m ==0){
                ram++;
            }
            else if(arr[i]%n==0){     //else if because 6 is taken off by m=2 then n=3 won't have chance to take it off again.
                rohan++;
            }
        }
        if(ram>rohan){
            return "Ram";
        }
        else if(rohan==ram){
            return "Both";
        }
        else{
            return "Rohan";
        }
    }
}
