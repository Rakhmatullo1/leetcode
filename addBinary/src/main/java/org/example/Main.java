package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public static String addBinary(String a, String b) {

        long num1 = Long.parseLong(a,2);
        long num2 = Long.parseLong(b,2);

        String result = Long.toBinaryString(num1+num2);


        return result;
    }

}