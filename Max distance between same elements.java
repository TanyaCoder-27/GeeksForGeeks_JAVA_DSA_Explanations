/*
Max distance between same elements
Difficulty: EasyAccuracy: 46.67%Submissions: 69K+Points: 2
Given an array arr[] with repeated elements, the task is to find the maximum distance between two occurrences of an element.

Note: You may assume that every input array has repetitions.

Examples:

Input: arr = [1, 1, 2, 2, 2, 1]
Output: 5
Explanation: distance for 1 is: 5-0 = 5, distance for 2 is : 4-2 = 2, So max distance is 5.
Input: arr = [3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2]
Output: 10
Explanation: maximum distance for 2 is 11-1 = 10, maximum distance for 1 is 4-2 = 2 ,maximum distance for 4 is 10-5 = 5, So max distance is 10.
Expected Time Complexity :  O(n)
Expected Auxilliary Space : O(n)

Constraints:
1 <= arr.size() <= 106
1 <= arr[i] <= 109
*/

//method1:
import java.util.HashMap;

class Solution {
    public int maxDistance(int[] arr) {
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        int maxDistance = 0;

        for (int i = 0; i < arr.length; i++) {
            int firstIndex = firstOccurrence.getOrDefault(arr[i], -1);
            if (firstIndex == -1) {
                firstOccurrence.put(arr[i], i);
            } else {
                int distance = i - firstIndex;
                maxDistance = Math.max(maxDistance, distance);
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 1, 2, 2, 2, 1};
        System.out.println(sol.maxDistance(arr1)); // Output: 5

        int[] arr2 = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        System.out.println(sol.maxDistance(arr2)); // Output: 10
    }
}

/*
Explanation:
-Initialization:
Create a HashMap named firstOccurrence to store the first occurrence of each element.
Initialize maxDistance to keep track of the maximum distance.

-Loop Through Array:
Iterate through each element in the array.
Use getOrDefault to check if the element already has a recorded first occurrence. If not, it defaults to -1.
If firstIndex is -1, add the current index as the first occurrence.
If firstIndex is not -1, calculate the distance and update maxDistance if the calculated distance is greater.

-Return Result:
After processing all elements, return maxDistance.

Using getOrDefault makes the code cleaner by combining the lookup and default value handling in one step.
*/

//method2:
import java.util.HashMap;

class Solution {
    public int maxDistance(int[] arr) {
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        int maxDistance = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!firstOccurrence.containsKey(arr[i])) {
                firstOccurrence.put(arr[i], i);
            } else {
                int distance = i - firstOccurrence.get(arr[i]);
                maxDistance = Math.max(maxDistance, distance);
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 1, 2, 2, 2, 1};
        System.out.println(sol.maxDistance(arr1)); // Output: 5

        int[] arr2 = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        System.out.println(sol.maxDistance(arr2)); // Output: 10
    }
}

/*
Explanation:
-Initialization:
Create a HashMap named firstOccurrence to store the first occurrence of each element in the array.
Initialize maxDistance to 0 to keep track of the maximum distance found.

-Loop Through Array:
Iterate through each element in the array.
If the element is not in firstOccurrence, add it with its index.
If the element is already in firstOccurrence, calculate the distance between the current index and the stored index.
Update maxDistance if the calculated distance is greater.

-Return Result:
After processing all elements, return maxDistance.

*/
