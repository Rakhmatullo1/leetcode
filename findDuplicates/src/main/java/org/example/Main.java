package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> temp = findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) {
                ans.add(x);
            }
            nums[x - 1] *= -1;
        }
        return ans;
    }
}