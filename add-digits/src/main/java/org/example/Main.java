package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        System.out.println(main.addDigits(135));
    }

    public int addDigits(int num) {
        if(num == num % 10){
            return num;
        }
        int sum = 0;
        while(num !=0) {
            sum += num%10;
            num = num/10;
        }

        return addDigits(sum);
    }
}