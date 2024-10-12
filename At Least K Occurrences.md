## At Least K Occurrences
Difficulty: EasyAccuracy: 37.11%Submissions: 200K+Points: 2
Given an array of n integers. Return the element that occurs at least k number of times.

Note:

If there are multiple answers, please return the first one.
If there is no element found, return -1.
Examples

Input: n = 7, k = 2, arr[] = [1, 7, 4, 3, 4, 8, 7]
Output: 4
Explanation: Both 7 and 4 occur 2 times. But 4 is first that occurs twice. As the index = 4, is the first element.
Input: n = 10, k = 3, arr[] = [3, 1, 3, 4, 5, 1, 3, 3, 5, 4]
Output: 3
Explanation: Here, 3 is the only number that appeared atleast 3 times in the array.
Input: n = 3, k = 10, arr[] = [10, 8, 2]
Output: -1
Explanation: Here no element is returning atleast 10 number of times, so -1.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= n <= 104
1 <= k <= 100
0 <= arr[i] <= 200

## JAVA CODE:
```
class Solution {
    public int firstElementKTime(int n, int k, int[] arr) {
        //atleast k times - greater than or equal to k
        HashMap<Integer,Integer> freq = new LinkedHashMap<>();
        
        for(int i: arr){
            freq.put(i,freq.getOrDefault(i,0)+1);
            //since first occurred, at the count of frequency only checked and returned.
            if(freq.get(i)==k){
                return i;
            }
        }
        return -1;
    }
}

```
