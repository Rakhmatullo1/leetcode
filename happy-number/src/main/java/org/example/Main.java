package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        main.isHappy(11);
    }

    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }

        if(n==4){
            return false;
        }

        String[] nums = String.valueOf(n).split("");
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum = sum + (int) Math.pow(Integer.parseInt(nums[i]), 2);
        }
        System.out.println(sum);
        return isHappy(sum);
    }
}