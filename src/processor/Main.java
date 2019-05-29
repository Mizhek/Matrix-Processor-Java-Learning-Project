package processor;

import java.util.Scanner;

public class Main {

    enum MatrProcessorStates {
        CHOOSING_ACTION,
        ADDING_MATRICES,
        MULTIPLYING_TWO_MATR,
        MULTIPLYING_MATR_TO_CONSTANT,
        TRANSPOSING_MATR,
        CALCULATING_DETERMINANT,
        INVERSING_MATRIX,
        EXITING
    }


    private static MatrProcessorStates currentProcessorState = MatrProcessorStates.CHOOSING_ACTION;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int userChoice;
        double[][] firstMatr;
        double[][] secondMatr;
        mainLoop:
        while (true) {
            switch (currentProcessorState) {
                case CHOOSING_ACTION:
                    System.out.println("\nPlease choose preferred action:");
                    System.out.println("1. Add matrices \n" +
                            "2. Multiply matrix to a constant \n" +
                            "3. Multiply matrices \n" +
                            "4. Transpose matrix \n" +
                            "5. Calculate a determinant \n" +
                            "6. Inverse matrix \n" +
                            "0. Exit \n");
                    System.out.print("Your choice: ");
                    userChoice = scanner.nextInt();
                    changeCurrentProcessorState(userChoice);
                    break;
                case ADDING_MATRICES:
                    System.out.print("Enter size of first matrix: ");
                    firstMatr = InputOutput.createMatrFromInput();
                    System.out.print("Enter size of second matrix: ");
                    secondMatr = InputOutput.createMatrFromInput();
                    if (firstMatr.length != secondMatr.length || firstMatr[0].length != secondMatr[0].length) {
                        System.out.println("Matrices with different sizes can't be added!\n " +
                                "Please enter two new matrices with same size.");
                        currentProcessorState = MatrProcessorStates.ADDING_MATRICES;
                    } else {
                        InputOutput.printMatr(MatricesOperations.addMatrices(firstMatr, secondMatr));
                        currentProcessorState = MatrProcessorStates.CHOOSING_ACTION;
                    }
                    break;
                case MULTIPLYING_MATR_TO_CONSTANT:
                    System.out.print("Enter size of matrix: ");
                    firstMatr = InputOutput.createMatrFromInput();
                    System.out.print("Enter constant: ");
                    int constant = scanner.nextInt();
                    InputOutput.printMatr(MatricesOperations.multiplyMatrToConstant(firstMatr, constant));
                    currentProcessorState = MatrProcessorStates.CHOOSING_ACTION;
                    break;
                case MULTIPLYING_TWO_MATR:
                    System.out.print("Enter size of first matrix: ");
                    firstMatr = InputOutput.createMatrFromInput();
                    System.out.print("Enter size of second matrix: ");
                    secondMatr = InputOutput.createMatrFromInput();
                    if (firstMatr[0].length != secondMatr.length) {
                        System.out.println("The number of columns in fist matrix must be equal to the number of rows in second matrix.\n" +
                                "Please enter correct matrices:");
                        currentProcessorState = MatrProcessorStates.MULTIPLYING_TWO_MATR;
                    } else {
                        InputOutput.printMatr(MatricesOperations.multiplyMatrices(firstMatr, secondMatr));
                        currentProcessorState = MatrProcessorStates.CHOOSING_ACTION;
                    }
                    break;
                case TRANSPOSING_MATR:
                    System.out.println("Choose preferred matrix transposition:");
                    System.out.println("1. Main diagonal \n" +
                            "2. Side diagonal \n" +
                            "3. Vertical line \n" +
                            "4. Horizontal line \n");
                    System.out.print("Your choice: ");
                    userChoice = scanner.nextInt();
                    System.out.print("Enter matrix size: ");
                    firstMatr = InputOutput.createMatrFromInput();
                    MatrixTransposition.chooseTransposition(userChoice, firstMatr);
                    currentProcessorState = MatrProcessorStates.CHOOSING_ACTION;
                    break;
                case CALCULATING_DETERMINANT:
                    System.out.print("Enter matrix size: ");
                    firstMatr = InputOutput.createMatrFromInput();
                    if (firstMatr.length != firstMatr[0].length) {
                        System.out.println("Wrong matrix! It must be square. Enter a new one:");
                        currentProcessorState = MatrProcessorStates.CALCULATING_DETERMINANT;
                        break;
                    } else {
                        System.out.println("The determinant is: \n" +
                                Determinant.calcDeterminant(firstMatr));
                    }
                    currentProcessorState = MatrProcessorStates.CHOOSING_ACTION;
                    break;
                case INVERSING_MATRIX:
                    System.out.print("Enter matrix size: ");
                    firstMatr = InputOutput.createMatrFromInput();
                    if (firstMatr.length != firstMatr[0].length) {
                        System.out.println("Wrong matrix! It must be square. Enter a new one:");
                        currentProcessorState = MatrProcessorStates.CALCULATING_DETERMINANT;
                        break;
                    } else {
                        Inversion.inverseMatr(firstMatr);

                    }
                    currentProcessorState = MatrProcessorStates.CHOOSING_ACTION;
                    break;
                case EXITING:
                    break mainLoop;
            }
        }

    }

    private static void changeCurrentProcessorState(int userChoice) {
        switch (userChoice) {
            case 1:
                currentProcessorState = MatrProcessorStates.ADDING_MATRICES;
                break;
            case 2:
                currentProcessorState = MatrProcessorStates.MULTIPLYING_MATR_TO_CONSTANT;
                break;
            case 3:
                currentProcessorState = MatrProcessorStates.MULTIPLYING_TWO_MATR;
                break;
            case 4:
                currentProcessorState = MatrProcessorStates.TRANSPOSING_MATR;
                break;
            case 5:
                currentProcessorState = MatrProcessorStates.CALCULATING_DETERMINANT;
                break;
            case 6:
                currentProcessorState = MatrProcessorStates.INVERSING_MATRIX;
                break;
            case 0:
                currentProcessorState = MatrProcessorStates.EXITING;
                break;
            default:
                System.out.println("You've entered wrong command!");
                break;
        }
    }


}
