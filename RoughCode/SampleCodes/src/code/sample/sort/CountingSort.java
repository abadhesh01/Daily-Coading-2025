package code.sample.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class CountingSort {
    public static int[] countAndSort(int[] input) {
        if (input == null || input.length < 2)
            return new int[]{};

        // [1] Get Minimum and Maximum values in the input array.
        int min, max;
        min = max = input[0];
        for (int index = 1; index < input.length; index++) {
            if (input[index] < min)
                min = input[index];
            if (input[index] > max)
                max = input[index];
        }

        // [2] Generate a trace array to keep number of repetations of each
        //     element in the input array.
        int[] trace = new int[max - min + 1];
        // [2.1 (NOT REQUIRED. ONLY FOR OBSERVATIONAL PURPOSE.)] Generating a copy of trace array.
        int[] traceCopy = new int[max - min + 1];

        // [3] Key is used for indexing the minimum value to the index '0'
        //     of trace array.
        int key = (-min);

        // [4] Trace the number of repetations of each element in the input array.
        for (int index = 0; index < input.length; index++) {
            trace[input[index] + key]++;
            traceCopy[input[index] + key]++; // NOT REQUIRED. ONLY FOR OBSERVATIONAL PURPOSE.
        }

        // [5] perform sorting on the basis of repetations of each element.
        for (int indexOfInput = 0, indexOfTrace = 0;
             indexOfInput < input.length;
             indexOfTrace++) {
            while (trace[indexOfTrace] > 0) {
                input[indexOfInput++] = indexOfTrace - key;
                trace[indexOfTrace]--;
            }
        }

        // [6] Sorting is done.
        //     Return the copy of trace array.
        return traceCopy;
    }

    public static List<Integer> getUnmodifiableList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toUnmodifiableList());
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {4, 2, 2, 8, 3, 3, 1},        // Test Case 1: Simple Case with Positive Numbers
                {-1, -3, -2, -4, -1, -2},     // Test Case 2: Simple Case with Negative Numbers
                {3, -1, 0, 2, -3, 1, 0},      // Test Case 3: Mixed Positive and Negative Numbers
                {-5, -1, -3, -2, -5, -4},     // Test Case 4: All Negative Numbers
                {5, 1, 3, 2, 5, 4},           // Test Case 5: All Positive Numbers
                {1, -1, 0, 1, -1, 0, 1},      // Test Case 6: Duplicates with Mixed Values
                {10, -10, 5, -5, 10, -10, 0}, // Test Case 7: Large Range with Duplicates
                {7},                           // Test Case 8: Single Element
                {2, 2, 2, 2, 2},              // Test Case 9: All Elements the Same
                {},                            // Test Case 10: Empty Array
                {3, -2, 1, 4, -1, 0, 2, -3, 3, 2, 1, 0}, // Test Case 11: Large Input with Random Values
                {-100, 100, 0, -50, 50, 0, 100, -100}, // Test Case 12: Negative and Positive with Large Range
                {1, 2, 2, 3, 1, 4, 4, 4, 3, 2}, // Test Case 13: Large Input with Duplicates
                {5, -3, 2, -1, 0, 3, -2, 1}   // Test Case 14: Random Order with Negative and Positive
        };

        for (int row = 0; row < testCases.length; row++) {
            String result = "\nGiven array: "
                    + getUnmodifiableList(testCases[row])
                    + ";\nGiven array after counting sort: ";

            countAndSort(testCases[row]); // Performing Counting Sort.

            result += getUnmodifiableList(testCases[row]) + "\n";

            System.out.println(result);
        }
    }
}
