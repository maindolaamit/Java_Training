package debugging;

import java.util.Arrays;

/**
The transpose of a matrix reverses the columns and rows. In other words, each row from the original matrix becomes a column in the new matrix.
The given code is not producing the correct transpose matrix
Use breakpoints to visualize the runtime. Watching the output line by line will help you debug the problem.

HINT: The solution may involve creating another 2D array.
**/
public class Transpose {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[j][i];
            }
        }

        System.out.println();
        printMatrix(matrix);
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
                System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
