package code.sample.problem;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class FillMatrixByRecursion {

    /*
        NOTE:
        -----
        We are creating two filler functions called as "fillMatrix()" and "fillMatrixHelper()" which
        fills any 2D array (/ matrix) or zagged array with values in an increaing order provided
        the starting value using recursive calls or recursion.
     */

    private static int matrixStartValue = Integer.MIN_VALUE;

    private static void fillMatrixHelper(int[][] matrix, List<Integer> matrixIndices) {

        int size = Integer.MIN_VALUE;

        if (matrixIndices.size() == 0) // Size of the row.
            size = matrix.length;

        if (matrixIndices.size() == 1) // Size of the column.
            size = matrix[matrixIndices.get(0)].length;

        if (matrixIndices.size() == 2) {
            int row = matrixIndices.get(0);
            int col = matrixIndices.get(1);
            matrix[row][col] = matrixStartValue++;
            return;
        }

        for (int index = 0; index < size; index++) {
            matrixIndices.add(index);
            fillMatrixHelper(matrix, matrixIndices);
            matrixIndices.remove(matrixIndices.size() - 1);
        }

    }

    public static void fillMatrix(int[][] matrix, int startValue) {
        matrixStartValue = startValue;
        fillMatrixHelper(matrix, new LinkedList<>());
        matrixStartValue = Integer.MIN_VALUE;
    }

    public static void printMatrix(int[][] matrix) {
        String result = "\n";
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                result += (matrix[row][col] + "\t\t");
            }
            result += "\n";
        }
        System.out.println(result + "\n");
    }

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        java.util.Random randomObj = new java.util.Random();

        // Test Case 1: Random Jagged Array.
        int[][] testCase = new int[randomObj.nextInt(9) + 1][];
        for (int index = 0; index < testCase.length; index++)
            testCase[index] = new int[randomObj.nextInt(9) + 1];

        System.out.println("Sample Jagged Matrix: ");
        printMatrix(testCase);

        System.out.print("Eneter the starting number from which the jagged matrix will be filled: ");
        fillMatrix(testCase, input.nextInt()); // Call for test case 1.

        System.out.println("\nSample Jagged Matrix filled with provided starting with: ");
        printMatrix(testCase);

        System.out.println("\n---------------------------------------------------------------------\n");

        // Test Case 2: M*N matrix.
        System.out.print("Enter the number of rows and columns of the custom matrix respectively: ");
        int rowSize = input.nextInt();
        int colSize = input.nextInt();
        int[][] testCase2 = new int[(rowSize % 9 == 0) ? 9 : (rowSize % 9)][(colSize % 9 == 0) ? 9 : (colSize % 9)];

        System.out.println("Sample Custom Matrix: ");
        printMatrix(testCase2);

        System.out.print("Eneter the starting number from which the custom matrix will be filled: ");
        fillMatrix(testCase2, input.nextInt()); // Call for test case 2.

        System.out.println("\nSample Custom Matrix filled with provided starting with: ");
        printMatrix(testCase2);

        input.close();
    }
}
