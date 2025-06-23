
# 🔠 Program to Find Smallest and Largest Word in a String

**Last Updated:** 03 Mar, 2025  
**Difficulty:** Easy

---

## 📝 Problem Statement

Given a string, find the **minimum** and **maximum length** words in it.

---

## 📥 Examples

### Example 1:
**Input:**  
`"This is a test string"`  
**Output:**  
```

Minimum length word: a
Maximum length word: string

```

---

### Example 2:
**Input:**  
`"GeeksforGeeks A computer Science portal for Geeks"`  
**Output:**  
```

Minimum length word: A
Maximum length word: GeeksforGeeks

````

---

## ✅ Intuition

- Split the string into words using spaces.
- Keep track of the current shortest and longest words using just a few variables.
- Single pass through all the words is sufficient.

This approach ensures:
- No nested loops
- Constant memory outside the split array

---

## 💻 Java Code (Using Split)

```java
import java.util.*;

class Solution {
    public static void findMinMaxWords(String input) {
        if (input == null || input.isEmpty()) return;

        String[] words = input.trim().split("\\s+"); // Handles multiple spaces

        String minWord = words[0];
        String maxWord = words[0];

        for (String word : words) {
            if (word.length() < minWord.length()) {
                minWord = word;
            }
            if (word.length() > maxWord.length()) {
                maxWord = word;
            }
        }

        System.out.println("Minimum length word: " + minWord);
        System.out.println("Maximum length word: " + maxWord);
    }

    public static void main(String[] args) {
        String input = "GeeksforGeeks A computer Science portal for Geeks";
        findMinMaxWords(input);
    }
}
````

---

## 💾 Space-Efficient Version (Without Split)

```java
class SpaceEfficientSolution {
    public static void findMinMaxWords(String input) {
        input = input.trim() + " ";

        int start = 0;
        String minWord = "", maxWord = "";
        int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                int len = i - start;

                if (len == 0) {
                    start = i + 1;
                    continue;
                }

                String word = input.substring(start, i);

                if (len < minLen) {
                    minLen = len;
                    minWord = word;
                }

                if (len > maxLen) {
                    maxLen = len;
                    maxWord = word;
                }

                start = i + 1;
            }
        }

        System.out.println("Minimum length word: " + minWord);
        System.out.println("Maximum length word: " + maxWord);
    }

    public static void main(String[] args) {
        String input = "This is a test string";
        findMinMaxWords(input);
    }
}
```

---

## 🧠 Line-by-Line Breakdown (Space-Efficient Version)

### `input = input.trim() + " ";`

* Removes extra spaces from start/end
* Adds a **sentinel space** at the end so the **last word** gets processed

### Initialization:

```java
int start = 0;
String minWord = "", maxWord = "";
int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;
```

### Loop through each character:

* When a space is found:

  * Get the word from `start` to `i`
  * Skip if it’s an empty word
  * Update min/max word if needed
  * Move `start` to the next word’s beginning

---

## ⏱️ Time and Space Complexity

| Metric           | Complexity |
| ---------------- | ---------- |
| Time Complexity  | O(n)       |
| Space Complexity | O(1)       |

---

## 🔍 Edge Case: Single Word

### Input:

```java
String input = "Destiny";
```

### What Happens?

* After `input.trim() + " "` → becomes `"Destiny "`
* It enters the loop and hits the space:

  * `start = 0`, `i = 7`
  * Extracted word = `"Destiny"`
* Since it's the **only word**, it’s both:

  * `minWord = "Destiny"`
  * `maxWord = "Destiny"`

### ✅ Output:

```
Minimum length word: Destiny  
Maximum length word: Destiny
```



