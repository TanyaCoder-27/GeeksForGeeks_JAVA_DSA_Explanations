
### Insert a character in String at a Given Position
Last Updated : 06 Nov, 2024
#### Given a string s, a character c and an integer position pos, the task is to insert the character c into the string s at the specified position pos.

Examples:

Input: s = "Geeks", c = 'A', pos = 3
Output: GeeAks

Input: s = "HelloWorld", c = '!', pos = 5
Output: Hello!World

-------------------

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

		StringBuilder sb = new StringBuilder(str);
		sb.insert(pos,ch);
		System.out.println("String:"+sb.toString());
		
	}
}

```

---

### ✅ `new String(sb)` vs `sb.toString()`

Both convert a `StringBuilder` into a `String`, but here’s what actually happens:

1. **`sb.toString()`**  
   - This is the standard and most direct way to get the `String` content from a `StringBuilder`.  
   - Internally, it creates a new `String` object using the current character buffer of `sb`.

2. **`new String(sb)`**  
   - This also calls the `StringBuilder.toString()` method under the hood.
   - So effectively, `new String(sb)` becomes `new String(sb.toString())`.

---

### 🔍 Does it make a difference?

- **Performance:** `sb.toString()` is slightly more efficient because it doesn’t create an unnecessary extra `String` object.
- **Readability & convention:** `sb.toString()` is cleaner and idiomatic Java.
- **Functionality:** Both give you the same result.

---

### 💡 So, prefer:
```java
String result = sb.toString();  // More efficient, cleaner
```

Unless you have a very specific reason to wrap it with `new String(...)` (which is rare), keep it direct and simple.
