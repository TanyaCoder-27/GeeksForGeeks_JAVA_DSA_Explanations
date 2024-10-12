## Product array puzzle
Difficulty: EasyAccuracy: 33.46%Submissions: 244K+Points: 2
Given an array nums[], construct a Product Array nums[] such that nums[i] is equal to the product of all the elements of nums except nums[i].

Examples:

Input: nums[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: For i=0, P[i] = 3*5*6*2 = 180.
For i=1, P[i] = 10*5*6*2 = 600.
For i=2, P[i] = 10*3*6*2 = 360.
For i=3, P[i] = 10*3*5*2 = 300.
For i=4, P[i] = 10*3*5*6 = 900.
Input: nums[] = [12,0]
Output: [0, 12]
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= nums.size() <= 1000
0 <= nums[i] <= 200
nums[i] may contain duplicates.

## JAVA CODE:
```
class Solution {
    public static long[] productExceptSelf(int nums[]) {
        int n = nums.length;
        long[] result = new long[n];
        
        // Arrays to store prefix and suffix products
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        
        // Initialize prefix and suffix arrays
        prefix[0] = 1;
        suffix[n - 1] = 1;
        
        // Build prefix product array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        // Build suffix product array
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        
        // Build result array by multiplying prefix and suffix products
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 5, 6, 2};
        long[] result = productExceptSelf(nums);

        for (long num : result) {
            System.out.print(num + " ");
        }
    }
}
```

## Explanation:
Prefix Array: It stores the product of all elements before the current element.

Suffix Array: It stores the product of all elements after the current element.

Result Array: By multiplying the corresponding elements from the prefix and suffix arrays, you get the desired product array.
