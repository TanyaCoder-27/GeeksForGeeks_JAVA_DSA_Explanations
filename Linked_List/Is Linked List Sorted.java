/*

Is Linked List Sorted
Difficulty: EasyAccuracy: 37.09%Submissions: 26K+Points: 2Average Time: 15m
Given a linked list of size n, you have to find whether the given linked list is sorted or not.
The sorting can either be non-increasing or non-decreasing.

Example 1:

Input:
LinkedList: 5->5->6->7->8
Output: 1
Example 2:

Input:
LinkedList: 2->5->7->8->99->7
Output: 0
Your Task:
The task is to complete the function isSorted() which takes head reference as argument. The function returns true if the LL is sorted, else it returns false. (The driver code prints 1 when the returned value is true, otherwise 0)

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= number of nodes <= 103
*/

//User function Template for Java


/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
*/

class Solution
{
    public static boolean isSorted(Node head)
    {
        if (head == null || head.next == null) {
            return true; // A single node or empty list is always sorted
        }

        boolean inc = true; // For increasing order
        boolean dec = true; // For decreasing order
        
        Node curr = head;

        while (curr.next != null) {
            if (curr.data > curr.next.data) {
                inc = false; // Not in increasing order
            }
            if (curr.data < curr.next.data) {
                dec = false; // Not in decreasing order
            }
            curr = curr.next; // Move to the next node
        }

        return inc || dec; // True if either order is satisfied
    }
}
