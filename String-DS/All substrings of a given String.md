
# 🌟 All Substrings of a Given String

**Last Updated:** 14 Feb, 2025  
**Difficulty:** Easy

---

## 📘 Problem Statement

Given a string `s` containing lowercase alphabetical characters, the task is to print **all non-empty substrings** of the given string.

---

## 🧪 Examples

### Example 1:
```

Input:  s = "abc"
Output: "a", "ab", "abc", "b", "bc", "c"

```

### Example 2:
```

Input:  s = "ab"
Output: "a", "ab", "b"

```

### Example 3:
```

Input:  s = "a"
Output: "a"

````

---

## ✅ Expected Approach (Iterative)

The idea is to use two nested loops:
- Outer loop picks the **starting index** `i`
- Inner loop picks the **ending index** `j` and builds substrings `s[i...j]`

---

## 💻 Java Code – Iterative Approach

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> findSubstrings(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                res.add(s.substring(i, j + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abc";
        List<String> res = findSubstrings(s);
        for (String i : res) {
            System.out.print(i + " ");
        }
    }
}
````

---

## 🔄 Alternative: Recursive Substring Generation

If you'd like to explore all substrings recursively:

### 🔁 Recursive Logic:

```java
public static void generateSubstrings(String s, int start, String curr) {
    if (start == s.length()) return;

    curr += s.charAt(start);
    System.out.println(curr); // print current substring

    // Continue building current substring
    generateSubstrings(s, start + 1, curr);

    // Start new substring from next character
    generateSubstrings(s, start + 1, "");
}
```

### ☕ Example Usage:

```java
public static void main(String[] args) {
    generateSubstrings("abc", 0, "");
}
```

---

## 🧠 Visual Trace for `"abc"`

```
""  
├─ "a"  
│   ├─ "ab"  
│   │   ├─ "abc"  
│   └─ "ac"  
└─ "b"  
    ├─ "bc"  
    └─ "c"  
```

This outputs: `"a", "ab", "abc", "ac", "b", "bc", "c"` ✅

---

## 🧠 Why This Works

* Explores every possible **starting point** for substrings
* Builds and prints every **non-empty stretch** from those points
* Recursively mimics the nested loop structure

---

## 📌 Base Case Reminder

```java
if (start == s.length()) return;
```

Stops recursion once we reach the end of the string.

---

## 🧾 Summary

| Method    | Time Complexity | Output Order  | Notes                             |
| --------- | --------------- | ------------- | --------------------------------- |
| Iterative | O(n²)           | Left to right | Simple and efficient              |
| Recursive | O(2ⁿ)           | All branches  | Elegant but more memory-intensive |

---






