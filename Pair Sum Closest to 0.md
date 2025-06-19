# 🔢 Pair Sum Closest to 0

**Difficulty:** Medium  
**Accuracy:** 19.61%  
**Submissions:** 81K+  
**Points:** 4  

---

## 📝 Problem Statement

Given an integer array of `N` elements, you need to find the **maximum sum of two elements such that their sum is closest to zero**.

---

### 📥 Examples

#### Example 1:
**Input:**  
N = 3  
arr[] = {-8, -66, -60}  

**Output:**  
-68  

**Explanation:**  
Sum of two elements closest to zero is -68 using numbers -60 and -8.

---

#### Example 2:
**Input:**  
N = 6  
arr[] = {-21, -67, -37, -18, 4, -65}  

**Output:**  
-14  

**Explanation:**  
Sum of two elements closest to zero is -14 using numbers -18 and 4.

---

**Note:**  
If multiple pairs have the same absolute closest sum to zero, return the **maximum (least negative)** such sum.

---

## ✅ Constraints

- 2 ≤ N ≤ 5 × 10⁵  
- -10⁶ ≤ arr[i] ≤ 10⁶

---

## 💡 Intuition

We are asked to find **two numbers** whose sum is **closest to zero**. The naive approach is O(N²), but that’s too slow. Instead, we’ll:

- **Sort the array**
- Use the **two-pointer technique**
- Carefully track the **closest sum**, preferring **larger values** when a tie in closeness occurs

---

## 🔍 Key Observations

- Array can contain both negative and positive values.
- We're aiming for a **greedy and efficient** solution.
- Sorting + Two Pointers = 🔥 classic combo for problems involving sum targets.

---

## ⚙️ Approach (Two Pointers)

1. **Sort** the array.
2. Use two pointers:
   - `left = 0`  
   - `right = n - 1`
3. While `left < right`:
   - Compute `sum = arr[left] + arr[right]`
   - If `abs(sum)` < `abs(closestSum)`, update `closestSum`
   - If tie, choose the larger sum (less negative)
   - Adjust pointers:
     - If `sum < 0`: move `left++`
     - If `sum > 0`: move `right--`
     - If `sum == 0`: perfect match, return immediately

---

## 🧪 Dry Run

**Input:** `[-21, -67, -37, -18, 4, -65]`  
**Sorted:** `[-67, -65, -37, -21, -18, 4]`  
**Best Pair:** `-18 + 4 = -14` ✅

---

## 🧠 Java Code

```java
class Solution {
    public static int closestToZero(int arr[], int n) {
        // your code here
        // 0 --> mins and maxs --> sort
        
        Arrays.sort(arr);
        
        //mins and maxs --> left and right pointers
        
        int left = 0 , right = n-1;
        int sum = 0, closest_min_sum = Integer.MAX_VALUE;
        
        while(left < right){
            sum = arr[left] + arr[right];
            
            if(sum == 0){
                return 0;
            }
            
            //comparision of absolutes becoz to find the nearest to zero.
            if(Math.abs(sum) < Math.abs(closest_min_sum)){
                closest_min_sum = sum;
            }
            else if(Math.abs(sum) == Math.abs(closest_min_sum)){
                closest_min_sum = Math.max(sum, closest_min_sum);
            }
            
            if(sum<0){
                left++;
            }
            else{
                right--;
            }
            
            
        }
        
        return closest_min_sum;
    }
}

```

## ⏱️ Time & Space Complexity
Time Complexity: O(N log N) – due to sorting + linear scan

Space Complexity: O(1) – in-place two-pointer traversal
