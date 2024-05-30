package org.example;

public class Main {
    public static void main(String[] args) {
    }

    public static int[][] largestLocal(int[][] grid) {
        int[][] answer = new int[grid.length-2][grid[0].length-2];

        for(int i=0; i< answer.length; i++) {
            for(int j=0; j<answer[i].length; j++) {
                answer[i][j] = getLargest(grid, i+1, j+1);
            }
        }

        return answer;
    }

    private static int getLargest(int[][] grid, int indexOne, int indexTwo) {
        int max =0;
        for(int i=indexOne-1; i<=indexOne+1; i++) {
            for(int j=indexTwo-1; j<=indexTwo+1; j++){
                max = Math.max(max, grid[i][j]);
            }
        }

        return max;
    }
}