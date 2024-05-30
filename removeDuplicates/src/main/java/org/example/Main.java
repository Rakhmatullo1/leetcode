package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length; i++ ) {
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }

        for(int i=0; i<list.size(); i++) {
            nums[i] = list.get(i);
        }

        return list.size();
    }
}