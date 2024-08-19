package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.minSteps(1);
    }

    public int minSteps(int n) {
        return findPrimeFactors(n);
    }

    public int findPrimeFactors(int num) {
        int sum =0;
        while (num % 2 == 0) {
            sum +=2;
            num /= 2;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                sum +=i; // Print i as a prime factor
                num /= i; // Divide num by i
            }
        }
        // Step 3: If num is greater than 2, it's also a prime factor
        if (num > 2) {
            sum +=num;
        }
        System.out.println(sum);
        return sum;
    }


}