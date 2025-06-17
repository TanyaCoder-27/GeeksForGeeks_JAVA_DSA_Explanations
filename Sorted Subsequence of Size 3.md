

# 🔍 Sorted Subsequence of Size 3

**Difficulty:** Medium  
**Accuracy:** 25.95%  
**Submissions:** 80K+  
**Points:** 4  
**Average Time:** 20m  

---

## 📘 Problem Statement

You are given an array `arr`. You need to find **any three elements** in it such that:



arr\[i] < arr\[j] < arr\[k]  and  i < j < k



---

### 📌 Notes

- ✅ Return `1` if a valid subsequence is found.
- ❌ Return an **empty array** if no such subsequence exists (the driver will print `0`).
- ⚠️ Return format must strictly follow `arr[i] < arr[j] < arr[k]` and `i < j < k`; otherwise, the output is `-1`.

---

## 🧪 Examples

### Example 1:
- **Input:** `arr = [1, 2, 1, 1, 3]`  
- **Output:** `1`  
- **Explanation:** A valid subsequence `1 < 2 < 3` exists in the array.

### Example 2:
- **Input:** `arr = [1, 1, 3]`  
- **Output:** `0`  
- **Explanation:** No valid increasing subsequence of size 3 is present.

---

## ⏱ Expected Time & Space Complexity

- **Time Complexity:** `O(n)`
- **Auxiliary Space:** `O(n)`

---

## 📎 Constraints

- `1 <= arr.length <= 10^5`
- `1 <= arr[i] <= 10^6`

---



# 🔍 Sorted Subsequence of Size 3 – Optimized Solution

---

## 🧠 Intuition

The goal is to find three elements `arr[i] < arr[j] < arr[k]` with indices `i < j < k`.  
A naive or incorrect approach might skip middle values or fail for edge cases.  
To solve this reliably, we track:
- The **smallest element before each index**
- The **largest element after each index**

By doing so, we ensure the middle value `arr[j]` lies strictly between two valid elements on both sides.

---

## ⚠️ Issue in Previous Approach

Many simple solutions fail due to:
1. Only tracking the smallest or largest without verifying position.
2. Not preserving the correct **order of indices** (`i < j < k`).
3. Failing on non-linear arrangements or duplicate values.

---

## 🔧 Optimized Approach (Two-Pass Strategy)

### ➤ Step-by-Step Strategy:

1. **Left to Right Pass**  
   - Build an array `leftMin[i]` where `leftMin[i]` is the minimum of all values before or at index `i`.
2. **Right to Left Pass**  
   - Build `rightMax[i]` where `rightMax[i]` is the maximum of all values from index `i` to end.
3. **Final Check**  
   - For every middle index `j`, check if:
     ```
     leftMin[j] < arr[j] < rightMax[j]
     ```
   - If true, a valid triplet is found.

---

## ✅ Java Code Implementation

```java
import java.util.*;

class Solution {
    public List<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        if (n < 3) return new ArrayList<>();

        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        // Step 1: Populate leftMin array
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
        }

        // Step 2: Populate rightMax array
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // Step 3: Identify valid subsequence
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > leftMin[i] && arr[i] < rightMax[i]) {
                return Arrays.asList(leftMin[i], arr[i], rightMax[i]);
            }
        }

        return new ArrayList<>();
    }
}
````

---

## 🚀 Why This Works

* ✅ **Ensures correct order** (`i < j < k`) by using array indices directly.
* ✅ **Handles all edge cases** by capturing minimums and maximums explicitly.
* ✅ **Time Complexity:** `O(n)` — Single pass for both `leftMin` and `rightMax`.
* ✅ **Space Complexity:** `O(n)` — Only two auxiliary arrays used.

---

## 🧪 Example

**Input:** `arr = [1, 2, 1, 1, 3]`
**Output:** `[1, 2, 3]`
**Explanation:** A valid subsequence exists with increasing values and indices.

---

## 📎 Constraints

* `1 <= arr.length <= 10^5`
* `1 <= arr[i] <= 10^6`

---

📊 Time & Space Complexity
Time Complexity: O(n)

One pass for each array.

Space Complexity: O(n)

Uses two extra arrays left_min[] and right_max[].


