/*
Count the Specials
Difficulty: EasyAccuracy: 30.81%Submissions: 24K+Points: 2
Given an array arr[] (may contain duplicates) and a positive integer k, your task is to count the number of elements whose occurrence is exactly equal to the size of array arr[] divided by k times.

Examples:

Input: k = 2, arr[] = [1, 4, 1, 2, 4]
Output: 2
Explanation:In the given array, 1 and 4 occurs floor(5/2) = 2 times.So count is 2.
Input: k = 4, arr[] = [1, 1, 7, 1]
Output: 1
Explanation:In the given array, only 7 occurs floor(4/4) = 1 times.So count is 1.
Expected Time Complexity: O(n). 
Expected Auxiliary Space: O(n).

Constraints:
1 <= arr.size() <= 105
1 <= arri <= 106
1 <= k <= arr.size()
*/

class Solution {
    public int countSpecials(int k, List<Integer> arr) {
        // floor(n/k) times -> which elements occurred that many times,their count has to get returned
        
        int n = arr.size();
        HashMap<Integer,Integer> freq = new HashMap<>();   //to calculate frequency of every element
        Set<Integer> unique = new HashSet<>();            // to get unique elements only so that in future, we can calculate frequency of unique elements and not for every element.
        for(int i: arr){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        int c=0;
        for(int j : arr){
            if(freq.get(j)==Math.floor(n/k)){
                if(!unique.contains(j)){
                    c++;
                    unique.add(j);
                }
            }
        }
        return c;
    }
}
