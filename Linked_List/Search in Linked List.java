/*

Search in Linked List
Difficulty: EasyAccuracy: 65.4%Submissions: 97K+Points: 2Average Time: 10m
Given a linked list of n nodes and a key, the task is to check if the key is present in the linked list or not.

Example:

Input: n = 4, key = 3
1->2->3->4
Output: true
Explanation: 3 is present in Linked List, so the function returns true.
Constraint:
1 <= n <= 105
1 <= key <= 105

*/

// User function Template for Java

/* Node of a linked list
class Node {
    int data; // Stores the value of the node
    Node next; // Points to the next node in the list

    Node(int d) { // Constructor to initialize the node
        data = d;  // Assign the value to the node
        next = null; // By default, next is null
    }
}
*/

class Solution {
    /**
     * Function to search for a key in the linked list.
     *
     * @param n    The total number of nodes in the linked list (not used in logic).
     * @param head The head (starting node) of the linked list.
     * @param key  The value to be searched in the linked list.
     * @return True if the key is found, false otherwise.
     */
    static boolean searchKey(int n, Node head, int key) {
        // If the linked list is empty, return false
        if (head == null) {
            return false; // No nodes to search
        }

        // Initialize a temporary pointer to traverse the list
        Node temp = head;

        // Traverse the linked list until the end
        while (temp != null) {
            // Check if the current node's data matches the key
            if (temp.data == key) {
                return true; // Key found, return true
            }

            // Move to the next node in the list
            temp = temp.next;
        }

        // If the traversal is complete and key is not found, return false
        return false;
    }
}
