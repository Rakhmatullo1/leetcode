package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(divide(-1, -2));
    }

    public static int divide(int dividend, int divisor) {
        Double r = (double)dividend/(double)divisor;
        long ex = r.intValue();

        if(ex>=Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(ex<=Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return ((int) ex);
    }
}