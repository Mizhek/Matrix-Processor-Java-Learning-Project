package processor;

class MatrixTransposition {

    static void chooseTransposition(int choice, double[][] matr) {

        if (matr.length == matr[0].length) {

            switch (choice) {

                case 1: // main diagonal
                    InputOutput.printMatr(MatrixTransposition.transposeMainDiag(matr));
                    break;
                case 2: // side diagonal
                    InputOutput.printMatr(MatrixTransposition.transposeSideDiag(matr));
                    break;
                case 3: // vertical line
                    InputOutput.printMatr(MatrixTransposition.transposeVerticalLine(matr));
                    break;
                case 4: // horizontal line
                    InputOutput.printMatr(MatrixTransposition.transposeHorizontalLine(matr));
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }

    }


    static double[][] transposeMainDiag(double[][] matr) {
        double[][] transposedMatr = new double[matr.length][matr[0].length];
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                if (i == j) {
                    transposedMatr[i][j] = matr[i][j];
                } else {
                    transposedMatr[i][j] = matr[j][i];
                }
            }
        }
        return transposedMatr;
    }

    private static double[][] transposeSideDiag(double[][] matr) {
        double[][] transposedMatr = new double[matr.length][matr[0].length];
        int row = matr.length;
        int column = matr[0].length;
        int rowPosition = row - 1;
        int columnPosition = column - 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transposedMatr[i][j] = matr[rowPosition][columnPosition];
                rowPosition--;
            }
            rowPosition = row - 1;
            columnPosition--;
        }

        return transposedMatr;
    }

    private static double[][] transposeVerticalLine(double[][] matr) {
        double[][] transposedMatr = new double[matr.length][matr[0].length];
        for (int i = 0; i < matr.length; i++) {
            int endRowIndex = matr[0].length - 1;
            for (int j = 0; j < matr[0].length; j++) {
                transposedMatr[i][j] = matr[i][endRowIndex];
                endRowIndex--;
            }
        }
        return transposedMatr;
    }

    private static double[][] transposeHorizontalLine(double[][] matr) {
        double[][] transposedMatr = new double[matr.length][matr[0].length];
        int endColumnIndex = matr.length - 1;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                transposedMatr[i][j] = matr[endColumnIndex][j];
            }
            endColumnIndex--;
        }
        return transposedMatr;
    }
}
