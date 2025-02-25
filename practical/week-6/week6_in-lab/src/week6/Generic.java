package week6;

public class Generic {
	 public static <T extends Comparable<T>> int binarySearch(T[] array, T target) {
	 int low = 0;
	 int high = array.length - 1;
	 while (low <= high) {
	 int mid = low + (high - low) / 2;
	 int comparison = target.compareTo(array[mid]);
	 if (comparison == 0) {
	 return mid;
	 } else if (comparison < 0) {
	 high = mid - 1;
	 } else {
	 low = mid + 1;
	 }
	 }
	 return -1; // Target not found
	 }
	 public static void main(String[] args) {
	 Integer[] intArray = {2, 4, 6, 8, 10};
	 Double[] doubleArray = {1.2, 3.4, 5.6, 7.8, 9.0};
	 String[] stringArray = {"apple", "banana", "cherry", "date", "fig"};
	 int index1 = binarySearch(intArray, 6);
	 int index2 = binarySearch(doubleArray, 5.6);
	 int index3 = binarySearch(stringArray, "cherry");
	 System.out.println("Index of 6 in intArray: " + index1);
	 System.out.println("Index of 5.6 in doubleArray: " + index2);
	 System.out.println("Index of 'cherry' in stringArray: " + index3);
	 }
	}
