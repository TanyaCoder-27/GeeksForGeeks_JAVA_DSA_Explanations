/*
Race in Fooland
Difficulty: EasyAccuracy: 20.0%Submissions: 3K+Points: 2
There is a multi-lane running track with lanes numbered from 1 to tracks (Tracks). There are some horizontal barriers placed across the lanes. Each barrier spans from lane start_i to lane end_i (both inclusive). The barriers may overlap, and athletes cannot run on lanes covered by a barrier.

Determine how many lanes are free from barriers and can be used by athletes.

Examples:

Input: tracks = 20, barriers = [(1, 3), (5, 8), (8, 13), (14, 15), (9, 12)]
Output: 6
Explanation:
The barriers cover the following lanes:
1 to 3, 5 to 8, 8 to 13, 14 to 15, 9 to 12
So, the lanes blocked by barriers are: {1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}.
The lanes that are free and not covered by barriers are: {4, 16, 17, 18, 19, 20}.
Therefore, 6 lanes are available for athletes to run.
Input: tracks = 10, barriers = [(1, 10), (3, 6)]
Output: 0
Explanation:
The barriers cover the following lanes:
1 to 10 (first barrier), 3 to 6 (second barrier, but already covered by the first one)
All lanes from 1 to 10 are blocked, so no lanes are available for athletes to run.
Expected Time Complexity: O(max(tracks, barriers.size()))
Expected Auxiliary Space: O(tracks)

Constraints:
1 ≤ n ≤ 106
1 ≤ barriers.size() ≤ 106
1 ≤ start_i ≤ end_i ≤ n
The barriers may overlap.
*/

class Solution {
    public int emptyLanes(int tracks, List<int[]> barriers) {
 
        boolean[]ch = new boolean[tracks+1];
        
        for(int[]a: barriers){
            int i = a[0], j = a[1];
             Arrays.fill(ch, i, j+1, true);
        }
        int c = 0;
        for(int i = 1; i<=tracks; i++){
            if(!ch[i])
                c++;
        }
        return c ;
    
    }
}

/*
Explanation
---Initialization:

boolean[] ch = new boolean[tracks + 1];

This initializes a boolean array ch with a size of tracks + 1. The additional element ensures that we can use 1-based indexing for convenience.

---Filling Barriers:

for (int[] a : barriers) {

This loop iterates over each barrier in the barriers list.

int i = a[0], j = a[1];

For each barrier, i and j represent the start and end positions of the barrier on the tracks.

Arrays.fill(ch, i, j + 1, true);

This line marks all tracks from position i to position j (inclusive) as occupied by setting those positions in the ch array to true.

---Counting Empty Lanes:

int c = 0;

This initializes a counter c to count the number of empty lanes.

for (int i = 1; i <= tracks; i++) {

This loop iterates through each track position from 1 to tracks.

if (!ch[i]) c++;

For each position, it checks if the track is not occupied (i.e., ch[i] is false). If it's empty, the counter c is incremented.

Returning the Result:

return c;

This returns the total count of empty lanes.

--Example
Let's say you have 5 tracks and barriers covering the following positions:

Barriers: [[1, 2], [4, 4]]

Step-by-Step Execution:

Initialize ch = [false, false, false, false, false, false].

Mark barriers:

For [1, 2]: ch = [false, true, true, false, false, false]

For [4, 4]: ch = [false, true, true, false, true, false]

Count empty lanes:

Tracks 3 and 5 are empty, so the count is 2.


*/
