/*
Definition:
Cyclic Sort is a sorting algorithm used when numbers are in the range [0, n] or [1, n].
It places every number at its correct index (for example, value 3 at index 3) by swapping.

Used in problems like:
- Finding missing number
- Finding duplicate or repeated number
- Sorting arrays containing continuous integers efficiently

Time Complexity: O(n)
Space Complexity: O(1)
*/

// Cyclic Sort Algorithm Example – Missing Number Problem
public class J06_CyclicSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int missingNumber(int[] arr) {
        int n = arr.length, i = 0;

        // Place each element at its correct index
        while (i < n) {
            if (arr[i] == i || arr[i] == n) i++;
            else swap(arr, i, arr[i]);
        }

        // Find missing index
        for (i = 0; i < n; i++)
            if (arr[i] != i) return i;

        return n;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};   // Example array (n = 3)
        System.out.println("Missing Number: " + missingNumber(arr));
    }
}




//  Cyclic Sort approach to find the duplicate element
// TC: O(n), SC: O(1)

// public class J07_FindDuplicate {

//     public static void swap(int[] arr, int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }

//     public static int findDuplicate(int[] arr) {
//         while (true) {
//             int elem = arr[0];
//             if (elem == arr[elem]) return arr[0];  // Duplicate found
//             swap(arr, 0, elem);                   // Place element at correct index
//         }
//     }

//     public static void main(String[] args) {
//         int[] arr = {2, 1, 3, 4, 2};   // Example array with duplicate 2
//         System.out.println("Duplicate Number: " + findDuplicate(arr));
//     }
// }




//  Cyclic Sort approach to find missing numbers in an array (1 to n)
// TC: O(n), SC: O(1)  [excluding output list]

// import java.util.*;

// public class J08_FindDisappearedNumbers {
//     static List<Integer> ans;

//     // Utility function to swap elements
//     public static void swap(int[] arr, int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }

//     public static List<Integer> findDisappearedNumbers(int[] arr) {
//         ans = new ArrayList<>();
//         int i = 0;

//         //  Cyclic Sort: place each number at its correct index
//         while (i < arr.length) {
//             int elem = arr[i];
//             if (elem == i + 1 || arr[elem - 1] == elem) i++;
//             else swap(arr, i, elem - 1);
//         }

//         //  Collect all missing numbers
//         for (i = 0; i < arr.length; i++) {
//             if (arr[i] != i + 1) ans.add(i + 1);
//         }

//         return ans;
//     }

//     public static void main(String[] args) {
//         int[] arr = {4, 3, 2, 7, 8, 2, 3, 1}; // Missing numbers: [5, 6]
//         System.out.println("Disappeared Numbers: " + findDisappearedNumbers(arr));
//     }
// }
