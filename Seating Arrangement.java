/*
Seating Arrangement
Difficulty: EasyAccuracy: 49.85%Submissions: 47K+Points: 2
You are given an integer n, denoting the number of people who needs to be seated, and a list of m integers seats, where 0 represents a vacant seat and 1 represents an already occupied seat.

Find whether all n people can find a seat, provided that no two people can sit next to each other.

Example 1:

Input:
n = 2
m = 7
seats[] = {0, 0, 1, 0, 0, 0, 1}
Output:
Yes
Explanation:
The two people can sit at index 0 and 4.
Example 2:

Input:
n = 1
m = 3
seats[] = {0, 1, 0}
Output:
No
Explanation:
There is no way to get a seat for one person.
Your Task:

You don't have to input or print anything. Complete the function is_possible_to_get_seats() which takes the input parameters and return a boolean value, indicating whether all people can find a seat.

Expected Time Complexity: O(m)
Expected Space Complexity: O(1)

Constraints:

0 <= n <= 105
1 <= m <= 105
seats[i] == 0 or seats[i] == 1
*/

class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        int availableSeats = 0;
        for (int i = 0; i < m; i++) {
            if (seats[i] == 0 && (i == 0 || seats[i - 1] == 0) && (i == m - 1 || seats[i + 1] == 0)) {
                availableSeats++;
                seats[i] = 1; // Mark this seat as occupied
                i++; // Skip the next seat to ensure no one sits next to each other
            }
            if (availableSeats >= n) {
                return true;
            }
        }
        return availableSeats >= n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] seats1 = {0, 0, 1, 0, 0, 0, 1};
        int n1 = 2, m1 = 7;
        System.out.println(sol.is_possible_to_get_seats(n1, m1, seats1)); // Output: Yes

        int[] seats2 = {0, 1, 0};
        int n2 = 1, m2 = 3;
        System.out.println(sol.is_possible_to_get_seats(n2, m2, seats2)); // Output: No
    }
}

/*
Explanation:

---Initialize Available Seats:
availableSeats tracks the count of seats where a person can sit without violating the no-adjacent rule.

---Loop Through Seats:
For each seat in the array:
Check if the current seat is empty (seats[i] == 0).
Check if the adjacent seats are also empty (or out of bounds at the edges).
If all conditions are met, increment availableSeats and mark the current seat as occupied (seats[i] = 1).
Skip the next seat (i++) to ensure no two people sit next to each other.
If availableSeats meets or exceeds n, return true immediately.

---Return Result:
If the loop finishes and availableSeats is less than n, return false.

This approach ensures an O(m) time complexity and O(1) auxiliary space as required.
*/
