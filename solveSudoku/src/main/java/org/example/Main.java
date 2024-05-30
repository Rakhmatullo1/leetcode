package org.example;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        solveSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.','.', '.'},
                {'6', '.', '.', '1', '9', '5', '.','.', '.'},
                {'.', '9', '8', '.', '.', '.', '.','6', '.'},
                {'8', '.', '.', '.', '6', '.', '.','.', '3'},
                {'4', '.', '.', '8', '.', '3', '.','.', '1'},
                {'7', '.', '.', '.', '2', '.', '.','.', '6'},
                {'.', '6', '.', '.', '.', '.', '2','8', '.'},
                {'.', '.', '.', '4', '1', '9', '.','.', '5'},
                {'.', '.', '.', '.', '8', '.', '.','7', '9'}
        });
    }

    public static void solveSudoku(char[][] board) {
        String[][] result = new String[9][9];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                result[i][j]= String.valueOf(board[i][j]);
            }
        }

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                changeColumn(i,j, result);
                changeRow(i,j, result);
                change3x3mat(i, j, result);
            }
        }

        String k = "";
        k = k+"h";
    }



    private static void changeColumn(int i, int j, String[][] board) {
        StringBuilder isAvailable = new StringBuilder("123456789");
        StringBuilder isNotAvailable= new StringBuilder();
        for(int k=0; k<9; k++) {
            if(!Objects.equals(board[k][i], ".")){
                isNotAvailable.append(board[k][i]);
            }
        }
        String[] array= isNotAvailable.toString().split("");
        for(int k=0; k<isNotAvailable.toString().split("").length; k++) {
            if(isAvailable.toString().contains(array[k])){
                isAvailable.deleteCharAt(isAvailable.indexOf(array[k]));
            }
        }

        board[i][j] = isAvailable.toString();
    }

    private static void changeRow(int i, int j, String[][] board) {
        StringBuilder isAvailable = new StringBuilder(board[i][j]);
        StringBuilder isNotAvailable= new StringBuilder();
        for(int k=0; k<9; k++) {
            if(!Objects.equals(board[i][k],"." ) ||board[i][k].length()>1 ){
                isNotAvailable.append(board[i][k]);
            }
        }
        String[] array= isNotAvailable.toString().split("");
        for(int k=0; k<isNotAvailable.toString().split("").length; k++) {
            if(isAvailable.toString().contains(array[k])){
                isAvailable.deleteCharAt(isAvailable.indexOf(array[k]));
            }
        }
        board[i][j] = isAvailable.toString();
    }

    private static void change3x3mat(int i, int j, String[][] board){
        StringBuilder isAvailable = new StringBuilder(board[i][j]);
        StringBuilder isNotAvailable= new StringBuilder();

        int limitX = ((int) (i / 3))*3+2;
        int limitY = ((int) (j / 3))*3+2;
        int minX = ((int) (i / 3))*3;
        int minY = ((int) (j / 3))*3;

        for(int p = minX; p<limitX; p++){
            for(int q= minY; q<limitY; q++) {
                if(!Objects.equals(board[p][q],"." ) ||board[p][q].length()>1 ){
                    isNotAvailable.append(board[p][q]);
                }
            }
        }

        String[] array= isNotAvailable.toString().split("i");
        for(int k=0; k<isNotAvailable.toString().split("i").length; k++) {
            if(isAvailable.toString().contains(array[k])){
                isAvailable.deleteCharAt(isAvailable.indexOf(array[k]));
            }
        }

        board[i][j] = isAvailable.toString();
    }
}