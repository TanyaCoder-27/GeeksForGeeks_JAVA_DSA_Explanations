/*

Majority Element
Difficulty: MediumAccuracy: 27.82%Submissions: 660K+Points: 4
Given an array arr. Find the majority element in the array. If no majority exists, return -1.

A majority element in an array is an element that appears strictly more than arr.size()/2 times in the array.

Examples:

Input: arr[] = [3, 1, 3, 3, 2]
Output: 3
Explanation: Since, 3 is present more than n/2 times, so it is the majority element.
Input: arr[] = [7]
Output: 7
Explanation: Since, 7 is single element and present more than n/2 times, so it is the majority element.
Input: arr[] = [2, 13]
Output: -1
Explanation: Since, no element is present more than n/2 times, so there is no majority element.
Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i]≤ 105

*/

class Solution {
    static int majorityElement(int arr[]) {
        // your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        // Count occurrences of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find the majority element
        for (Integer key : map.keySet()) {
            if (map.get(key) > n / 2) {
                return key;
            }
        }

        // If no majority element found, return -1
        return -1;
    }
}
