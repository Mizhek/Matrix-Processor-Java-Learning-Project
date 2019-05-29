package processor;

class MatricesOperations {
    static double[][] addMatrices(double[][] firstMatr, double[][] secondMatr) {
        double[][] resultMatr = new double[firstMatr.length][firstMatr[0].length];

        for (int i = 0; i < resultMatr.length; i++) {
            for (int j = 0; j < resultMatr[0].length; j++) {
                resultMatr[i][j] = firstMatr[i][j] + secondMatr[i][j];
            }
        }

        return resultMatr;
    }

    static double[][] multiplyMatrToConstant(double[][] matr, double constant) {
        double[][] resultMatr = new double[matr.length][matr[0].length];
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                resultMatr[i][j] = matr[i][j] * constant;
            }
        }

        return resultMatr;
    }


    static double[][] multiplyMatrices(double[][] firstMatr, double[][] secondMatr) {
        double[][] resultMatr = new double[firstMatr.length][secondMatr[0].length];

        for (int i = 0; i < resultMatr.length; i++) {
            for (int j = 0; j < resultMatr[0].length; j++) {
                double[] row = firstMatr[i];
                double[] column = new double[secondMatr.length];
                for (int k = 0; k < column.length; k++) {
                    column[k] = secondMatr[k][j];
                }
                resultMatr[i][j] = calculateMatrElementForMultiplication(row, column);
            }
        }

        return resultMatr;
    }

    private static double calculateMatrElementForMultiplication(double[] row, double[] column) {
        double result = 0;

        for (int i = 0; i < row.length; i++) {
            result += row[i] * column[i];
        }

        return result;
    }
    static double[][] roundMatrElements(double[][] matr) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                if (matr[i][j] > 0) {
                matr[i][j] = Math.floor(matr[i][j] * 100) / 100.0; }
                else {
                    matr[i][j] = Math.ceil(matr[i][j] * 100) / 100.0;
                }
            }
        }
        return matr;
    }
}
