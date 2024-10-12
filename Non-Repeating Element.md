# Non-Repeating Element
Difficulty: EasyAccuracy: 39.31%Submissions: 113K+Points: 2
## Find the first non-repeating element in a given array arr of integers and if there is not present any non-repeating element then return 0

Note: The array consists of only positive and negative integers and not zero.

## Examples:

Input: arr[] = [-1, 2, -1, 3, 2]
Output: 3
Explanation: -1 and 2 are repeating whereas 3 is the only number occuring once. Hence, the output is 3. 
Input: arr[] = [1, 1, 1]
Output: 0
Explanation: There is not present any non-repeating element so answer should be 0.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

## Constraints:
1 <= arr.size <= 106
-109 <= arr[i] <= 109
arr[i] != 0 

## JAVA Code:
```
class Solution {
    public int firstNonRepeating(int[] arr) {
       LinkedHashMap<Integer,Integer> uniq = new LinkedHashMap<>();
       
       for(int i: arr){
           uniq.put(i,uniq.getOrDefault(i,0)+1);
       }
       
       for(int j: uniq.keySet()){
           if(uniq.get(j)==1){
               return j;
           }
       }
       return 0;
    }
}
```
