## Array Leaders
Difficulty: EasyAccuracy: 29.94%Submissions: 743K+Points: 2
## Given an array arr of n positive integers, your task is to find all the leaders in the array. An element of the array is considered a leader if it is greater than all the elements on its right side or if it is equal to the maximum element on its right side. The rightmost element is always a leader.

Examples

Input: n = 6, arr[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
Input: n = 5, arr[] = {10,4,2,4,1}
Output: 10 4 4 1
Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side
Input: n = 4, arr[] = {5, 10, 20, 40} 
Output: 40
Explanation: When an array is sorted in increasing order, only the rightmost element is leader.
Input: n = 4, arr[] = {30, 10, 10, 5} 
Output: 30 10 10 5
Explanation: When an array is sorted in non-increasing order, all elements are leaders.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 107
0 <= arr[i] <= 107

## JAVA CODE:
```
import java.util.ArrayList;

class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int n, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Start with the last element as the initial leader
        int maxFromRight = arr[n - 1];
        result.add(maxFromRight);
        
        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                result.add(maxFromRight);
            }
        }
        
        // Reverse the result list to maintain the order
        Collections.reverse(result);
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        int[] arr2 = {10, 4, 2, 4, 1};
        
        System.out.println(leaders(arr1.length, arr1)); // Output: [17, 5, 2]
        System.out.println(leaders(arr2.length, arr2)); // Output: [10, 4, 4, 1]
    }
}

```

## Explanation:
Initialize Result List: Start with an empty list to store the leaders.

Start with the Last Element: The last element is always a leader.

Traverse from Right to Left: Compare each element with the maximum element found so far from the right (maxFromRight).

If the current element is greater than or equal to maxFromRight, update maxFromRight and add it to the result list.

Reverse the Result: Reverse the result list to maintain the original order of the leaders.

This approach ensures an O(n) time complexity and efficiently finds the leaders in the array. 
