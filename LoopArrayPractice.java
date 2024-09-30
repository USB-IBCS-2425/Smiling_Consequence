import java.util.*;

public class LoopArrayPractice {

    public static int middleValue(int[] arr) {
        int middleIndex = (arr.length - 1) / 2;
        return arr[middleIndex];
    }

    public static int numMatches(String[] arr, String str) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(str)) {
                count++;
            }
        }
        return count;
    }

    public static boolean inOrder(int[] arr) {
        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                ascending = false;
            }
            if (arr[i] < arr[i + 1]) {
                descending = false;
            }
        }

        return ascending || descending;
    }

    public static boolean[] doubleLetter(String[] arr) {
        boolean[] result = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = hasDoubleLetter(arr[i]);
        }

        return result;
    }

    private static boolean hasDoubleLetter(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static String[] bookEnds(String[] arr) {
        int count = 0;

        for (String str : arr) {
            if (startsAndEndsWithSameLetter(str)) {
                count++;
            }
        }

        // Create the result array with the correct size
        String[] result = new String[count];
        int index = 0;

        // Fill the result array with the matching strings
        for (String str : arr) {
            if (startsAndEndsWithSameLetter(str)) {
                result[index++] = str;
            }
        }

        return result;
    }

    // Helper method to check if a string starts and ends with the same character
    private static boolean startsAndEndsWithSameLetter(String str) {
        return str.length() > 0 && str.charAt(0) == str.charAt(str.length() - 1);
    }

    // Main method to test all the methods
    public static void main(String[] args) {
        // Test middleValue
        int[] intArray1 = {1, 2, 3, 4, 5};
        System.out.println("Middle value: " + middleValue(intArray1)); // Output: 3

        int[] intArray2 = {10, 20, 30, 40, 50, 60};
        System.out.println("Middle value: " + middleValue(intArray2)); // Output: 30

        // Test numMatches
        String[] stringArray1 = {"apple", "banana", "apple", "orange"};
        System.out.println("Number of matches: " + numMatches(stringArray1, "apple")); // Output: 2

        // Test inOrder
        int[] intArray3 = {2, 3, 8, 8, 9};
        System.out.println("Is in order: " + inOrder(intArray3)); // Output: true

        int[] intArray4 = {9, 8, 8, 3, 2};
        System.out.println("Is in order: " + inOrder(intArray4)); // Output: true

        int[] intArray5 = {1, 5, 3, 8, 9};
        System.out.println("Is in order: " + inOrder(intArray5)); // Output: false

        // Test doubleLetter
        String[] stringArray2 = {"Considine", "Phillips", "Vankatesh", "Elliott", "Droubay", "Woolley"};
        boolean[] doubleLetterResults = doubleLetter(stringArray2);
        for (boolean b : doubleLetterResults) {
            System.out.print(b + " "); // Output: false true false true false true
        }
        System.out.println();

        // Test bookEnds
        String[] stringArray3 = {"bob", "jim", "sally", "anna", "joe", "elle", "zbhskdjez"};
        String[] bookEndsResults = bookEnds(stringArray3);
        for (String s : bookEndsResults) {
            System.out.print(s + " "); // Output: bob anna elle zbhskdjez
        }
        System.out.println();
    }
}