package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        main.containsDuplicate(new int[]{1,2,3,1});
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!values.add(nums[i])){
                return true;
            }
        }

        return false;
    }
}