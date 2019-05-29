package processor;

class Inversion {
    static void inverseMatr (double [][] matr) {
        double[][] cofactorMatr;
        double[][] inversedMatr;
        double determinant = Determinant.calcDeterminant(matr);
        if (determinant == 0) {
            System.out.println("The determinant of given matrix is 0. \n" +
                    "This matrix can't be inversed!");

        } else {
            if (matr.length == 2 && matr[0].length == 2) {
                double temp = matr[0][0];
                matr[0][0] = matr[1][1];
                matr[0][1] *= -1;
                matr[1][0] *= -1;
                matr[1][1] = temp;
                InputOutput.printMatr(matr);
            } else {
                cofactorMatr = MatrixTransposition.transposeMainDiag(Determinant.createCofactorMatr(matr));
                inversedMatr = MatricesOperations.multiplyMatrToConstant(cofactorMatr, 1/determinant);
                InputOutput.printMatr(MatricesOperations.roundMatrElements(inversedMatr));
            }
        }



    }
}
