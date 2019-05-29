package processor;

class Determinant {

    static double[][] createCofactorMatr(double[][] matr) {
        double[][] cofactorMatr = new double[matr.length][matr[0].length];

        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                cofactorMatr[i][j] = calcDeterminant(createMinorMatr(matr,i,j)) * Math.pow(-1,i+j+2);
            }
        }


        return cofactorMatr;
    }


    static double calcDeterminant(double[][] matr) {
        double determinant = 0;
        if (matr.length == 2) {
            return matr[0][0] * matr[1][1] - matr[0][1] * matr[1][0];
        }
        for (int i = 0; i < matr[0].length; i++) {
            determinant += matr[0][i] * calcDeterminant(createMinorMatr(matr, 0, i)) * Math.pow(-1, 2 + i);
        }
        return determinant;
    }

    private static double[][] createMinorMatr(double[][] matr, int row, int column) {
        double[][] minor = new double[matr.length - 1][matr[0].length - 1];
        double[] tempAtrray = new double[minor.length * minor.length];
        int counter = 0;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                if (i != row && j != column) {
                    tempAtrray[counter] = matr[i][j];
                    counter++;
                }
            }
        }
        counter = 0;
        for (int i = 0; i < minor.length; i++) {
            for (int j = 0; j < minor.length; j++) {
                minor[i][j] = tempAtrray[counter];
                counter++;
            }
        }
        return minor;
    }





}
