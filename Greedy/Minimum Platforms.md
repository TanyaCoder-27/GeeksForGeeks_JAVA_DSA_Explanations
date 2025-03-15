### Minimum Platforms
- **Difficulty**: Medium  
- **Accuracy**: 26.84%  
- **Submissions**: 514K+  
- **Points**: 4  

You are given the arrival times `arr[]` and departure times `dep[]` of all trains that arrive at a railway station on the same day. Your task is to determine the **minimum number of platforms** required at the station to ensure that no train is kept waiting.

At any given time, the same platform cannot be used for both the arrival of one train and the departure of another. Therefore, when two trains arrive at the same time, or when one arrives before another departs, **additional platforms** are required to accommodate both trains.

---

### Examples:

#### Example 1:
- **Input**:  
  `arr[] = [900, 940, 950, 1100, 1500, 1800]`  
  `dep[] = [910, 1200, 1120, 1130, 1900, 2000]`  
- **Output**: `3`  
- **Explanation**: There are three trains during the time 9:40 to 12:00. So, we need a minimum of 3 platforms.

#### Example 2:
- **Input**:  
  `arr[] = [900, 1235, 1100]`  
  `dep[] = [1000, 1240, 1200]`  
- **Output**: `1`  
- **Explanation**: All train times are mutually exclusive. So, we need only 1 platform.

#### Example 3:
- **Input**:  
  `arr[] = [1000, 935, 1100]`  
  `dep[] = [1200, 1240, 1130]`  
- **Output**: `3`  
- **Explanation**: All 3 trains have to be there from 11:00 to 11:30.

---

### Constraints:
1. **1 ≤ Number of Trains ≤ 50,000**  
2. **0000 ≤ arr[i] ≤ dep[i] ≤ 2359**  
3. Time intervals are in the **24-hour format (HHMM)**:  
   - The first two characters represent the hour (between 00 to 23).  
   - The last two characters represent the minutes (between 00 and 59).

```
import java.util.Arrays;

class Solution {
    // Function to find the minimum number of platforms required at the railway station
    static int findPlatform(int arr[], int dep[]) {
        int max_plat = 1; // Maximum platforms needed
        int plat = 1; // Current platforms in use
        int n = arr.length; // Number of trains
        
        // Pointers for arrival and departure arrays
        int i = 1, j = 0;
        
        // Sort the arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        // Traverse events in sorted order
        while (i < n) { // Loop till all trains are processed
            if (arr[i] <= dep[j]) {
                // A train arrives before the earliest departure
                plat++;
                i++;
            } else {
                // A train departs
                plat--;
                j++;
            }
            // Update the maximum platforms needed
            max_plat = Math.max(max_plat, plat);
        }
        
        return max_plat;
    }
}
```
### Example Walkthrough:

#### Input:

arr = {900, 940, 950, 1100, 1500, 1800};
dep = {910, 1200, 1120, 1130, 1900, 2000};

#### Execution:
Sort the arrays:

arr = {900, 940, 950, 1100, 1500, 1800}

dep = {910, 1120, 1130, 1200, 1900, 2000}

Process Events:

Train at 900 arrives → plat = 1, max_plat = 1.

Train at 940 arrives → plat = 2, max_plat = 2.

Train at 950 arrives → plat = 3, max_plat = 3.

Train at 910 departs → plat = 2.

Train at 1120 departs → plat = 1.

Repeat for other events.

Output:

max_plat = 3

#### Complexity:
Time Complexity:
Sorting the arrays: O(n log n).

Iterating through the events: O(n).

Total: O(n log n).

Space Complexity:
Uses constant extra space apart from the input arrays: O(1).
