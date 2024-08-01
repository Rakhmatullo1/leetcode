package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int result = main.maxProfit(new int[] {7,1,5,3,6,4});
    }

    public int maxProfit(int[] prices) {
        int[] temp = new int[prices.length-1];

        for(int i=0; i<temp.length; i++) {
             temp[i] = prices[i+1] - prices[i];
        }

        int maxSum =0;
        int sum = 0;

        for(int i=0; i<temp.length; i++) {
            if(sum+temp[i]>0) {
                sum+=temp[i];
            }
            else {
                sum =0;
            }
            if(maxSum<sum) {
                maxSum = sum;
            }
        }

        int max = Integer.MIN_VALUE;

        if(maxSum == 0) {
            for(int i=0;i<temp.length; i++) {
                if(temp[i]>max){
                    max=temp[i];
                }
                maxSum = sum;
            }
        }

        return maxSum;
    }

    private int sum(int[] array) {
        int sum =0;
        for(int i=0; i<array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }
}