package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] score = new int[] {10,3,8,9,4};
        String[] response = findRelativeRanks(score);
        String hell0 = new String(" ");
    }

    public static String[] findRelativeRanks(int[] score) {
        List<Integer>  sortedScore = new ArrayList<>(Arrays.stream(score).boxed().sorted().toList());
        Collections.reverse(sortedScore);
        List<Integer>  scoreList = Arrays.stream(score).boxed().toList();

        Map<Integer, String> rel = new HashMap<>();

        for (int i=0; i<sortedScore.size();i++) {
            if(i==0) {
                rel.put(sortedScore.get(i),"Gold Medal");
            } else if (i==1) {
                rel.put(sortedScore.get(i), "Silver Medal");
            } else if (i==2) {
                rel.put(sortedScore.get(i), "Bronze Medal");
            } else {
                rel.put(sortedScore.get(i), String.valueOf(i+1));
            }
        }

        List<String> response = scoreList.stream().map(rel::get).toList();

        return response.toArray(new String[0]);
    }
}