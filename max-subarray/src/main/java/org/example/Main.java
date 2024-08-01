package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main
                 = new Main();
        int result = main.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
    }

    public int maxSubArray(int[] nums) {
        int maxSum =0;
        int sum =0;

        for(int i=0; i<nums.length; i++) {
            if(sum+nums[i]>=0){
                sum+=nums[i];
            }else {
                sum = 0;
            }
            if(maxSum<sum) {
                maxSum = sum;
            }
        }
        int max = Integer.MIN_VALUE;

        if(maxSum == 0) {
            for(int i=0; i<nums.length; i++) {
                if(nums[i]>max) {
                    max = nums[i];
                }
            }
            maxSum = max;
        }

        return maxSum;
    }
}