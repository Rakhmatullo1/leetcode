package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0}
        }));
    }
    public static int matrixScore(int[][] grid) {
        int maxScore = getMaxScoreFromGrid(grid);

        for(int i=0; i<grid.length; i++) {
            int temp = getScore(grid[i]);
            grid[i] = reverse(grid[i]);
            if(temp>getScore(grid[i])){
                grid[i] = reverse(grid[i]);
            }
        }

        for(int i=0; i<grid[0].length; i++) {
            int[] tempArray = new int[grid.length];
            for(int j=0; j<grid.length; j++) {
                tempArray[j] = grid[j][i];
            }
            int temp = get1Number(tempArray);
            tempArray = reverse(tempArray);
            if(temp<get1Number(tempArray)) {
                for(int j=0; j<grid.length; j++) {
                    grid[j][i] = tempArray[j];
                }
            }
        }

        int temp =getMaxScoreFromGrid(grid);

        if(maxScore<temp){
            maxScore = temp;
        }

        return maxScore;
    }

    private static int get1Number(int[] c) {
        int num =0;
        for(int i=0; i<c.length; i++) {
            if(c[i]==1){
                num++;
            }
        }
        return num;
    }

    private static int[] reverse(int[] rc) {
        int [] newRC = new int[rc.length];
        for(int i=0; i< newRC.length; i++) {
            if(rc[i]==0) {
                newRC[i]=1;
            }else {
                newRC[i]=0;
            }
        }
        return newRC;
    }

    private static int getMaxScoreFromGrid(int[][] grid) {
        int maxScore= 0;
        for(int i=0; i<grid.length; i++) {
            maxScore = maxScore+ getScore(grid[i]);
        }
        return maxScore;
    }

    private static int getScore(int[] row) {
        int score = 0;
        int n =row.length;
        for(int i= n-1; i>=0; i--) {
            score = score + ((int) (row[i] * Math.pow(2, n-1-i)));
        }
        return score;
    }
}