package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(searchInsert(new int[]{1}, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
                break;
            }
            if (nums[i] > target) {
                if(i==0) {
                    return 0;
                }
                index = i - 1;
            }

            if (i != nums.length - 1) {
                if (nums[i] < target && target < nums[i + 1]) {
                    index = i + 1;
                    break;
                }
            } else {
                index = nums.length;
                break;
            }
        }

        return index;
    }
}