/*

Minimum element in BST
Given the root of a Binary Search Tree. The task is to find the minimum valued element in this given BST.

Examples

Input: root = [5, 4, 6, 3, N, N, 7, 1]
ex-1
Output: 1
Input: root = [10, 5, 20, 2]
ex-2
Output: 2
Input: root = [10, N, 10, N, 11]
             10
              \
               10
                \
                 11
Output: 10
Constraints:
0 <= number of nodes <= 105
0 <= node->data <= 105
*/

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        while(root.left !=null){
            root = root.left;
        }
        
        return root.data;
    }
}
