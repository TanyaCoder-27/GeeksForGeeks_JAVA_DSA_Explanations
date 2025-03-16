/*
Shortest Job first
Difficulty: MediumAccuracy: 68.79%Submissions: 27K+Points: 4Average Time: 30m
Geek is a software engineer. He is assigned with the task of calculating average waiting time of all the processes by following shortest job first policy.

The shortest job first (SJF) or shortest job next, is a scheduling policy that selects the waiting process with the smallest execution time to execute next.

Given an array of integers bt of size n. Array bt denotes the burst time of each process. Calculate the average waiting time of all the processes and return the nearest integer which is smaller or equal to the output.

Note: Consider all process are available at time 0.

Example 1:

Input:
n = 5
bt = [4,3,7,1,2]
Output: 4
Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 4.
Example 2:

Input:
n = 4
arr = [1,2,3,4]
Output: 2
Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function solve() which takes bt[] as input parameter and returns the average waiting time of all the processes.

Expected Time Complexity: O(nlog(n))
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 105
1 <= arr[i] <= 105
*/

class Solution {
    static int solve(int bt[] ) {
    // code here
    int wait_time = 0;
    int process_time =0;
    int n = bt.length;
    
    Arrays.sort(bt); //SJF
    for(int i=0;i<n;i++){
        wait_time += process_time; //For each job, its waiting time is the sum of total time taken by all previous jobs.
        process_time += bt[i]; // Update the total time taken by adding the duration of the current job to the total waiting time.
    }
    return (wait_time/n);//Avg waiting time
  }
}
