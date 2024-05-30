package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> sums = new ArrayList<>();

        List<Integer> givenList = new ArrayList<>();

        for(int i=0; i< nums.length; i++) {
            givenList.add(nums[i]);
        }


        for(Integer givenNum : givenList) {
            if(givenNum>target) {

            }
        }

        return sums;
    }
}