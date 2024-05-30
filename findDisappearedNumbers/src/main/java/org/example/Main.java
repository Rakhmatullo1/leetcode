package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }

    public  static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        boolean[] isAvailable = new boolean[nums.length];

        for(int i=0; i<nums.length; i++) {
            isAvailable[nums[i]-1] = true;
        }

        for(int i=0; i< isAvailable.length; i++) {
            if(!isAvailable[i]){
                answer.add(i+1);
            }
        }

        return answer;
    }
}