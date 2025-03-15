/*
N meetings in one room
Difficulty: EasyAccuracy: 45.3%Submissions: 318K+Points: 2Average Time: 20m
You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time. 

Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Examples :

Input: start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4), (5,7) and (8,9)
Input: start[] = [10, 12, 20], end[] = [20, 25, 30]
Output: 1
Explanation: Only one meetings can be held with given start and end timings.
Input: start[] = [1, 2], end[] = [100, 99]
Output: 1
Constraints:
1 ≤ n ≤ 105
0 ≤ start[i] < end[i] ≤ 106
*/

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // Create a list of Meeting objects
        ArrayList<Meeting> meet = new ArrayList<>();
        
        // Populate the list with meeting details
        for (int i = 0; i < start.length; i++) {
            meet.add(new Meeting(start[i], end[i], i + 1));
        }
        
        // Sort the meetings based on their end times
        Collections.sort(meet, new MeetingComp());
        
        // Initialize variables to count meetings and track the last meeting's end time
        int count = 1; // At least one meeting can always be held
        int limit = meet.get(0).end; // End time of the first meeting

        // Iterate through the remaining meetings
        for (int i = 1; i < meet.size(); i++) {
            if (meet.get(i).start > limit) { // If the meeting starts after the previous meeting ends
                count++; // Increment the meeting count
                limit = meet.get(i).end; // Update the limit to the current meeting's end time
            }
        }
        
        return count; // Return the total number of meetings
    }
}

// Class to represent a meeting
class Meeting {
    int start;
    int end;
    int pos;
    
    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

// Comparator class to sort meetings by end time
class MeetingComp implements Comparator<Meeting> {
    @Override
    public int compare(Meeting o1, Meeting o2) {     // compare method in Comparator interface should be Override
        if (o1.end < o2.end) return -1;
        else if (o1.end > o2.end) return 1;
        else if (o1.pos < o2.pos) return -1;
        return 1;
    }
}
