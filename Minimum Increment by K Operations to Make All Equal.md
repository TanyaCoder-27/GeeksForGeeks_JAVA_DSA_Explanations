

---

## 🧮 Minimum Increment by K Operations to Make All Equal

**Difficulty:** Easy
**Accuracy:** 60.91%
**Submissions:** 1K+
**Points:** 2
**Average Time:** 20m

### 📝 Problem Statement

Given an array `arr[]` and an integer `k`. You can perform an operation in which you **increment any number in the array by `k`**. Find the **minimum number of operations** needed to make **all the elements of the array equal**.

> **Note:** If it is not possible to make all elements equal using the allowed operation, return `-1`.

---

### 📘 Examples

#### Example 1

```text
Input: arr[] = [4, 4, 4, 2], k = 2  
Output: 1  
Explanation: We can increment the last element by 2 to make all elements equal to 4.
```

#### Example 2

```text
Input: arr[] = [4, 2, 6, 8], k = 3  
Output: -1  
Explanation: These elements can't be made equal by incrementing with steps of 3.
```

#### Example 3

```text
Input: arr[] = [4, 7, 19, 16], k = 3  
Output: 10  
```

---

### 🔒 Constraints

* `1 <= arr.size() <= 10^5`
* `0 <= arr[i] <= 10^5`
* `1 <= k <= 10^4`

---



---

## 🧠 Minimum Increment by K – Clean Solution

You're going to love how clean this solution is once it clicks, Tanya!

---

### 🔍 Problem Summary

You're given an array `arr[]` and a number `k`. You can **increment any element by `k` multiple times**, and your goal is to **make all elements equal using the least number of such operations**.

If it’s **not possible**, return `-1`.

---

### 🤔 Intuition

Let’s break it down:

1. **We can only increment in steps of `k`**, so for any two elements `a` and `b`, if the difference between them **isn't divisible by `k`**, then `a` can't reach `b` using `+k` operations.

   → That’s our key check:
   **For all `arr[i]`, is `(max - arr[i]) % k == 0`?**

2. **Why aim for the max?**
   Because we can only **increase** numbers, not decrease. So we need to pull all elements **up to the largest number in the array** using `+k` jumps.

---

### ✅ Strategy

* Find the **maximum element** `max` in the array.
* For each `arr[i]`:

  * If `(max - arr[i]) % k != 0`, return `-1` (not reachable).
  * Else, compute steps: `(max - arr[i]) / k`, and **sum them all**.
* Return the total number of operations.

---

### 💡 Optimized Java Code

```java
class Solution {
    static int minOps(int arr[], int k) {
        int max = Integer.MIN_VALUE;
        int operations = 0;

        // Find max element
        for (int num : arr) {
            max = Math.max(max, num);
        }

        // Calculate total operations
        for (int num : arr) {
            int diff = max - num;

            if (diff % k != 0) {
                return -1; // Not possible
            }

            operations += diff / k;
        }

        return operations;
    }
}
```

---

### 🧪 Test Example Walkthrough

#### Input

```text
arr = [4, 4, 4, 2], k = 2
```

#### Process

* `max = 4`
* For element `2`:
  → `diff = 4 - 2 = 2`, `2 % 2 == 0 ✅`, `2 / 2 = 1` operation
* All other elements are already 4 → 0 steps

#### ✅ Total operations = 1

---
😊



