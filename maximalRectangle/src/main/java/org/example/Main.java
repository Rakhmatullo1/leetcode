package org.example;

public class Main {
    public static void main(String[] args) {
        char[][] mat = {
                {'1', '0', '1', '0', '0'}, // i - qator, j - ustun
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        maximalRectangle(mat);
    }

    public static int maximalRectangle(char[][] mat) {
        int highestRectangle = 0;

        for (int i = 0; i < mat.length; i++) {
            int temp = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == '0') {
                }
            }
        }

        return 0;
    }
}