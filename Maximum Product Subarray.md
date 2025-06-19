# 🔥 Maximum Product Subarray

**Difficulty:** Medium  
**Accuracy:** 18.09%  
**Submissions:** 458K+  
**Points:** 4

---

## 📋 Problem Statement

Given an array `arr[]` that contains positive and negative integers (may contain 0 as well). Find the **maximum product** that we can get in a subarray of `arr[]`.

> Note: It is guaranteed that the output fits in a 32-bit integer.

---

## 🧪 Examples

**Input:**  
`arr = [-2, 6, -3, -10, 0, 2]`  
**Output:** `180`  
**Explanation:** The subarray with maximum product is `{6, -3, -10}` with product `6 * (-3) * (-10) = 180`.

**Input:**  
`arr = [-1, -3, -10, 0, 6]`  
**Output:** `30`  
**Explanation:** The subarray with maximum product is `{-3, -10}` with product `(-3) * (-10) = 30`.

**Input:**  
`arr = [2, 3, 4]`  
**Output:** `24`  
**Explanation:** For an array with all positive elements, the result is the product of all elements.

---

## 🔒 Constraints

- 1 ≤ arr.length ≤ 10⁶  
- -10 ≤ arr[i] ≤ 10

---

## 🧠 Intuition

The maximum product subarray problem is tricky because of **negative numbers** and **zeros**. A negative number flips the sign of a product. So to find the maximum product at each point, we track both:
- the **maximum product ending here**, and
- the **minimum product ending here** (might become maximum if multiplied with a negative number).

---

## ⚙️ Approach & Logic

1. Initialize:
   - `max_prod`: the maximum product ending at current index
   - `min_prod`: the minimum product ending at current index
   - `res_max_product`: the result that holds the global maximum

2. Traverse the array:
   - If current element is negative → **swap `max_prod` and `min_prod`**
   - Update `max_prod` and `min_prod` using `arr[i]`
   - Update `res_max_product` with the maximum seen so far

---

## 🧾 Java Code

```java
class Solution {
    int maxProduct(int[] arr) {
        int n = arr.length;
        int max_prod = arr[0];
        int min_prod = arr[0];
        int res_max_product = arr[0];
        
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                // If arr[i] is negative, swap max and min
                int temp = max_prod;
                max_prod = min_prod;
                min_prod = temp;
            }

            max_prod = Math.max(arr[i], arr[i] * max_prod);
            min_prod = Math.min(arr[i], arr[i] * min_prod);

            res_max_product = Math.max(res_max_product, max_prod);
        }

        return res_max_product;
    }
}
```

## Time and space complexity

O(n) and O(1) respectively
