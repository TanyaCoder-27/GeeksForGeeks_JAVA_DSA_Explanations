# Missing number
Difficulty: EasyAccuracy: 45.15%Submissions: 95K+Points: 2
## Ritu has all numbers from 2 to n in an array, arr of length n-1 except one number. You have to return the missing number, Ritu doesn't have from 1 to n.

## Note: Don't use Sorting

## Examples:

Input: n = 4, arr = [1,  4,  3]
Output: 2     
Explanation: Ritu doesn't have the number 2
Input: n = 5, arr = [2,  5,  3,  1]
Output: 4
Explanation: Ritu doesn't have number 4 in her collection
Expected Time Complexity: O(n)
Expected Auxillary Space: O(1)

## Constraints:
2 ≤ n ≤ 104
1 ≤ arr[i] ≤ n
arr.szie = n-1 

## Java Code:
```
class Solution {
    public static int missingNumber(int n, int[] arr) {
        int sn = (n*(n+1))/2;
        int s=0;
        
        for(int i=0;i<arr.length;i++){
            s+=arr[i];
        }
        
        return sn-s;
    }
}
        


```
