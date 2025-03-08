package code.sample.problem;

import static code.sample.problem.RotateImage.getMatrix;
import static code.sample.problem.RotateImage.printMatrix;

@SuppressWarnings("all")
public class RotateImage2 {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter the size of the 2D matrix: ");
        int[][] matrix = getMatrix(input.nextInt());
        System.out.println("\nGiven matrix:");
        printMatrix(matrix);

        // STEP 1: Get the transpose (/ anti-clockwise rotation) of the given matrix.
        for (int row = 0; row < matrix.length; row++)
            for (int col = row + 1; col < matrix.length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }

        System.out.println("Transpose (/ Anti-clockwise rotation) of the given matrix:");
        printMatrix(matrix);

        System.out.println("Result matrix (Rversing arrays of each row of the transposed matrix):");
        // STEP 2: Reverse the arrays in each rows of the given matrix.
        for (int row = 0; row < matrix.length; row++)
            for (int leftCol = 0, rightCol = matrix.length - 1; leftCol < rightCol; leftCol++, rightCol--) {
                int temp = matrix[row][leftCol];
                matrix[row][leftCol] = matrix[row][rightCol];
                matrix[row][rightCol] = temp;
            }

        printMatrix(matrix);

        input.close();
    }
}
