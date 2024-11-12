## Meeting Rooms
Difficulty: MediumAccuracy: 68.38%Submissions: 11K+Points: 4
Given an array arr[][] such that arr[i][0] is the starting time of ith meeting and arr[i][1] is the ending time of ith meeting, the task is to check if it is possible for a person to attend all the meetings such that he can attend only one meeting at a particular time.

Note: A person can attend a meeting if its starting time is greater than or equal to the previous meeting's ending time.

### Examples:

Input: arr[][] = [[1, 4], [10, 15], [7, 10]]
Output: true
Explanation: Since all the meetings are held at different times, it is possible to attend all the meetings.
Input: arr[][] = [[2, 4], [9, 12], [6, 10]]
Output: false
Explanation: It is not possible to attend the second and third meetings simultaneously.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 2*106

```
class Solution {
    static boolean canAttend(int[][] arr) {
        // Your code here
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        for(int i=0; i<arr.length-1; i++){
            if(arr[i][1]>arr[i+1][0]) 
                return false;
        }
        return true;
    }
}

```

The code aims to determine whether it's possible to attend all meetings without any overlap. The input is an array of intervals, where each interval represents the start and end times of a meeting.

## Code Explanation
### Class and Method Definition:
```
class Solution {
    static boolean canAttend(int[][] arr) {
```
### Sorting Intervals by End Time:
```
    Arrays.sort(arr, (a, b) -> a[1] - b[1]);
```
This line sorts the intervals (meeting times) based on their end times.

The Arrays.sort method is used with a lambda expression (a, b) -> a[1] - b[1] that compares the end times (a[1] and b[1]) of two intervals.

Sorting by end time helps in easily checking for overlaps with subsequent intervals.

### Checking for Overlapping Intervals:
```
    for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i][1] > arr[i+1][0])
            return false;
    }
    return true;
}
```
This loop iterates through the sorted intervals to check for any overlaps.

if (arr[i][1] > arr[i+1][0]): This condition checks if the end time of the current interval (arr[i][1]) is greater than the start time of the next interval (arr[i+1][0]).

If the condition is true, it means there is an overlap, and the method returns false, indicating that it's not possible to attend all meetings without overlap.

If no overlaps are found after checking all intervals, the method returns true, indicating that it's possible to attend all meetings.

## Example Walkthrough
Suppose we have the following intervals:

[[1, 3], [2, 4], [3, 5]]
After sorting by end time, the intervals become:

[[1, 3], [3, 5], [2, 4]]
The loop checks for overlaps:

First iteration (i = 0): arr[0][1] = 3, arr[1][0] = 3. Since 3 <= 3, there's no overlap.

Second iteration (i = 1): arr[1][1] = 5, arr[2][0] = 2. Here, 5 > 2, indicating an overlap. The function returns false.

This function effectively checks for the feasibility of attending all meetings based on their start and end times.
