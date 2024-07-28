package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        main.longestPalindrome("adam");
    }

    public int longestPalindrome(String s) {
      List<String> duplicates = Arrays.stream(s.split("")).distinct().toList();
      String extraPart = "";
      String[] parts =s.split("");

      for(int i=0; i<parts.length; i++) {
          if(!duplicates.contains(parts[i])) {
              extraPart = parts[i];
              break;
          }
      }

      return 2*duplicates.size()-1;
    }
}