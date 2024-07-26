package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {

    private static final int INF = 10001;

    public static void main(String[] args) {
        Main main = new Main();
        int result = main.findTheCity(4, new int[][]{
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        }, 4);
        System.out.println(result);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            matrix[i][i] = -1;
            int x = edges[i][0];
            int y = edges[i][1];
            matrix[x][y] = edges[i][2];
            matrix[y][x] = edges[i][2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
        floydWarshall(matrix, n);

        Map<Integer, Integer> cities = new HashMap<>();

        for(int i=0; i<n; i++) {
            cities.put(i, 0);
            for(int j=0; j<n; j++) {
                if(i!=j && matrix[i][j]<=distanceThreshold){
                    int neighbours = cities.get(i);
                    neighbours++;
                    cities.put(i, neighbours);
                }
            }
        }

        int minNum = cities.values().stream().reduce(Math::min).get();

        return cities.keySet().stream().filter(x->cities.get(x)==minNum).max(Integer::compareTo).get();
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