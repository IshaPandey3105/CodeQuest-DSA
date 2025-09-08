public class J02_StringMethods {
    public static void main(String[] args) {
        String s1 = "Isha";
        String s2 = "Pandey";
        String s3 = "   Java Strings Example   ";

        // 1. length() → returns number of characters in string
        System.out.println(s1.length());  // Output: 4

        // 2. charAt() → returns character at given index
        System.out.println(s1.charAt(2));  // Output: h

        // 3. substring(begin) → returns substring from index till end
        System.out.println(s1.substring(2));  // Output: ha

        // 4. substring(begin, end) → returns substring between indices
        System.out.println(s1.substring(1, 3));  // Output: sh

        // 5. concat() → joins two strings
        System.out.println(s1.concat(s2));  // Output: IshaPandey

        // 6. equals() → compares content of two strings
        System.out.println(s1.equals("Isha"));  // Output: true

        // 7. equalsIgnoreCase() → compares strings ignoring case
        System.out.println(s1.equalsIgnoreCase("ISHA"));  // Output: true

        // 8. compareTo() → compares lexicographically (0 = equal)
        System.out.println(s1.compareTo(s2));  // Output: negative value (since "Isha" < "Pandey")

        // 9. toLowerCase() → converts to lowercase
        System.out.println(s1.toLowerCase());  // Output: isha

        // 10. toUpperCase() → converts to uppercase
        System.out.println(s1.toUpperCase());  // Output: ISHA

        // 11. trim() → removes leading & trailing spaces
        System.out.println(s3.trim());  // Output: Java Strings Example

        // 12. contains() → checks if substring is present
        System.out.println(s1.contains("sha"));  // Output: true

        // 13. startsWith() → checks if string starts with given prefix
        System.out.println(s1.startsWith("Is"));  // Output: true

        // 14. endsWith() → checks if string ends with given suffix
        System.out.println(s1.endsWith("a"));  // Output: true

        // 15. indexOf() → returns first index of given char/substring
        System.out.println(s1.indexOf('a'));  // Output: 3

        // 16. lastIndexOf() → returns last index of given char/substring
        System.out.println(s2.lastIndexOf('a'));  // Output: 1

        // 17. isEmpty() → checks if string is empty
        System.out.println(s1.isEmpty());  // Output: false

        // 18. replace() → replaces character/substring
        System.out.println(s1.replace('a', 'o'));  // Output: Isho

        // 19. split() → splits string into array based on delimiter
        String words[] = "apple,banana,grape".split(",");
        for (String w : words) {
            System.out.println(w);
        }
        // Output: apple \n banana \n grape

        // 20. toCharArray() → converts string into character array
        char arr[] = s1.toCharArray();
        for (char c : arr) System.out.print(c + " ");
        System.out.println();  
        // Output: I s h a 

        // 21. valueOf() → converts given value to string
        int num = 100;
        String strNum = String.valueOf(num);
        System.out.println(strNum);  // Output: 100

        // 22. matches() → checks string against regex
        String email = "test@gmail.com";
        System.out.println(email.matches(".*@.*\\.com"));  // Output: true

        // 23. join() → joins multiple strings with delimiter
        String joined = String.join("-", "2025", "09", "07");
        System.out.println(joined);  // Output: 2025-09-07
    }
}
