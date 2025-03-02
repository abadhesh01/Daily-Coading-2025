public class SpiralMatrix {
    enum Direction {LEFT, DOWN, RIGHT, TOP}

    public static void printMatrix(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                result.append(anInt).append(" ");
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    @SuppressWarnings("all")
    public static int[][] getSpiralMatrix(int matrixSize) {

        int number = 0;
        int[][] spiralMatrix = new int[matrixSize][matrixSize];
        int left = 0, right = matrixSize - 1;
        int top = 0, bottom = matrixSize - 1;

        Direction direction = Direction.RIGHT;
        while (top <= bottom && left <= right) {

            if (direction == Direction.RIGHT) {
                for (int col = left; col <= right; col++) {
                    spiralMatrix[top][col] = ++number;
                }
                direction = Direction.DOWN;
            }

            if (direction == Direction.DOWN) {
                for (int row = ++top; row <= bottom; row++) {
                    spiralMatrix[row][right] = ++number;
                }
                direction = Direction.LEFT;
            }

            if (direction == Direction.LEFT) {
                for (int col = --right; col >= left; col--) {
                    spiralMatrix[bottom][col] = ++number;
                }
                direction = Direction.TOP;
            }

            if (direction == Direction.TOP) {
                for (int row = --bottom; row >= top; row--) {
                    spiralMatrix[row][left] = ++number;
                }
                direction = Direction.RIGHT;
                left++;
            }
        }

        return spiralMatrix;
    }

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter the size of the spiral matrix: ");
        int matrixSize = input.nextInt();
        int[][] result = getSpiralMatrix(matrixSize);
        printMatrix(result);
        input.close();
    }
}
