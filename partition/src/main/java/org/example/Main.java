package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    }

    public List<List<String>> partition(String s) {
        List<List<String>> allParts = new ArrayList<>();




        return allParts;
    }

    private static boolean isPalindrome(String s) {

        int mid = s.length()/2;

        String subString1 = s.substring(0, mid);
        String subString2 = s.substring(mid);

        if(s.length()%2==1) {
            subString2 = s.substring(mid+1);
        }

        List<String> h = Arrays.stream(subString2.split("")).collect(Collectors.toList());

        Collections.reverse(h);
        subString2 = String.join("",h);

        return Objects.equals(subString1, subString2);
    }
}