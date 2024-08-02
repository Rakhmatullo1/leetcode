package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        main.minSwaps(new int[]{0,1,1,1,0,0,1,1,0});
    }

    public int minSwaps(int[] nums) {
        int count= 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] ==1) {
                count++;
            }
        }

        int[] newArr = new int[nums.length*2];


        for(int i=nums.length; i<nums.length*2; i++){
            newArr[i-nums.length] = nums[i-nums.length];
            newArr[i] = nums[i-nums.length];
        }
        int maxSum = maxSum(newArr, newArr.length, count);

        return count-maxSum;
    }

    private int maxSum(int arr[], int n, int k)
    {
        // Initialize result
        int window_sum = 0;
        for (int i = 0; i < k; i++)
            window_sum += arr[i];

        // Initialize max_sum with the sum of the first window
        int max_sum = window_sum;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            window_sum += arr[i] - arr[i - k]; // Slide the window right by adding new element and subtracting the old one

            // Update max_sum if we found a larger sum in the current window
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }
}