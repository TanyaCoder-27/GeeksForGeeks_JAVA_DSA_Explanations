# Roof Top
Difficulty: EasyAccuracy: 40.48%Submissions: 89K+Points: 2
## You are given the heights of consecutive buildings. You can move from the roof of a building to the roof of the next adjacent building. You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude with each step.

## Examples:

Input: arr[] = [1, 2, 2, 3, 2]
Output: 1
Explanation: 1, 2, or 2, 3 are the only consecutive buildings with increasing heights thus maximum number of consecutive steps with an increase in gain in altitude would be 1 in both cases.
Input: arr[] = [1, 2, 3, 4]
Output: 3
Explanation: 1 to 2 to 3 to 4 is the jump of length 3 to have a maximum number of buildings with increasing heights, so maximum steps with increasing altitude becomes 3.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size() <= 106
1 <= arr[i] <= 105

## Java Code:
```
class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        int maxSteps = 0;
        int currentSteps = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                currentSteps++;
                maxSteps = Math.max(maxSteps, currentSteps);
            } else {
                currentSteps = 0;
            }
        }

        return maxSteps;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1, 2, 2, 3, 2};
        System.out.println("Maximum steps: " + sol.maxStep(arr1)); // Output: 1

        int[] arr2 = {1, 2, 3, 4};
        System.out.println("Maximum steps: " + sol.maxStep(arr2)); // Output: 3
    }
}
```
##  Explanation:

```
- Initialize:

maxSteps to keep track of the maximum consecutive steps with increasing height.

currentSteps to count the current streak of increasing steps.

- Iterate through the array:

If the current building height is greater than the previous one (arr[i] > arr[i - 1]), increment currentSteps.

Update maxSteps with the maximum of maxSteps and currentSteps.

If the current building height is not greater, reset currentSteps to 0.

Return maxSteps after the loop completes.

This approach ensures a time complexity of O(n) and auxiliary space of O(1). Perfect for large input sizes! Give it a go and see how it performs. 🚀

```
