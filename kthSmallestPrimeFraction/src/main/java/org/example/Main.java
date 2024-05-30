package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(kthSmallestPrimeFraction(new int[]{1,7}, 1));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Map<Double, List<Integer>> fractions = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                for (int j = i + 1; j < arr.length; j++) {
                    fractions.put(((double) arr[i] / (double) arr[j]), List.of(arr[i], arr[j]));
                }
            }
        }


        List<Double> keys  = fractions.keySet().stream().sorted().toList();

        Double kth = keys.get(k-1);

        List<Integer> answer = fractions.get(kth);

        return new int[]{answer.get(0), answer.get(1)};
    }
}