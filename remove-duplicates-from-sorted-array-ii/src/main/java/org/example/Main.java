package org.example;

import java.util.Arrays;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();

        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        main.removeDuplicates(nums);
        int[] expectedNums = new int[]{};
    }

    public int removeDuplicates(int[] nums) {
        int[] finalNums = new int[nums.length];
        Arrays.fill(finalNums, Integer.MAX_VALUE);
        int size = 0;
        finalNums[0] = nums[0];

        int count = 0;

        for(int i=0; i<nums.length; i++) {
            int countEl = countElement(nums, nums[i]);
            finalNums[count] = nums[i];
            if(countEl>=2){
                finalNums[count+1] = nums[i];
                count+=2;
                i+=countEl-1;
            } else {
                count ++;
            }
        }

        for (int i = 0; i < finalNums.length; i++) {
            if (finalNums[i] == Integer.MAX_VALUE) {
                break;
            }
            size++;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = finalNums[i];
        }

        return size;
    }

    private int countElement(int[] nums, int k) {
        int size =0;
        for(int i=0; i<nums.length; i++ ){
            if(nums[i] == k){
                size ++;
            }
        }
        return size;
    }
}