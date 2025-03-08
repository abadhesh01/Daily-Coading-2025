package code.sample.problem;

@SuppressWarnings("all")
public class RotateImage {

    public static int[][] getMatrix(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int row = 0; row < matrixSize; row++)
            for (int col = 0; col < matrixSize; col++)
                matrix[row][col] = (row * matrixSize) + col + 1;
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        String result = "\n";
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                result += (matrix[row][col] + "\t\t");
            }
            result += "\n";
        }
        System.out.println(result + "\n");
    }

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter the size of the 2D matrix: ");
        int[][] matrix = getMatrix(input.nextInt());
        System.out.println("\nGiven matrix:");
        printMatrix(matrix);

        int traceSize = (matrix.length / 2) + 1;
        boolean[][] trace = new boolean[traceSize][traceSize];

        for (int row = 0; row < traceSize; row++) {
            for (int col = 0; col < traceSize; col++) {
                if (trace[row][col])
                    continue;
                trace[row][col] = true;
                int previousRow = row;
                int previousCol = col;
                int previousValue = matrix[previousRow][previousCol];
                int currentRow, currentCol;
                do {
                    currentRow = previousCol;
                    currentCol = matrix.length - (1 + previousRow);
                    int currentValue = matrix[currentRow][currentCol];
                    matrix[currentRow][currentCol] = previousValue;

                    previousRow = currentRow;
                    previousCol = currentCol;
                    previousValue = currentValue;

                    if (currentRow < traceSize && currentCol < traceSize)
                        trace[currentRow][currentCol] = true;
                } while (!(currentRow == row && currentCol == col));
            }
        }

        System.out.println("Result (/ Clockwise rotation) of the given matrix:");
        printMatrix(matrix);

        input.close();
    }
}
