
# 🧮 Trail of Ones

**Difficulty:** Medium  
**Accuracy:** 51.16%  
**Submissions:** 33K+  
**Points:** 4  

---

## 📝 Problem Statement

Given a number `n`, find the number of binary strings of length `n` that contain **consecutive 1's** in them. Since the number can be very large, return the answer modulo `1e9+7`.

---

## 🔢 Examples

### Example 1:
**Input:**  
`n = 2`  
**Output:**  
`1`  
**Explanation:**  
Binary strings of length 2: `00`, `01`, `10`, `11` → Only `11` has consecutive 1's.

---

### Example 2:
**Input:**  
`n = 3`  
**Output:**  
`3`  
**Explanation:**  
Binary strings:  
`000`, `001`, `010`, `011`, `100`, `101`, `110`, `111`  
Valid ones: `011`, `110`, `111` → 3 strings with consecutive 1's.

---

### Example 3:
**Input:**  
`n = 5`  
**Output:**  
`19`

---

## ✅ Constraints

- `2 <= n <= 10^5`

---

## 💻 Java Code

```java
class Solution {
    static final int MOD = 1_000_000_007;

    static int numberOfConsecutiveOnes(int n) {
        long pow2 = 1, dp0 = 1, dp1 = 1;

        // DP part - calculate strings with NO consecutive 1s
        for (int i = 2; i <= n; i++) {
            long new_dp0 = (dp0 + dp1) % MOD;
            long new_dp1 = dp0;
            dp0 = new_dp0;
            dp1 = new_dp1;
        }

        // Calculate total number of binary strings (2^n)
        for (int i = 0; i < n; i++) {
            pow2 = (pow2 * 2) % MOD;
        }

        long no_consec = (dp0 + dp1) % MOD;
        long consec = (pow2 - no_consec + MOD) % MOD;

        return (int) consec;
    }
}
````

---

## 🧠 DP Explanation

### 🎯 Goal:

Count binary strings of length `n` that **have at least one pair of consecutive 1s**.

### 💡 Strategy:

* Total strings = `2^n`
* Subtract count of strings with **no consecutive 1s**
* Return: `2^n - count(without consecutive 1s)`

---

### 🧮 Dynamic Programming Idea:

Let’s define:

* `dp0`: number of valid strings of length `i` that **end with 0**
* `dp1`: number of valid strings of length `i` that **end with 1**

#### ✅ Base Case:

* `dp0 = 1` → string = "0"
* `dp1 = 1` → string = "1"

#### 🔄 Transition:

* If ending with `0`, we can place it after both `0` or `1`:

  ```
  new_dp0 = dp0 + dp1
  ```
* If ending with `1`, we can only place it after a `0` (to avoid "11"):

  ```
  new_dp1 = dp0
  ```

Update values at each step from `i = 2` to `n`.

---

### 🧪 Sample Trace (n = 3):

| i | dp0 (end in 0) | dp1 (end in 1) | Total valid |
| - | -------------- | -------------- | ----------- |
| 1 | 1              | 1              | 2           |
| 2 | 2              | 1              | 3           |
| 3 | 3              | 2              | 5           |

Total binary strings = 8
Valid without "11" = 5
Answer = `8 - 5 = 3` ✅

---

### ⏱️ Complexity

* **Time:** `O(n)`
* **Space:** `O(1)` (constant DP variables)

---

## 🏁 Final Formula

```java
consec = (2^n - (dp0 + dp1) + MOD) % MOD
```

---


