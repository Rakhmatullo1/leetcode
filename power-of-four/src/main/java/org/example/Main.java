package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.isPowerOfFour(16);
    }

    public boolean isPowerOfFour(int n) {
       int result = (int) ( Math.log(n)/ Math.log(4));

       return Math.pow(4, result) == n;
    }
}