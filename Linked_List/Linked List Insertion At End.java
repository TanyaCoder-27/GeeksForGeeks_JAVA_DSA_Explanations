/*

Linked List Insertion At End
Difficulty: BasicAccuracy: 43.96%Submissions: 336K+Points: 1Average Time: 20m
Given the head of a Singly Linked List and a value x, insert that value x at the end of the LinkedList and return the modified Linked List.

Examples :

Input: LinkedList: 1->2->3->4->5 , x = 6
Output: 1->2->3->4->5->6
Explanation: 

We can see that 6 is inserted at the end of the linkedlist.
Input: LinkedList: 5->4 , x = 1
Output: 5->4->1
Explanation: 

We can see that 1 is inserted at the end of the linkedlist.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
0 <= number of nodes <= 105
1 <= node->data , x <= 103
*/


/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        Node node = new Node(x); // Create the new node with value x
        if (head == null) { // If the list is empty
            head = node;
            return head;
        }

        Node temp = head; // Start from the head node
        while (temp.next != null) { // Traverse until the last node (the end goal is to point to the last node when loop ends!)
            temp = temp.next;
        }

        temp.next = node; // Set the next of the last node to the new node
        return head; // Return the head of the modified linked list
    }
}

