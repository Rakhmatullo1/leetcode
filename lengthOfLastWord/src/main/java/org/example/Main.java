package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int lengthOfLastWord(String s) {
        String[] parts = s.split(" ");

        return parts[parts.length-1].length();
    }
}