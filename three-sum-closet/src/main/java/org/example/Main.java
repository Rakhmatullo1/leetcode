package org.example;

import java.util.Arrays;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.threeSumClosest(new int[]{-1,2,1,-4}, 1);

    }

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length==3) {
            return nums[0]+nums[1]+nums[2];
        }

        Arrays.sort(nums);
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++) {
            int j = i+1;
            int k= nums.length-1;
            while (j<k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(target == sum) {
                    return target;
                }
                if(sum<target) {
                    j++;
                } else {
                    k--;
                }
                int diff = Math.abs(sum-target);

                if(diff < minDiff) {
                    minDiff =diff;
                    closest = sum;
                }
            }
        }

        return closest;
    }
}