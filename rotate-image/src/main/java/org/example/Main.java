package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.rotate(new int[][]{
                {1, 2, 3},
                {4,5,6},
                {7,8,9}
        });
    }

    public void rotate(int[][] matrix) {
        int[][] unitMatrix = new int[matrix.length][matrix.length];
        int[][] tempMatrix = new int[matrix.length][matrix.length];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                if(i+j == matrix.length-1) {
                    unitMatrix[i][j] = 1;
                }
            }
        }

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                tempMatrix[j][i] = matrix[i][j];
            }
        }

        for(int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                matrix[i][j] = 0;
                for(int k=0; k<matrix.length; k++) {
                    matrix[i][j] =matrix[i][j] + tempMatrix[i][k]*unitMatrix[k][j];
                }
            }
        }


        System.out.println(tempMatrix[0][0]);
    }

}