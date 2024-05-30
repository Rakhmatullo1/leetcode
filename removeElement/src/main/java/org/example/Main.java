package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
    }
    public  static int removeElement(int[] nums, int val) {

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=val) {
                list.add(nums[i]);
            }
        }
        nums = new int[list.size()+1];
        for(int i=0; i<list.size(); i++){
            nums[i] = list.get(i);
        }

        return list.size();
    }
}