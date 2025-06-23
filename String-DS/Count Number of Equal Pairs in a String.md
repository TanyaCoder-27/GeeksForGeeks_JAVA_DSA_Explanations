
# 🧮 Count Number of Equal Pairs in a String

**Difficulty:** Basic  
**Accuracy:** 42.87%  
**Submissions:** 3K+  
**Points:** 1

---

## 📄 Problem Statement

Given a string `S`, find the number of **pairs of characters** that are equal.  
All pairs like `(s[i], s[j])`, `(s[j], s[i])`, `(s[i], s[i])`, `(s[j], s[j])` should be considered **different**.

---

## ✨ Examples

### Example 1:
**Input:**  
```

S = "air"

```
**Output:**  
```

3

```
**Explanation:**  
There are 3 equal pairs:
- (S[0], S[0]) → 'a'  
- (S[1], S[1]) → 'i'  
- (S[2], S[2]) → 'r'

---

### Example 2:
**Input:**  
```

S = "aa"

```
**Output:**  
```

4

````
**Explanation:**  
All possible equal pairs:
- (S[0], S[0])  
- (S[0], S[1])  
- (S[1], S[0])  
- (S[1], S[1])  

---

## 🧪 Constraints

- `1 ≤ |S| ≤ 10^4`

---

## ✅ Expected Time and Space

- **Time Complexity:** O(|S|)  
- **Auxiliary Space:** O(1)

---

## 🔍 Java Solution

```java
// User function Template for Java
class Sol {
    long equalPairs(String s) {
        char[] carr = s.toCharArray();
        int[] freq = new int[256]; // For all ASCII characters

        for (char ch : carr) {
            freq[ch]++;
        }

        long count = 0;
        for (int i : freq) {
            count += (long) (i * i);
        }

        return count;
    }
}
````

---

## 💡 Explanation of the Approach

### 🎯 Goal

We want to count **all pairs (i, j)** such that:

* `S[i] == S[j]`
* We count **all** combinations:

  * `(i, j)`, `(j, i)`, `(i, i)` — everything counts!

---

### 🔢 Key Insight

If a character appears **f times**, it can form:

* `f × f` such equal pairs (including self-pairs and cross-pairs)

E.g., for `"aaabb"`:

* `'a'` appears 3 times → 3 × 3 = 9 pairs
* `'b'` appears 2 times → 2 × 2 = 4 pairs
  → **Total = 13 pairs**

---

### ⚙️ Steps

1. Create a frequency array for ASCII characters (size 256)
2. Count how often each character appears
3. For each frequency `f`, compute `f × f` and add it to a counter
4. Return the counter

---

### 🧠 Why It Works

* The approach avoids nested loops (which would take O(n²))
* Instead, it computes character frequency in O(n) and does a fixed-size array scan (O(1))
* **Time Complexity:** O(n)
* **Space Complexity:** O(1) (fixed array size)

---

## 🚀 Possible Extensions

* Make it case-insensitive (`'A' == 'a'`)
* Skip `(i, i)` pairs
* Only count unique index pairs where `i < j`

