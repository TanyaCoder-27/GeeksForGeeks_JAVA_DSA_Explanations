/*

Ceil in BST
Difficulty: MediumAccuracy: 62.73%Submissions: 133K+Points: 4Average Time: 30m
Given a BST and a number X, find Ceil of X.
Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.

If Ceil could not be found, return -1.

Example 1:

Input: root = [5, 1, 7, N, 2, N, N, N, 3], X = 3
      5
    /   \
   1     7
    \
     2 
      \
       3
Output: 3
Explanation: We find 3 in BST, so ceil of 3 is 3.
Example 2:

Input: root = [10, 5, 11, 4, 7, N, N, N, N, N, 8], X = 6
     10
    /  \
   5    11
  / \ 
 4   7
      \
       8
Output: 7
Explanation: We find 7 in BST, so ceil of 6 is 7.
Your task:
You don't need to read input or print anything. Just complete the function findCeil() to implement ceil in BST which returns the ceil of X in the given BST.

Constraints:
1 <= Number of nodes <= 105
1 <= Value of nodes<= 105

*/

class Tree {
    /**
     * Function to return the ceil of a given number in the Binary Search Tree (BST).
     * 
     * Ceil(X) is defined as:
     * - The smallest element in the BST that is greater than or equal to X.
     * - If such an element does not exist, return -1.
     * 
     * @param root - The root node of the BST.
     * @param key - The value for which we need to find the ceil.
     * @return The ceil value if it exists, otherwise -1.
     */
    int findCeil(Node root, int key) {
        // Initialize the variable to store the ceil value.
        int ceil = -1;

        // Traverse the BST until the root is null (or we've found the ceil).
        while (root != null) {
            // If the current node's value matches the key, we have found the ceil.
            if (root.data == key) {
                // Assign the current node's value as ceil and return it directly.
                ceil = root.data;
                return ceil; // Direct match, return immediately.
            }
            // If the current node's value is less than the key:
            else if (root.data < key) {
                // Move to the right subtree, as ceil must be in the larger values.
                root = root.right;
            }
            // If the current node's value is greater than the key:
            else {
                // Update the ceil to the current node's value.
                ceil = root.data;
                // Move to the left subtree to potentially find a smaller, closer value.
                root = root.left;
            }
        }
        // If no ceil value was found during traversal, return -1.
        return ceil;
    }
}
