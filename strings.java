
import java.util.ArrayList;
import java.util.Collections;

public class strings{
    public static void main(String[] args) {
        // String name = "oyo is ok ok";
        // StringBuilder sb = new StringBuilder(name);
        // char[] ok  = name.toCharArray();
        // System.out.println(Arrays.toString(name.toCharArray()));
        // System.out.println(sb.reverse().toString().equals(name));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(56);
        list.add(897);
        list.add(86);
        int ans = Collections.binarySearch(list, 56);
        // System.out.println(ans);
    // System.out.println(list);
        // StringTokenizer st = new StringTokenizer(name," ");
        // while(st.hasMoreElements()){
        //     System.out.println(st.nextToken());
        // }

        String s = "Khushuuu";
        System.out.println(s.indexOf("shuu"));
        

    }
}


// String Immutability :
// Strings in Java are immutable, which means once a string object is created, it cannot be changed. 
// Any operation that seems to modify the string actually creates a new string object.

// Example:

// String str = "Hello";
// str.concat(" World"); // Trying to add " World"
// System.out.println(str); // Output: Hello

//  => str is still "Hello".

// Why? Because concat() doesn’t change the original string—it creates a new string "Hello World".

// If we want to keep the new string:

// str = str.concat(" World");
// System.out.println(str); // Output: Hello World

// ✅ Key Point: Original string remains unchanged; operations create new strings/object.



// String Pool
// The string pool is a special memory area in the heap where Java stores string literals.
// If two string literals have the same value, they refer to the same object in the pool to save memory.

// Example:
// String s1 = "Hello";
// String s2 = "Hello";
// System.out.println(s1 == s2); // Output: true

// s1 and s2 point to the same object in the string pool.
// Memory is saved because Java doesn’t create a new object if it already exists in the pool.

// Now, if you create a string using new:
// String s3 = new String("Hello");
// System.out.println(s1 == s3); // Output: false

// s3 is outside the string pool (in the heap).
// So even though the value is "Hello", the reference is different.

// 1. "==" Operator : 
// Compares references (memory addresses), not actual content.
// For primitive types (int, char, etc.), it compares values directly.
// For objects (like String, Integer, custom classes), it checks whether they point to the same memory location.

// 2 ".equals()" Method
// Compares the actual content (values) of objects.
// For strings, .equals() checks whether the characters match.