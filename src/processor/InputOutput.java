package processor;

import static processor.Main.scanner;

class InputOutput {

    static double[][] createMatrFromInput() {
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        double[][] matr = new double[rows][columns];
        System.out.println("Enter matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matr[i][j] = scanner.nextDouble();
            }
        }
        return matr;
    }

    static void printMatr(double[][] matrix) {
        System.out.println("The answer is: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
