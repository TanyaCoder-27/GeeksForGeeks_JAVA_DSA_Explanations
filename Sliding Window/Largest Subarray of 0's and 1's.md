# 📊 Largest Subarray of 0's and 1's

**Difficulty:** Easy  
**Accuracy:** 32.96%  
**Submissions:** 123K+  
**Points:** 2  
**Average Time:** 20m  

---

## 📝 Problem Statement

Given an array `arr` of 0s and 1s, find and return the **length of the longest subarray** with an **equal number of 0s and 1s**.

---

## 📥 Examples

### Example 1:
**Input:**  
`arr = [1, 0, 1, 1, 1, 0, 0]`  
**Output:**  
`6`  
**Explanation:**  
The subarray from index `1` to `6` has equal number of 0s and 1s (3 of each): `[0, 1, 1, 1, 0, 0]`

---

### Example 2:
**Input:**  
`arr = [0, 0, 1, 1, 0]`  
**Output:**  
`4`  
**Explanation:**  
Subarrays `[0, 0, 1, 1]` or `[0, 1, 1, 0]` both contain two 0s and two 1s.

---

### Example 3:
**Input:**  
`arr = [0]`  
**Output:**  
`0`  
**Explanation:**  
There is no subarray with an equal number of 0s and 1s.

---

## ✅ Constraints

- `1 ≤ arr.length ≤ 10⁵`
- `0 ≤ arr[i] ≤ 1`

---

## 🧠 Intuition

We want to find subarrays where the number of 0s and 1s is **equal**.

Let’s convert all 0s in the array to -1s. Now the problem reduces to finding the **longest subarray with a sum of 0**.

This is because:
- `1` adds `+1` to the prefix sum
- `0` becomes `-1`, subtracting from the sum

If the sum of a subarray is 0, then the number of 1s and -1s (originally 0s) is equal.

---

## 🔍 Key Observations

- Transform `0` to `-1`
- Maintain a prefix sum as we traverse
- Use a `HashMap<sum, firstIndex>` to store the first time a prefix sum occurred
- When we see the same prefix sum again at a later index, it means the elements in between balance out to 0

---

## 💡 Algorithm

1. Replace all `0`s with `-1`
2. Initialize `prefixSum = 0` and `maxLen = 0`
3. Create a HashMap to store the **first index** of each prefix sum
4. Traverse the array:
    - Add 1 or subtract 1 based on value
    - If current `prefixSum` has been seen before:
        - Calculate distance between indices
        - Update `maxLen` if it's larger
    - Else:
        - Store `prefixSum` and index

---

## 💻 Java Code

```java
class Solution {

    public int maxLen(int[] arr) {
        int n = arr.length;
        int max_len = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1); // Initial prefix sum 0 at index -1

        int pre_sum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                pre_sum -= 1;
            } else {
                pre_sum += 1;
            }

            if (!hm.containsKey(pre_sum)) {
                hm.put(pre_sum, i);
            } else {
                int len = i - hm.get(pre_sum);
                max_len = Math.max(max_len, len);
            }
        }

        return max_len;
    }
}
```
## ⏱️ Time & Space Complexity
Time: O(n) — one pass through the array

Space: O(n) — due to the hashmap storing prefix sums

## 🧪 Dry Run (Optional)
For arr = [0, 1, 0, 1] → replace 0s with -1:
[-1, 1, -1, 1] → prefix sums: -1, 0, -1, 0
Same sums seen again at later indices → longest zero-sum subarray = length 4

