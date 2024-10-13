/*
Even occurring elements
Difficulty: BasicAccuracy: 33.95%Submissions: 7K+Points: 1
Given an array arr[] of integers, where most numbers occur an odd number of times, except for a few elements that appear an even number of times. Find and return the elements with even occurrences in the array.
If no such element exists, return -1.
Note: Elements should be returned in order of occurrence.

Examples:

Input: arr[] = [9, 12, 23, 10, 12, 12, 15, 23, 14, 12, 15]
Output: [12, 15, 23]
Explanation: The numbers 12, 15, and 23 each appear an even number of times.
Input: arr[] = [23, 12, 56, 34, 32]
Output: [-1]
Explanation: Every number in the array occurs an odd number of times.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:

1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 105
*/

class Solution {
    public List<Integer> findEvenOccurrences(int[] arr) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i:arr){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        
        for(int i:arr){
            if(freq.containsKey(i)&&freq.get(i)%2==0){
                res.add(i);
                freq.remove(i);
            }
        }
        if(res.isEmpty()){
            res.add(-1);
        }
        
        return res;
    }
}

/*
Explanation:
Step 1: Initialize Data Structures

HashMap<Integer, Integer> freq = new HashMap<>();
ArrayList<Integer> res = new ArrayList<>();
freq: A HashMap to keep track of the frequency of each number in the input array.
res: An ArrayList to store the result, i.e., numbers that appear an even number of times.

Step 2: Calculate Frequency of Each Number

Loop through the input array arr.

For each number i in the array, update its frequency count in the freq HashMap. If the number is not already in the map, use getOrDefault to set its count to 0 and then add 1.

Step 3: Identify Even Occurrences

for (int i : arr) {
    if (freq.containsKey(i) && freq.get(i) % 2 == 0) {
        res.add(i);
        freq.remove(i);
    }
}
Loop through the input array arr again.

For each number i, check if it is in the freq map and if its frequency is even.

If the frequency is even, add the number to the result list res and remove it from the freq map to avoid duplicates in the result.

Step 4: Handle Edge Case of No Even Occurrences

if (res.isEmpty()) {
    res.add(-1);
}
If the result list res is empty after the loop, add -1 to indicate that no number had an even frequency.

Step 5: Return the Result

return res;
Finally, return the result list res.

This code calculates the frequency of each number in the input array, identifies those that appear an even number of times, and returns them in a list. If no numbers appear an even number of times, it returns a list containing -1.
*/
