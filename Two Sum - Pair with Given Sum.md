# 🎯 Two Sum - Pair with Given Sum

**Difficulty:** Easy  
**Accuracy:** 30.61%  
**Points:** 2  
**Average Solve Time:** 20 minutes  
**Submissions:** 382K+

---

## 📋 Problem Statement

Given an array `arr[]` of **positive integers** and another integer `target`, determine if there exist **two distinct indices** such that the sum of their elements is equal to the target.

---

## 🧪 Examples

### Example 1  
**Input:** `arr = [1, 4, 45, 6, 10, 8]`, `target = 16`  
**Output:** `true`  
**Explanation:** `arr[3] + arr[4] = 6 + 10 = 16`

---

### Example 2  
**Input:** `arr = [1, 2, 4, 3, 6]`, `target = 11`  
**Output:** `false`  
**Explanation:** No pair sums up to 11

---

### Example 3  
**Input:** `arr = [11]`, `target = 11`  
**Output:** `false`  
**Explanation:** Only one element → no pair possible

---

## 🔒 Constraints

- `1 ≤ arr.length ≤ 10⁵`  
- `1 ≤ arr[i] ≤ 10⁵`  
- `1 ≤ target ≤ 2 × 10⁵`

---

## 🧠 Intuition

We need to determine:  
> “Is there a pair `(a, b)` such that `a + b == target`?”

Instead of using brute force to check all pairs (which is **O(n²)**), we can be smart and use a **HashSet**.

As we iterate through each element:
- Calculate its **complement**: `target - arr[i]`
- If that complement has been seen before, a pair exists!
- Otherwise, add the current element to the set and keep going

---

## ✅ Java Solution

```java
import java.util.HashSet;

class Solution {
    boolean twoSum(int arr[], int target) {
        int n = arr.length;
        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (seen.contains(target - arr[i])) {
                return true;
            }
            seen.add(arr[i]);
        }

        return false;
    }
}
```

## ⚙️ Time & Space Complexity
Time: O(n) — one pass through the array

Space: O(n) — for the HashSet

## 🔍 Why `HashSet` Instead of `ArrayList`?

| Feature            | `HashSet` | `ArrayList` |
|--------------------|-----------|-------------|
| **Lookup (`contains`)** | O(1)     | O(n)        |
| **Insert**         | O(1)     | O(1)        |
| **Duplicates allowed** | No        | Yes         |
| **Use case**       | Fast existence check | Maintains order, allows duplicates |

---

We use **`HashSet`** here because we only care about **whether a value exists** —  
not about order, duplicates, or indexing.

Using `ArrayList` would make `contains()` slow **O(n)**, resulting in overall **O(n²)** time complexity.  
This becomes inefficient for large inputs.

---

### 🧠 Bonus Tip

If the question asked you to **return the pair** or **their indices**,  
you’d switch to using a **`HashMap<Integer, Integer>`** instead,  
to store both **values** and their **positions**.


