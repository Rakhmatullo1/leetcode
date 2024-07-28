package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    private static final int INF = 1000001;


    public static void main(String[] args) {
        Main main = new Main();
        main.minimumCost("aabbddccbc", "abbbaabaca", new char[]{'a','b','c','b','a','d'}, new char[]{'d','c','b','d','b','b'}, new int[] {3,8,7,6,7,1});
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<Character> chars = new ArrayList<>();

        for(int i=0; i<original.length; i++) {
            chars.add(original[i]);
            chars.add(changed[i]);
        }

        chars = chars.stream().distinct().toList();
        int size = chars.size();

        int[][] matrix = new int[size+1][size+1];

        for(int i=0; i<size+1; i++) {
            for(int j=0; j<size+1; j++) {
                matrix[i][j] = INF;
            }
        }

        for(int i=1; i<size+1; i++) {
            matrix[i][0] = chars.get(i-1);
            matrix[0][i] = chars.get(i-1);
        }

        for(int i=1; i<size+1; i++) {
            for(int j=1; j<size+1; j++) {
                for(int k=0; k<original.length; k++) {
                    if(matrix[i][0]==original[k] && matrix[0][j]==changed[k]){
                        matrix[i][j]= cost[k];
                    } else if(i==j) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        int[][] matrices = new int[size][size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++){
                matrices[i][j] = matrix[i+1][j+1];
            }
        }

        floydWarshall(matrices, size);

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(matrices[i][j] == INF) {
                    matrices[i][j] = -1;
                }
            }
        }

        for(int i=1; i<size+1; i++){
            for(int j=1; j<size+1; j++) {
                matrix[i][j] = matrices[i-1][j-1];
            }
        }

        int minCost = 0;

        for(int i=0; i<source.length(); i++) {
            if(source.charAt(i) == target.charAt(i)){
                continue;
            }

            for(int j=1; j<size+1; j++) {
                if(matrix[j][0] != source.charAt(i)) {
                    continue;
                }

                boolean isExec=false;
                for(int k=1; k<size+1; k++){
                    if(matrix[j][0]==source.charAt(i) && matrix[0][k]==target.charAt(i)){
                        if(matrix[j][k] == -1) {
                            return -1;
                        }
                        minCost =minCost + matrix[j][k];
                        isExec=true;
                        break;
                    }
                }
                if (isExec){
                    break;
                }
            }
        }

        if(minCost==0) {
            return -1;
        }

        return minCost;
    }

    void floydWarshall(int[][] dist, int v) {
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (dist[i][k] + dist[k][j]
                            < dist[i][j])
                        dist[i][j]
                                = dist[i][k] + dist[k][j];
                }
            }
        }
    }
}