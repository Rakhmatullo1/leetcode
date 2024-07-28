package org.example;

import java.util.*;

public class Main {

    private static final Map<Character, List<String>> nums =
            Map.of(
                    '2', List.of("a","b","c"),
                    '3', List.of("d","e","f"),
                    '4', List.of("g","h","i"),
                    '5', List.of("j","k","l"),
                    '6', List.of("m","n","o"),
                    '7', List.of("p","q","r","s"),
                    '8', List.of("t","u","v"),
                    '9', List.of("w","x", "y","z"));
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        main.letterCombinations("234");
    }

    // dg, dh, di, eg, eh, ei, fg, fh, fi
    // adg, adh, adi

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();

        List<String> chars = nums.get(digits.charAt(0));
        List<String> temp = letterCombinations(digits.substring(1));
        if(digits.length() ==1){
            return chars;
        }
        for(int j=0;j<chars.size(); j++) {
            for(int k=0; k<temp.size(); k++) {
                ans.add(chars.get(j) + temp.get(k));
            }
        }



        return ans;
    }
}