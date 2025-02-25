package week6;

import java.util.Arrays;

public class GenericBubbleSort {
	 public static <T extends Comparable<T>> void bubbleSort(T[] array) {
	 int n = array.length;
	 boolean swapped;
	 for (int i = 0; i < n - 1; i++) {
	 swapped = false;
	 for (int j = 0; j < n - i - 1; j++) {
	 if (array[j].compareTo(array[j + 1]) > 0) {
	 // Swap array[j] and array[j+1]
	 T temp = array[j];
	 array[j] = array[j + 1];
	 array[j + 1] = temp;
	 swapped = true;
	 }
	 }
	 // If no two elements were swapped by inner loop, then break
	 if (!swapped)
	 break;
	 }
	 }
	 public static void main(String[] args) {
	 Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
	
	 Double[] doubleArray = {3.14, 1.57, 2.71, 0.5, 4.2};
	 String[] stringArray = {"apple", "banana", "cherry", "date", "fig"};
	 bubbleSort(intArray);
	 bubbleSort(doubleArray);
	 bubbleSort(stringArray);
	 // Print the sorted arrays
	 System.out.println("Integer array: " + Arrays.toString(intArray));
	 System.out.println("Double array: " + Arrays.toString(doubleArray));
	 System.out.println("String array: " + Arrays.toString(stringArray));
	 }
	}
