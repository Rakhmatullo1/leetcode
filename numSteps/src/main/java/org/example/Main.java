package org.example;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(numSteps("1101"));
    }

    public static int numSteps(String s) {
        if(s.length() == 1 && s.charAt(0) == '1') {
            return 0;
        }

        BigInteger result = BigInteger.ZERO;

        for(int i = s.length()-1; i>=0; i--) {
            int power = s.length()-1-i;
            int j=0;
            BigInteger powerOf = BigInteger.ONE;
            if(s.charAt(i)=='1') {
                while (j!=power) {
                    powerOf = powerOf.multiply(BigInteger.TWO);
                    j++;
                }

                result = result.add(powerOf);
            }
        }

        int steps = 0;

        while (!result.equals(BigInteger.ONE)) {
            int isOdd = result.toString().charAt(result.toString().length()-1);
            if(isOdd(isOdd)) {
                result = result.add(BigInteger.ONE);
            } else {
                result = result.divide(BigInteger.TWO);
            }
            steps++;
        }

        return steps;
    }

    static boolean isOdd ( long num ) {
        return num %2 !=0;
    }
}