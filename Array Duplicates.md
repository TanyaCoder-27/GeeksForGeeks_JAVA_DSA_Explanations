## Array Duplicates
Difficulty: EasyAccuracy: 18.95%Submissions: 763K+Points: 2
## Given an array arr of size n which contains elements in range from 0 to n-1, you need to find all the elements occurring more than once in the given array. Return the answer in ascending order. If no such element is found, return list containing [-1]. 

Examples:

Input: n = 4, arr[] = [0,3,1,2]
Output: -1
Explanation: There is no repeating element in the array. Therefore output is -1.
Input: n = 5, arr[] = [2,3,1,2,3]
Output: 2 3 
Explanation: 2 and 3 occur more than once in the given array.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:

1 <= n <= 105
0 <= arr[i] <= 105, for each valid i

## JAVA CODE:
```
class Solution {
    public static ArrayList<Integer> duplicates(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        TreeMap<Integer,Integer> freq = new TreeMap<>();
        
        for(int i:arr){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        boolean flag = false;
        for(int j : freq.keySet()){
            if(freq.get(j)>1){
                flag = true;
                res.add(j);
            }
        }
        if(!flag){
            res.add(-1);
        }
        return res;
    }
}

```
