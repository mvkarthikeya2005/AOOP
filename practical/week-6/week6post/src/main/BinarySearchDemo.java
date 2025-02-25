package main;

public class BinarySearchDemo {

    // Generic method to perform binary search on an array of any comparable type
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = arr[mid].compareTo(target);

            if (comparison == 0) {
                return mid; // Target found
            } else if (comparison < 0) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Test with Integer array
        Integer[] intArr = {1, 3, 5, 7, 9, 11};
        int intResult = binarySearch(intArr, 7);
        System.out.println("Integer search (7): " + (intResult != -1 ? "Found at index " + intResult : "Not found"));

        // Test with Double array
        Double[] doubleArr = {1.1, 2.2, 3.3, 4.4, 5.5};
        int doubleResult = binarySearch(doubleArr, 3.3);
        System.out.println("Double search (3.3): " + (doubleResult != -1 ? "Found at index " + doubleResult : "Not found"));

        // Test with String array
        String[] stringArr = {"apple", "banana", "cherry", "date", "fig"};
        int stringResult = binarySearch(stringArr, "cherry");
        System.out.println("String search ('cherry'): " + (stringResult != -1 ? "Found at index " + stringResult : "Not found"));

        // Test with a missing element
        int missingResult = binarySearch(intArr, 4);
        System.out.println("Integer search (4): " + (missingResult != -1 ? "Found at index " + missingResult : "Not found"));
    }
}

