package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.fractionAddition("-1/3+1/4-1/5+1/6-1/7+1/8-1/9+1/10-1/11+1/12");
    }

    public String fractionAddition(String expression) {
        String[] nums = expression.split("/|(?=[-+])");

        long sum = 0;

        for (int i = 0; i < nums.length; i = i + 2) {
            long multiply = 1;
            for (int j = 1; j < nums.length; j = j + 2) {
                if (i + 1 != j) {
                    multiply = Integer.parseInt(nums[j]) * multiply;
                }
            }
            sum += Long.parseLong(nums[i]) * multiply;
        }

        long bottom = 1;
        for (int i = 1; i < nums.length; i += 2) {
            bottom = bottom * Long.parseLong(nums[i]);
        }

        boolean topMinus = sum < 0;
        boolean bottomMinus = bottom<0  ;



        long x = topMinus ? (-1)*sum : sum;
        long y = bottomMinus ? (-1) * bottom : bottom, gcd = 1;
        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0)
                gcd = i;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum / gcd).append("/").append(bottom / gcd);

        if(sum == 0) {
            return "0/1";
        }

        return sb.toString();
    }
}