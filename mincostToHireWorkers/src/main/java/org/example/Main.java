package org.example;

import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(minCostToHireWorkers(new int[]{39,79,78,16,6,36,97,79,27,14,31,4,36,2,61,30,74,35,65,31}, new int[]{213,456,71,53,110,376,403,273,358,457,47,427,123,316,140,60,213,48,269,132}, 4));
    }

    public static double minCostToHireWorkers(int[] quality, int[] wage, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Pair<Double, Integer>> ratio = new ArrayList<>();
        int n = quality.length, qualitySum = 0;
        double res = Double.MAX_VALUE, maxRate = 0.0;

        for (int i = 0; i < n; ++i) {
            ratio.add(new Pair<>((double) wage[i] / quality[i], i));
        }

        ratio.sort(Comparator.comparingDouble(Pair::getKey));
        for (int i = 0; i < k; ++i) {
            qualitySum += quality[ratio.get(i).getValue()];
            maxRate = Math.max(maxRate, ratio.get(i).getKey());
            maxHeap.offer(quality[ratio.get(i).getValue()]);
        }

        res = maxRate * qualitySum;
        for (int i = k; i <n; ++i) {
            maxRate = Math.max(maxRate, ratio.get(i).getKey());
            qualitySum -= maxHeap.poll();
            qualitySum += quality[ratio.get(i).getValue()];
            maxHeap.offer(quality[ratio.get(i).getValue()]);
            res = Math.min(res, maxRate * qualitySum);
        }

        return res;
    }

    private static double calculate(List<Double> answer) {
        double sum =0;
        for(Double a : answer) {
            sum = sum +a;
        }

        return sum;
    }
}