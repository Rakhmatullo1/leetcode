package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> nums = Map.of('2', List.of('a','b','c'), '3', List.of('d','e','f'), '4', List.of('g','h','i'), '5', List.of('j','k','l'), '6', List.of('m','n','o'), '7', List.of('p','q','r','s'), '8', List.of('t', 'u','v'), '9', List.of('w', 'x', 'y','z'));

        List<String> ans = new ArrayList<>();

        List<List<Character>> characters = new ArrayList<>();

        for(int i=0; i<digits.length(); i++) {
            characters.add(nums.get(digits.charAt(i)));
        }

        

        return ans;
    }
}