package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));

    }
    public static String intToRoman(int num) {
        int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder romanNumeral = new StringBuilder();

        for (int i = 0; i < decimalValues.length; i++) {
            while (num >= decimalValues[i]) {
                romanNumeral.append(romanSymbols[i]);
                num -= decimalValues[i];
            }
        }

        return romanNumeral.toString();
    }
}