package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        main.scoreOfString("hello");
    }

    public int scoreOfString(String s) {
        String s1 = s.substring(0, s.length()-1);
        String s2 = s.substring(1);
        int sum =0;
        for(int i=0; i<s1.length(); i++) {
            sum += Math.abs(s1.charAt(i) - s2.charAt(i));
        }

        return sum;
    }
}