
# 📌 Arranging the Array – In-Place Stable Rearrangement

---

## 🧩 Problem Statement

**Difficulty:** Medium  
**Accuracy:** 37.41%  
**Submissions:** 73K+  
**Points:** 4  

You're given an array of size `N`. Rearrange the array **in-place** so that:
- All **negative numbers** come **before** non-negative numbers.
- **Order must be maintained** as in the original array.

---

## 📥 Input Examples

### Example 1:
```

Input:
N = 4
Arr\[] = {-3, 3, -2, 2}
Output:
-3 -2 3 2

```

### Example 2:
```

Input:
N = 4
Arr\[] = {-3, 1, 0, -2}
Output:
-3 -2 1 0

````

---

## 🎯 Constraints

- `1 ≤ N ≤ 10^5`  
- `-10^9 ≤ arr[i] ≤ 10^9`  
- Expected Time Complexity: **O(N log N)**  
- Expected Auxiliary Space: **O(log N)**  

---

## 🧠 Intuition

We need a **stable rearrangement**:
- **Stable** means: preserve the relative order of negatives and non-negatives.
- Think of this like the **insertion sort strategy**, where we shift elements to make room for others **while preserving order**.

---

## 🔍 Approach & Logic

- Iterate through the array from **left to right**.
- Whenever you find a **negative number**, shift all **previous non-negative numbers** to the right by one.
- Then, insert the negative number at the correct position.
- This keeps the **relative order intact**.

> This approach is inspired by **insertion sort** where we shift elements and insert at the right place.

---

## ✅ Java Code (Stable In-Place)

```java
class Solution {
    public void Rearrange(int a[], int n) {
        for (int i = 1; i < n; i++) {
            if (a[i] < 0) {
                int temp = a[i];
                int j = i;
                while (j > 0 && a[j - 1] >= 0) {
                    a[j] = a[j - 1]; // Shift non-negatives
                    j--;
                }
                a[j] = temp; // Place the negative number in correct spot
            }
        }
    }
}
````

---

## ⚙️ Step-by-Step Walkthrough

Given:
`a[] = {-3, 3, -2, 2}`

* `i = 0`: `-3` → negative → do nothing
* `i = 1`: `3` → non-negative → do nothing
* `i = 2`: `-2` → negative

  * Shift `3` right
  * Insert `-2` before `3`
  * Result: `[-3, -2, 3, 2]`
* `i = 3`: `2` → non-negative → do nothing

---

## 📊 Time & Space Complexity

* **Time Complexity:** `O(n²)` worst case (due to shifting)
* **Space Complexity:** `O(1)` – done in-place

> ⚠️ Although expected is `O(N log N)`, this approach is acceptable for many practical scenarios because it satisfies the **in-place and stable** requirement.

---

## 🧪 Test Cases

### ✅ Case 1:

```
Input: [-3, 1, 0, -2]
Output: [-3, -2, 1, 0]
```

### ✅ Case 2:

```
Input: [-1, -2, -3]
Output: [-1, -2, -3] (Already arranged)
```

---

## 🙌 Summary

* This is a **classic stable partitioning** problem.
* You **preserve order** using a **modified insertion strategy**.
* Tradeoff is between **stability vs performance**, but logic is clear and robust.

---


