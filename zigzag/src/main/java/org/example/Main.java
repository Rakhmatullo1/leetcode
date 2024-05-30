package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public String convert(String s, int numRows) {
        String[][] mat = new String[numRows][];
        String[] parts = s.split("");
        String temp = s;

        for(int i=0; i<s.length(); i = i+ numRows) {
            temp = temp.substring(i, numRows);
        }
    }
}