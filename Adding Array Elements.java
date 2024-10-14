/*
Adding Array Elements
Difficulty: EasyAccuracy: 28.15%Submissions: 40K+Points: 2
Given an array Arr[] of size N and an integer K, you have to choose the first two minimum elements of the array and erase them, then insert the sum of these two elements in the array until all the elements are greater than or equal to K and find the number of such operations required.

Example 1:

Input:
N = 6, K = 6 
Arr[] = {1, 10, 12, 9, 2, 3}
Output: 2
Explanation: First we add (1 + 2), now the
new list becomes 3 10 12 9 3, then we add
(3 + 3), now the new list becomes 6 10 12 9,
Now all the elements in the list are greater
than 6. Hence the output is 2 i:e 2 operations
are required to do this. 
Example 2:

Input:
N = 4, K = 4
Arr[] = {5, 4, 6, 4}
Output: 0
Explanation: Every element in the given array 
is greater than or equal to K.
Your Task:
You don't need to read input or print anything. Your task is to complete the function minOperations() which takes array of integers arr, n and k as parameters and returns an integer denoting the answer. If it is not possible to make elements greater than or equal to K, return -1.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)

Constraints :
1 ≤ N, K ≤ 105
1 ≤ Arr[i] ≤ 106
*/

class Solution {
    int minOperations(int[] arr, int n, int k) {
        
        int res =0;
        PriorityQueue<Integer> minPQ =new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            minPQ.add(arr[i]);
        }
        
        //goal: minPQ.peek() >= k where peek() is the smallest element in Min Priority Queue.
        while(minPQ.peek()<k){
            int a = minPQ.poll();
            if(minPQ.isEmpty())
                return -1;
            int b = minPQ.poll();
            minPQ.add(a+b);
            res++;
        }
        
        return res;
        
    }
}

/*
---Class and Method Definition:

class Solution {
    int minOperations(int[] arr, int n, int k) {
You’ve defined a class Solution and a method minOperations that takes an array arr, an integer n (the size of the array), and an integer k.

---Initializing Variables:

int ans=0;
PriorityQueue<Integer> PQ= new PriorityQueue<>();

ans is initialized to 0. This will keep track of the number of operations performed.
PQ is a PriorityQueue which will store the elements in ascending order.

---Populating the PriorityQueue:

for(int i=0; i<n; i++){
    PQ.add(arr[i]);
}

You loop through the array and add each element to the PriorityQueue.

---Performing Operations:

while(PQ.peek()<k){
    int a=PQ.poll();
    if(PQ.isEmpty()) return -1;
    int b=PQ.poll();
    PQ.add(a+b);
    ans++;
}

The while loop continues as long as the smallest element in PQ (given by PQ.peek()) is less than k.

Within the loop:
You remove (poll()) the smallest element a from PQ.
If PQ is empty after removing a, the method returns -1, indicating it’s not possible to reach k.
Otherwise, you remove the next smallest element b.
You add the sum of a and b back to PQ.
Increment ans to count this operation.

---Return the Result:

return ans;

After the loop, if all elements in PQ are greater than or equal to k, return the number of operations stored in ans.

In essence, this code merges the two smallest elements of the array until all elements are at least k. If it’s not possible, it returns -1.

*/
