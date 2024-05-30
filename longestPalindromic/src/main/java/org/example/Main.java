package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));;
    }

    public static String longestPalindrome(String s) {
        List<String> parts = Arrays.stream(s.split("")).toList();

        int longestSize = 0;
        String longestPart = s.substring(0,1);

        for(String part :parts) {
            List<String> temp = new ArrayList<>(parts);

            Collections.reverse(temp);

            for(int i=0; i<parts.size(); i++) {
                if(Objects.equals(temp.get(i), part)) {

                    int h = parts.size()-i;
                    String realPart = String.join("", parts.subList(parts.indexOf(part), h));

                    if(isPalindromic(realPart)) {
                        if(realPart.length()>longestSize) {
                            longestSize = realPart.length();
                            longestPart = realPart;
                        }
                    }

                    if(temp.size()!=i) {
                        temp = temp.subList(i+1, temp.size());
                    }
                }
            }
        }

        return longestPart;
    }

    private static boolean isPalindromic(int x) {
        String p = String.valueOf(x);
        if(p.length()==1) {
            return true;
        }
        List<String> parts = Arrays.stream(p.split("")).collect(Collectors.toList());
        int size = parts.size()/2;
        List<String> a = parts.subList(0,size);
        List<String> b = parts.subList(parts.size()-(size), parts.size());
        Collections.reverse(b);
        return Objects.equals(a,b);
    }
}