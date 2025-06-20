
# 🔁 Replace Character at a Given Index in a String

**Difficulty:** Easy  
**Topic:** String Manipulation  

---

## 📋 Problem Statement

Given a string `s`, a character `ch`, and an integer position `pos`, write a program to **replace the character at the specified index `pos` with `ch`**.  

Assume:
- Indexing is **0-based**
- The input string contains only alphabetic characters
- The replacement should be reflected in the final output string

If the index is invalid (i.e., `pos < 0` or `pos >= s.length()`), return the original string unchanged.

---

## 🧪 Examples

**Example 1**  
**Input:**  
`s = "Geeks"`  
`ch = 'A'`  
`pos = 3`  
**Output:**  
`"GeeAs"`

---

**Example 2**  
**Input:**  
`s = "Tanya"`  
`ch = 'X'`  
`pos = 0`  
**Output:**  
`"Xanya"`

---

**Example 3**  
**Input:**  
`s = "Code"`  
`ch = 'Q'`  
`pos = 10`  
**Output:**  
`"Code"`  _(position is invalid)_

---

## ✅ Constraints

- 1 ≤ s.length() ≤ 10⁵  
- ch is a single alphabetic character  
- 0 ≤ pos < s.length()

---

## 🔧 Expected Time Complexity: O(n)  
## 🗂️ Expected Auxiliary Space: O(n)

---

## 💡 Sample Java Code

```java
class Solution {
    static String replaceChar(String s, char ch, int pos) {
        if (s == null || pos < 0 || pos >= s.length()) {
            return s; // Invalid position
        }

        char[] arr = s.toCharArray();
        arr[pos] = ch;
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(replaceChar("Geeks", 'A', 3));  // Output: GeeAs
        System.out.println(replaceChar("Tanya", 'X', 0));  // Output: Xanya
        System.out.println(replaceChar("Code", 'Q', 10));  // Output: Code
    }
}

```



```
import java.util.*;
class CharPos{
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = sc.nextLine();
		System.out.println("Enter a character:");
		char ch = sc.next().charAt(0);
		System.out.println("Enter a position:");
		int pos = sc.nextInt();

		
		char[] charr = str.toCharArray();
		charr[pos] = ch;
		System.out.println("String:"+new String(charr));

	}

}
```

## Note:

charr is a char[], and calling .toString() on an array doesn’t print the characters—it prints the object reference (like [C@3feba861), which is pretty useless.

To properly display the modified string, convert the char[] back to a String by :
                      System.out.println("String: " + new String(charr));

*/
